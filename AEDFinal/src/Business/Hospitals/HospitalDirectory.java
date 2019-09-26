/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Hospitals;

import Business.Enterprise.Enterprise;
import Business.Enterprise.THCSEnterprise;
import Business.Network.Network;
import java.util.ArrayList;

/**
 *
 * @author Gaya 3
 */
public class HospitalDirectory {
    private ArrayList<String> hospitalsDirectory;
    
    public ArrayList<String> getHospitalsByLocation(String location){
        hospitalsDirectory = new ArrayList<String>();
        if(location.equals("Alaska")){
            hospitalsDirectory.add("Alaska Regional Hospital");
            hospitalsDirectory.add("Fairbanks Memorial Hospital");
            hospitalsDirectory.add("Norton Sound Regional Hospital");
            hospitalsDirectory.add("Samuel Simmonds Memorial Hospital");
            hospitalsDirectory.add("South Peninsula Hospital");
        } else if(location.equals("Alabama")){
            hospitalsDirectory.add("Wiregrass Medical Center");
            hospitalsDirectory.add("Monroe County Hospital");
            hospitalsDirectory.add("Lakeland Community Hospital");
            hospitalsDirectory.add("Central Alabama VA Healthcare System");
            hospitalsDirectory.add("Southeast Health");
        }
        else if(location.equals("Arizona")){
            hospitalsDirectory.add("Kingman Regional Medical Center");
            hospitalsDirectory.add("Northern Cochise Community Hospital");
            hospitalsDirectory.add("Mountain Vista Medical Center");
            hospitalsDirectory.add("Holy Cross Hospital");
            hospitalsDirectory.add("Flagstaff Medical Center");
        }
        else if(location.equals("California")){
            hospitalsDirectory.add("UCSF Medical Center");
            hospitalsDirectory.add("The Department of State Hospitals - Patton");
            hospitalsDirectory.add("Sutter Lakeside Hospital");
            hospitalsDirectory.add("Adventist Health Ukiah Valley");
            hospitalsDirectory.add("Barstow Community Hospital");
        }
        else if(location.equals("Massachusetts")){
            hospitalsDirectory.add("Boston Medical Center");
            hospitalsDirectory.add("Massachusetts General Hospital");
            hospitalsDirectory.add("UMass Memorial Health Care");
            hospitalsDirectory.add("Athol Memorial Hospital");
            hospitalsDirectory.add("Boston Medical Center");
        }
        
        return hospitalsDirectory;
    }
    
    public ArrayList<String> getHospitalsFromEnterpriseDirectory(Network network){
        hospitalsDirectory = new ArrayList<String>();
                
        for (Enterprise e : network.getEnterpriseDirectory().getEnterpriseList()) {
            if (e.getEnterpriseType() == Enterprise.EnterpriseType.Hospital) {
                hospitalsDirectory.add(e.getName());
            }
        }
        return hospitalsDirectory;
    }
 
    
    
}
