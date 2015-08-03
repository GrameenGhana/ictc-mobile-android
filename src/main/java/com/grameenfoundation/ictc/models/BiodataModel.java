/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.models;

import com.grameenfoundation.ictc.domains.Biodata;
import com.grameenfoundation.ictc.utils.CRUDServices;
import com.grameenfoundation.ictc.utils.ICTCDBUtil;
import com.grameenfoundation.ictc.utils.ICTCRelationshipTypes;
import com.grameenfoundation.ictc.utils.Labels;
import com.grameenfoundation.ictc.utils.Neo4jServices;
import com.grameenfoundation.ictc.utils.ParentNode;
import com.grameenfoundation.ictc.wrapper.BiodataWrapper;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.helpers.collection.IteratorUtil;
import scala.collection.Iterator;
import scala.sys.process.processInternal;

/**
 *
 * @author Joseph George Davis
 * @date Jul 16, 2015 1:49:34 PM description:
 */
public class BiodataModel {

    Logger log = Logger.getLogger(BiodataModel.class.getName());
    Node FarmerParent;

    public boolean createBiodata(BiodataWrapper biodataWrapper) {
        boolean created = true;

        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            Node farmerNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.FARMER);

            Biodata biodata = new Biodata(farmerNode);

            if (null == biodataWrapper) {
                log.info("Biodata is invalid");
                created = false;
            } else {
                FarmerParent = ParentNode.FarmerParentNode();

                biodata.setFirstname(biodataWrapper.getFirstName());
                biodata.setLastname(biodataWrapper.getLastName());
                biodata.setAge(biodataWrapper.getAge());
                biodata.setVillage(biodataWrapper.getVillage());
                biodata.setDistrict(biodataWrapper.getDistrict());
                biodata.setCommunity(biodataWrapper.getCommunity());
                biodata.setGender(biodataWrapper.getGender());
                biodata.setMaritalstatus(biodataWrapper.getMaritalStatus());
                biodata.setNickname(biodataWrapper.getNickname());
                biodata.setNumberofchildren(biodataWrapper.getNumberOfChildren());
                biodata.setNumberofdependants(biodataWrapper.getNumberOfDependants());
                biodata.setEducation(biodataWrapper.getEducation());
                biodata.setLastModifiedDate(new Date());

                FarmerParent.createRelationshipTo(farmerNode, ICTCRelationshipTypes.FARMER);

                log.log(Level.INFO, "new node created {0}", biodata.getUnderlyingNode().getId());
                trx.success();

            }

        } catch (Exception e) {

            created = false;
            log.severe("Creation of Farmer Failed");
            e.printStackTrace();
        }

        return created;
    }
    
    
  public boolean createBiodata(Node node)
  {
      boolean created = true;
           
        try(Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
           
            
            if(null == node)
            {
                log.info("Biodata is invalid");
                created = false;
            }
            else
            {
              FarmerParent  = ParentNode.FarmerParentNode();      
              FarmerParent.createRelationshipTo(node,ICTCRelationshipTypes.FARMER);
              
              log.log(Level.INFO, "new node created {0}",node.getId());
              trx.success();
              
              
            }
           
        
            
            
        } catch (Exception e) {
            
            created = false;
            log.severe("Creation of Farmer Failed");
            e.printStackTrace();
        }
        
        return created;  
  }
    
 public Biodata getBiodata(String field, String value) {
        String q = "Start root=node(0) "
                + " MATCH root-[:" + ICTCRelationshipTypes.ENTITY + "]->parent-[:" + ICTCRelationshipTypes.FARMER + "]->p"
                + " where p." + field + "='" + value + "'"
                + " return p";

        System.out.println("Query " + q);
        try {
            Node node = Neo4jServices.executeCypherQuerySingleResult(q, "p");
            if (null != node) {
                return new Biodata(node);
            }
        } catch (Exception e) {
            System.out.println("Unable to Find geofence");
        }

        return null;
    }

    public List<BiodataWrapper> getBioData(String field, String value) {
        List<Biodata> bioData = new ArrayList<>();
        try {
  

            return Neo4jServices.findByLabel(ICTCRelationshipTypes.FARMER, "","");
//            Iterator<Node> n_column = Neo4jServices.findAllByPrimaryRelation(ICTCRelationshipTypes.FARMER, null);
//            while (n_column.hasNext()) {
//                Node node = n_column.next();
//                try {
//                    System.out.println("Node I : "+node.getId());
//                    System.out.println("Node I I: "+(String)node.getProperty(Biodata.FIRST_NAME));
//                } catch (Exception e) {
//                    System.out.println("Exception e : "+e.getLocalizedMessage());
//                }
//                Biodata bd = new Biodata(node);
//                try {
//                    System.out.println("NDII : "+bd.getFirstname());
//                } catch (Exception e) {
//                }
//                bioData.add(bd);
//            }

        } catch (Exception e) {
            System.out.println("Unable to Find Bio Data List  : "+e.getLocalizedMessage());
            e.printStackTrace();
        }

        return null;
    }

    public boolean BiodataToFarmManagement(String biodata, Node farmManagement) {
        boolean created = false;

        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            Biodata b = new BiodataModel().getBiodata(Biodata.LAST_NAME, biodata);

            System.out.println("biodata" + b.getUnderlyingNode().getId());
            if (null != biodata) {

                b.setFarmManagement(farmManagement);
                created = true;
                trx.success();

            }
        } catch (Exception e) {
            System.out.println("error");
            //created = false;

        }

        return created;
    }

    public boolean BiodataToHarvest(String biodata, Node harvest) {
        boolean created = false;

        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            Biodata b = new BiodataModel().getBiodata(Biodata.LAST_NAME, biodata);

            System.out.println("biodata" + b.getUnderlyingNode().getId());
            if (null != biodata) {

                b.setHarvest(harvest);
                created = true;
                trx.success();

            }
        } catch (Exception e) {
            System.out.println("error");
            //created = false;

        }

        return created;
    }

    public boolean BiodataToPostHarvest(String biodata, Node postHarvest) {
        boolean created = false;

        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            Biodata b = new BiodataModel().getBiodata(Biodata.LAST_NAME, biodata);

            System.out.println("biodata" + b.getUnderlyingNode().getId());
            if (null != biodata) {

                b.setPostHarvest(postHarvest);
                created = true;
                trx.success();

            }
        } catch (Exception e) {
            System.out.println("error");
            //created = false;

        }

        return created;
    }

    public boolean BiodataToStorage(String biodata, Node storage) {
        boolean created = false;

        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            Biodata b = new BiodataModel().getBiodata(Biodata.LAST_NAME, biodata);

            System.out.println("biodata" + b.getUnderlyingNode().getId());
            if (null != biodata) {

                b.setStorage(storage);
                created = true;
                trx.success();

            }
        } catch (Exception e) {
            System.out.println("error");
            //created = false;

        }

        return created;
    }

    public boolean BiodataToMarketing(String biodata, Node marketing) {
        boolean created = false;

        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            Biodata b = new BiodataModel().getBiodata(Biodata.LAST_NAME, biodata);

            System.out.println("biodata" + b.getUnderlyingNode().getId());
            if (null != biodata) {

                b.setMarketing(marketing);
                created = true;
                trx.success();

            }
        } catch (Exception e) {
            System.out.println("error");
            //created = false;

        }

        return created;
    }

        try(Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
          
            Biodata b = new BiodataModel().getBiodata(Biodata.ID, biodata);
           

            System.out.println("biodata" + b.getUnderlyingNode().getId());
            if (null != biodata) {

                b.setTechNeeds(techNeeds);
                created = true;
                trx.success();

            }
        } catch (Exception e) {
            System.out.println("error");
            //created = false;

        }

        return created;
    }

}
