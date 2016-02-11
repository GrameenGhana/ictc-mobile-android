/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.ictc.models;


import com.grameenfoundation.ictc.domains.Ouestion;
import com.grameenfoundation.ictc.domains.Profiling;
import com.grameenfoundation.ictc.utils.ICTCDBUtil;
import com.grameenfoundation.ictc.utils.ICTCRelationshipTypes;
import com.grameenfoundation.ictc.utils.Neo4jServices;
import java.util.ArrayList;
import java.util.List;
import org.neo4j.cypher.ExecutionResult;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.ResourceIterator;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.Transaction;
import scala.collection.Iterator;

/**
 *
 * @author Joseph George Davis
 * @date Oct 5, 2015 11:02:11 AM
 * description:
 */
public class ProfilingModel {
    
       public Profiling getProfile(String field, String value) {
           
        Profiling pp = null;
       //try(Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx())
       //{
        String q = "Start root=node(0) "
                + " MATCH root-[:" + ICTCRelationshipTypes.ENTITY + "]->parent-[:" + ICTCRelationshipTypes.FARMER + "]->f-[:"+ICTCRelationshipTypes.HAS_PROFILING+
                "]->p"
                + " where f." + field + "='" + value + "'"
                + " return p";

        System.out.println("Query " + q);
        try {
            Node node = Neo4jServices.executeCypherQuerySingleResult(q, "p");
            if (null != node) {
              pp =new Profiling(node);
              System.out.println("Profile in action " + pp.getFarmrecordkeepingstatus());
              return pp;
            }
        } catch (Exception e) {
            System.out.println("Unable to Profile " + e.getMessage());
            e.printStackTrace();
       // }
       // trx.success();
       }

        return pp;
    }
       
       
    public Ouestion getScoreByAnswer(String field, String value) {
        
        List<Ouestion> actList = new ArrayList<Ouestion>();
        
       // try(Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx())
      // { 
        String q = "Start root=node(0) "
                + " MATCH root-[:" + ICTCRelationshipTypes.ENTITY + "]->parent-[:" + ICTCRelationshipTypes.QUESTION + "]->f"
                + " where f." + field + "='" + value + "'"
                + " return f";

        System.out.println("Query " + q);
        try {
            Result result = Neo4jServices.executeCypherQuery(q);
            
             ResourceIterator<Node> n_column = result.columnAs("f");
            
            while(n_column.hasNext())
            {
                actList.add(new Ouestion(n_column.next()));
            }
            System.out.println("List number " +actList.size());
             if(actList.size()> 0)
                return actList.get(0);
            
            
        } catch (Exception e) {
            System.out.println("Unable to get score");
      //  }
        
        
        //trx.success();
       }
           
       
        
       
        return null;
    }    
       
    

}
