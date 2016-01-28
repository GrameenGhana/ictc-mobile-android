/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.ictc.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author Joseph George Davis
 * @date Dec 7, 2015 2:19:08 PM
 * description:
 */
public class SalesforceHttpClient {
    
    
    public static String getSalesforceData(String url,Map<String,String> parameters)
    {
         String serverResponse = "";
        try {
            HttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost(url);
            List<NameValuePair> nameValuePairs = new ArrayList<>(1);
           
            for (Map.Entry<String, String> entrySet : parameters.entrySet()) {
                String key = entrySet.getKey();
                String value = entrySet.getValue();
                System.out.println("key " + key +" "+ value +" "+ url);
                nameValuePairs.add(new BasicNameValuePair(key,value));
            }
            post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse resp = client.execute(post); 
            BufferedReader rd = new BufferedReader(new InputStreamReader(resp.getEntity().getContent()));
            String line = "";
            while ((line = rd.readLine()) != null) {
                //System.out.println(line);
                serverResponse += line;
                
            }
            
           
        } catch (IOException ex) {
            Logger.getLogger(SalesforceHttpClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return serverResponse;
    }
 
}
