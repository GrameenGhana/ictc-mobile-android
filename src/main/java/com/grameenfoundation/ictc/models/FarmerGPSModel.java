/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.models;

import com.grameenfoundation.ictc.domains.FarmGPSLocation;
import com.grameenfoundation.ictc.domains.MobileTracker;
import com.grameenfoundation.ictc.utils.ICTCDBUtil;
import com.grameenfoundation.ictc.utils.ICTCRelationshipTypes;
import com.grameenfoundation.ictc.utils.Labels;
import com.grameenfoundation.ictc.utils.Neo4jServices;
import com.grameenfoundation.ictc.utils.ParentNode;
import com.grameenfoundation.ictc.wrapper.FarmGPSLocationWrapper;
import com.grameenfoundation.ictc.wrapper.MobileTrackerWrapper;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.ResourceIterator;
import org.neo4j.graphdb.Transaction;
import scala.collection.Iterator;

/**
 *
 * @author skwakwa
 */
public class FarmerGPSModel {
    
    Logger log = Logger.getLogger(MobileTrackerModel.class.getName());
    Node gpsParent;

    public boolean create(FarmGPSLocationWrapper mw) {

        boolean created = true;

        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
       
            Node stNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.FARM_GPS);

            FarmGPSLocation gps = new FarmGPSLocation(stNode);

            if (null == gps) {
                log.info("FarmGPSLocation is invalid");
                created = false;
            } else {
                
                gpsParent = ParentNode.FarmerGPSParentNode();
                gps.setFarmerId(mw.getFarmerId());            
                gps.setLongitude(mw.getLongitude());
                gps.setLatitude(mw.getLatitude());
              
                Node farmerNode = Neo4jServices.getFarmerNode(mw.getFarmerId());
                
                //FARM_GPS
                gpsParent.createRelationshipTo(stNode, ICTCRelationshipTypes.FARM_GPS);
                
                //HAS_FARM_GPS
                farmerNode.createRelationshipTo(stNode, ICTCRelationshipTypes.HAS_FARM_GPS);
                
                log.log(Level.INFO, "new node created gps.loc {0}", gps.getUnderlyingNode().getId());
                
//                trx.success();
                
                return true;

            }

        } catch (Exception e) {

            created = false;
            log.severe("Creation of gps Failed");
            e.printStackTrace();
        }

        return false;
    }

    public List<FarmGPSLocationWrapper> findAll() {
        return farmGpsQuery("match (l:" + ICTCRelationshipTypes.FARM_GPS + ") return  l", "l");
    }

    public List<FarmGPSLocationWrapper> findPerUser(String user) {
        return farmGpsQuery("match (l:" + ICTCRelationshipTypes.FARM_GPS + ") where l." + FarmGPSLocation.FARMER_ID + "='" + user + "'"
                + " return  l", "l");
    }

    private List<FarmGPSLocationWrapper> farmGpsQuery(String q, String returnedItem) {
        List<FarmGPSLocationWrapper> mtg = new ArrayList<>();
        System.out.println("Query GPS Location : " + q);
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
             ResourceIterator<Node> n_column = Neo4jServices.executeIteratorQuery(q, returnedItem);
            while (n_column.hasNext()) {
                FarmGPSLocation m = new FarmGPSLocation(n_column.next());
                FarmGPSLocationWrapper mr = new FarmGPSLocationWrapper();

                mr.setFarmerId(m.getFarmerId());
                mr.setId(m.getGPSId());
                mr.setLatitude(m.getLatitude());
                mr.setLongitude(m.getLongitude());
                mtg.add(mr);
            }
        }
        return mtg;
    }
}
