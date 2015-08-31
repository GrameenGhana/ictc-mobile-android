/**
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.utils.security;


import com.grameenfoundation.ictc.domain.commons.PageAccess;
import com.grameenfoundation.ictc.utils.ICTCUtil;
import com.grameenfoundation.ictc.wrapper.LoginUser;
import com.grameenfoundation.ictc.wrapper.UserWrapper;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;


/* @author Seth Adarkwa Kwakwa
 *         email : seth.kwakwa@corenett.com, kwasett@gmail.com    
 * @copyright CoreNett Limited Ghana       
 * @Date   May 31, 2012
 */
public class UserActionAuthenticator {

    private final static Logger log = Logger.getRootLogger();

    /**
     * This function determines whether a user is valid to access a particular resource
     * @return boolean whether the resource is to be viewed by the user
     */
    public static boolean validateUserAccess(String aliase) {
        //Get the actions assigned to this particular
        String action = userActionList();
        //If the actions are not empty
        if (!action.isEmpty()) {
            //Check if the aliase for the particular resource is assigned to this particular user
            if (action.contains(aliase + ",")) {
                return true;
            }
        }
        //Return False if not allowed to perform action
        return true;//temp value
    }

    /**
     *This function returns the list of actions the user is assigned to
     * @return String the list per user
     */
    public static String userActionList() {
        //Get the user who has login
        LoginUser user = null;//loginUser();

        //If the user is valid
        if (user != null) {
            //If the user has login
            if (user.isIsLogin()) {
                //Return the users page access
                return (String) (user.getAccessFor());
            }
        }
        //return an empty string 
        return "";
    }

    /**
     *This function returns the user who has login
     *@return LoginUser 
     */
    public static LoginUser loginUser(HttpSession session) {
        try {

            LoginUser user = (LoginUser) session.getAttribute(SessionKeys.LOGIN_USER);

            // UserSessionModel().userSessionFind(user.getSessionId());
            return user;
        } catch (Exception e) {
        }
        //Return null if no user is found
        return null;
    }

    public static void setLoginUser(HttpSession session, LoginUser user) {
        try {

            session.setAttribute(SessionKeys.LOGIN_USER, user);

        } catch (Exception e) {
        }

    }

    /**
     *This function returns the user who has login
     *@return LoginUser 
     */
    public static String systemUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        try {
            //Get the User who has login in the current session
            LoginUser user = loginUser(session);
            if (user != null) {
                return user.getUserId(); //Returns the userId
            }
        } catch (Exception e) {
        }
        //Return null if no user is found
        return "0";
    }

    /**
     * indicates whether a user is login
     * @return boolean indicated if login/not
     */
    public static boolean hasLogin(HttpSession session) {
        try {

            //Get the User
            LoginUser user = loginUser(session);
            //If Null
            if (user == null) {
                return false;//Temp value
            } else {
                //Return the status of the user
                return user.isIsLogin();
            }
        } catch (Exception e) {
        }
        return false; //temp value
    }

    /**
     * indicates whether a user is login
     * @return boolean indicated if login/not
     */
    public static boolean hasSubscriberLogin(HttpServletRequest request) {
        try {
            //Get the User
            LoginUser user = loginUser(request.getSession());
            //If Null
            if (user == null) {
                return false;//Temp value
            } else {
                if (user.getUserType().equalsIgnoreCase(SessionKeys.SUBSCRIBER_USER_TYPE) && user.isIsLogin()) {
                    return true;
                }
                //Return the status of the user
                return false;
            }
        } catch (Exception e) {
        }
        return false; //temp value
    }

    /**
     * This function logs the user out and invalidate the session of that particular user
     * @return String the page to go after logout
     */
    public static boolean logoutClient(HttpServletRequest request) {
        log.info("Requested to Logout");
        // Date logOutDate = DateTimeUtil.getCurSqlDate();
        try {
            HttpSession session = request.getSession();
            session.invalidate();
        } catch (Exception e) {
            System.out.println("Error with Session 1st End");
        }

        try {
            // session.setAttribute(SessionKeys.LOGIN_USER, "");
//            long id = 0l;
//            try {
//                   id =Long.parseLong((String) session.getAttribute(SessionKeys.SESSION_ID));
//              new UserSessionModel().killSession(id);
//            } catch (Exception e) {
//            }
//            return true;
        } catch (Exception e) {
            System.out.println("Unable to end Session {logout}");
            e.printStackTrace();
        }



        log.info("Logout Successful");
        return false;
    }

    /**
     * This function logs the user out and invalidate the session of that particular user
     * @return String the page to go after logout
     */
    public static boolean logoutClient(HttpServletRequest request, HttpServletResponse response, String redirectPage) {
        log.info("Requested to Logout");
        // Date logOutDate = DateTimeUtil.getCurSqlDate();
//        try {
//             HttpSession session = request.getSession();
//              session.invalidate();
//        } catch (Exception e) {
//            System.out.println("Error with Session 1st End");
//        }

        try {
            // session.setAttribute(SessionKeys.LOGIN_USER, "");
//            long id = 0l;
//            try {
//                   id =Long.parseLong((String) session.getAttribute(SessionKeys.SESSION_ID));
//              new UserSessionModel().killSession(id);
//            } catch (Exception e) {
//            }
//            return true;
        } catch (Exception e) {
            System.out.println("Unable to end Session {logout}");
            e.printStackTrace();
        }



        log.info("Logout Successful");
        
        ICTCUtil.doRRedirect("/login.jsp", request, response, null);
        log.warn("After Error");
        return false;
    }

    /**
     * This function logs a user in
     * @return boolean  the whether login was successful or not
     */
    public static boolean userLogin(UserWrapper user) {
        try {
//            //Create a login User
//            LoginUser loginUser = new LoginUser();
//            //Set the details for the the loginUser
//            loginUser.setIsLogin(true);
//            loginUser.setDateLogin(DateTimeUtils.getCurSqlDate());
//            loginUser.setUserScreenName(user.getFullName());
//            loginUser.setUserLogin(user);
//            log.log(Level.INFO, "Username : {0}", loginUser.getUserScreenName());
//            loginUser.setUserType(user.getUserType());
//            try {
//
//                //get list of all activities the user is entitiled to do
//
//                List<SystemUserActivity> systemActivities = DS.sessionBean().systemUserActivityPerUser(user);
//                String userAccess = "";
//                System.out.println("System Act length : " + systemActivities.size());
//                List<PageAccess> pages = new ArrayList<PageAccess>();
//                for (SystemUserActivity systemUserActivity : systemActivities) {
//                    userAccess += systemUserActivity.getUserActivityId() + ",";
//                    Activity act = (systemUserActivity.getActivity());
//                    pages.add(new PageAccess(act.getActivityUrl(), act.getActivityName(), act.getActivityId(), act.getParentId()));
//                }
//                log.log(Level.INFO, "User Page Access: {0}", userAccess);
//                loginUser.setAccessFor(userAccess);
//                loginUser.setPages(pages);
//
//            } catch (Exception e) {
//                System.out.println("Oh Login Error " + e.toString());
//            } //Put the User in session View
//            JSFUtility.putSessionValue(MTConstant.LOGIN_USER, loginUser);
//            return true;
        } catch (Exception e) {
        }
        return true;//Temp value
    }

    /**
     * This functions logs the user in
     * @param username the username of the user
     * @param password
     * @param pin
     * @return boolean indicates whether the login was successful or not
     */
    public static boolean userLogin(String username, String password, String pin) {
        try {
            log.info("Starting Authenfication");
            //DB login with the credentials given
//            SystemUser user = DS.sessionBean().systemUserLogin(username, password, pin);
//            //If No User is found
//            if (user == null) {
//                log.warning("No User Found");
//                //Error Message
//                // JSFUtility.warnMessage("Wrong Username or Password");
//                System.out.println("Wrong username or password");
//            } else {
//                log.info("User Found: Login Successful");
//                //Create a new instance of the loginUser
//                return userLogin(user);
//            }
        } catch (Exception e) {
            log.warn("Unable to Authenticate");
        }
        return false;
    }

    /**
     * Returns the language of the user
     * @return 
     */
    public static String languagePreferred(HttpServletRequest req) {
        try {
            String lang = (String) req.getSession().getAttribute("lang");
            if (null == lang || lang.isEmpty()) {
                lang = "en";
            }
            return lang;
        } catch (Exception e) {
        }
        return "en";
    }

    public static void setLanguagePreferred(HttpServletRequest req, String lang) {

        try {
            req.getSession().setAttribute("lang", lang);
        } catch (Exception e) {
        }

    }

    /**
     * 
     * @param request
     * @return 
     */
    public static boolean hasPageAccess(HttpServletRequest request) {

        String url = request.getServletPath();
        try {
            List<PageAccess> pages = null;//loginUser(request.getSession()).getPages();
            if (pages == null) {
                return false;
            }
            for (PageAccess page : pages) {
              //  log.warn("Page "+page.getPath());
                if (page.getPath().equalsIgnoreCase(url)) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Not FOund");
            e.printStackTrace();
            return false;
        }
        return false;
    }
    public static boolean hasPageAccess(HttpServletRequest request,String url) {

      log.warn("Visiting Page : "+url);
        try {
            List<PageAccess> pages = null;//loginUser(request.getSession()).getPages();
            if (pages == null) {
                return false;
            }
            for (PageAccess page : pages) {
              
               // log.warn(page.getPageId()+" PageId : "+page.getPath());
                if (page.getPath().equalsIgnoreCase(url)) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Not FOund");
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public static boolean validateUserAlias(HttpServletRequest request, String alias) {

        try {
            List<PageAccess> pages = null;//loginUser(request.getSession()).getPages();
            if (pages == null) {
                return false;
            }
            for (PageAccess page : pages) {
                if (page.getAlias().equalsIgnoreCase(alias)) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Not FOund");
            e.printStackTrace();
            return false;
        }
        return false;

    }
}
