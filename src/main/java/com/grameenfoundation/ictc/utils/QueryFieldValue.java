/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.utils;

/**
 * @author Seth Adarkwa Kwakwa
 *         email : seth.kwakwa@corenett.com, kwasett@gmail.com    
 * @copyright CoreNett Limited Ghana       
 * @Date   Apr 19, 2013
 */
public class QueryFieldValue {
    private String operationOn;
    private String name;
    private String value;
    
     private DataTypes type;

    /**
     * @return the type
     */
    public DataTypes getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(DataTypes type) {
        this.type = type;
    }

      public static enum DataTypes {

        STRING,
        LONG,}
      
    public QueryFieldValue(String operationOn, String name, String value,DataTypes type) {
        this.operationOn = operationOn;
        this.name = name;
        this.value = value;
        this.type =type;
        
    }
    
    

    /**
     * @return the operationOn
     */
    public String getOperationOn() {
        return operationOn;
    }

    /**
     * @param operationOn the operationOn to set
     */
    public void setOperationOn(String operationOn) {
        this.operationOn = operationOn;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }
}
