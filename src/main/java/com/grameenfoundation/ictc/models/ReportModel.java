/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.models;

import com.grameenfoundation.ictc.utils.Neo4jServices;
import com.grameenfoundation.ictc.wrapper.ListItem;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author skwakwa
 */
public class ReportModel {
    
   public List<ListItem> getInfos(){
        List<ListItem> items = new ArrayList<>();
       items.add(new ListItem("Farmers",new BiodataModel().getFarmerCount()));
       items.add(new ListItem("Target", Neo4jServices.getCollectionValue("sum", "BASELINE_PRODUCTION", "targeted_yield_base")));
       items.add(new ListItem("Revenue", Neo4jServices.getCollectionValue("sum", "BASELINE_PRODUCTION", "revenue_from_sales_base")));
       items.add(new ListItem("Acres", Neo4jServices.getCollectionValue("sum", "BASELINE_PRODUCTION", "area_cultivated_base")));
       items.add(new ListItem("Largest Acre", Neo4jServices.getCollectionValue("max", "BASELINE_PRODUCTION", "area_cultivated_base")));
       items.add(new ListItem("Smallest Acre", Neo4jServices.getCollectionValue("min", "BASELINE_PRODUCTION", "area_cultivated_base")));
       items.add(new ListItem("Cost", Neo4jServices.getCollectionValue("sum", "BASELINE_PRODUCTION", "production_cost")));
        items.add(new ListItem("Gross Margin", Neo4jServices.getCollectionValue("sum", "BASELINE_PRODUCTION", "gross_margin")));
       return items;
    }
    
   public  List<ListItem> getAverageInfos(){
        List<ListItem> items = new ArrayList<>();
       items.add(new ListItem("Average Target", Neo4jServices.getCollectionValue("avg", "BASELINE_PRODUCTION", "targeted_yield_base")));
       items.add(new ListItem("Average Revenue", Neo4jServices.getCollectionValue("avg", "BASELINE_PRODUCTION", "revenue_from_sales_base")));
       items.add(new ListItem("Average Acres", Neo4jServices.getCollectionValue("avg", "BASELINE_PRODUCTION", "area_cultivated_base")));
         items.add(new ListItem("Average Cost", Neo4jServices.getCollectionValue("avg", "BASELINE_PRODUCTION", "production_cost")));
        items.add(new ListItem("Average Gross Margin", Neo4jServices.getCollectionValue("avg", "BASELINE_PRODUCTION", "gross_margin")));
       return items;
    }
     
     
     
     public List<ListItem> getRevenues(){
        List<ListItem> items = new ArrayList<>();
        double totalRevenue = Neo4jServices.getCollectionValue("sum", "BASELINE_PRODUCTION", "revenue_from_sales_base");
        double totalGrossMargin = Neo4jServices.getCollectionValue("sum", "BASELINE_PRODUCTION", "gross_margin");
        double totalCost=Neo4jServices.getCollectionValue("sum", "BASELINE_PRODUCTION", "production_cost");
        double totalAcre= Neo4jServices.getCollectionValue("sum", "BASELINE_PRODUCTION", "area_cultivated_base");
        long farmersCnt =  new BiodataModel().getFarmerCount();
        
       items.add(new ListItem("Average revenue per acre", totalRevenue/totalAcre));
       items.add(new ListItem("Total revenue", Neo4jServices.getCollectionValue("sum", "BASELINE_PRODUCTION", "revenue_from_sales_base")));
       items.add(new ListItem("Average Revenue", Neo4jServices.getCollectionValue("avg", "BASELINE_PRODUCTION", "revenue_from_sales_base")));
        items.add(new ListItem("Total Gross Margin", Neo4jServices.getCollectionValue("sum", "BASELINE_PRODUCTION", "gross_margin")));
         items.add(new ListItem("Average Gross Margin", Neo4jServices.getCollectionValue("avg", "BASELINE_PRODUCTION", "gross_margin")));
      
       items.add(new ListItem("Average Gross Margin/Acre", totalGrossMargin/totalAcre));
       items.add(new ListItem("Average Gross Margin/Farmer", totalGrossMargin/farmersCnt));
       
       
        items.add(new ListItem("Total Cost", totalCost));
         items.add(new ListItem("Average Cost", Neo4jServices.getCollectionValue("avg", "BASELINE_PRODUCTION", "production_cost")));
         
         
        items.add(new ListItem("Gross Margin", Neo4jServices.getCollectionValue("sum", "BASELINE_PRODUCTION", "gross_margin")));
       return items;
    }
     
     
    
}
