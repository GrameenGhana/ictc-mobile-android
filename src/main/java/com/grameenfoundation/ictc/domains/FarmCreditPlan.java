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
 * @date Mar 9, 2016 4:56:00 PM
 * description:
 */
public class FarmCreditPlan extends Status implements GeneralInterface{
    
    Node underlyingNode = null;
    
  

    public FarmCreditPlan(Node underlyingNode) {
        super(underlyingNode);
        this.underlyingNode = underlyingNode;
    }
    public static String CREDITACTUALC="creditactualc";
    public static String CREDITCASHPAYBACKEXPECTEDC="creditcashpaybackexpectedc";
    public static String CREDITCASHRECEIVEDQUANTUMC="creditcashreceivedquantumc";
    public static String CREDITINORGANICFERTILIZERC="creditinorganicfertilizerc";
    public static String CREDITMODEC="creditmodec";
    public static String CREDITORTYPEOTHERC="creditortypeotherc";
    public static String CREDITPAYBACKGENERALMODEC="creditpaybackgeneralmodec";
    public static String CREDITPLOUGHINGC="creditploughingc";
    public static String CREDITPOSTPLANTHERBICIDEC="creditpostplantherbicidec";
    public static String CREDITPREPLANTHERBICIDEC="creditpreplantherbicidec";
    public static String CREDITPRODUCEPAYBACKEXPECTEDC="creditproducepaybackexpectedc";
    public static String CREDITPRODUCESTORAGEC="creditproducestoragec";
    public static String CREDITSEEDC="creditseedc";
    public static String CREDITTHRESHINGC="creditthreshingc";
    public static String CREDITTRANSPORTC="credittransportc";
    public static String CREDITTYPEC="credittypec";
    public static String GPSLOCATIONPLANCREDIT_="gpslocationplancredit";
    public static String PAYBACKQUANTUMFERTILIZERC="paybackquantumfertilizerc";
    public static String PAYBACKQUANTUMPLOUGHC="paybackquantumploughc";
    public static String PAYBACKQUANTUMPOSTHERBC="paybackquantumpostherbc";
    public static String PAYBACKQUANTUMPREPLANTHERBC="paybackquantumpreplantherbc";
    public static String PAYBACKQUANTUMSEEDC="paybackquantumseedc";
    public static String PAYBACKQUANTUMSTORAGEC="paybackquantumstoragec";
    public static String PAYBACKQUANTUMTHRESHINGC="paybackquantumthreshingc";
    public static String PAYBACKQUANTUMTRANSPORTC="paybackquantumtransportc";
    public static String PLANNEDPAYBACKMODE="plannedpaybackmode";
    public static String REFERENCECROPC="referencecropc";
    public static String REFERENCESEASONC="referenceseasonc";
    public static String REFERENCEYEARC="referenceyearc";
    public static String PAYBACKCASHFERTILIZERPLAN="paybackcashfertilizerplan";
    public static String PAYBACKCASHPKOUGHPLAN="paybackcashpkoughplan";
    public static String PAYBACKCASHPOSTPLANTHERBPLAN="paybackcashpostplantherbplan";
    public static String PAYBACKCASHPREPLANTHERBPLAN="paybackcashpreplantherbplan";
    public static String PAYBACKCASHPROCESSINGPLAN="paybackcashprocessingplan";
    public static String PAYBACKCASHSEEDPLAN="paybackcashseedplan";
    public static String PAYBACKCASHSTORAGEPLAN="paybackcashstorageplan";
    public static String PAYBACKCASHTRANSPORTPLAN="paybackcashtransportplan";
    public static String PAYBACKDATEPLAN="paybackdateplan";
    
    
public void setPaybackdateplan(String paybackdateplan) {
underlyingNode.setProperty(PAYBACKDATEPLAN,paybackdateplan);
}

public String getPaybackdateplan(){
          try {
          return (String) underlyingNode.getProperty(PAYBACKDATEPLAN);

        } catch (Exception e) {
        }
        return null;
    }
public void setPaybackcashtransportplan(String paybackcashtransportplan) {
underlyingNode.setProperty(PAYBACKCASHTRANSPORTPLAN,paybackcashtransportplan);
}

public String getPaybackcashtransportplan(){
          try {
          return (String) underlyingNode.getProperty(PAYBACKCASHTRANSPORTPLAN);

        } catch (Exception e) {
        }
        return null;
    }
public void setPaybackcashstorageplan(String paybackcashstorageplan) {
underlyingNode.setProperty(PAYBACKCASHSTORAGEPLAN,paybackcashstorageplan);
}

public String getPaybackcashstorageplan(){
          try {
          return (String) underlyingNode.getProperty(PAYBACKCASHSTORAGEPLAN);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setPaybackcashseedplan(String paybackcashseedplan) {
underlyingNode.setProperty(PAYBACKCASHSEEDPLAN,paybackcashseedplan);
}

public String getPaybackcashseedplan(){
          try {
          return (String) underlyingNode.getProperty(PAYBACKCASHSEEDPLAN);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setPaybackcashprocessingplan(String paybackcashprocessingplan) {
underlyingNode.setProperty(PAYBACKCASHPROCESSINGPLAN,paybackcashprocessingplan);
}

public String getPaybackcashprocessingplan(){
          try {
          return (String) underlyingNode.getProperty(PAYBACKCASHPROCESSINGPLAN);

        } catch (Exception e) {
        }
        return null;
    }
    
    
    
    
public void setPaybackcashpreplantherbplan(String paybackcashpreplantherbplan) {
underlyingNode.setProperty(PAYBACKCASHPREPLANTHERBPLAN,paybackcashpreplantherbplan);
}

public String getPaybackcashpreplantherbplan(){
          try {
          return (String) underlyingNode.getProperty(PAYBACKCASHPREPLANTHERBPLAN);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setPaybackcashpostplantherbplan(String paybackcashpostplantherbplan) {
underlyingNode.setProperty(PAYBACKCASHPOSTPLANTHERBPLAN,paybackcashpostplantherbplan);
}

public String getPaybackcashpostplantherbplan(){
          try {
          return (String) underlyingNode.getProperty(PAYBACKCASHPOSTPLANTHERBPLAN);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setPaybackcashpkoughplan(String paybackcashpkoughplan) {
underlyingNode.setProperty(PAYBACKCASHPKOUGHPLAN,paybackcashpkoughplan);
}

public String getPaybackcashpkoughplan(){
          try {
          return (String) underlyingNode.getProperty(PAYBACKCASHPKOUGHPLAN);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setPaybackcashfertilizerplan(String paybackcashfertilizerplan) {
underlyingNode.setProperty(PAYBACKCASHFERTILIZERPLAN,paybackcashfertilizerplan);
}

public String getPaybackcashfertilizerplan(){
          try {
          return (String) underlyingNode.getProperty(PAYBACKCASHFERTILIZERPLAN);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setReferenceyearc(String referenceyearc) {
underlyingNode.setProperty(REFERENCEYEARC,referenceyearc);
}

public String getReferenceyearc(){
          try {
          return (String) underlyingNode.getProperty(REFERENCEYEARC);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setReferenceseasonc(String referenceseasonc) {
underlyingNode.setProperty(REFERENCESEASONC,referenceseasonc);
}

public String getReferenceseasonc(){
          try {
          return (String) underlyingNode.getProperty(REFERENCESEASONC);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setReferencecropc(String referencecropc) {
underlyingNode.setProperty(REFERENCECROPC,referencecropc);
}

public String getReferencecropc(){
          try {
          return (String) underlyingNode.getProperty(REFERENCECROPC);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setPlannedpaybackmode(String plannedpaybackmode) {
underlyingNode.setProperty(PLANNEDPAYBACKMODE,plannedpaybackmode);
}

public String getPlannedpaybackmode(){
          try {
          return (String) underlyingNode.getProperty(PLANNEDPAYBACKMODE);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setPaybackquantumtransportc(String paybackquantumtransportc) {
underlyingNode.setProperty(PAYBACKQUANTUMTRANSPORTC,paybackquantumtransportc);
}

public String getPaybackquantumtransportc(){
          try {
          return (String) underlyingNode.getProperty(PAYBACKQUANTUMTRANSPORTC);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setPaybackquantumthreshingc(String paybackquantumthreshingc) {
underlyingNode.setProperty(PAYBACKQUANTUMTHRESHINGC,paybackquantumthreshingc);
}

public String getPaybackquantumthreshingc(){
          try {
          return (String) underlyingNode.getProperty(PAYBACKQUANTUMTHRESHINGC);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setPaybackquantumstoragec(String paybackquantumstoragec) {
underlyingNode.setProperty(PAYBACKQUANTUMSTORAGEC,paybackquantumstoragec);
}

public String getPaybackquantumstoragec(){
          try {
          return (String) underlyingNode.getProperty(PAYBACKQUANTUMSTORAGEC);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setPaybackquantumseedc(String paybackquantumseedc) {
underlyingNode.setProperty(PAYBACKQUANTUMSEEDC,paybackquantumseedc);
}

public String getPaybackquantumseedc(){
          try {
          return (String) underlyingNode.getProperty(PAYBACKQUANTUMSEEDC);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setPaybackquantumpreplantherbc(String paybackquantumpreplantherbc) {
underlyingNode.setProperty(PAYBACKQUANTUMPREPLANTHERBC,paybackquantumpreplantherbc);
}

public String getPaybackquantumpreplantherbc(){
          try {
          return (String) underlyingNode.getProperty(PAYBACKQUANTUMPREPLANTHERBC);

        } catch (Exception e) {
        }
        return null;
    }
public void setPaybackquantumpostherbc(String paybackquantumpostherbc) {
underlyingNode.setProperty(PAYBACKQUANTUMPOSTHERBC,paybackquantumpostherbc);
}

public String getPaybackquantumpostherbc(){
          try {
          return (String) underlyingNode.getProperty(PAYBACKQUANTUMPOSTHERBC);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setPaybackquantumploughc(String paybackquantumploughc) {
underlyingNode.setProperty(PAYBACKQUANTUMPLOUGHC,paybackquantumploughc);
}

public String getPaybackquantumploughc(){
          try {
          return (String) underlyingNode.getProperty(PAYBACKQUANTUMPLOUGHC);

        } catch (Exception e) {
        }
        return null;
    }
public void setPaybackquantumfertilizerc(String paybackquantumfertilizerc) {
underlyingNode.setProperty(PAYBACKQUANTUMFERTILIZERC,paybackquantumfertilizerc);
}

public String getPaybackquantumfertilizerc(){
          try {
          return (String) underlyingNode.getProperty(PAYBACKQUANTUMFERTILIZERC);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setGpslocationplancredit_(String gpslocationplancredit_) {
underlyingNode.setProperty(GPSLOCATIONPLANCREDIT_,gpslocationplancredit_);
}

public String getGpslocationplancredit_(){
          try {
          return (String) underlyingNode.getProperty(GPSLOCATIONPLANCREDIT_);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setCredittypec(String credittypec) {
underlyingNode.setProperty(CREDITTYPEC,credittypec);
}

public String getCredittypec(){
          try {
          return (String) underlyingNode.getProperty(CREDITTYPEC);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setCredittransportc(String credittransportc) {
underlyingNode.setProperty(CREDITTRANSPORTC,credittransportc);
}

public String getCredittransportc(){
          try {
          return (String) underlyingNode.getProperty(CREDITTRANSPORTC);

        } catch (Exception e) {
        }
        return null;
    }

public void setCreditthreshingc(String creditthreshingc) {
underlyingNode.setProperty(CREDITTHRESHINGC,creditthreshingc);
}

public String getCreditthreshingc(){
          try {
          return (String) underlyingNode.getProperty(CREDITTHRESHINGC);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setCreditseedc(String creditseedc) {
underlyingNode.setProperty(CREDITSEEDC,creditseedc);
}

public String getCreditseedc(){
          try {
          return (String) underlyingNode.getProperty(CREDITSEEDC);

        } catch (Exception e) {
        }
        return null;
    }

public void setCreditproducestoragec(String creditproducestoragec) {
underlyingNode.setProperty(CREDITPRODUCESTORAGEC,creditproducestoragec);
}

public String getCreditproducestoragec(){
          try {
          return (String) underlyingNode.getProperty(CREDITPRODUCESTORAGEC);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setCreditproducepaybackexpectedc(String creditproducepaybackexpectedc) {
underlyingNode.setProperty(CREDITPRODUCEPAYBACKEXPECTEDC,creditproducepaybackexpectedc);
}

public String getCreditproducepaybackexpectedc(){
          try {
          return (String) underlyingNode.getProperty(CREDITPRODUCEPAYBACKEXPECTEDC);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setCreditpreplantherbicidec(String creditpreplantherbicidec) {
underlyingNode.setProperty(CREDITPREPLANTHERBICIDEC,creditpreplantherbicidec);
}

public String getCreditpreplantherbicidec(){
          try {
          return (String) underlyingNode.getProperty(CREDITPREPLANTHERBICIDEC);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setCreditpostplantherbicidec(String creditpostplantherbicidec) {
underlyingNode.setProperty(CREDITPOSTPLANTHERBICIDEC,creditpostplantherbicidec);
}

public String getCreditpostplantherbicidec(){
          try {
          return (String) underlyingNode.getProperty(CREDITPOSTPLANTHERBICIDEC);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setCreditploughingc(String creditploughingc) {
underlyingNode.setProperty(CREDITPLOUGHINGC,creditploughingc);
}

public String getCreditploughingc(){
          try {
          return (String) underlyingNode.getProperty(CREDITPLOUGHINGC);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setCreditpaybackgeneralmodec(String creditpaybackgeneralmodec) {
underlyingNode.setProperty(CREDITPAYBACKGENERALMODEC,creditpaybackgeneralmodec);
}

public String getCreditpaybackgeneralmodec(){
          try {
          return (String) underlyingNode.getProperty(CREDITPAYBACKGENERALMODEC);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setCreditortypeotherc(String creditortypeotherc) {
underlyingNode.setProperty(CREDITORTYPEOTHERC,creditortypeotherc);
}

public String getCreditortypeotherc(){
          try {
          return (String) underlyingNode.getProperty(CREDITORTYPEOTHERC);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setCreditmodec(String creditmodec) {
underlyingNode.setProperty(CREDITMODEC,creditmodec);
}

public String getCreditmodec(){
          try {
          return (String) underlyingNode.getProperty(CREDITMODEC);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setCreditinorganicfertilizerc(String creditinorganicfertilizerc) {
underlyingNode.setProperty(CREDITINORGANICFERTILIZERC,creditinorganicfertilizerc);
}

public String getCreditinorganicfertilizerc(){
          try {
          return (String) underlyingNode.getProperty(CREDITINORGANICFERTILIZERC);

        } catch (Exception e) {
        }
        return null;
    }

    
    
    
public void setCreditcashreceivedquantumc(String creditcashreceivedquantumc) {
underlyingNode.setProperty(CREDITCASHRECEIVEDQUANTUMC,creditcashreceivedquantumc);
}

public String getCreditcashreceivedquantumc(){
          try {
          return (String) underlyingNode.getProperty(CREDITCASHRECEIVEDQUANTUMC);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setCreditcashpaybackexpectedc(String creditcashpaybackexpectedc) {
underlyingNode.setProperty(CREDITCASHPAYBACKEXPECTEDC,creditcashpaybackexpectedc);
}

public String getCreditcashpaybackexpectedc(){
          try {
          return (String) underlyingNode.getProperty(CREDITCASHPAYBACKEXPECTEDC);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setCreditactualc(String creditactualc) {
underlyingNode.setProperty(CREDITACTUALC,creditactualc);
}

public String getCreditactualc(){
          try {
          return (String) underlyingNode.getProperty(CREDITACTUALC);

        } catch (Exception e) {
        }
        return null;
    }
    
    

}
