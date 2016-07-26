/** This software is released under the University of Illinois/Research and Academic Use License. See
  * the LICENSE file in the root folder for details. Copyright (c) 2016
  *
  * Developed by: The Cognitive Computations Group, University of Illinois at Urbana-Champaign
  * http://cogcomp.cs.illinois.edu/
  */
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.07.25 at 08:20:43 PM IRDT 
//


package edu.illinois.cs.cogcomp.saulexamples.data.SpRL2015Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "QSLINK")
public class QSLINK {

    @XmlAttribute(name = "comment", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String comment;
    @XmlAttribute(name = "fromID", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String fromID;
    @XmlAttribute(name = "fromText", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String fromText;
    @XmlAttribute(name = "id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String id;
    @XmlAttribute(name = "landmark", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String landmark;
    @XmlAttribute(name = "relType", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String relType;
    @XmlAttribute(name = "toID", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String toID;
    @XmlAttribute(name = "toText", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String toText;
    @XmlAttribute(name = "trajector", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String trajector;
    @XmlAttribute(name = "trigger", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String trigger;

    /**
     * Gets the value of the comment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the value of the comment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComment(String value) {
        this.comment = value;
    }

    /**
     * Gets the value of the fromID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromID() {
        return fromID;
    }

    /**
     * Sets the value of the fromID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromID(String value) {
        this.fromID = value;
    }

    /**
     * Gets the value of the fromText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromText() {
        return fromText;
    }

    /**
     * Sets the value of the fromText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromText(String value) {
        this.fromText = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the landmark property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLandmark() {
        return landmark;
    }

    /**
     * Sets the value of the landmark property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLandmark(String value) {
        this.landmark = value;
    }

    /**
     * Gets the value of the relType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelType() {
        return relType;
    }

    /**
     * Sets the value of the relType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelType(String value) {
        this.relType = value;
    }

    /**
     * Gets the value of the toID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToID() {
        return toID;
    }

    /**
     * Sets the value of the toID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToID(String value) {
        this.toID = value;
    }

    /**
     * Gets the value of the toText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToText() {
        return toText;
    }

    /**
     * Sets the value of the toText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToText(String value) {
        this.toText = value;
    }

    /**
     * Gets the value of the trajector property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrajector() {
        return trajector;
    }

    /**
     * Sets the value of the trajector property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrajector(String value) {
        this.trajector = value;
    }

    /**
     * Gets the value of the trigger property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrigger() {
        return trigger;
    }

    /**
     * Sets the value of the trigger property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrigger(String value) {
        this.trigger = value;
    }

}
