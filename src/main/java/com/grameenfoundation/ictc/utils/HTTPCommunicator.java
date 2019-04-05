/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.utils;

import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.net.ConnectException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author seth
 */
public class HTTPCommunicator {

//    private SettingsFacade settingsFacade;
    private static final Logger log = LoggerFactory.getLogger(HTTPCommunicator.class);

    public static String IVR_URL = " http://192.168.1.157:8000/pls/mmarket.api.GM_PLAY_FILE?msisdn=%s&callfile=%s.wav";
    public static String IVR_URL_ETISALAT= "http://airtel1.v2nmobile.co.uk/mmarket/GM_PLAY_FILE?msisdn=%s&callfile=%s.wav";
    public static String SMS_URL = "http://192.168.100.168:8080/pls/vas2nets.inbox_pkg.schedule_sms?password=A850717D6882A6342C59B007131CF2C6&"
            + "username=skwakwa@grameenfoundation.org&sender=%s&receiver=%s&message=%s&message_type=0";
    
    
    public static String SUCCESSFUL_RESPONSE = "1";

    public static String sendSMS(String msisdn, String message,Long provider) {
        String sender =(provider==1l)? "561":"32126";
        String url = "";
        try {
                  url =  String.format(SMS_URL,sender, msisdn, URLEncoder.encode(message,"UTF-8"));

        } catch (Exception e) {
        }
        return (doGet(url));
        //for the interim
//        return sendSimpleMail(msisdn, message, "SMS");
    }


    public static String doGet(String urlStr) {
        URLConnection connection = null;
        try {
            log.info("url BEEN SENT  : "+urlStr);
            System.out.println("Url to send : "+urlStr);
            URL url = new URL(urlStr);
            URI uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef());
            url = uri.toURL();

            // Open the connection
            connection = url.openConnection();
        } catch (Exception e) {
        }

        try {
            InputStream in = connection.getInputStream();

            StringWriter writer = new StringWriter();
            IOUtils.copy(in, writer, "utf-8");
            String theString = writer.toString();
            log.info("Respone : "+theString);
            return theString;
        } catch (Exception e) {
        }
        return "";
    }

    public static String doPost(String serviceUrl, String queryString) {
        URLConnection connection = null;
        try {

            URL url = new URL(serviceUrl);
            URI uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef());
            url = uri.toURL();
            // Open the connection
            connection = url.openConnection();
            connection.setDoInput(true);
            connection.setUseCaches(false); // Disable caching the document
            connection.setDoOutput(true); // Triggers POST.
            connection.setRequestProperty("Content-Type",
                    "text/html");

            OutputStreamWriter writer = null;

            log.info("About to write");
            try {
                if (null != connection.getOutputStream()) {
                    writer = new OutputStreamWriter(connection.getOutputStream());
                    writer.write(queryString); // Write POST query

                } else {
                    log.warn("connection Null");
                }
                // string.
            } catch (ConnectException ex) {
                log.warn("Exception : " + ex);
                // ex.printStackTrace();
            } finally {
                if (writer != null) {
                    try {
                        writer.close();
                    } catch (Exception lg) {
                        log.warn("Exception lg: " + lg.toString());
                        //lg.printStackTrace();
                    }
                }
            }

            InputStream in = connection.getInputStream();

//            StringWriter writer = new StringWriter();
            IOUtils.copy(in, writer, "utf-8");
            String theString = writer.toString();
            return theString;
        } catch (Exception e) {
            //e.printStackTrace();
            log.warn("Error URL " + e.toString());
            return "";
        }
    }

   
}
