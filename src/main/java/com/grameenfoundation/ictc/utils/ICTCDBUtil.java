/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.ictc.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.graphdb.factory.GraphDatabaseSettings;
import org.neo4j.kernel.GraphDatabaseAPI;
import org.neo4j.server.WrappingNeoServerBootstrapper;
import org.neo4j.server.configuration.Configurator;
import org.neo4j.server.configuration.ServerConfigurator;

/**
 *
 * @author Joseph George Davis
 * @date Jul 15, 2015 4:20:36 PM
 * description:
 */
public class ICTCDBUtil {
     static String DATABASE_PATH = null;
    static String PORT = null;
    static String SERVER_HOSTNAME = "0.0.0.0";
    static WrappingNeoServerBootstrapper srv;
    static java.util.logging.Logger log = java.util.logging.Logger.getLogger(ICTCDBUtil.class.getName());
    static GraphDatabaseService database = null;
    private static ICTCDBUtil instance = new ICTCDBUtil();
    private ICTCDBUtil() {}
    
    /**
     * 
     * @return GraphDatabaseService
     */
    
     public static ICTCDBUtil getInstance(){
      return instance;
   }
    
    
    public  GraphDatabaseService startDB()
    {
        GraphDatabaseService graphdb = null;
        
         ServerConfigurator config;
      
        
        String glassishinstanceRootPropertyName = "com.sun.aas.instanceRoot";
        //get path to db config file
        String configFile =  System.getProperty(glassishinstanceRootPropertyName)+ ICTCKonstants.PROPERTIES_FILE;
        System.out.println("File " + configFile);
      
        
        //properties object to load properties file
        Properties dbProperties = new Properties();
        
        //using a try with resources to open a input stream to file
        try(InputStream inputStream = new FileInputStream(configFile))
        {
            //load properties file
            dbProperties.load(inputStream);
            
        } catch (FileNotFoundException ex) {
           //Logger.getLogger(DatabaseUtil.class.getName()).log(Level.ERROR, null, ex);
            System.out.println("File not found " + ex.getLocalizedMessage());
            ex.printStackTrace();
        }
        catch(Exception ex)
        {
          System.out.println("File not found " + ex.getLocalizedMessage());
           ex.printStackTrace(); 
        }
        
        try {
        DATABASE_PATH = dbProperties.getProperty("graphdb.location");
        PORT = dbProperties.getProperty("graphdb.port");
        
        log.log(Level.INFO, "DB Path - :{0}", DATABASE_PATH);
        log.log(Level.INFO, "DB Port - :{0}", PORT);
        
       // System.out.println("DB Path - :" + DATABASE_PATH);
       // System.out.println("DB Path - :" + PORT);
        //creating a graphdatabase using settings in properties file
        graphdb =  new GraphDatabaseFactory().newEmbeddedDatabaseBuilder(DATABASE_PATH).
                setConfig(GraphDatabaseSettings.node_keys_indexable,  dbProperties.getProperty("node_keys_indexable")).
                setConfig(GraphDatabaseSettings.node_auto_indexing,  dbProperties.getProperty("node_auto_indexing")).
                setConfig(GraphDatabaseSettings.cache_type,  dbProperties.getProperty("cache_type")).
               //setConfig(GraphDatabaseSettings.allow_store_upgrade,  dbProperties.getProperty("allow_store_upgrade")).
                setConfig(GraphDatabaseSettings.nodestore_propertystore_mapped_memory_size,  dbProperties.getProperty("nodestore_propertystore_mapped_memory_size")).
                setConfig(GraphDatabaseSettings.nodestore_mapped_memory_size, dbProperties.getProperty("nodestore_mapped_memory_size")).
                setConfig(GraphDatabaseSettings.relationshipstore_mapped_memory_size,  dbProperties.getProperty("relationshipstore_mapped_memory_size")).
                setConfig(GraphDatabaseSettings.strings_mapped_memory_size, dbProperties.getProperty("strings_mapped_memory_size")).
                setConfig(GraphDatabaseSettings.nodestore_mapped_memory_size, dbProperties.getProperty("nodestore_mapped_memory_size")).
                setConfig(GraphDatabaseSettings.relationship_auto_indexing, dbProperties.getProperty("relationship_auto_indexing")).
                //setConfig( GraphDatabaseSettings., "true" ).
                newGraphDatabase();
        
           log.log(Level.INFO, "{0} Database ", graphdb.isAvailable(2));
       
       config = new ServerConfigurator((GraphDatabaseAPI) graphdb);
                 
         config.configuration().setProperty(
         Configurator.WEBSERVER_PORT_PROPERTY_KEY,PORT);
         config.configuration().setProperty(
         Configurator.WEBSERVER_ADDRESS_PROPERTY_KEY, SERVER_HOSTNAME);

            srv = new WrappingNeoServerBootstrapper((GraphDatabaseAPI) graphdb, config);
            
            database = graphdb;
           
            srv.start();
        } catch (Exception e) {
            log.log(Level.SEVERE, "DS Error : {0}", e.getLocalizedMessage());

              e.printStackTrace();
        }
   
        registerShutdownHook(graphdb);
        return graphdb;
    }
    
    
     /**
     * returns created database
     * @return 
     */
     public GraphDatabaseService getGraphDB() {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
        return database;
    }
    
      /**
     * <pre>
     * Registers a shutdown hook for the Neo4j instance so that it
     * shuts down nicely when the VM exits (even if you "Ctrl-C" the  running example before it's completed)
     * @param GraphDatabaseService graphDb
     * </pre>
     */
    private static void registerShutdownHook(final GraphDatabaseService graphDb) {
        Runtime.getRuntime().addShutdownHook(new Thread() {

            @Override
            public void run() {
                graphDb.shutdown();
                srv.stop();
            }
        });
    }
    
    
      public void shutdown(final GraphDatabaseService graphDb) {

        try {
            graphDb.shutdown();
        } catch (Exception e) {
            log.log(Level.WARNING, "Shut Down Thread {0}", e.getLocalizedMessage());
        }
      }
    
    

}
