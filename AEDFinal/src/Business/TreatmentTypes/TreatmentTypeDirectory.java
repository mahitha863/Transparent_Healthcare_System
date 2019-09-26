/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.TreatmentTypes;

import java.util.ArrayList;

/**
 *
 * @author Gaya 3
 */
public class TreatmentTypeDirectory {
    private ArrayList<String> treatmentTypesDirectory;
    
    public ArrayList<String> getTreatmentTypes(){
        treatmentTypesDirectory = new ArrayList<String>();
        treatmentTypesDirectory.add("MRI");
        treatmentTypesDirectory.add("EEG");
        treatmentTypesDirectory.add("ECG");
        treatmentTypesDirectory.add("X-Ray");
        treatmentTypesDirectory.add("Flu Vaccine");
        treatmentTypesDirectory.add("Hepatitis A Vaccine");
        treatmentTypesDirectory.add("Hepatitis B Vaccine");
        treatmentTypesDirectory.add("HPV Vaccine");
        treatmentTypesDirectory.add("IPV Vaccine");
        treatmentTypesDirectory.add("MMR Vaccine");
        treatmentTypesDirectory.add("Heart Bypass Surgery");
        treatmentTypesDirectory.add("Angioplasty Surgery");
        treatmentTypesDirectory.add("Knee Replacement Surgery");
        treatmentTypesDirectory.add("Cornea Surgery");
        treatmentTypesDirectory.add("Consultation Fee");
        
        return treatmentTypesDirectory;
    }
}
