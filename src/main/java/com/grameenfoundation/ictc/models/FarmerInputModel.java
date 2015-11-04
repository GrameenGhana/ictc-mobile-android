/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.models;

import com.grameenfoundation.ictc.domains.Biodata;
import com.grameenfoundation.ictc.domains.CropCalendar;
import com.grameenfoundation.ictc.domains.FarmerInputReceived;
import com.grameenfoundation.ictc.utils.ICTCDBUtil;
import com.grameenfoundation.ictc.utils.ICTCRelationshipTypes;
import com.grameenfoundation.ictc.utils.Labels;
import com.grameenfoundation.ictc.utils.Neo4jServices;
import com.grameenfoundation.ictc.utils.ParentNode;
import com.grameenfoundation.ictc.wrapper.CropCalendarWrapper;
import com.grameenfoundation.ictc.wrapper.FarmerInputReceivedWrapper;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import scala.collection.Iterator;

/**
 *
 * @author skwakwa
 */
public class FarmerInputModel {

    Logger log = Logger.getLogger(FarmerInputModel.class.getName());
    Node farmInput;

    public FarmerInputReceived create(FarmerInputReceivedWrapper setting) {
        boolean created = true;

        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
            Node stNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.FARM_INPUT);

            FarmerInputReceived fic = new FarmerInputReceived(stNode);

            if (fic != null) {
                farmInput = ParentNode.FarmInputReceivedNode();
                fic.setStatus(setting.getStatus());
                fic.setName(setting.getName());
                fic.setQty(setting.getQty());
                if (setting.getDateReceived() != null) {
                    fic.setDateReceived(setting.getDateReceived());
                }

                Node farmerNode = Neo4jServices.executeSingleQuery(" match (n:" + Labels.FARMER + ") where n." + Biodata.ID + "='" + setting.getFarmer() + "'",
                        "n");

                farmInput.createRelationshipTo(stNode, ICTCRelationshipTypes.FARM_INPUT_RECEIVED);
                farmerNode.createRelationshipTo(stNode, ICTCRelationshipTypes.HAS_FARM_INPUT);

                log.log(Level.INFO, "new node created. {0}", fic.getUnderlyingNode().getId());
                trx.success();
                return fic;

            } else {
                log.info("meeting is invalid");
                created = false;
            }
        }

        return null;

    }

    public boolean update(String id, String name, double qty) {
        boolean created = true;

        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            String q = "MATCH (l:" + Labels.FARM_INPUT + ")<-[:" + ICTCRelationshipTypes.HAS_FARMER + "]-f where f." + Biodata.ID + "= '" + id + "' and  l." + FarmerInputReceived.NAME + "='" + name + "' "
                    + " set l." + FarmerInputReceived.QTY + "=" + qty + " return  l order by l." + CropCalendar.RELATIVE_WEEK + " asc";
            getFarmInput(q, "l");
            return true;
        }

        

    }

    public List<FarmerInputReceivedWrapper> getFarmerInputs(String farmer) {

        String q = "MATCH (l:" + Labels.FARM_INPUT + ")<-[:" + ICTCRelationshipTypes.HAS_FARMER + "]-f where f." + Biodata.ID + "= '" + farmer + "' return  l order by l." + CropCalendar.RELATIVE_WEEK + " asc";
        return getFarmInput(q, "l");
    }

    public FarmerInputReceivedWrapper getFarmerInputs(String farmer, String type) {

        String q = "MATCH (l:" + Labels.FARM_INPUT + ")<-[:" + ICTCRelationshipTypes.HAS_FARMER + "]-f where f." + Biodata.ID + "= '" + farmer + "' and  l." + FarmerInputReceived.NAME + "='" + type + "' return  l order by l." + CropCalendar.RELATIVE_WEEK + " asc";
        return getFarmInput(q, "l").get(0);
    }

    public List<FarmerInputReceivedWrapper> getFarmInput(String q, String returnItem) {

        List<FarmerInputReceivedWrapper> usrs = new ArrayList<>();
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
            Iterator<Node> n_column = Neo4jServices.executeIteratorQuery(q, returnItem);
            while (n_column.hasNext()) {
                FarmerInputReceived setting = new FarmerInputReceived(n_column.next());
                FarmerInputReceivedWrapper fic = new FarmerInputReceivedWrapper();

                fic.setStatus(setting.getStatus());
                fic.setName(setting.getName());
                fic.setQty(setting.getQty());
                usrs.add(fic);
            }
        }
        return usrs;
    }
}
