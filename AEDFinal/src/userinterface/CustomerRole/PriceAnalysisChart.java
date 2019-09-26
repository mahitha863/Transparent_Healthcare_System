/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CustomerRole;

import Business.Enterprise.THCSEnterprise;
import Business.HealthCost.HealthCost;
import Business.WorkQueue.BookAppointmentWorkRequest;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author mahitha
 */
public class PriceAnalysisChart extends Application {
    
    private BookAppointmentWorkRequest req;
    private THCSEnterprise thcsEnterprise;
    
    
    public void launchChart(BookAppointmentWorkRequest req, THCSEnterprise thcsEnterprise){
        
        this.req = req;
        this.thcsEnterprise = thcsEnterprise;

        SwingUtilities.invokeLater(new Runnable() {
           @Override
           public void run() {
               initAndShowGUI();
           }
       });
    }
    
    
    
     private void initAndShowGUI() {
       // This method is invoked on Swing thread
       JFrame frame = new JFrame("Price Analysis Chart");
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
       stage.setTitle("PriceAnalysis");
       
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Category");
        yAxis.setLabel("Cost(USD)");
     
      //Creating the Bar chart
      BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis); 
      barChart.setTitle("Price Analysis for "+req.getTreatmentType());
      barChart.setAnimated(false);   
        
      //Prepare XYChart.Series objects by setting data       
      XYChart.Series<String, Number> series1 = new XYChart.Series<>();
      
      
      String hospitalLocation = " ";
      double priceSelected = 0;
      for(HealthCost hc : thcsEnterprise.getHcDirectory()){
          if(hc.getHospitalName().equalsIgnoreCase(req.getHospitalName()))
          {
              hospitalLocation = hc.getHospitalLocation();
          }
      }
      
      
      series1.setName(hospitalLocation);
      double maxPrice = thcsEnterprise.getHighestCost(req.getTreatmentType());
      double minPrice = thcsEnterprise.getLowestCost(req.getTreatmentType());
      double avgPrice = thcsEnterprise.getAvgCostByTreatment(req.getTreatmentType());
      double selectedPrice = req.getTreatmentFee();
      
      series1.getData().add(new XYChart.Data("Max Price",maxPrice));
      series1.getData().add(new XYChart.Data("Min Price",minPrice));
      series1.getData().add(new XYChart.Data("Avg Price",avgPrice));
      series1.getData().add(new XYChart.Data("Selected Price", selectedPrice));
      
      System.out.println("maxPrice ="+maxPrice);
      System.out.println("minPrice ="+minPrice);
      System.out.println("avgPrice ="+avgPrice);
      System.out.println("selectedPrice ="+selectedPrice);
        
      
      Scene scene = new Scene(barChart, 800, 600);
      //Setting the data to bar chart       
      barChart.getData().addAll(series1);
      fxPanel.setScene(scene);
   }
    

    @Override
    public void start(Stage stage) throws Exception {
       
    }
    
}
