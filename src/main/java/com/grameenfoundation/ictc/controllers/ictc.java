/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.controllers;

import com.grameenfoundation.ictc.domains.Operations;
import com.grameenfoundation.ictc.wrapper.OperationsWrapper;
import java.util.Scanner;

/**
 *
 * @author grameen
 */
public class ictc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //genCode("firstName");
        // genWrapperCode("firstName");
        Scanner sc = new Scanner(System.in);
        String input = "";
        while (!sc.next().equals("exit")) {
            System.out.println("Enter Variabe name");

            input = sc.next();
            genWrapperCode(input);
            genGraphCode(input);
        }

    }

    public static void genGraphCode(String param) {
        String variable = "public static String " + param.toUpperCase() + "=" + '"' + param.toLowerCase() + '"' + ";\n";
        String setterMethod = "public void set" + param.substring(0, 1).toUpperCase() + param.substring(1) + "(String " + param.toLowerCase() + ") {\n"
                + "underlyingNode.setProperty(" + param.toUpperCase() + "," + param.toLowerCase() + ");\n" + "}\n\n";

        String getterMethod = "public String get" + param.substring(0, 1).toUpperCase() + param.substring(1) + "(){\n"
                + "          try {\n"
                + "          return (String) underlyingNode.getProperty(" + param.toUpperCase() + ");\n"
                + "\n"
                + "        } catch (Exception e) {\n"
                + "        }\n"
                + "        return null;\n"
                + "    }";

        System.out.println(variable + setterMethod + getterMethod);
        //System.out.println(getterMethod);
    }

    public static void genWrapperCode(String param) {
        String variable = "String " + param + "=" + '"' + param.toLowerCase() + '"' + ";\n";

        String setterMethod = " public  void set" + param.substring(0, 1).toUpperCase() + param.substring(1) + "(String " + param + ") {\n"
                + "      this." + param + "=" + param + ";\n"
                + "    }\n";

        String getterMethod = " public  String get" + param.substring(0, 1).toUpperCase() + param.substring(1) + "() {\n"
                + "        return " + param + ";\n\n"
                + "    }";

        System.out.println(variable + setterMethod + getterMethod);

    }

}
