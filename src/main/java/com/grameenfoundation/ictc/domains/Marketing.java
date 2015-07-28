/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.ictc.domains;

import com.grameenfoundation.ictc.domain.commons.GeneralInterface;
import com.grameenfoundation.ictc.domain.commons.Status;
import org.neo4j.graphdb.Node;

/**
 *
 * @author Joseph George Davis
 * @date Jul 22, 2015 4:33:50 PM
 * description:
 */
public class Marketing extends Status implements GeneralInterface{

  Node underlyingNode;
    
 public static String MAINPOINTOFCONTACT="mainpointofcontact";
 public static String MONTHSELLINGBEGINS="monthsellingbegins";
 public static String PRICEOFFIRSTHARVESTPRODUCE="priceoffirstharvestproduce";
 public static String MONTHMOSTHARVESTPRODUCESOLD="monthmostharvestproducesold";
 public static String PRICEMOSTHARVESTPRODUCESOLD="pricemostharvestproducesold";
 public static String MONTHFINALBATCHSOLD="monthfinalbatchsold";
 public static String PRICEFINALBATCHSOLD="pricefinalbatchsold";
 public static String MONTHSELLINGDRIEDCHIPCHICKS="monthsellingdriedchipchicks";
 public static String PRICEFIRSTDRIEDCHIPCHUNK="pricefirstdriedchipchunk";
 public static String MONTHMOSTDRIEDCHIPSCHUNKSSOLD="monthmostdriedchipschunkssold";
 public static String PRICEMOSTDRIEDCHIPSCHUNKSSOLD="pricemostdriedchipschunkssold";
 public static String MONTHLASTBATCHDRIEDCHIPCHUNKSSOLD="monthlastbatchdriedchipchunkssold";
 public static String PRICEFINALBATCHDRIEDCHIPSCHUNKSSOLD="pricefinalbatchdriedchipschunkssold";
 
 
public void setPriceFinalBatchDriedChipsChunksSold(String pricefinalbatchdriedchipschunkssold) {
underlyingNode.setProperty(PRICEFINALBATCHDRIEDCHIPSCHUNKSSOLD,pricefinalbatchdriedchipschunkssold);
}

public String getPriceFinalBatchDriedChipsChunksSold(){
          try {
          return (String) underlyingNode.getProperty(PRICEFINALBATCHDRIEDCHIPSCHUNKSSOLD);

        } catch (Exception e) {
        }
        return null;
    }

 
 
public void setMonthLastBatchDriedChipChunksSold(String monthlastbatchdriedchipchunkssold) {
underlyingNode.setProperty(MONTHLASTBATCHDRIEDCHIPCHUNKSSOLD,monthlastbatchdriedchipchunkssold);
}

public String getMonthLastBatchDriedChipChunksSold(){
          try {
          return (String) underlyingNode.getProperty(MONTHLASTBATCHDRIEDCHIPCHUNKSSOLD);

        } catch (Exception e) {
        }
        return null;
    }

 
public void setPriceMostDriedChipsChunksSold(String pricemostdriedchipschunkssold) {
underlyingNode.setProperty(PRICEMOSTDRIEDCHIPSCHUNKSSOLD,pricemostdriedchipschunkssold);
}

public String getPriceMostDriedChipsChunksSold(){
          try {
          return (String) underlyingNode.getProperty(PRICEMOSTDRIEDCHIPSCHUNKSSOLD);

        } catch (Exception e) {
        }
        return null;
    }

 
 
public void setMonthMostDriedChipsChunksSold(String monthmostdriedchipschunkssold) {
underlyingNode.setProperty(MONTHMOSTDRIEDCHIPSCHUNKSSOLD,monthmostdriedchipschunkssold);
}

public String getMonthMostDriedChipsChunksSold(){
          try {
          return (String) underlyingNode.getProperty(MONTHMOSTDRIEDCHIPSCHUNKSSOLD);

        } catch (Exception e) {
        }
        return null;
    }

 
 
public void setPriceFirstDriedChipChunk(String pricefirstdriedchipchunk) {
underlyingNode.setProperty(PRICEFIRSTDRIEDCHIPCHUNK,pricefirstdriedchipchunk);
}

public String getPriceFirstDriedChipChunk(){
          try {
          return (String) underlyingNode.getProperty(PRICEFIRSTDRIEDCHIPCHUNK);

        } catch (Exception e) {
        }
        return null;
    }

 
 
public void setMonthSellingDriedChipChicks(String monthsellingdriedchipchicks) {
underlyingNode.setProperty(MONTHSELLINGDRIEDCHIPCHICKS,monthsellingdriedchipchicks);
}

public String getMonthSellingDriedChipChicks(){
          try {
          return (String) underlyingNode.getProperty(MONTHSELLINGDRIEDCHIPCHICKS);

        } catch (Exception e) {
        }
        return null;
    }

 
 
public void setPriceFinalBatchSold(String pricefinalbatchsold) {
underlyingNode.setProperty(PRICEFINALBATCHSOLD,pricefinalbatchsold);
}

public String getPriceFinalBatchSold(){
          try {
          return (String) underlyingNode.getProperty(PRICEFINALBATCHSOLD);

        } catch (Exception e) {
        }
        return null;
    }

 
 
public void setMonthFinalBatchSold(String monthfinalbatchsold) {
underlyingNode.setProperty(MONTHFINALBATCHSOLD,monthfinalbatchsold);
}

public String getMonthFinalBatchSold(){
          try {
          return (String) underlyingNode.getProperty(MONTHFINALBATCHSOLD);

        } catch (Exception e) {
        }
        return null;
    }

 
 
public void setPriceMostHarvestProduceSold(String pricemostharvestproducesold) {
underlyingNode.setProperty(PRICEMOSTHARVESTPRODUCESOLD,pricemostharvestproducesold);
}

public String getPriceMostHarvestProduceSold(){
          try {
          return (String) underlyingNode.getProperty(PRICEMOSTHARVESTPRODUCESOLD);

        } catch (Exception e) {
        }
        return null;
    }
 
 
public void setMonthMostHarvestProduceSold(String monthmostharvestproducesold) {
underlyingNode.setProperty(MONTHMOSTHARVESTPRODUCESOLD,monthmostharvestproducesold);
}

public String getMonthMostHarvestProduceSold(){
          try {
          return (String) underlyingNode.getProperty(MONTHMOSTHARVESTPRODUCESOLD);

        } catch (Exception e) {
        }
        return null;
    }

 
 
public void setPriceOfFirstHarvestProduce(String priceoffirstharvestproduce) {
underlyingNode.setProperty(PRICEOFFIRSTHARVESTPRODUCE,priceoffirstharvestproduce);
}

public String getPriceOfFirstHarvestProduce(){
          try {
          return (String) underlyingNode.getProperty(PRICEOFFIRSTHARVESTPRODUCE);

        } catch (Exception e) {
        }
        return null;
    }
 
 
public void setMonthSellingBegins(String monthsellingbegins) {
underlyingNode.setProperty(MONTHSELLINGBEGINS,monthsellingbegins);
}

public String getMonthSellingBegins(){
          try {
          return (String) underlyingNode.getProperty(MONTHSELLINGBEGINS);

        } catch (Exception e) {
        }
        return null;
    }

 
public void setMainPointOfContact(String mainpointofcontact) {
underlyingNode.setProperty(MAINPOINTOFCONTACT,mainpointofcontact);
}

public String getMainPointOfContact(){
          try {
          return (String) underlyingNode.getProperty(MAINPOINTOFCONTACT);

        } catch (Exception e) {
        }
        return null;
    }

    
    
    public Marketing(Node underlyingNode) {
        super(underlyingNode);
        this.underlyingNode = underlyingNode;
    }
    
    
    

}
