/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author maheswararaogunturi
 */
public class BookAppointmentWorkRequest extends WorkRequest{
    
    private String InfoResult;
    public String hospitalName;
    public String doctor;
    public String date;
    public String time;
    public String treatmentType;
    public double treatmentFee;

    public String getInfoResult() {
        return InfoResult;
    }

    public void setInfoResult(String InfoResult) {
        this.InfoResult = InfoResult;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTreatmentType() {
        return treatmentType;
    }

    public void setTreatmentType(String treatmentType) {
        this.treatmentType = treatmentType;
    }

    public double getTreatmentFee() {
        return treatmentFee;
    }

    public void setTreatmentFee(double treatmentFee) {
        this.treatmentFee = treatmentFee;
    }
    
    
    
    
    
}
