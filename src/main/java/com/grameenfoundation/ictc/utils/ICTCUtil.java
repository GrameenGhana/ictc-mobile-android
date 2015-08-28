/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.ictc.utils;

import java.util.Date;

/**
 *
 * @author Joseph George Davis
 * @date Jul 16, 2015 11:31:27 AM
 * description:
 */
public class ICTCUtil {

    
     //Converts date to timesramp
     public static long dateToLong(Date date) {
        if (date != null) {
            return date.getTime();
        } else {
            return 0l;
        }
    }
    
    
    
  public static Date LongToDate(long str) {

        if (str == 0l) {
            return null;
        }
        {
            Date t = new Date();
            t.setTime(str);
            return t;
        }

          public static String  replaceKeyInObject(String toBeReplace){
      String []  keys={"production","identification","expected","renting","number","target","renting","application","fertilizer","herbicide","renting","applied","quantity","yield","acre","number","land","price","ton","of"};
      for (String key : keys) {
        toBeReplace =  toBeReplace.replace(key, " "+key.substring(0, 1).toUpperCase()+key.substring(1));
          System.out.println("Rreplcea : "+toBeReplace);
      }
      return  toBeReplace;  
  }
    }
}
