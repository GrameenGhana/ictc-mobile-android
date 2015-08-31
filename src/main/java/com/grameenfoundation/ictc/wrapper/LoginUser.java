/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.wrapper;

import com.grameenfoundation.ictc.domain.commons.PageAccess;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *@author Seth Adarkwa Kwakwa
 *         email : seth@corenett.com, kwasett@gmail.com           
 *@Date   Mar 14, 2012
 */
public class LoginUser {

    private long sessionId;
    private String userType;
    private String langPref;
    private String userId;
    private String userScreenName;
    private String accessFor;
    private Object userLogin;
    private boolean isLogin = false;
    private Date dateLogin;
    private String userTypeDetails;
    private List<PageAccess> pages = new ArrayList<PageAccess>();

    /**
     * @return the userType
     */
    public String getUserType() {
        return userType;
    }

    /**
     * @param userType the userType to set
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * @return the userScreenName
     */
    public String getUserScreenName() {
        return userScreenName;
    }

    /**
     * @param userScreenName the userScreenName to set
     */
    public void setUserScreenName(String userScreenName) {
        this.userScreenName = userScreenName;
    }

    /**
     * @return the accessFor
     */
    public String getAccessFor() {
        return accessFor;
    }

    /**
     * @param accessFor the accessFor to set
     */
    public void setAccessFor(String accessFor) {
        this.accessFor = accessFor;
    }

    /**
     * @return the userLogin
     */
    public Object getUserLogin() {
        return userLogin;
    }

    /**
     * @param userLogin the userLogin to set
     */
    public void setUserLogin(Object userLogin) {
        this.userLogin = userLogin;
    }

    /**
     * @return the isLogin
     */
    public boolean isIsLogin() {
        return isLogin;
    }

    /**
     * @param isLogin the isLogin to set
     */
    public void setIsLogin(boolean isLogin) {
        this.isLogin = isLogin;
    }

    /**
     * @return the dateLogin
     */
    public Date getDateLogin() {
        return dateLogin;
    }

    /**
     * @param dateLogin the dateLogin to set
     */
    public void setDateLogin(Date dateLogin) {
        this.dateLogin = dateLogin;
    }

    /**
     * @return the userTypeDetails
     */
    public String getUserTypeDetails() {
        if(userType.equalsIgnoreCase("t")){
        
        }
        
        return userTypeDetails;
    }

    /**
     * @param userTypeDetails the userTypeDetails to set
     */
    public void setUserTypeDetails(String userTypeDetails) {
        this.userTypeDetails = userTypeDetails;
    }

    /**
     * @return the pages
     */
    public List<PageAccess> getPages() {
        return pages;
    }

    /**
     * @param pages the pages to set
     */
    public void setPages(List<PageAccess> pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
    
        return userScreenName;
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return the sessionId
     */
    public long getSessionId() {
        return sessionId;
    }

    /**
     * @param sessionId the sessionId to set
     */
    public void setSessionId(long sessionId) {
        this.sessionId = sessionId;
    }

    /**
     * @return the langPref
     */
    public String getLangPref() {
        return langPref;
    }

    /**
     * @param langPref the langPref to set
     */
    public void setLangPref(String langPref) {
        this.langPref = langPref;
    }
    
    

}
