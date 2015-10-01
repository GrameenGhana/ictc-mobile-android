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
 * @date Oct 1, 2015 2:31:19 PM
 * description:
 */
public class Ouestion extends Status implements GeneralInterface{
    
    public static String QUESTION = "question";
    public static String ANSWER = "answer";
    public static String SCORE  = "score";

    public Ouestion(Node underlyingNode) {
        super(underlyingNode);
        this.underlyingNode = underlyingNode;
    }
    
    
    Node underlyingNode = null;
    
    
    public String getQuestion() {
          try {
            return (String) underlyingNode.getProperty(QUESTION);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public void setQuestion(String question) {
       underlyingNode.setProperty(QUESTION,question);
    }
    
    public String getAnswer() {
       try {
            return (String) underlyingNode.getProperty(ANSWER);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public void setAnswer(String answer) {
       underlyingNode.setProperty(ANSWER,answer);
    }

    public String getScore() {
        try {
            return (String) underlyingNode.getProperty(SCORE);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public void setScore(String score) {
       underlyingNode.setProperty(SCORE,score);
    }
    
    
}
