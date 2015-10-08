/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.ictc.models;

import com.grameenfoundation.ictc.utils.ICTCDBUtil;
import com.grameenfoundation.ictc.utils.Labels;
import com.grameenfoundation.ictc.wrapper.QuestionWrapper;
import java.util.logging.Logger;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import com.grameenfoundation.ictc.domains.Ouestion;
import com.grameenfoundation.ictc.utils.ICTCRelationshipTypes;
import com.grameenfoundation.ictc.utils.ParentNode;
import java.util.logging.Level;

/**
 *
 * @author Joseph George Davis
 * @date Oct 1, 2015 3:13:15 PM
 * description:
 */
public class QuestionModel {
   
      Logger log = Logger.getLogger(BiodataModel.class.getName());
      Node  QuestionParent = null;
      
      
      public boolean createQuestion(QuestionWrapper questionWrapper)
      {
           boolean created = true;
           
             try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
                 
                 
                   Node questionNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.QUESTION);
                   
                   Ouestion question = new Ouestion(questionNode);
                   
                   
                   if(null== questionWrapper)
                   {
                      
                       log.info("question is invalid");
                       created = false;
                   }
                   else
                   {
                       
                       
                       QuestionParent = ParentNode.QuestionParentNode();
                       
                       question.setQuestion(questionWrapper.getQuestion());
                       question.setAnswer(questionWrapper.getAnswer());
                       question.setScore(questionWrapper.getScore());
                       
                       
                       QuestionParent.createRelationshipTo(questionNode, ICTCRelationshipTypes.QUESTION);
                       
                       log.log(Level.INFO, "new node created {0}", question.getUnderlyingNode().getId());
                       
                       
                       trx.success();
                       
                   }
                  
                   

                 
                 
             }
             
             
             return created;
      }
      
      
    
    

}
