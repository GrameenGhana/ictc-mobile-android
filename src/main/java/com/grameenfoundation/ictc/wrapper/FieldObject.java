/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.wrapper;

/**
 *
 * @author skwakwa
 */
public class FieldObject {
    private String key;
    private Object value;

    public FieldObject(String key, Object value) {
        this.value = value;
        this.key = key;
    }

    /**
     * @return the name
     */
    public Object getValue() {
        return value;
    }

    /**
     * @param name the name to set
     */
    public void setValue(String name) {
        this.value = name;
    }

    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(String key) {
        this.key = key;
    }
}
