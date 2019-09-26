/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.Enterprise.Enterprise;
import Business.Enterprise.EnterpriseDirectory;
import Business.Enterprise.THCSEnterprise;

/**
 *
 * @author MyPC1
 */
public class Network {
    private String name;
    private EnterpriseDirectory enterpriseDirectory;
    
    public Network(){
        enterpriseDirectory=new EnterpriseDirectory();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }
    
    public THCSEnterprise getTHCSEnterprise() {

        //Enterprise.EnterpriseType type;
        THCSEnterprise thcsEnterprise = null;

        for (Enterprise e : enterpriseDirectory.getEnterpriseList()) {
            if (e.getEnterpriseType() == Enterprise.EnterpriseType.THCS) {
                thcsEnterprise = (THCSEnterprise) e;
                break;
            }
        }
        return thcsEnterprise;
    }
    
    @Override
    public String toString(){
        return name;
    }
    
}
