//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5.1 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.06.13 at 05:12:53 PM CEST 
//


package hello.entity.gov.gradskaskupstina;

import hello.entity.org.w3._2000._09.xmldsig.SignatureType;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DocumentId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PravniOsnov" type="{http://www.gradskaskupstina.gov/}TReferenca"/>
 *         &lt;element name="Akt" type="{http://www.gradskaskupstina.gov/}TReferenca"/>
 *         &lt;element name="Amandman" type="{http://www.gradskaskupstina.gov/}TAmandman" maxOccurs="unbounded"/>
 *         &lt;element name="Potpisnici" type="{http://www.gradskaskupstina.gov/}TPotpisnici"/>
 *         &lt;element name="UserName" type="{http://www.w3.org/2001/XMLSchema}string"  minOccurs="0" maxOccurs="1"/>
 *         &lt;element name="TimeStamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"  minOccurs="0" maxOccurs="1"/>
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}Signature" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "documentId",
    "pravniOsnov",
    "akt",
    "amandman",
    "potpisnici",
    "userName",
    "timeStamp",
    "signature"
})
@XmlRootElement(name = "Amandmani")
public class Amandmani {

    @XmlElement(name = "DocumentId")
    protected String documentId;
    @XmlElement(name = "PravniOsnov", required = true)
    protected TReferenca pravniOsnov;
    @XmlElement(name = "Akt", required = true)
    protected TReferenca akt;
    @XmlElement(name = "Amandman", required = true)
    protected List<TAmandman> amandman;
    @XmlElement(name = "Potpisnici", required = true)
    protected TPotpisnici potpisnici;
    @XmlElement(name = "UserName")
    protected String userName;
    @XmlElement(name = "TimeStamp")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar timeStamp;
    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#")
    protected SignatureType signature;

    /**
     * Gets the value of the documentId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentId() {
        return documentId;
    }

    /**
     * Sets the value of the documentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentId(String value) {
        this.documentId = value;
    }

    /**
     * Gets the value of the pravniOsnov property.
     * 
     * @return
     *     possible object is
     *     {@link TReferenca }
     *     
     */
    public TReferenca getPravniOsnov() {
        return pravniOsnov;
    }

    /**
     * Sets the value of the pravniOsnov property.
     * 
     * @param value
     *     allowed object is
     *     {@link TReferenca }
     *     
     */
    public void setPravniOsnov(TReferenca value) {
        this.pravniOsnov = value;
    }

    /**
     * Gets the value of the akt property.
     * 
     * @return
     *     possible object is
     *     {@link TReferenca }
     *     
     */
    public TReferenca getAkt() {
        return akt;
    }

    /**
     * Sets the value of the akt property.
     * 
     * @param value
     *     allowed object is
     *     {@link TReferenca }
     *     
     */
    public void setAkt(TReferenca value) {
        this.akt = value;
    }

    /**
     * Gets the value of the amandman property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the amandman property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAmandman().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TAmandman }
     * 
     * 
     */
    public List<TAmandman> getAmandman() {
        if (amandman == null) {
            amandman = new ArrayList<TAmandman>();
        }
        return this.amandman;
    }

    /**
     * Gets the value of the potpisnici property.
     * 
     * @return
     *     possible object is
     *     {@link TPotpisnici }
     *     
     */
    public TPotpisnici getPotpisnici() {
        return potpisnici;
    }

    /**
     * Sets the value of the potpisnici property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPotpisnici }
     *     
     */
    public void setPotpisnici(TPotpisnici value) {
        this.potpisnici = value;
    }

    /**
     * Gets the value of the userName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the value of the userName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserName(String value) {
        this.userName = value;
    }

    /**
     * Gets the value of the timeStamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTimeStamp() {
        return timeStamp;
    }

    /**
     * Sets the value of the timeStamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTimeStamp(XMLGregorianCalendar value) {
        this.timeStamp = value;
    }

    /**
     * Gets the value of the signature property.
     * 
     * @return
     *     possible object is
     *     {@link SignatureType }
     *     
     */
    public SignatureType getSignature() {
        return signature;
    }

    /**
     * Sets the value of the signature property.
     * 
     * @param value
     *     allowed object is
     *     {@link SignatureType }
     *     
     */
    public void setSignature(SignatureType value) {
        this.signature = value;
    }

}
