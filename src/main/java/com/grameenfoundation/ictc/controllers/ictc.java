/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.controllers;

import com.grameenfoundation.ictc.domains.Operations;
import com.grameenfoundation.ictc.domains.PostHarvest;
import com.grameenfoundation.ictc.utils.ICTCDBUtil;
import com.grameenfoundation.ictc.utils.Neo4jServices;
import com.grameenfoundation.ictc.wrapper.OperationsWrapper;
import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.json.JSONObject;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.Transaction;
import org.neo4j.shell.util.json.JSONArray;

/**
 *
 * @author grameen
 */
public class ictc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           // try {
                 //TODO code application logic here
                
                //genCode("firstName");
//                 //genWrapperCode("firstName");
//        Scanner sc = new Scanner(System.in);
//        String input = "";
//        while (!sc.next().equals("exit")) {
//            System.out.println("Enter Variabe name");
//
//            input = sc.next();
//            genWrapperCode(input);
//            genGraphCode(input);
//       }
        
     String s = "ASHANTI|EJURA SEKYEREDUMASE|EJURA";
   s=  s.replace("|","-");
      for (String retval: s.split("-")) {
         System.out.println(retval);
      }

//        String codefrom = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n" +
//"Info:   <html>\n" +
//"Info:   <head>\n" +
//"Info:   <meta HTTP-EQUIV=\"PRAGMA\" CONTENT=\"NO-CACHE\">\n" +
//"Info:   <script>\n" +
//"Info:   if (this.SfdcApp && this.SfdcApp.projectOneNavigator) { SfdcApp.projectOneNavigator.handleRedirect('{   username : konetyme@ictc.org,   userId : 00525000000xaRRAAY,   responseCode : 00 }'); }  else\n" +
//"Info:   if (window.location.replace){\n" +
//"Info:   window.location.replace('{   username : konetyme@ictc.org,   userId : 00525000000xaRRAAY,   responseCode : 00 }');\n" +
//"Info:   } else {;\n" +
//"Info:   window.location.href ='{   username : konetyme@ictc.org,   userId : 00525000000xaRRAAY,   responseCode : 00 }';\n" +
//"Info:   }\n" +
//"Info:   </script>\n" +
//"Info:   </head>\n" +
//"Info:   </html>\n" +
//"Info:   <!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\"><html><head>    <meta HTTP-EQUIV=\"PRAGMA\" CONTENT=\"NO-CACHE\"><script>if (this.SfdcApp && this.SfdcApp.projectOneNavigator) { SfdcApp.projectOneNavigator.handleRedirect('{   username : konetyme@ictc.org,   userId : 00525000000xaRRAAY,   responseCode : 00 }'); }  else if (window.location.replace){ window.location.replace('{   username : konetyme@ictc.org,   userId : 00525000000xaRRAAY,   responseCode : 00 }');} else {;window.location.href ='{   username : konetyme@ictc.org,   userId : 00525000000xaRRAAY,   responseCode : 00 }';} </script></head></html>\n" +
//"Info:   Agent Created";
        
//        String u = "konetyme@ictc.org";
//        
//        System.out.println(u.substring(0,u.indexOf("@")));
//        
//        String onetyme =codefrom.substring(codefrom.indexOf("'"), codefrom.indexOf(";"));
//        
//        String jsonformat =onetyme.substring(onetyme.indexOf("'")+1, onetyme.lastIndexOf("'"));
//        
//        JSONObject json = new JSONObject(jsonformat);
//        System.out.println(json.toString());
        
//        String  f = "https://na1.salesforce.com/servlet/servlet.FileDownload?file=00P24000004ovnVEAQ";
//        
//        System.out.println(f.substring(f.indexOf("=")+1));
        
        
//        String query = "match (n:FARMER)-[:HAS_POSTHARVEST]->(f) where n.firstname='Koi' return f";
//        
//        GraphDatabaseService db =  ICTCDBUtil.getInstance().getGraphDB();
//        
//        
//        try(Transaction tx = db.beginTx()) {
//
//            org.neo4j.graphdb.Node node;
//            node = Neo4jServices.executeCypherQuerySingleResult(query,"f");
//            
//            
//            System.out.println("post " + new PostHarvest(node).getId());
//            
//            
//            
//        } 
//        
//        String user = "spo@ictc.org";
//        
//        System.out.println(user.substring(0, user.indexOf("@")));
//       
          //System.out.println("3.josss".substring(0,1));       
                
//                File xmlFile = new File("/home/grameen/test.xml");
//                DocumentBuilderFactory db = DocumentBuilderFactory.newInstance();
//                DocumentBuilder builder = null;
//                try {
//                    builder = db.newDocumentBuilder();
//                } catch (ParserConfigurationException ex) {
//                    Logger.getLogger(TestServlet.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                
//                Document doc = builder.parse(xmlFile);
//                
//                doc.getDocumentElement().normalize();;
//                
//                System.out.println("Root element :" + doc.getDocumentElement());
//                
//                Node node = doc.getDocumentElement();
//                
//                System.out.println(node.getChildNodes().getLength());
//                String nodeName= null;
//                org.neo4j.graphdb.Node nid = null;
//                NodeList n =  doc.getElementsByTagName("sObject");
//                NodeList nlst = node.getChildNodes();
//                //Node object = n.item(1);
//                System.out.println("object " + n.getLength());
//                
//                 for (int j = 0; j < n.getLength(); j++) {
//
//                              Node rowNode = n.item(j);
//                            //  Map<String,String> m = (Map<String,String>) rowNode.getAttributes();
//                              String salesforceObj = rowNode.getAttributes().getNamedItem("xsi:type").getNodeValue();
//                              System.out.println(salesforceObj);
//                             for(int k=0;k< rowNode.getChildNodes().getLength();k++)
//                             {
//                                
//                                  System.out.println("node: " + rowNode.getChildNodes().item(k).getNodeName()+": "+ rowNode.getChildNodes().item(k).getTextContent());
//                                  if(rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id"))
//                                     System.out.println("id : " + getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()));
//                                  
//                                  if(!rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id") && !rowNode.getChildNodes().item(k).getNodeName().equals("#text"))
//                                  {
//                                  
//                                   System.out.println(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()));
//                                  // String nnn = nodeName.substring(0,nodeName.indexOf('_') );
//                                    //System.out.println(nnn);
//                                   
//                                  }
//                             }   // System.out.println("node: " + rowNode.getTextContent());
            // }
                
                
//            for (int i = 1; i < n.getLength(); i++) {
//                
//                Node nd = n.item(i);
//                
//                nodeName = nd.getNodeName().substring(3);
//                System.out.println(nodeName);
//                String nnn = nodeName.substring(0,nodeName.indexOf('_') );
//                 nid.setProperty(nnn, nd.getNodeValue());
//                 
//                System.out.println(nnn);
//            
//            }
                
//            } catch (SAXException ex) {
//                Logger.getLogger(ictc.class.getName()).log(Level.SEVERE, null, ex);
           //  catch (IOException ex) {
            //Logger.getLogger(ictc.class.getName()).log(Level.SEVERE, null, ex);
        

            //}
        
//        try (BufferedReader br = new BufferedReader(new FileReader("/home/grameen/acdivoca/data.a2")))
//		{
//
//			String sCurrentLine;
//                     
//                        JSONArray ja = new JSONArray();
//                        JSONObject x = null;
//                        JSONObject y = null;
//                        String json ="";
//                        String replace = null;
//                        int i =0;
//
//			while ((sCurrentLine = br.readLine()) != null) {
//				//System.out.println(sCurrentLine+";");
//// 
//                           // sCurrentLine+=";";
////                                tag = sCurrentLine.split(";");
////                                 for (int j = 0; j < tag.length; j++) {
////                                   json =tag[j].replace("~", "\":\"").replace("\t","\",\"");
////                                     System.out.println("{\""+json+"\"}");
////                                
////                                      }
//                             if(sCurrentLine.contains("DATASET"))
//                             {
//                                  sCurrentLine = sCurrentLine.replace("~", "\":\"").replace("\t","\",\"");
//                                  sCurrentLine +="\"" ;
//                                 sCurrentLine ="{\""+sCurrentLine+"}";
//                                  x = new JSONObject(sCurrentLine);
//                                  ja.put(x);
//                             }
//                             else
//                             {
//                                sCurrentLine = sCurrentLine.replace("~", "\":\"").replace("\t","\",\"");
//                               // sCurrentLine = sCurrentLine.replace("\\", "\\\\");
//                                sCurrentLine = sCurrentLine.substring(0, sCurrentLine.lastIndexOf(","));
//                               // sCurrentLine ="{\""+sCurrentLine+"}";
//                              //  y = new JSONObject(sCurrentLine);
//                              //  ja.put(y);
//                                
//                             }
//                                  // Ssoystem.out.println(sCurrentLine);
//                             //System.out.println("{\""+sCurrentLine+"}");
//                            //   json += "{\""+sCurrentLine+"}";
//                             
//                              //  System.out.println("taaaal "+json);
//                            //  break;
//                              
//			}
//                        
//                        //  replace = json.replace("\\", "\\\\");
//                      //  System.out.println("json all-----------------------------------------------\n " + json);
//                       // JSONObject x= new JSONObject(json);
//                   
//                     System.out.println("data :" +ja.toString());
//
//		} catch (Exception e) {
//                         
//                    System.out.println("ththh " + e.getMessage());
//	             e.printStackTrace();
//                        
//		}

        
    }
    
    
   public static String getObjectFieldName(String field){
        
       String nodeName = field.substring(3);
       System.out.println(nodeName);
       String finalField = nodeName.substring(0,nodeName.indexOf('_') ); 
       return finalField;
       
        
    }
    
    
    public static String getObjectFieldId(String id)
    {
      return id.substring(3);
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
