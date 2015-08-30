/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.models;

import com.grameenfoundation.ictc.domains.Storage;
import com.grameenfoundation.ictc.domains.User;
import com.grameenfoundation.ictc.utils.ICTCDBUtil;
import com.grameenfoundation.ictc.utils.ICTCRelationshipTypes;
import com.grameenfoundation.ictc.utils.Labels;
import com.grameenfoundation.ictc.utils.Neo4jServices;
import com.grameenfoundation.ictc.utils.ParentNode;
import com.grameenfoundation.ictc.utils.security.CryptoLibrary;
import com.grameenfoundation.ictc.wrapper.StorageWrapper;
import com.grameenfoundation.ictc.wrapper.UserWrapper;
import java.util.ArrayList;
import java.util.Date;
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
public class UserModel {

    Logger log = Logger.getLogger(UserModel.class.getName());
    Node userParent;

    public User create(UserWrapper st) {
        boolean created = true;

        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            Node stNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.USER);

            User stg = new User(stNode);

            if (null == st) {
                log.info("storage is invalid");
                created = false;
            } else {
                userParent = ParentNode.AgentParentNode();

                stg.setAgentCode(st.getAgentCode());
                stg.setAgentID(st.getID());
                stg.setAgentType(st.getAgentType());
                stg.setFirstname(st.getFirstName());
                stg.setLastname(st.getLastName());

                stg.setStatus("ACTIVE");
                stg.setCreatedOn(new Date());

                userParent.createRelationshipTo(stNode, ICTCRelationshipTypes.USER);

                log.log(Level.INFO, "new node created. {0}", stg.getUnderlyingNode().getId());
                trx.success();
                return stg;

            }

        } catch (Exception e) {

            created = false;
            log.severe("Creation of Farmer Failed");
            e.printStackTrace();
        }

        return null;
    }

    public List<UserWrapper> findAll() {

        return userQuery("match (l:USER) return  l", "l");
    }

    public List<UserWrapper> findByType(String userType) {

        return userQuery("match (l:USER) where l." + User.AGENT_TYPE + "='" + userType + "' return  l", "l");
    }

    public List<UserWrapper> findByTypeStatus(String userType, String status) {

        return userQuery("match (l:USER) where l." + User.AGENT_TYPE + "='" + userType + "' and l." + User.AGENT_TYPE + "='" + status + "' return  l", "l");
    }

    public UserWrapper findUser(String username, String password) {
        CryptoLibrary crypt = new CryptoLibrary();
        String q = "match (l:USER) WERE l." + User.USERNAME + "= '" + username + "'  and  l." + User.PASSWORD + "='" + crypt.encrypt(password) + "'  return l";
        List<UserWrapper> usr = userQuery(q, "l");
        if (null != usr) {
            return usr.get(0);
        }
        return null;
    }

private List<UserWrapper> userQuery(String q, String returnedItem) {
List<UserWrapper> usrs = new ArrayList<>();
        System.out.println("Query : "+q);
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
            Iterator<Node> n_column = Neo4jServices.executeIteratorQuery(q, returnedItem);
            while (n_column.hasNext()) {
                User u = new User(n_column.next());
                UserWrapper wr = new UserWrapper();
                wr.setAgentCode(u.getAgentCode());
                wr.setAgentType(u.getAgenttype());
                wr.setFirstName(u.getFirstname());
                wr.setID(u.getAgentID());

                wr.setOrganisation(u.getOrganisation());
                usrs.add(wr);
               //todo Find relationship to farmer to replace
                wr.setMyFarmers(Neo4jServices.findByLabel(Labels.FARMER, ICTCRelationshipTypes.USER, "id", wr.getID()));
//               wr.(u.getFirstname());
            }
           
        }
        return usrs;
    }
}
