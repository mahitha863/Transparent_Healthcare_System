/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.HealthCost.HealthCost;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author MyPC1
 */
public class THCSEnterprise extends Enterprise {
    
    private ArrayList<HealthCost> healthCostDirectory;
    
    public THCSEnterprise(String name){
        super(name,EnterpriseType.THCS);
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
    public ArrayList<HealthCost> getHcDirectory() {
        if(healthCostDirectory == null){
           healthCostDirectory = new ArrayList<HealthCost>();
        }
        return healthCostDirectory;
    }

    public void setHcDirectory(ArrayList<HealthCost> healthCostDirectory) {
        this.healthCostDirectory = healthCostDirectory;
    }
    
    public void addHealthCosts(HealthCost hc)
    {
        this.getHcDirectory().add(hc);
    }
    
    public void deleteHealthCost(String hopitalName){
        for(HealthCost hc: this.healthCostDirectory){
            if(hc.getHospitalName().equals(hopitalName)){
                this.healthCostDirectory.remove(hc);
                return;
            }
        }
    }
    
    public HealthCost findHealthCost(String hopitalName){
        HealthCost healthCost = null;
        for(HealthCost hc: this.healthCostDirectory){
            if(hc.getHospitalName().equals(hopitalName)){
                healthCost = hc;
            }
        }
        
        return healthCost;
        
    }
    // flag=true for HighestCost ; falg=false for LowestCost
    public double getHighestCost(String treatmentType){
        double maxValue = -1;
            for(int i = 0; i < healthCostDirectory.size(); i++) {
                double costOfTreatment = 0.0;
                if(treatmentType.equals("MRI")){
                    costOfTreatment = healthCostDirectory.get(i).getMriCost();
                }
                else if(treatmentType.equals("Consultation Fee")){
                    costOfTreatment = healthCostDirectory.get(i).getConsultationFee();
                }
                else if(treatmentType.equals("EEG")){
                    costOfTreatment = healthCostDirectory.get(i).getEegCost();
                }
                else if(treatmentType.equals("ECG")){
                    costOfTreatment = healthCostDirectory.get(i).getEcgCost();
                }
                else if(treatmentType.equals("X-Ray")){
                    costOfTreatment = healthCostDirectory.get(i).getxRayCost();
                }
                else if(treatmentType.equals("Flu Vaccine")){
                    costOfTreatment = healthCostDirectory.get(i).getFluVaccine();
                }
                else if(treatmentType.equals("Hepatitis A Vaccine")){
                    costOfTreatment = healthCostDirectory.get(i).getHepatitisAVaccine();
                }
                else if(treatmentType.equals("Hepatitis B Vaccine")){
                    costOfTreatment = healthCostDirectory.get(i).getHepatitisBVaccine();
                }
                else if(treatmentType.equals("HPV Vaccine")){
                    costOfTreatment = healthCostDirectory.get(i).getHPVvaccine();
                }
                else if(treatmentType.equals("IPV Vaccine")){
                    costOfTreatment = healthCostDirectory.get(i).getIPVvaccine();
                }
                else if(treatmentType.equals("MMR Vaccine")){
                    costOfTreatment = healthCostDirectory.get(i).getMMRVaccine();
                }
                else if(treatmentType.equals("Heart Bypass Surgery")){
                    costOfTreatment = healthCostDirectory.get(i).getHeartBypassSurgery();
                }
                else if(treatmentType.equals("Angioplasty Surgery")){
                    costOfTreatment = healthCostDirectory.get(i).getAngioplastySurgery();
                }
                else if(treatmentType.equals("Knee Replacement Surgery")){
                    costOfTreatment = healthCostDirectory.get(i).getKneeReplacementSurgery();
                }
                 else if(treatmentType.equals("Cornea Surgery")){
                    costOfTreatment = healthCostDirectory.get(i).getCorneaSurgery();
                }
                
                if(costOfTreatment > maxValue) {
                    maxValue = costOfTreatment;
                }
            }
            System.out.println("max value" + maxValue);
        
       
        return maxValue;
    }
    
    public double getLowestCost(String treatmentType){
        
        double minValue = 0.0;
        if(treatmentType.equals("MRI")){
            minValue = healthCostDirectory.get(0).getMriCost();
            for(int i=0; i<healthCostDirectory.size(); i++){ 
              if(healthCostDirectory.get(i).getMriCost() < minValue){ 
                minValue = healthCostDirectory.get(i).getMriCost();
              } 
            } 
        }
        else if(treatmentType.equals("Consultation Fee")){
            minValue = healthCostDirectory.get(0).getConsultationFee();
            for(int i=0; i<healthCostDirectory.size(); i++){ 
              if(healthCostDirectory.get(i).getConsultationFee() < minValue){ 
                minValue = healthCostDirectory.get(i).getConsultationFee();
              } 
            } 
        }
        else if(treatmentType.equals("EEG")){
            minValue = healthCostDirectory.get(0).getEegCost();
            for(int i=0; i<healthCostDirectory.size(); i++){ 
              if(healthCostDirectory.get(i).getEegCost() < minValue){ 
                minValue = healthCostDirectory.get(i).getEegCost();
              } 
            } 
        }
        else if(treatmentType.equals("ECG")){
            minValue = healthCostDirectory.get(0).getEcgCost();
            for(int i=0; i<healthCostDirectory.size(); i++){ 
              if(healthCostDirectory.get(i).getEcgCost() < minValue){ 
                minValue = healthCostDirectory.get(i).getEcgCost();
              } 
            } 
        }
        else if(treatmentType.equals("X-Ray")){
             minValue = healthCostDirectory.get(0).getxRayCost();
            for(int i=0; i<healthCostDirectory.size(); i++){ 
              if(healthCostDirectory.get(i).getxRayCost() < minValue){ 
                minValue = healthCostDirectory.get(i).getxRayCost();
              } 
            } 
        }
        else if(treatmentType.equals("Flu Vaccine")){
             minValue = healthCostDirectory.get(0).getFluVaccine();
            for(int i=0; i<healthCostDirectory.size(); i++){ 
              if(healthCostDirectory.get(i).getFluVaccine() < minValue){ 
                minValue = healthCostDirectory.get(i).getFluVaccine();
              } 
            } 
        }
        else if(treatmentType.equals("Hepatitis A Vaccine")){
             minValue = healthCostDirectory.get(0).getHepatitisAVaccine();
            for(int i=0; i<healthCostDirectory.size(); i++){ 
              if(healthCostDirectory.get(i).getHepatitisAVaccine() < minValue){ 
                minValue = healthCostDirectory.get(i).getHepatitisAVaccine();
              } 
            } 
        }
        else if(treatmentType.equals("Hepatitis B Vaccine")){
            minValue = healthCostDirectory.get(0).getHepatitisBVaccine();
            for(int i=0; i<healthCostDirectory.size(); i++){ 
              if(healthCostDirectory.get(i).getHepatitisBVaccine() < minValue){ 
                minValue = healthCostDirectory.get(i).getHepatitisBVaccine();
              } 
            } 
        }
        else if(treatmentType.equals("HPV Vaccine")){
             minValue = healthCostDirectory.get(0).getHPVvaccine();
            for(int i=0; i<healthCostDirectory.size(); i++){ 
              if(healthCostDirectory.get(i).getHPVvaccine() < minValue){ 
                minValue = healthCostDirectory.get(i).getHPVvaccine();
              } 
            } 
        }
        else if(treatmentType.equals("IPV Vaccine")){
             minValue = healthCostDirectory.get(0).getIPVvaccine();
            for(int i=0; i<healthCostDirectory.size(); i++){ 
              if(healthCostDirectory.get(i).getIPVvaccine() < minValue){ 
                minValue = healthCostDirectory.get(i).getIPVvaccine();
              } 
            } 
        }
        else if(treatmentType.equals("MMR Vaccine")){
             minValue = healthCostDirectory.get(0).getMMRVaccine();
            for(int i=0; i<healthCostDirectory.size(); i++){ 
              if(healthCostDirectory.get(i).getMMRVaccine() < minValue){ 
                minValue = healthCostDirectory.get(i).getMMRVaccine();
              } 
            } 
        }
        else if(treatmentType.equals("Heart Bypass Surgery")){
             minValue = healthCostDirectory.get(0).getHeartBypassSurgery();
            for(int i=0; i<healthCostDirectory.size(); i++){ 
              if(healthCostDirectory.get(i).getHeartBypassSurgery() < minValue){ 
                minValue = healthCostDirectory.get(i).getHeartBypassSurgery();
              } 
            } 
        }
        else if(treatmentType.equals("Angioplasty Surgery")){
             minValue = healthCostDirectory.get(0).getAngioplastySurgery();
            for(int i=0; i<healthCostDirectory.size(); i++){ 
              if(healthCostDirectory.get(i).getAngioplastySurgery() < minValue){ 
                minValue = healthCostDirectory.get(i).getAngioplastySurgery();
              } 
            } 
        }
        else if(treatmentType.equals("Knee Replacement Surgery")){
             minValue = healthCostDirectory.get(0).getKneeReplacementSurgery();
            for(int i=0; i<healthCostDirectory.size(); i++){ 
              if(healthCostDirectory.get(i).getKneeReplacementSurgery() < minValue){ 
                minValue = healthCostDirectory.get(i).getKneeReplacementSurgery();
              } 
            } 
        }
         else if(treatmentType.equals("Cornea Surgery")){
             minValue = healthCostDirectory.get(0).getCorneaSurgery();
            for(int i=0; i<healthCostDirectory.size(); i++){ 
              if(healthCostDirectory.get(i).getCorneaSurgery() < minValue){ 
                minValue = healthCostDirectory.get(i).getCorneaSurgery();
              } 
            } 
        }
        
        
        System.out.println("min value.." + minValue);
        return minValue;
    }
    
    
    public double getAvgCostByTreatment(String treatmentType){
        double costOfTreatmentType = 0;
        double sum=0;
        int count =0;
        double avgCost=0;
       
        
        for(HealthCost hc : healthCostDirectory ){
            switch (treatmentType) {
                case "Consultation Fee":
                    costOfTreatmentType = hc.getConsultationFee();
                case "MRI":
                    costOfTreatmentType = hc.getMriCost();
                    break;
                case "EEG":
                    costOfTreatmentType = hc.getEegCost();
                    break;
                case "ECG":
                    costOfTreatmentType = hc.getEcgCost();
                    break;
                case "X-Ray":
                    costOfTreatmentType = hc.getxRayCost();
                    break;
                case "Flu Vaccine":
                    costOfTreatmentType = hc.getFluVaccine();
                    break;
                case "Hepatitis A Vaccine":
                    costOfTreatmentType = hc.getHepatitisAVaccine();
                    break;
                case "Hepatitis B Vaccine":
                    costOfTreatmentType = hc.getHepatitisBVaccine();
                    break;
                case "HPV Vaccine":
                    costOfTreatmentType = hc.getHPVvaccine();
                    break;
                case "IPV Vaccine":
                    costOfTreatmentType = hc.getIPVvaccine();
                    break;
                case "MMR Vaccine":
                    costOfTreatmentType = hc.getMMRVaccine();
                    break;
                case "Heart Bypass Surgery":
                    costOfTreatmentType = hc.getHeartBypassSurgery();
                    break;
                case "Angioplasty Surgery":
                    costOfTreatmentType = hc.getAngioplastySurgery();
                    break;
                case "Knee Replacement Surgery":
                    costOfTreatmentType = hc.getKneeReplacementSurgery();
                    break;
                case "Cornea Surgery":
                    costOfTreatmentType = hc.getCorneaSurgery();
                    break;
                default:
                    break;
            }
            
            
            sum += costOfTreatmentType;
            count++;
                    
        }
        
        if(count!=0)
        avgCost = sum/count;
        
        return avgCost;
    }
    
    
    
}
