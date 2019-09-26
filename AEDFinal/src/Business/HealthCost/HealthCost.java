/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.HealthCost;

/**
 *
 * @author mahitha
 */
public class HealthCost {
    
    private String hospitalName;
    private String hospitalLocation;
    
    private double consultationFee;
    
    //scans
    private double mriCost;
    private double eegCost;
    private double ecgCost;
    private double xRayCost;
    
    //surgeries
    private double heartBypassSurgery;
    private double angioplastySurgery;
    private double kneeReplacementSurgery;
    private double corneaSurgery;
    
    //vaccines
    private double fluVaccine;
    private double hepatitisAVaccine;
    private double hepatitisBVaccine;
    private double HPVvaccine;
    private double IPVvaccine;
    private double MMRVaccine;

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }
    
    public String getHospitalLocation() {
        return hospitalLocation;
    }

    public void setHospitalLocation(String hospitalLocation) {
        this.hospitalLocation = hospitalLocation;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(double consultationFee) {
        this.consultationFee = consultationFee;
    }

    public double getMriCost() {
        return mriCost;
    }

    public void setMriCost(double mriCost) {
        this.mriCost = mriCost;
    }

    public double getEegCost() {
        return eegCost;
    }

    public void setEegCost(double eegCost) {
        this.eegCost = eegCost;
    }

    public double getEcgCost() {
        return ecgCost;
    }

    public void setEcgCost(double ecgCost) {
        this.ecgCost = ecgCost;
    }

    public double getxRayCost() {
        return xRayCost;
    }

    public void setxRayCost(double xRayCost) {
        this.xRayCost = xRayCost;
    }

    public double getHeartBypassSurgery() {
        return heartBypassSurgery;
    }

    public void setHeartBypassSurgery(double heartBypassSurgery) {
        this.heartBypassSurgery = heartBypassSurgery;
    }

    public double getAngioplastySurgery() {
        return angioplastySurgery;
    }

    public void setAngioplastySurgery(double angioplastySurgery) {
        this.angioplastySurgery = angioplastySurgery;
    }

    public double getKneeReplacementSurgery() {
        return kneeReplacementSurgery;
    }

    public void setKneeReplacementSurgery(double kneeReplacementSurgery) {
        this.kneeReplacementSurgery = kneeReplacementSurgery;
    }

    public double getCorneaSurgery() {
        return corneaSurgery;
    }

    public void setCorneaSurgery(double corneaSurgery) {
        this.corneaSurgery = corneaSurgery;
    }

    public double getFluVaccine() {
        return fluVaccine;
    }

    public void setFluVaccine(double fluVaccine) {
        this.fluVaccine = fluVaccine;
    }

    public double getHepatitisAVaccine() {
        return hepatitisAVaccine;
    }

    public void setHepatitisAVaccine(double hepatitisAVaccine) {
        this.hepatitisAVaccine = hepatitisAVaccine;
    }

    public double getHepatitisBVaccine() {
        return hepatitisBVaccine;
    }

    public void setHepatitisBVaccine(double hepatitisBVaccine) {
        this.hepatitisBVaccine = hepatitisBVaccine;
    }

    public double getHPVvaccine() {
        return HPVvaccine;
    }

    public void setHPVvaccine(double HPVvaccine) {
        this.HPVvaccine = HPVvaccine;
    }

    public double getIPVvaccine() {
        return IPVvaccine;
    }

    public void setIPVvaccine(double IPVvaccine) {
        this.IPVvaccine = IPVvaccine;
    }

    public double getMMRVaccine() {
        return MMRVaccine;
    }

    public void setMMRVaccine(double MMRVaccine) {
        this.MMRVaccine = MMRVaccine;
    }
    
    
    @Override
    public String toString() {
        return "healthCost{" + "hospitalName= "+ hospitalName + " , consultationFee=" + consultationFee
                               + ", mriCost= "+ mriCost
                               + ", eegCost= "+ eegCost
                               + ", ecgCost= "+ ecgCost
                               + ", xRayCost= "+ xRayCost
                + "}";
    }
    
    
    
}
