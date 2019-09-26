/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.THCSDataAnalyserRole;

/**
 *
 * @author Gaya 3
 */
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.THCSEnterprise;
import Business.Hospitals.HospitalDirectory;
import Business.Network.Network;
import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
 
 
public class HealthCostLineChart extends Application {
    
    private static EcoSystem business;
    private static THCSEnterprise thcsEnterprise; 
    private static Network network;
    private static String treatmentType;
    private static String reportType;

    /**
     * Creates new form DataAnalyserWorkAreaJPanel
     */
 
    @Override public void start(Stage stage) {
  
    }
 
    public void launchChart(EcoSystem business, Enterprise enterprise, Network network, String treatmentType, String reportType) {
       
        
        this.business = business;
        this.thcsEnterprise = (THCSEnterprise)enterprise;
        this.network = network;
        this.treatmentType = treatmentType;
        this.reportType = reportType;

        SwingUtilities.invokeLater(new Runnable() {
           @Override
           public void run() {
               initAndShowGUI();
           }
       });
    }
    
    private void initAndShowGUI() {
       // This method is invoked on Swing thread
       JFrame frame = null;
       if(reportType.equals("hospitals")){
           frame = new JFrame("Costs vs Hospitals");
       }
       else{
           frame = new JFrame("Costs vs States");
       }
       frame.setBounds(250, 200, 600, 600);
       final JFXPanel fxPanel = new JFXPanel();
       frame.add(fxPanel);
       frame.setVisible(true);

       Platform.runLater(() -> {
           initFX(fxPanel);
       });
   }

   private void initFX(JFXPanel fxPanel) {
       Stage stage = new Stage();
       
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        
        final LineChart<String,Number> lineChart = new LineChart<String,Number>(xAxis,yAxis);
       
        lineChart.setTitle(this.treatmentType);
        lineChart.setAnimated(false);            
        
        
        
        
        
        String imagePath = null;
        if(reportType.equals("hospitals")){
            
            stage.setTitle("Cost VS Hospitals");
            xAxis.setLabel("Hospitals");
            yAxis.setLabel("Cost(USD)");
            
            XYChart.Series series1 = new XYChart.Series();
            
            series1.setName("Cost");
            
            
            HospitalDirectory hd = new HospitalDirectory();
            hd.getHospitalsFromEnterpriseDirectory(this.network).forEach((n) -> {
                double costOfTreatment = 0.0;
                if(treatmentType.equals("MRI")){
                    costOfTreatment = this.thcsEnterprise.findHealthCost(n).getMriCost();
                }
                else if(treatmentType.equals("Consultation Fee")){
                    costOfTreatment = this.thcsEnterprise.findHealthCost(n).getConsultationFee();
                }
                else if(treatmentType.equals("EEG")){
                    costOfTreatment = this.thcsEnterprise.findHealthCost(n).getEegCost();
                }
                else if(treatmentType.equals("ECG")){
                    costOfTreatment = this.thcsEnterprise.findHealthCost(n).getEcgCost();
                }
                else if(treatmentType.equals("X-Ray")){
                    costOfTreatment = this.thcsEnterprise.findHealthCost(n).getxRayCost();
                }
                else if(treatmentType.equals("Flu Vaccine")){
                    costOfTreatment = this.thcsEnterprise.findHealthCost(n).getFluVaccine();
                }
                else if(treatmentType.equals("Hepatitis A Vaccine")){
                    costOfTreatment = this.thcsEnterprise.findHealthCost(n).getHepatitisAVaccine();
                }
                else if(treatmentType.equals("Hepatitis B Vaccine")){
                    costOfTreatment = this.thcsEnterprise.findHealthCost(n).getHepatitisBVaccine();
                }
                else if(treatmentType.equals("HPV Vaccine")){
                    costOfTreatment = this.thcsEnterprise.findHealthCost(n).getHPVvaccine();
                }
                else if(treatmentType.equals("IPV Vaccine")){
                    costOfTreatment = this.thcsEnterprise.findHealthCost(n).getIPVvaccine();
                }
                else if(treatmentType.equals("MMR Vaccine")){
                    costOfTreatment = this.thcsEnterprise.findHealthCost(n).getMMRVaccine();
                }
                else if(treatmentType.equals("Heart Bypass Surgery")){
                    costOfTreatment = this.thcsEnterprise.findHealthCost(n).getHeartBypassSurgery();
                }
                else if(treatmentType.equals("Angioplasty Surgery")){
                    costOfTreatment = this.thcsEnterprise.findHealthCost(n).getAngioplastySurgery();
                }
                else if(treatmentType.equals("Knee Replacement Surgery")){
                    costOfTreatment = this.thcsEnterprise.findHealthCost(n).getKneeReplacementSurgery();
                }
                 else if(treatmentType.equals("Cornea Surgery")){
                    costOfTreatment = this.thcsEnterprise.findHealthCost(n).getCorneaSurgery();
                }
                series1.getData().add(new XYChart.Data(n, costOfTreatment));
                
            });
            imagePath = "snapshotsHospitals\\" + this.treatmentType + ".png";
            Scene scene  = new Scene(lineChart,800,600);       
        lineChart.getData().addAll(series1);
        
        fxPanel.setScene(scene);
        
        
        saveAsPng(scene, imagePath);

        }
        else if(reportType.equals("networks")){
            
            stage.setTitle("Cost VS State");
            
            xAxis.setLabel("States");
            yAxis.setLabel("Cost(USD)");
            
            XYChart.Series series1 = new XYChart.Series();
        XYChart.Series series2 = new XYChart.Series();
        XYChart.Series series3 = new XYChart.Series();
        series1.setName("Highest Cost");
        series2.setName("Lowest Cost");
        series3.setName("Average Cost");
            this.business.getNetworkList().forEach((n) -> {
                if(n.getTHCSEnterprise() != null){
                    series1.getData().add(new XYChart.Data(n.getName(), n.getTHCSEnterprise().getHighestCost(this.treatmentType)));
                    series2.getData().add(new XYChart.Data(n.getName(), n.getTHCSEnterprise().getLowestCost(this.treatmentType)));
                    series3.getData().add(new XYChart.Data(n.getName(), n.getTHCSEnterprise().getAvgCostByTreatment(this.treatmentType)));
                }

            });
            imagePath = "snapshotsNetworks\\" + this.treatmentType + ".png";
            Scene scene  = new Scene(lineChart,800,600);       
        lineChart.getData().addAll(series1, series2, series3);
        
        fxPanel.setScene(scene);
        
        
        saveAsPng(scene, imagePath);

        }
        
       
        
   }
   
   public void saveAsPng(Scene scene, String path) {
            WritableImage image = scene.snapshot(null);
            File file = new File(path);
            try {
                ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
