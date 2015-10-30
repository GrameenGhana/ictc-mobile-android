/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.ictc.models;

import com.grameenfoundation.ictc.utils.ICTCDBUtil;
import com.grameenfoundation.ictc.utils.Labels;
import com.grameenfoundation.ictc.wrapper.AgentWrapper;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
/**
 *
 * @author Joseph George Davis
 * @date Oct 30, 2015 11:41:32 AM
 * description:
 */
public class AgentModel {
    
    
    
     public boolean createBiodata(AgentWrapper agent) {
        boolean created = true;

        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            Node farmerNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.AGENT);

            Agent ag = new Agent(farmerNode);

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

}
