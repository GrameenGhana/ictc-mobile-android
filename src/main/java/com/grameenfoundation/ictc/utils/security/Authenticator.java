/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.utils.security;


import com.grameenfoundation.ictc.models.UserModel;
import com.grameenfoundation.ictc.wrapper.LoginUser;
import com.grameenfoundation.ictc.wrapper.UserWrapper;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Seth Adarkwa Kwakwa
 *         email : seth.kwakwa@corenett.com, kwasett@gmail.com    
 * @copyright CoreNett Limited Ghana       
 * @Date   Jun 11, 2012
 */
public class Authenticator {

    /**
     * For subscriber login
     * @param username
     * @param password
     * @param request
     * @return 
     */
    public boolean subscriberLogin(String username, String password, HttpServletRequest request) {

        //Query for a user with the said username and password
        UserWrapper s = new UserModel().findUser(username, password);

        //if no subscriber is found
        if (null == s) {
            //user not found
            return false;
        } else {
            //User Found
            startSubscriberSession(s, request);
        }

        return true;
    }

    /**
     * Login a Subscriber Into the system
     * @param s
     * @param request
     * @return 
     */
    public boolean subscriberLogin(UserWrapper s, HttpServletRequest request) {

        //Query for a user with the said username and password


        //if no subscriber is found
        if (null == s) {
            //user not found
            return false;
        } else {
            //User Found
            startSubscriberSession(s, request);
        }

        return true;
    }

    /**
     * For login of other users [Super admin, institution admin etc]
     * @param username
     * @param password
     * @param xtraLoginInfo
     * @param request
     * @return 
     */
    public boolean userLogin(String username, String password, String xtraLoginInfo, HttpServletRequest request) {
        UserWrapper u = new UserModel().findUser(username, password);
        if (u == null) {
            return false;
        } else {
            return startUserSession(u, request);
        }
    }

    public UserWrapper loginUser(String username, String password, String xtraLoginInfo, HttpServletRequest request) {
        UserWrapper u = new UserModel().findUser(username, password);
        if (u == null) {
            return null;
        } else {
            startUserSession(u, request);
        }

        return u;
    }

    /**
     * Start session for a subscriber
     * @param subscriber
     * @param req
     * @return 
     */
    public boolean startSubscriberSession(UserWrapper subscriber, HttpServletRequest req) {
        HttpSession session = req.getSession();
//        UserSessionImpl u = new UserSessionModel().userSessionCreate(req.getRemoteAddr(), req.getHeader("User-Agent"), SessionKeys.SUBSCRIBER_USER_TYPE, subscriber.getId());

        LoginUser loginUser = new LoginUser();
        loginUser.setDateLogin(new Date());
        loginUser.setIsLogin(true);
        loginUser.setUserId(subscriber.getAgentCode());
        loginUser.setUserScreenName(subscriber.getLastName() + ", " + subscriber.getFirstName());
        loginUser.setUserType(SessionKeys.SUBSCRIBER_USER_TYPE);
        // loginUser.setSessionId(Long.parseLong(u.getId()));


        session.setAttribute(SessionKeys.LOGIN_USER, loginUser);
        return true;
    }

    public boolean startTempSubscriberSession(UserWrapper subscriber, HttpServletRequest req) {
        HttpSession session = req.getSession();
        // loginUser.setSessionId(Long.parseLong(u.getId()));


        session.setAttribute(SessionKeys.TEMP_SUBSCRIBER_ID, subscriber.getAgentCode());
        return true;
    }

    /**
     * Start the session for a user
     * @param user
     * @param req
     * @return 
     */
    public boolean startUserSession(UserWrapper user, HttpServletRequest req) {
        HttpSession session = req.getSession();
        //Create a user session
//        UserSessionImpl u = new UserSessionModel().userSessionCreate(req.getRemoteAddr(), req.getHeader("User-Agent"), SessionKeys.SUBSCRIBER_USER_TYPE, user.getId());


        LoginUser loginUser = new LoginUser();
        loginUser.setDateLogin(new Date());
        loginUser.setIsLogin(true);
        loginUser.setUserId(user.getAgentCode());
        loginUser.setUserScreenName(user.getLastName() + ", " + user.getFirstName());
        loginUser.setUserType(SessionKeys.USER_USER_TYPE);
        // loginUser.setSessionId(Long.parseLong(u.getId()));
        //Get user actions
//        List<ActionImpl> acts = user.actionDetails();


        String pages = "";
//        List<PageAccess> pageAccess = new ArrayList<PageAccess>();
//        for (ActionImpl action : acts) {
//            pageAccess.add(new PageAccess(action.getUrl(), action.getName(), String.valueOf(action.getId()), action.getParentAction(), action.getAlias()));
//            pages += action.getAlias() + ",";
//        }
//        loginUser.setPages(pageAccess);
//        loginUser.setAccessFor(pages);

        session.setAttribute(SessionKeys.LOGIN_USER, loginUser);
        return true;
    }
}
