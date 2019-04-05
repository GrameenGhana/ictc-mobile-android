/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.ictc.utils;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.commons.logging.Log;
import org.w3c.dom.Document;

/**
 *
 * @author Joseph George Davis
 * @date Jul 30, 2015 5:02:51 PM
 * description:
 */
public class XMLParser {
    
    
    public static Document parseXmlText(String requestType) {
	    //get the factory
	    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	    try {
	
	        //Using factory get an instance of document builder
	        DocumentBuilder db = dbf.newDocumentBuilder();
	
	        //InputSource is = new InputSource();
	        //is.setCharacterStream(new StringReader(data));
	    
	       
	        
	        File f = new File(requestType);
	       
	        Document doc = db.parse(f);
	        // normalize text representation
	        doc.getDocumentElement().normalize();
	        System.out.println("Root element of the doc is " + doc.getDocumentElement().getNodeName());
	
	        return doc;
	
	    } catch (ParserConfigurationException pce) {
	    	//Log.info("ParserConfigurationException. Reason: "+pce.getMessage());
	        pce.printStackTrace();
	        return null;
	    } catch (IOException ioe) {
	    	//Log.info("IOException. Reason: "+ioe.getMessage());
	        ioe.printStackTrace();
	        return null;
	    } catch (org.xml.sax.SAXException ex) {
            Logger.getLogger(XMLParser.class.getName()).log(Level.SEVERE, null, ex);
        
	}
        return null;
    
    }

    }
