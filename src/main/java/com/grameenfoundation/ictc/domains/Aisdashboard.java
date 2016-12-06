/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.ictc.domains;

import com.grameenfoundation.ictc.domain.commons.GeneralInterface;
import com.grameenfoundation.ictc.domain.commons.Status;
import org.neo4j.graphdb.Node;

/**
 *
 * @author Joseph George Davis
 * @date Nov 30, 2016 11:25:46 AM
 * description:
 */
public class Aisdashboard extends Status implements GeneralInterface{
    
     Node underlyingNode = null;

    public Aisdashboard(Node underlyingNode) {
        super(underlyingNode);
        this.underlyingNode = underlyingNode;
    }
    
    
    
    
    public static String DATA = "data";
    public static String TYPE ="type";

    public String getType() {
         try {
            return (String) underlyingNode.getProperty(TYPE);

        } catch (Exception e) {
        }
        return "";
    }

    public void setType(String type) {
         underlyingNode.setProperty(TYPE,type);
    }

    public String getData() {
        try {
            return (String) underlyingNode.getProperty(DATA);

        } catch (Exception e) {
        }
        return "";
    }

    public  void setData(String data) {
          underlyingNode.setProperty(DATA,data);
    }
    
    
    

}
