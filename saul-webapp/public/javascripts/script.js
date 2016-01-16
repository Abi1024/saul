$(document).ready(function(){

        $("#errors").hide();
        setEditor("editor1","scala"); 
        $("#fileList").children("li").each(function(){
            installTabClickedAction($(this));
        })


        $("#compileBtn").click(function(){
            updateCode(false);
        });

        $("#runBtn").click(function() {
            console.log("run click")
            updateCode(true);
        });

        $("#plusFile").click(function(){
            newFile(); 
        });
})

var setEditor = function(editorId,mode){
    var editor = ace.edit(editorId);
    editor.setTheme("ace/theme/monokai");
    changeEditorMode(editor, mode);
    editor.focus();
}

var changeEditorMode = function(editor, mode){
    var mode;
    if(mode == "scala"){
        mode = require("ace/mode/scala").Mode;
    }
    if(mode == "java"){
    
        mode = require("ace/mode/java").Mode;
    }
    editor.getSession().setMode(new mode());
}
var newFile = function(){
    var li = $("<li class='active'><a href='#'></a></li>");
    var idx = $("#fileList").children("li").size() + 1;
    li.children().each(function(){
        $(this).text('test'+idx+'.scala');
    });
    $("#fileList").children(".active").removeClass("active"); 
    li.attr('id','fileName' + idx);
    $("#fileList").append(li);
    installTabClickedAction(li);
    var code = $("<textarea class='code active' rows='18'></textarea>");
    code.attr('id','code' + idx);
    $("#workspace").children(".active").each(function(){
        $(this).removeClass("active");
        $(this).hide();
    })
    $("#workspace").append(code);
    var editor = $("<div class='editor active' id='editor"+idx+"'></div>");
    $("#workspace").append(editor);
    setEditor("editor"+idx,"scala");
}

//check string end with suffix
function endsWith(str, suffix) {
    return str.indexOf(suffix, str.length - suffix.length) !== -1;
}

var enableEditingTabName = function(tab){

    var text = tab.text();
    var input = $("<input id='tempName' type='text' value='" + text + "' />");
    tab.find("a").hide();
    tab.append(input);

    input.select();
    input.blur(function() {
        var text = $('#tempName').val();
        var label = $('#tempName').parent().find("a");
        var idx = tab.attr('id').slice(-1);
        if(endsWith(text,".java")) {
            label.text(text);
            changeEditorMode(ace.edit("editor"+idx),"java");
        }
        if(endsWith(text,".scala")){
            label.text(text);
            changeEditorMode(ace.edit("editor"+idx),"scala");
        }

        label.show();
        $('#tempName').remove()
     });
}
var installTabClickedAction = function(tab){
    tab.click(function(){

        if($(this).hasClass("active")){
        
            //edit the file name
            enableEditingTabName($(this));
        }
        else{
            
            //switch to other tabs
            $("#fileList").children(".active").each(function(){
                $(this).removeClass("active");
            })

            tab.addClass("active");

            var idx = tab.attr('id').slice(-1);
            $("#workspace").children(".active").each(function(){
                $(this).removeClass("active");
                $(this).hide(); 
            })
            $("#code"+idx).addClass("active");
            $("#editor"+idx).show();
            $("#editor"+idx).addClass("active");
            ace.edit("editor"+idx).focus();
        }
    })
}

var getAllFiles = function(){
    var files = {}
    $("#fileList").children("li").each(function(index){
        var idx = $(this).attr('id').slice(-1);
        var codeId = "editor" + idx;
        var codeName = $(this).text();
        files[codeName] = ace.edit(codeId).getValue();
    })

    return JSON.stringify(files);
    
}

/**
 * @param {boolean} isRun indicates if the code should be run after compilation
 */
var updateCode = function(isRun){
    var callback = {
        success : onSuccess,
        error : onError
    }
    
    //jsRoutes.controllers.Application.updateCode($("#code1").text()).ajax(callback);
    var rURL;
    if (isRun) {
        rURL = '/runCode';
    } else {
        rURL = '/compileCode';
    }
    $.ajax({
        type : 'POST',
        url : rURL,
        headers: { 
                'Accept': 'application/json',
                'Content-Type': 'application/json' 
                },
        data : getAllFiles(),
        success : onSuccess,
        error: onError
        });
};

var generateSchemaGraphFromJson = function(data){
    $('#graphContainer').remove(); 
    $('#graphParent').html('<div id="graphContainer"></div>');
    var s = new sigma('graphContainer');
    var nodeId = 0;
    var nodeDict = {};
    var nodePropertyCount = {};
    for(var node in data['nodes']){
        nodePropertyCount[data['nodes'][node]] = 0;
        nodeDict[data['nodes'][node]] = 'n'+ ++nodeId;
        s.graph.addNode({
            id: 'n'+ nodeId,
            label: data['nodes'][node],
            size: 3,
            x: Math.cos(2 * nodeId * Math.PI / data['nodes'].length),
            y: Math.sin(2 * nodeId * Math.PI / data['nodes'].length),
            color: "#ec5148"
        });

    };
    var edgeId = 0;
    for(var edge in data['edges']){
        s.graph.addEdge({
            id: 'e'+ edgeId++,
            // Reference extremities:
            source: nodeDict[data['edges'][edge][0]],
            target: nodeDict[data['edges'][edge][1]]
        });
    };

    var getNodeByLabel = function(label){

        var id = nodeDict[label];
        return s.graph.nodes(id);
    }
    //generate properties nodes and edges
    for(var property in data['properties']){
        ++nodePropertyCount[data['properties'][property]];
        var parentNode = getNodeByLabel(data['properties'][property]);
        s.graph.addNode({
            id: 'p' + property + nodePropertyCount[data['properties'][property]],
            label: property,
            size: 1,
            x: parentNode.x + 0.5 * Math.cos(2 * nodePropertyCount[data['properties'][property]] * Math.PI / 6),
            y: parentNode.y + 0.5 * Math.sin(2 * nodePropertyCount[data['properties'][property]] * Math.PI / 6),
            color: "#0000ff"
        });
        s.graph.addEdge({
            id: 'e'+ edgeId++,
            source: nodeDict[data['properties'][property]],
            target: 'p' + property + nodePropertyCount[data['properties'][property]]
        });
    }
    s.refresh();
    $("#graphContainer").css("position","absolute");
}

var onSuccess = function(data){
    alert(JSON.stringify(data));
    if(data['error']){

        var message = "";
        for(var index in data['error']){
            for(var index2 in data['error'][index]){
                message += data['error'][index][index2] + "<br>";
            }
        }
        $("#errors").html(message);
        $("#errors").show();
    }else{
        $("#errors").hide();
    }
    generateSchemaGraphFromJson(data);
}
var onError = function(data){
    alert("error"+data);
}
