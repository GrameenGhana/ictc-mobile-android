/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.ictc.wrapper;

/**
 *
 * @author Joseph George Davis
 * @date Oct 1, 2015 3:01:04 PM
 * description:
 */
public class QuestionWrapper {
    
     private String answer = "answer";
     private String score = "score";
     private String question = "question";

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
     
     
     

}
