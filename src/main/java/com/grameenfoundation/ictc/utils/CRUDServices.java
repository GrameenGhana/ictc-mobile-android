/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.ictc.utils;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Spomega
 * @Date Mar 17, 2015
 * @Email spomegasys@gmail.com
 * @Description-
 */
public interface CRUDServices {
    
    
    Object find(Object id);

    List findAll();

    List findAll(long start, long limit);

    List findAll(String fieldName, String fieldValue);

    List findAll(String fieldName, String fieldValue, long start, long limit);
    
    boolean update(long id, Map<String, String> data, Date lastModified);
    
    boolean delete(Object id);

}
