/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.models;

import com.grameenfoundation.ictc.domains.MobileTracker;
import com.grameenfoundation.ictc.domains.MobileTracker;
import com.grameenfoundation.ictc.domains.User;
import com.grameenfoundation.ictc.domains.Weather;
import com.grameenfoundation.ictc.domains.Weather;
import com.grameenfoundation.ictc.utils.ICTCDBUtil;
import com.grameenfoundation.ictc.utils.Labels;
import com.grameenfoundation.ictc.utils.Neo4jServices;
import com.grameenfoundation.ictc.wrapper.MobileTrackerWrapper;
import com.grameenfoundation.ictc.wrapper.OpenWeather;
import com.grameenfoundation.ictc.wrapper.UserWrapper;
import com.grameenfoundation.ictc.wrapper.WeatherWrapper;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import scala.collection.Iterator;

/**
 *
 * @author skwakwa
 */
public class WeatherModel {

    Logger log = Logger.getLogger(WeatherModel.class.getName());
    Node userParent;

    public boolean create(WeatherWrapper weather) {

        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            Node stNode = ICTCDBUtil.getInstance().getGraphDB().createNode();

            MobileTracker meet = new MobileTracker(stNode);
            stNode.addLabel(Labels.WEATHER);

            Weather w = new Weather(stNode);
            w.setIcon(weather.getIcon());
            w.setDetail(weather.getDetail());
            w.setTemprature(weather.getTemprature());
            w.setMinTemprature(weather.getMinTemprature());
            w.setMaxTemprature(weather.getMaxTemprature());
            w.setTime(weather.getTime());
            w.setLocation(weather.getLocation());
            w.setLocationId(weather.getLocationId());

            trx.success();
            return true;
        } catch (Exception e) {
        }

        return false;

    }

    public void createBulk(List<WeatherWrapper> weathers) {

        
        long time = new Date().getTime();
        String location;
        if(weathers.size() >0){
           location=  weathers.get(0).getLocation();
            deleteWeatherForLatest(location, time);
        }
        for (WeatherWrapper weather : weathers) {
            boolean result = create(weather);
            System.out.println("Result Item : " + result);
        }
    }
    
    
    public void deleteWeatherForLatest(String location,long time){
    
       time  = time/1000;
        String q=" match (n:WEATHER) WHERE n.location='"+location+"' and n.time >= "+time+" delete n ";
        Neo4jServices.executeCypherQuery(q);
    }
    
    
    public  List<WeatherWrapper> getWeatherPerCommunity(){
        String q="match (n:WEATHER) WHERE n.time >= "+(new Date().getTime()/1000)+" return n ";
        return weatherQuery(q, "n");
    }  
    
     private List<WeatherWrapper> weatherQuery(String q, String returnedItem) {
        List<WeatherWrapper> mtg = new ArrayList<>();
        System.out.println("Query Meeting : " + q);
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
            Iterator<Node> n_column = Neo4jServices.executeIteratorQuery(q, returnedItem);
            while (n_column.hasNext()) {
                Weather m = new Weather(n_column.next());
                WeatherWrapper mr = new WeatherWrapper();
                
                mr.setDetail(m.getDetail());
                mr.setLocation(m.getLocation());
                mr.setIcon(m.getIcon());
                mr.setTemprature(m.getTemprature());
                mr.setTime(m.getTime());
                mr.setMinTemprature(m.getMinTemprature());
                mr.setMaxTemprature(m.getMaxTemprature());
               
                
                mtg.add(mr);
            }
            
        }
        return mtg;
    }
}
