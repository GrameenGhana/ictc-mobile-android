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
 * @date Jul 22, 2015 3:38:33 PM description:
 */
public class Storage extends Status implements GeneralInterface {

    Node underlyingNode;
    public static String TYPEOFSTORAGESTRUCTURE = "typeofstoragestructure";
    public static String OWNERSHIPOFSTORAGE = "ownershipofstorage";
    public static String CHARGESTORAGESERVICES = "chargestorageservices";
    public static String BASISFORCHARGING = "basisforcharging";
    public static String COSTPERUNITOFSTORAGE = "costperunitofstorage";
    public static String USEOFCHEMICALSTORAGE = "useofchemicalstorage";
    public static String TYPEOFCHEMICALSTORAGE = "typeofchemicalstorage";
    public static String QNTYUSERPERUNITPRODUCESTORAGECHEMICAL = "qntyuserperunitproducestoragechemical";
    public static String POSTHARVESTLOSSES = "postharvestlosses";

    public void setPostHarvestLosses(String postharvestlosses) {
        underlyingNode.setProperty(POSTHARVESTLOSSES, postharvestlosses);
    }

    public String getPostHarvestLosses() {
        try {
            return (String) underlyingNode.getProperty(POSTHARVESTLOSSES);

        } catch (Exception e) {
        }
        return null;
    }

    public void setQntyUserPerUnitProduceStorageChemical(String qntyuserperunitproducestoragechemical) {
        underlyingNode.setProperty(QNTYUSERPERUNITPRODUCESTORAGECHEMICAL, qntyuserperunitproducestoragechemical);
    }

    public String getQntyUserPerUnitProduceStorageChemical() {
        try {
            return (String) underlyingNode.getProperty(QNTYUSERPERUNITPRODUCESTORAGECHEMICAL);

        } catch (Exception e) {
        }
        return null;
    }

    public void setTypeOfChemicalStorage(String typeofchemicalstorage) {
        underlyingNode.setProperty(TYPEOFCHEMICALSTORAGE, typeofchemicalstorage);
    }

    public String getTypeOfChemicalStorage() {
        try {
            return (String) underlyingNode.getProperty(TYPEOFCHEMICALSTORAGE);

        } catch (Exception e) {
        }
        return null;
    }

    public void setUseOfChemicalStorage(String useofchemicalstorage) {
        underlyingNode.setProperty(USEOFCHEMICALSTORAGE, useofchemicalstorage);
    }

    public String getUseOfChemicalStorage() {
        try {
            return (String) underlyingNode.getProperty(USEOFCHEMICALSTORAGE);

        } catch (Exception e) {
        }
        return null;
    }

    public void setCostPerUnitOfStorage(String costperunitofstorage) {
        underlyingNode.setProperty(COSTPERUNITOFSTORAGE, costperunitofstorage);
    }

    public String getCostPerUnitOfStorage() {
        try {
            return (String) underlyingNode.getProperty(COSTPERUNITOFSTORAGE);

        } catch (Exception e) {
        }
        return null;
    }

    public void setBasisForCharging(String basisforcharging) {
        underlyingNode.setProperty(BASISFORCHARGING, basisforcharging);
    }

    public String getBasisForCharging() {
        try {
            return (String) underlyingNode.getProperty(BASISFORCHARGING);

        } catch (Exception e) {
        }
        return null;
    }

    public void setChargeStorageServices(String chargestorageservices) {
        underlyingNode.setProperty(CHARGESTORAGESERVICES, chargestorageservices);
    }

    public String getChargeStorageServices() {
        try {
            return (String) underlyingNode.getProperty(CHARGESTORAGESERVICES);

        } catch (Exception e) {
        }
        return null;
    }

    public void setOwnershipOfStorage(String ownershipofstorage) {
        underlyingNode.setProperty(OWNERSHIPOFSTORAGE, ownershipofstorage);
    }

    public String getOwnershipOfStorage() {
        try {
            return (String) underlyingNode.getProperty(OWNERSHIPOFSTORAGE);

        } catch (Exception e) {
        }
        return null;
    }

    public void setTypeOfStorageStructure(String typeofstoragestructure) {
        underlyingNode.setProperty(TYPEOFSTORAGESTRUCTURE, typeofstoragestructure);
    }

    public String getTypeOfStorageStructure() {
        try {
            return (String) underlyingNode.getProperty(TYPEOFSTORAGESTRUCTURE);

        } catch (Exception e) {
        }
        return null;
    }

    public Storage(Node underlyingNode) {
        super(underlyingNode);
        this.underlyingNode = underlyingNode;
    }

}
