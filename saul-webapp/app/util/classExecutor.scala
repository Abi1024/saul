package util

import java.io.{ InputStreamReader, BufferedReader }

import scala.sys.process._

object classExecutor {

  def containsMain(clazz: Any): Boolean = {
    clazz match {
      case ob: Object => {
        val mainEntry = ob.getClass.getMethods find (x => x.getName eq "main")
        mainEntry match {
          case Some(x) => true
          case None => false
        }
      }
      case _ => false
    }
  }

  /** @param className The main class to execute
    * @param classPath The classpath argument
    * @return Output from STDOUT, output from STDERR, value return on exit
    */
  //TODO: further handle exception
  def execute(className: String, classPath: String): (List[String], List[String], Int) = {

    val cmd = Seq("scala", "-cp", classPath, className)
    var outBuffer = List[String]()
    var errBuffer = List[String]()
    val outputLogger = ProcessLogger(
      (line: String) => { outBuffer = outBuffer :+ line },
      (line: String) => { errBuffer = errBuffer :+ line }
    )
    val status = cmd ! outputLogger
    (outBuffer, errBuffer, status)
  }

}