/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.models;

import com.grameenfoundation.ictc.domains.Agent;
import com.grameenfoundation.ictc.domains.User;
import com.grameenfoundation.ictc.utils.ICTCDBUtil;
import com.grameenfoundation.ictc.utils.ICTCRelationshipTypes;
import com.grameenfoundation.ictc.utils.Labels;
import com.grameenfoundation.ictc.utils.Neo4jServices;
import com.grameenfoundation.ictc.utils.ParentNode;
import com.grameenfoundation.ictc.utils.security.CryptoLibrary;
import com.grameenfoundation.ictc.wrapper.AgentWrapper;
import com.grameenfoundation.ictc.wrapper.UserWrapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.neo4j.cypher.ExecutionResult;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import scala.collection.Iterator;

/**
 *
 * @author Joseph George Davis
 * @date Oct 30, 2015 11:41:32 AM description:
 */
public class AgentModel {

    Logger log = Logger.getLogger(AgentModel.class.getName());

    public boolean createAgent(AgentWrapper agent) {
        boolean created = true;

        Node AgentParent;

        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            Node agentNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.AGENT);

            Agent ag = new Agent(agentNode);

            if (null == agent) {
                log.info("Agent is invalid");
                created = false;
            } else {
                AgentParent = ParentNode.AgentParentNode();

                ag.setAgentcode(agent.getAgentcode());
                ag.setAgenttype(agent.getAgenttype());
                ag.setEmail(agent.getEmail());
                ag.setFirstname(agent.getFirstname());
                ag.setLastname(agent.getLastname());
                ag.setUsername(agent.getUsername());
                ag.setPassword(agent.getPassword());
                ag.setAgentId(agent.getAgentId());

                AgentParent.createRelationshipTo(agentNode, ICTCRelationshipTypes.AGENT);

                log.log(Level.INFO, "new node created {0}", ag.getUnderlyingNode().getId());
                trx.success();

            }

        } catch (Exception e) {

            created = false;
            log.severe("Creation of Agent Failed");
            e.printStackTrace();
        }

        return created;
    }

    public List<AgentWrapper> findAllAgents() {
        List<AgentWrapper> aglist = new ArrayList<>();

        String q = "match (l:AGENT) return l";

        try (Transaction tx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
            ExecutionResult result = Neo4jServices.executeCypherQuery(q);

            Iterator<Node> n_column = result.columnAs("l");
            while (n_column.hasNext()) {
                // aglist.add(new Agent(n_column.next()));
                Agent ag = new Agent(n_column.next());

                AgentWrapper wrapper = new AgentWrapper();
                wrapper.setAgentcode(ag.getAgentcode());
                wrapper.setAgenttype(ag.getAgenttype());
                wrapper.setEmail(ag.getEmail());
                wrapper.setFirstname(ag.getFirstname());
                wrapper.setLastname(ag.getLastname());
                wrapper.setUsername(ag.getUsername());

                aglist.add(wrapper);

            }
            tx.success();
        }
//        } catch (Exception e) {
//            log.log(Level.SEVERE,e.getMessage());
//            e.printStackTrace();
//        }

        return aglist;
    }

    public AgentWrapper findUser(String username, String password) {
        CryptoLibrary crypt = new CryptoLibrary();
        String q = "match (l:AGENT) WHERE l." + User.USERNAME + "= '" + username + "'  "
                //+ "and  l." + User.PASSWORD + "='" + (password) + "'"
                + "  return l";
        System.out.println("login : " + q);
        List<AgentWrapper> usr = userQuery(q, "l");
        if (null != usr && !usr.isEmpty()) {
            return usr.get(0);
        }
        return null;
    }
    
     public AgentWrapper findUser(String username) {
       
        String q = "match (l:AGENT) WHERE l." + User.USERNAME + "= '" + username + "'  "
                //+ "and  l." + User.PASSWORD + "='" + (password) + "'"
                + "  return l";
        System.out.println("login : " + q);
        List<AgentWrapper> usr = userQuery(q, "l");
        if (null != usr && !usr.isEmpty()) {
            return usr.get(0);
        }
        return null;
    }
     
     
      public Agent getAgent(String field, String value) {
        String q = "Start root=node(0) "
                + " MATCH root-[:" + ICTCRelationshipTypes.ENTITY + "]->parent-[:" + ICTCRelationshipTypes.AGENT + "]->p"
                + " where p." + field + "='" + value + "'"
                + " return p";

        System.out.println("Query " + q);
        try {
            Node node = Neo4jServices.executeCypherQuerySingleResult(q, "p");
            if (null != node) {
                return new Agent(node);
            }
        } catch (Exception e) {
            System.out.println("Unable to Find Agent");
        }

        return null;
    }
    

    private List<AgentWrapper> userQuery(String q, String returnedItem) {
        List<AgentWrapper> usrs = new ArrayList<>();
        System.out.println("Query : " + q);
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
            Iterator<Node> n_column = Neo4jServices.executeIteratorQuery(q, returnedItem);
            while (n_column.hasNext()) {
                Agent u = new Agent(n_column.next());
                AgentWrapper wr = new AgentWrapper();
                wr.setAgentcode(u.getAgentcode());
                wr.setAgenttype(u.getAgenttype());
                wr.setFirstname(u.getFirstname());
                wr.setLastname(u.getLastname());
                wr.setAgentId(u.getAgentId());
                wr.setEmail(u.getEmail());

                usrs.add(wr);
                //todo Find relationship to farmer to replace
//                wr.setMyFarmers(Neo4jServices.findByLabel(Labels.FARMER, ICTCRelationshipTypes.USER, "id", wr.getAgentcode()));
//               wr.(u.getFirstname());
            }

        }
        return usrs;
    }
    
    
    
    public boolean AgentUpdate(String id, Map<String, String> data) {
        
      

        Agent  ag  = getAgent(Agent.USERNAME, id);
        boolean updated = false;
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
            //If the setting is not null
            if (null != ag) {

                for (Map.Entry<String, String> dataEntry : data.entrySet()) {

                    // get the field name
                    String fieldName = dataEntry.getKey();
                    // get the field value
                    String fieldValue = dataEntry.getValue();
                    System.out.println("Updating : "+fieldName+" <> "+fieldValue);
                    // Assigning the alias
                    if (fieldName.equalsIgnoreCase(Agent.AGENTID)) {
                        if (null != fieldValue) {
                            ag.setAgentId(fieldValue);
                        }
                    }
                    
                }
                trx.success();

                updated = true;
                log.log(Level.INFO, "Bio Data Successfully Updated {0}", updated);
               
            } else {

                log.info("Unable to update Bio Data");
            }
        }
        return updated;
    }

}
