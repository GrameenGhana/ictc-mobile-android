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
 * @date Jan 31, 2016 2:11:19 PM
 * description:
 */
public class CropAssessmentImage extends Status implements GeneralInterface {
    
     Node underlyingNode = null;
     
     
     public static String TAG="tag";
     public static String IMAGE = "image";
     
     

    public CropAssessmentImage(Node underlyingNode) {
        super(underlyingNode);
        this.underlyingNode = underlyingNode;
    }
    
    
    public void setTag(String tag)
    {
        underlyingNode.setProperty(TAG,tag);
        
    }
    
    public String getTag(){
          try {
          return (String) underlyingNode.getProperty(TAG);

        } catch (Exception e) {
        }
        return null;
    }
    
    
     public void setImage(String image)
    {
        underlyingNode.setProperty(IMAGE,image);
        
    }
    
       public String getImage(){
          try {
          return (String) underlyingNode.getProperty(IMAGE);

        } catch (Exception e) {
        }
        return null;
    }

}
