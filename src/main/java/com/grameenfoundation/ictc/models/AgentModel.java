/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.ictc.models;

import com.grameenfoundation.ictc.domains.Agent;
import com.grameenfoundation.ictc.utils.ICTCDBUtil;
import com.grameenfoundation.ictc.utils.ICTCRelationshipTypes;
import com.grameenfoundation.ictc.utils.Labels;
import com.grameenfoundation.ictc.utils.Neo4jServices;
import com.grameenfoundation.ictc.utils.ParentNode;
import com.grameenfoundation.ictc.wrapper.AgentWrapper;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.neo4j.cypher.ExecutionResult;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import scala.collection.Iterator;
/**
 *
 * @author Joseph George Davis
 * @date Oct 30, 2015 11:41:32 AM
 * description:
 */
public class AgentModel {
    
     Logger log = Logger.getLogger(AgentModel.class.getName());
    
     public boolean createAgent(AgentWrapper agent) {
        boolean created = true;
        
     Node AgentParent;

        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            Node agentNode= ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.AGENT);

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
 
                AgentParent.createRelationshipTo(agentNode, ICTCRelationshipTypes.AGENT);

                log.log(Level.INFO, "new node created {0}",ag.getUnderlyingNode().getId());
                trx.success();

            }

        } catch (Exception e) {

            created = false;
            log.severe("Creation of Agent Failed");
            e.printStackTrace();
        }
        
        return created;
     } 
     
     
   public List<AgentWrapper> findAllAgents()
   {
     List<AgentWrapper> aglist =  new ArrayList<>();
     
     String q = "match (l:AGENT) return l";
       
        try(Transaction tx = ICTCDBUtil.getInstance().getGraphDB().beginTx() ) {
            ExecutionResult result = Neo4jServices.executeCypherQuery(q);
            
            Iterator<Node> n_column = result.columnAs("l");
            while (n_column.hasNext()) {
               // aglist.add(new Agent(n_column.next()));
                    Agent ag =new Agent(n_column.next());
                  
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
     

}
