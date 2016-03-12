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
 * @date Mar 10, 2016 4:24:29 PM
 * description:
 */
public class FarmCreditUpdate extends Status implements GeneralInterface{
    
    Node underlyingNode = null;

    public FarmCreditUpdate(Node underlyingNode) {
        super(underlyingNode);
       this.underlyingNode = underlyingNode;
    }
    
    public static String CREDITACTUALUPDATEU="creditactualupdateu";
    public static String CREDITCASHPAYBACKACTUALU="creditcashpaybackactualu";
    public static String CREDITCASHPAYBACKEXPECTEDU="creditcashpaybackexpectedu";
    public static String CREDITCASHRECEIVEDQUANTUM="creditcashreceivedquantum";
    public static String CREDITINORGANICFERTILIZER="creditinorganicfertilizer";
    public static String CREDITMODEUPDATE="creditmodeupdate";
    public static String CREDITORTYPEOTHERUPDATE="creditortypeotherupdate";
    public static String CREDITORTYPEUPDATE="creditortypeupdate";
    public static String CREDITPAYBACKEXPECTEDU="creditpaybackexpectedu";
    public static String CREDITPAYBACKGENERALMODEU="creditpaybackgeneralmodeu";
    public static String CREDITPAYBACKMODEU="creditpaybackmodeu";
    public static String CREDITPAYBACKSTATUSU="creditpaybackstatusu";
    public static String CREDITPLOUGHING="creditploughing";
    public static String CREDITPOSTPLANTHERBICIDEU="creditpostplantherbicideu";
    public static String CREDITPREPLANTHERBICIDE="creditpreplantherbicide";
    public static String CREDITPRODUCEPAYBACKEXPECTEDU="creditproducepaybackexpectedu";
    public static String CREDITPRODUCEPAYBACKQUANTUM="creditproducepaybackquantum";
    public static String CREDITPRODUCESTORAGE="creditproducestorage";
    public static String CREDITPRODUCETHRESHING="creditproducethreshing";
    public static String CREDITSEEDU="creditseedu";
    public static String CREDITTHRESHING="creditthreshing";
    public static String CREDITTRANSPORTUPDATE="credittransportupdate";
    public static String CREDITTYPEUPDATE="credittypeupdate";
    public static String GPSLOCATIONPLANCREDITUPDATE="gpslocationplancreditupdate";
    public static String PAYBACKQUANTUMFERTILIZER="paybackquantumfertilizer";
    public static String PAYBACKQUANTUMPLOUGH="paybackquantumplough";
    public static String PAYBACKQUANTUMPOSTHERBU="paybackquantumpostherbu";
    public static String PAYBACKQUANTUMPREPLANTHERBU="paybackquantumpreplantherbu";
    public static String PAYBACKQUANTUMSEEDU="paybackquantumseedu";
    public static String PAYBACKQUANTUMTRANSPORT="paybackquantumtransport";
    public static String PAYBACKTHRESHING="paybackthreshing";
    public static String REFERENCECROPUPDATEC="referencecropupdatec";
    public static String REFERENCESEASONUPDATES="referenceseasonupdates";
    public static String REFERENCEYEARPREVIOUS="referenceyearprevious";
    
    
public void setReferenceyearprevious(String referenceyearprevious) {
underlyingNode.setProperty(REFERENCEYEARPREVIOUS,referenceyearprevious);
}

public String getReferenceyearprevious(){
          try {
          return (String) underlyingNode.getProperty(REFERENCEYEARPREVIOUS);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setReferenceseasonupdates(String referenceseasonupdates) {
underlyingNode.setProperty(REFERENCESEASONUPDATES,referenceseasonupdates);
}

public String getReferenceseasonupdates(){
          try {
          return (String) underlyingNode.getProperty(REFERENCESEASONUPDATES);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setReferencecropupdatec(String referencecropupdatec) {
underlyingNode.setProperty(REFERENCECROPUPDATEC,referencecropupdatec);
}

public String getReferencecropupdatec(){
          try {
          return (String) underlyingNode.getProperty(REFERENCECROPUPDATEC);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setPaybackthreshing(String paybackthreshing) {
underlyingNode.setProperty(PAYBACKTHRESHING,paybackthreshing);
}

public String getPaybackthreshing(){
          try {
          return (String) underlyingNode.getProperty(PAYBACKTHRESHING);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setPaybackquantumtransport(String paybackquantumtransport) {
underlyingNode.setProperty(PAYBACKQUANTUMTRANSPORT,paybackquantumtransport);
}

public String getPaybackquantumtransport(){
          try {
          return (String) underlyingNode.getProperty(PAYBACKQUANTUMTRANSPORT);

        } catch (Exception e) {
        }
        return null;
    }

    
    
    

public void setPaybackquantumseedu(String paybackquantumseedu) {
underlyingNode.setProperty(PAYBACKQUANTUMSEEDU,paybackquantumseedu);
}

public String getPaybackquantumseedu(){
          try {
          return (String) underlyingNode.getProperty(PAYBACKQUANTUMSEEDU);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setPaybackquantumpreplantherbu(String paybackquantumpreplantherbu) {
underlyingNode.setProperty(PAYBACKQUANTUMPREPLANTHERBU,paybackquantumpreplantherbu);
}

public String getPaybackquantumpreplantherbu(){
          try {
          return (String) underlyingNode.getProperty(PAYBACKQUANTUMPREPLANTHERBU);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setPaybackquantumpostherbu(String paybackquantumpostherbu) {
underlyingNode.setProperty(PAYBACKQUANTUMPOSTHERBU,paybackquantumpostherbu);
}

public String getPaybackquantumpostherbu(){
          try {
          return (String) underlyingNode.getProperty(PAYBACKQUANTUMPOSTHERBU);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setPaybackquantumplough(String paybackquantumplough) {
underlyingNode.setProperty(PAYBACKQUANTUMPLOUGH,paybackquantumplough);
}

public String getPaybackquantumplough(){
          try {
          return (String) underlyingNode.getProperty(PAYBACKQUANTUMPLOUGH);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setPaybackquantumfertilizer(String paybackquantumfertilizer) {
underlyingNode.setProperty(PAYBACKQUANTUMFERTILIZER,paybackquantumfertilizer);
}

public String getPaybackquantumfertilizer(){
          try {
          return (String) underlyingNode.getProperty(PAYBACKQUANTUMFERTILIZER);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setGpslocationplancreditupdate(String gpslocationplancreditupdate) {
underlyingNode.setProperty(GPSLOCATIONPLANCREDITUPDATE,gpslocationplancreditupdate);
}

public String getGpslocationplancreditupdate(){
          try {
          return (String) underlyingNode.getProperty(GPSLOCATIONPLANCREDITUPDATE);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setCredittypeupdate(String credittypeupdate) {
underlyingNode.setProperty(CREDITTYPEUPDATE,credittypeupdate);
}

public String getCredittypeupdate(){
          try {
          return (String) underlyingNode.getProperty(CREDITTYPEUPDATE);

        } catch (Exception e) {
        }
        return null;
    }

    
    
    
public void setCredittransportupdate(String credittransportupdate) {
underlyingNode.setProperty(CREDITTRANSPORTUPDATE,credittransportupdate);
}

public String getCredittransportupdate(){
          try {
          return (String) underlyingNode.getProperty(CREDITTRANSPORTUPDATE);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setCreditthreshing(String creditthreshing) {
underlyingNode.setProperty(CREDITTHRESHING,creditthreshing);
}

public String getCreditthreshing(){
          try {
          return (String) underlyingNode.getProperty(CREDITTHRESHING);

        } catch (Exception e) {
        }
        return null;
    }
public void setCreditseedu(String creditseedu) {
underlyingNode.setProperty(CREDITSEEDU,creditseedu);
}

public String getCreditseedu(){
          try {
          return (String) underlyingNode.getProperty(CREDITSEEDU);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setCreditproducethreshing(String creditproducethreshing) {
underlyingNode.setProperty(CREDITPRODUCETHRESHING,creditproducethreshing);
}

public String getCreditproducethreshing(){
          try {
          return (String) underlyingNode.getProperty(CREDITPRODUCETHRESHING);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setCreditproducestorage(String creditproducestorage) {
underlyingNode.setProperty(CREDITPRODUCESTORAGE,creditproducestorage);
}

public String getCreditproducestorage(){
          try {
          return (String) underlyingNode.getProperty(CREDITPRODUCESTORAGE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
    
public void setCreditproducepaybackquantum(String creditproducepaybackquantum) {
underlyingNode.setProperty(CREDITPRODUCEPAYBACKQUANTUM,creditproducepaybackquantum);
}

public String getCreditproducepaybackquantum(){
          try {
          return (String) underlyingNode.getProperty(CREDITPRODUCEPAYBACKQUANTUM);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setCreditproducepaybackexpectedu(String creditproducepaybackexpectedu) {
underlyingNode.setProperty(CREDITPRODUCEPAYBACKEXPECTEDU,creditproducepaybackexpectedu);
}

public String getCreditproducepaybackexpectedu(){
          try {
          return (String) underlyingNode.getProperty(CREDITPRODUCEPAYBACKEXPECTEDU);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setCreditpreplantherbicide(String creditpreplantherbicide) {
underlyingNode.setProperty(CREDITPREPLANTHERBICIDE,creditpreplantherbicide);
}

public String getCreditpreplantherbicide(){
          try {
          return (String) underlyingNode.getProperty(CREDITPREPLANTHERBICIDE);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setCreditpostplantherbicideu(String creditpostplantherbicideu) {
underlyingNode.setProperty(CREDITPOSTPLANTHERBICIDEU,creditpostplantherbicideu);
}

public String getCreditpostplantherbicideu(){
          try {
          return (String) underlyingNode.getProperty(CREDITPOSTPLANTHERBICIDEU);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setCreditploughing(String creditploughing) {
underlyingNode.setProperty(CREDITPLOUGHING,creditploughing);
}

public String getCreditploughing(){
          try {
          return (String) underlyingNode.getProperty(CREDITPLOUGHING);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setCreditpaybackstatusu(String creditpaybackstatusu) {
underlyingNode.setProperty(CREDITPAYBACKSTATUSU,creditpaybackstatusu);
}

public String getCreditpaybackstatusu(){
          try {
          return (String) underlyingNode.getProperty(CREDITPAYBACKSTATUSU);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setCreditpaybackmodeu(String creditpaybackmodeu) {
underlyingNode.setProperty(CREDITPAYBACKMODEU,creditpaybackmodeu);
}

public String getCreditpaybackmodeu(){
          try {
          return (String) underlyingNode.getProperty(CREDITPAYBACKMODEU);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setCreditpaybackgeneralmodeu(String creditpaybackgeneralmodeu) {
underlyingNode.setProperty(CREDITPAYBACKGENERALMODEU,creditpaybackgeneralmodeu);
}

public String getCreditpaybackgeneralmodeu(){
          try {
          return (String) underlyingNode.getProperty(CREDITPAYBACKGENERALMODEU);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setCreditpaybackexpectedu(String creditpaybackexpectedu) {
underlyingNode.setProperty(CREDITPAYBACKEXPECTEDU,creditpaybackexpectedu);
}

public String getCreditpaybackexpectedu(){
          try {
          return (String) underlyingNode.getProperty(CREDITPAYBACKEXPECTEDU);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setCreditortypeupdate(String creditortypeupdate) {
underlyingNode.setProperty(CREDITORTYPEUPDATE,creditortypeupdate);
}

public String getCreditortypeupdate(){
          try {
          return (String) underlyingNode.getProperty(CREDITORTYPEUPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setCreditortypeotherupdate(String creditortypeotherupdate) {
underlyingNode.setProperty(CREDITORTYPEOTHERUPDATE,creditortypeotherupdate);
}

public String getCreditortypeotherupdate(){
          try {
          return (String) underlyingNode.getProperty(CREDITORTYPEOTHERUPDATE);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setCreditmodeupdate(String creditmodeupdate) {
underlyingNode.setProperty(CREDITMODEUPDATE,creditmodeupdate);
}

public String getCreditmodeupdate(){
          try {
          return (String) underlyingNode.getProperty(CREDITMODEUPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setCreditinorganicfertilizer(String creditinorganicfertilizer) {
underlyingNode.setProperty(CREDITINORGANICFERTILIZER,creditinorganicfertilizer);
}

public String getCreditinorganicfertilizer(){
          try {
          return (String) underlyingNode.getProperty(CREDITINORGANICFERTILIZER);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setCreditcashreceivedquantum(String creditcashreceivedquantum) {
underlyingNode.setProperty(CREDITCASHRECEIVEDQUANTUM,creditcashreceivedquantum);
}

public String getCreditcashreceivedquantum(){
          try {
          return (String) underlyingNode.getProperty(CREDITCASHRECEIVEDQUANTUM);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setCreditcashpaybackexpectedu(String creditcashpaybackexpectedu) {
underlyingNode.setProperty(CREDITCASHPAYBACKEXPECTEDU,creditcashpaybackexpectedu);
}

public String getCreditcashpaybackexpectedu(){
          try {
          return (String) underlyingNode.getProperty(CREDITCASHPAYBACKEXPECTEDU);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setCreditcashpaybackactualu(String creditcashpaybackactualu) {
underlyingNode.setProperty(CREDITCASHPAYBACKACTUALU,creditcashpaybackactualu);
}

public String getCreditcashpaybackactualu(){
          try {
          return (String) underlyingNode.getProperty(CREDITCASHPAYBACKACTUALU);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setCreditactualupdateu(String creditactualupdateu) {
underlyingNode.setProperty(CREDITACTUALUPDATEU,creditactualupdateu);
}

public String getCreditactualupdateu(){
          try {
          return (String) underlyingNode.getProperty(CREDITACTUALUPDATEU);

        } catch (Exception e) {
        }
        return null;
    }
    
    

}
