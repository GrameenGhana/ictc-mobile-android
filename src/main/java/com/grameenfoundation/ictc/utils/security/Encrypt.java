/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.utils.security;

/**
 *
 * @author Seth Adarkwa Kwakwa
 */

public class Encrypt {

    public static CryptoLibrary cl = new CryptoLibrary();

    /*
     *@param str the String to be encoded
     *@return String the encoded String
     */
    public static String encode(String str) {
        return cl.encrypt(str);
    }

    /*
     *@param str the String to be decoded
     *@return String the decoded String
     */
    public static String decode(String str) {

        return cl.decrypt(str);
    }

    /*
     *@param md5 the string to be encypted to MD5
     *@return String that has been encrypted with MD5
     */
    public static String MD5(String md5) {
        try {
            
            //Creating an instance of the message digest
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;



    }
    
    /*
     *@param md5 the string to be encypted to SHA1
     *@return String that has been encrypted with SHA1
     */
    public static String SHA1(String md5) {
        try {
            
            //Creating an instance of the message digest
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA1");
            byte[] array = md.digest(md5.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;



    }
}