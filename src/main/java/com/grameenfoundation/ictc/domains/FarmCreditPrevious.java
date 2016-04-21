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
 * @date Mar 10, 2016 2:49:58 PM
 * description:
 */
public class FarmCreditPrevious extends Status implements GeneralInterface{
    
    
    Node underlyingNode = null;

    public FarmCreditPrevious(Node underlyingNode) {
        super(underlyingNode);
        this.underlyingNode = underlyingNode;
    }
    
    
    public static String CREDITACTUALP="creditactualp";
    public static String CREDITCASHPAYBACKACTUALP="creditcashpaybackactualp";
    public static String CREDITCASHPAYBACKEXPECTEDP="creditcashpaybackexpectedp";
    public static String CREDITCASHRECEIVEDQUANTUMP="creditcashreceivedquantump";
    public static String CREDITINORGANICFERTILIZERP="creditinorganicfertilizerp";
    public static String CREDITORTYPEOTHERP="creditortypeotherp";
    public static String CREDITORTYPEP="creditortypep";
    public static String CREDITPAYBACKGENERALMODEP="creditpaybackgeneralmodep";
    public static String CREDITPAYBACKMODEP="creditpaybackmodep";
    public static String CREDITPAYBACKSTATUSP="creditpaybackstatusp";
    public static String CREDITPLOUGHINGP="creditploughingp";
    public static String CREDITPOSTPLANTHERBICIDEP="creditpostplantherbicidep";
    public static String CREDITPREPLANTHERBICIDEP="creditpreplantherbicidep";
    public static String CREDITPRODUCEPAYBACKEXPECTEDP="creditproducepaybackexpectedp";
    public static String CREDITPRODUCEPAYBACKQUANTUMP="creditproducepaybackquantump";
    public static String CREDITPRODUCESTORAGEP="creditproducestoragep";
    public static String CREDITPRODUCETRANSPORT="creditproducetransport";
    public static String CREDITSEEDP="creditseedp";
    public static String CREDITTHRESHINGP="creditthreshingp";
    public static String GPSLOCATIONPREVCRED="gpslocationprevcred";
    public static String PAYBACKQUANTUMFERTILIZERP="paybackquantumfertilizerp";
    public static String PAYBACKQUANTUMPLOUGHP="paybackquantumploughp";
    public static String PAYBACKQUANTUMPOSTPLANTHERBICIDEP="paybackquantumpostplantherbicidep";
    public static String PAYBACKQUANTUMPREPLANTHERBP="paybackquantumpreplantherbp";
    public static String PAYBACKQUANTUMSEEDP="paybackquantumseedp";
    public static String PAYBACKQUANTUMSTORAGE="paybackquantumstorage";
    public static String PAYBACKQUANTUMTHRESHINGP="paybackquantumthreshingp";
    public static String PAYBACKQUANTUMTRANSPORTP="paybackquantumtransportp";
    public static String REFERENCECROPP="referencecropp";
    public static String REFERENCESEASONP="referenceseasonp";
    public static String REFERENCEYEARP="referenceyearp";
    public static String PAYBACKCASHFERTILIZER="paybackcashfertilizer";
    public static String PAYBACKCASHPKOUGH="paybackcashpkough";
    public static String PAYBACKCASHPOSTPLANTHERB="paybackcashpostplantherb";
    public static String PAYBACKCASHPREPLANTHERB="paybackcashpreplantherb";
    public static String PAYBACKCASHPROCESSING="paybackcashprocessing";
    public static String PAYBACKCASHSEED="paybackcashseed";
    public static String PAYBACKCASHSTORAGE="paybackcashstorage";
    public static String PAYBACKCASHTRANSPORT="paybackcashtransport";
    
    
    
public void setPaybackcashtransport(String paybackcashtransport) {
underlyingNode.setProperty(PAYBACKCASHTRANSPORT,paybackcashtransport);
}

public String getPaybackcashtransport(){
          try {
          return (String) underlyingNode.getProperty(PAYBACKCASHTRANSPORT);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setPaybackcashstorage(String paybackcashstorage) {
underlyingNode.setProperty(PAYBACKCASHSTORAGE,paybackcashstorage);
}

public String getPaybackcashstorage(){
          try {
          return (String) underlyingNode.getProperty(PAYBACKCASHSTORAGE);

        } catch (Exception e) {
        }
        return null;
    }

    
    
    
public void setPaybackcashseed(String paybackcashseed) {
underlyingNode.setProperty(PAYBACKCASHSEED,paybackcashseed);
}

public String getPaybackcashseed(){
          try {
          return (String) underlyingNode.getProperty(PAYBACKCASHSEED);

        } catch (Exception e) {
        }
        return null;
    }
    
    
    
public void setPaybackcashprocessing(String paybackcashprocessing) {
underlyingNode.setProperty(PAYBACKCASHPROCESSING,paybackcashprocessing);
}

public String getPaybackcashprocessing(){
          try {
          return (String) underlyingNode.getProperty(PAYBACKCASHPROCESSING);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setPaybackcashpreplantherb(String paybackcashpreplantherb) {
underlyingNode.setProperty(PAYBACKCASHPREPLANTHERB,paybackcashpreplantherb);
}

public String getPaybackcashpreplantherb(){
          try {
          return (String) underlyingNode.getProperty(PAYBACKCASHPREPLANTHERB);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setPaybackcashpostplantherb(String paybackcashpostplantherb) {
underlyingNode.setProperty(PAYBACKCASHPOSTPLANTHERB,paybackcashpostplantherb);
}

public String getPaybackcashpostplantherb(){
          try {
          return (String) underlyingNode.getProperty(PAYBACKCASHPOSTPLANTHERB);

        } catch (Exception e) {
        }
        return null;
    }

    
    
    
public void setPaybackcashpkough(String paybackcashpkough) {
underlyingNode.setProperty(PAYBACKCASHPKOUGH,paybackcashpkough);
}

public String getPaybackcashpkough(){
          try {
          return (String) underlyingNode.getProperty(PAYBACKCASHPKOUGH);

        } catch (Exception e) {
        }
        return null;
    }

    
    
    
public void setPaybackcashfertilizer(String paybackcashfertilizer) {
underlyingNode.setProperty(PAYBACKCASHFERTILIZER,paybackcashfertilizer);
}

public String getPaybackcashfertilizer(){
          try {
          return (String) underlyingNode.getProperty(PAYBACKCASHFERTILIZER);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setReferenceyearp(String referenceyearp) {
underlyingNode.setProperty(REFERENCEYEARP,referenceyearp);
}

public String getReferenceyearp(){
          try {
          return (String) underlyingNode.getProperty(REFERENCEYEARP);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setReferenceseasonp(String referenceseasonp) {
underlyingNode.setProperty(REFERENCESEASONP,referenceseasonp);
}

public String getReferenceseasonp(){
          try {
          return (String) underlyingNode.getProperty(REFERENCESEASONP);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setReferencecropp(String referencecropp) {
underlyingNode.setProperty(REFERENCECROPP,referencecropp);
}

public String getReferencecropp(){
          try {
          return (String) underlyingNode.getProperty(REFERENCECROPP);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setPaybackquantumtransportp(String paybackquantumtransportp) {
underlyingNode.setProperty(PAYBACKQUANTUMTRANSPORTP,paybackquantumtransportp);
}

public String getPaybackquantumtransportp(){
          try {
          return (String) underlyingNode.getProperty(PAYBACKQUANTUMTRANSPORTP);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setPaybackquantumthreshingp(String paybackquantumthreshingp) {
underlyingNode.setProperty(PAYBACKQUANTUMTHRESHINGP,paybackquantumthreshingp);
}

public String getPaybackquantumthreshingp(){
          try {
          return (String) underlyingNode.getProperty(PAYBACKQUANTUMTHRESHINGP);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setPaybackquantumstorage(String paybackquantumstorage) {
underlyingNode.setProperty(PAYBACKQUANTUMSTORAGE,paybackquantumstorage);
}

public String getPaybackquantumstorage(){
          try {
          return (String) underlyingNode.getProperty(PAYBACKQUANTUMSTORAGE);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setPaybackquantumseedp(String paybackquantumseedp) {
underlyingNode.setProperty(PAYBACKQUANTUMSEEDP,paybackquantumseedp);
}

public String getPaybackquantumseedp(){
          try {
          return (String) underlyingNode.getProperty(PAYBACKQUANTUMSEEDP);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setPaybackquantumpreplantherbp(String paybackquantumpreplantherbp) {
underlyingNode.setProperty(PAYBACKQUANTUMPREPLANTHERBP,paybackquantumpreplantherbp);
}

public String getPaybackquantumpreplantherbp(){
          try {
          return (String) underlyingNode.getProperty(PAYBACKQUANTUMPREPLANTHERBP);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setPaybackquantumpostplantherbicidep(String paybackquantumpostplantherbicidep) {
underlyingNode.setProperty(PAYBACKQUANTUMPOSTPLANTHERBICIDEP,paybackquantumpostplantherbicidep);
}

public String getPaybackquantumpostplantherbicidep(){
          try {
          return (String) underlyingNode.getProperty(PAYBACKQUANTUMPOSTPLANTHERBICIDEP);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setPaybackquantumploughp(String paybackquantumploughp) {
underlyingNode.setProperty(PAYBACKQUANTUMPLOUGHP,paybackquantumploughp);
}

public String getPaybackquantumploughp(){
          try {
          return (String) underlyingNode.getProperty(PAYBACKQUANTUMPLOUGHP);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setPaybackquantumfertilizerp(String paybackquantumfertilizerp) {
underlyingNode.setProperty(PAYBACKQUANTUMFERTILIZERP,paybackquantumfertilizerp);
}

public String getPaybackquantumfertilizerp(){
          try {
          return (String) underlyingNode.getProperty(PAYBACKQUANTUMFERTILIZERP);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setGpslocationprevcred(String gpslocationprevcred) {
underlyingNode.setProperty(GPSLOCATIONPREVCRED,gpslocationprevcred);
}

public String getGpslocationprevcred(){
          try {
          return (String) underlyingNode.getProperty(GPSLOCATIONPREVCRED);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setCreditthreshingp(String creditthreshingp) {
underlyingNode.setProperty(CREDITTHRESHINGP,creditthreshingp);
}

public String getCreditthreshingp(){
          try {
          return (String) underlyingNode.getProperty(CREDITTHRESHINGP);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setCreditseedp(String creditseedp) {
underlyingNode.setProperty(CREDITSEEDP,creditseedp);
}

public String getCreditseedp(){
          try {
          return (String) underlyingNode.getProperty(CREDITSEEDP);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setCreditproducetransport(String creditproducetransport) {
underlyingNode.setProperty(CREDITPRODUCETRANSPORT,creditproducetransport);
}

public String getCreditproducetransport(){
          try {
          return (String) underlyingNode.getProperty(CREDITPRODUCETRANSPORT);

        } catch (Exception e) {
        }
        return null;
    }
public void setCreditproducestoragep(String creditproducestoragep) {
underlyingNode.setProperty(CREDITPRODUCESTORAGEP,creditproducestoragep);
}

public String getCreditproducestoragep(){
          try {
          return (String) underlyingNode.getProperty(CREDITPRODUCESTORAGEP);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setCreditproducepaybackquantump(String creditproducepaybackquantump) {
underlyingNode.setProperty(CREDITPRODUCEPAYBACKQUANTUMP,creditproducepaybackquantump);
}

public String getCreditproducepaybackquantump(){
          try {
          return (String) underlyingNode.getProperty(CREDITPRODUCEPAYBACKQUANTUMP);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setCreditproducepaybackexpectedp(String creditproducepaybackexpectedp) {
underlyingNode.setProperty(CREDITPRODUCEPAYBACKEXPECTEDP,creditproducepaybackexpectedp);
}

public String getCreditproducepaybackexpectedp(){
          try {
          return (String) underlyingNode.getProperty(CREDITPRODUCEPAYBACKEXPECTEDP);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setCreditpreplantherbicidep(String creditpreplantherbicidep) {
underlyingNode.setProperty(CREDITPREPLANTHERBICIDEP,creditpreplantherbicidep);
}

public String getCreditpreplantherbicidep(){
          try {
          return (String) underlyingNode.getProperty(CREDITPREPLANTHERBICIDEP);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setCreditpostplantherbicidep(String creditpostplantherbicidep) {
underlyingNode.setProperty(CREDITPOSTPLANTHERBICIDEP,creditpostplantherbicidep);
}

public String getCreditpostplantherbicidep(){
          try {
          return (String) underlyingNode.getProperty(CREDITPOSTPLANTHERBICIDEP);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setCreditploughingp(String creditploughingp) {
underlyingNode.setProperty(CREDITPLOUGHINGP,creditploughingp);
}

public String getCreditploughingp(){
          try {
          return (String) underlyingNode.getProperty(CREDITPLOUGHINGP);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setCreditpaybackstatusp(String creditpaybackstatusp) {
underlyingNode.setProperty(CREDITPAYBACKSTATUSP,creditpaybackstatusp);
}

public String getCreditpaybackstatusp(){
          try {
          return (String) underlyingNode.getProperty(CREDITPAYBACKSTATUSP);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setCreditpaybackmodep(String creditpaybackmodep) {
underlyingNode.setProperty(CREDITPAYBACKMODEP,creditpaybackmodep);
}

public String getCreditpaybackmodep(){
          try {
          return (String) underlyingNode.getProperty(CREDITPAYBACKMODEP);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setCreditpaybackgeneralmodep(String creditpaybackgeneralmodep) {
underlyingNode.setProperty(CREDITPAYBACKGENERALMODEP,creditpaybackgeneralmodep);
}

public String getCreditpaybackgeneralmodep(){
          try {
          return (String) underlyingNode.getProperty(CREDITPAYBACKGENERALMODEP);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setCreditortypep(String creditortypep) {
underlyingNode.setProperty(CREDITORTYPEP,creditortypep);
}

public String getCreditortypep(){
          try {
          return (String) underlyingNode.getProperty(CREDITORTYPEP);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setCreditortypeotherp(String creditortypeotherp) {
underlyingNode.setProperty(CREDITORTYPEOTHERP,creditortypeotherp);
}

public String getCreditortypeotherp(){
          try {
          return (String) underlyingNode.getProperty(CREDITORTYPEOTHERP);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setCreditinorganicfertilizerp(String creditinorganicfertilizerp) {
underlyingNode.setProperty(CREDITINORGANICFERTILIZERP,creditinorganicfertilizerp);
}

public String getCreditinorganicfertilizerp(){
          try {
          return (String) underlyingNode.getProperty(CREDITINORGANICFERTILIZERP);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setCreditcashreceivedquantump(String creditcashreceivedquantump) {
underlyingNode.setProperty(CREDITCASHRECEIVEDQUANTUMP,creditcashreceivedquantump);
}

public String getCreditcashreceivedquantump(){
          try {
          return (String) underlyingNode.getProperty(CREDITCASHRECEIVEDQUANTUMP);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setCreditcashpaybackexpectedp(String creditcashpaybackexpectedp) {
underlyingNode.setProperty(CREDITCASHPAYBACKEXPECTEDP,creditcashpaybackexpectedp);
}

public String getCreditcashpaybackexpectedp(){
          try {
          return (String) underlyingNode.getProperty(CREDITCASHPAYBACKEXPECTEDP);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setCreditcashpaybackactualp(String creditcashpaybackactualp) {
underlyingNode.setProperty(CREDITCASHPAYBACKACTUALP,creditcashpaybackactualp);
}

public String getCreditcashpaybackactualp(){
          try {
          return (String) underlyingNode.getProperty(CREDITCASHPAYBACKACTUALP);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setCreditactualp(String creditactualp) {
underlyingNode.setProperty(CREDITACTUALP,creditactualp);
}

public String getCreditactualp(){
          try {
          return (String) underlyingNode.getProperty(CREDITACTUALP);

        } catch (Exception e) {
        }
        return null;
    }


}
