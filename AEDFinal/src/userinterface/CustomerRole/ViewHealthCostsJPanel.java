/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CustomerRole;

import java.util.ArrayList;
import Business.Enterprise.Enterprise;
import Business.Enterprise.THCSEnterprise;
import Business.HealthCost.HealthCost;
import Business.Network.Network;
import Business.Organization.CustomerOrganization;
import Business.Organization.HospitalEmployeeOrganization;
import Business.Organization.Organization;
import Business.TreatmentTypes.TreatmentTypeDirectory;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.BookAppointmentWorkRequest;
import java.awt.CardLayout;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import static org.openxmlformats.schemas.spreadsheetml.x2006.main.STAxis.Enum.table;

/**
 *
 * @author Gaya 3
 */
public class ViewHealthCostsJPanel extends javax.swing.JPanel {
    
    private THCSEnterprise thcsEnterprise; 
    private JPanel userProcessContainer;
    private CustomerOrganization organization;
    private UserAccount userAccount;
    private Network network;
    
    
    
    

    /**
     * Creates new form CustomerWorkAreaJPanel
     */
    public ViewHealthCostsJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network) {
        initComponents();
        this.thcsEnterprise = (THCSEnterprise)enterprise;
        this.userProcessContainer = userProcessContainer;
        this.organization = (CustomerOrganization) organization;
        this.userAccount = account;
        this.network = network;
        
        populateTreatmentComboUser();
        
        //populateTable();
    }
    
    public void populateTreatmentComboUser(){
        treatmentComboUser.removeAllItems();
        
        treatmentComboUser.addItem("Select a treatment");
        ArrayList<String> treatmentsList = new ArrayList<String>();
        TreatmentTypeDirectory tt = new TreatmentTypeDirectory();
        treatmentsList = tt.getTreatmentTypes();
        for(String treatment:treatmentsList)
        {
            treatmentComboUser.addItem(treatment);
        }
        
    }
    
    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel)healthCostsTbl.getModel();
        model.setRowCount(0);
        
        if(treatmentComboUser.getSelectedItem().toString().equals("Select a treatment")){
            
        }else{
          for(HealthCost c: this.thcsEnterprise.getHcDirectory()){
            Object[] row = new Object[3];
            row[0] = c.getHospitalName();
            row[1] = c.getHospitalLocation();
            row[2] = getTreatmentFee(c);
            
            model.addRow(row);
          }
          displayTopFour();
        }
        
    }
    
    
    public void displayTopFour(){
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(healthCostsTbl.getModel());
        healthCostsTbl.setRowSorter(sorter);

        List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
        sortKeys.add(new RowSorter.SortKey(2, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);
        if(((DefaultTableModel)healthCostsTbl.getModel()).getRowCount() > 4)
        ((DefaultTableModel)healthCostsTbl.getModel()).setRowCount(4);
    }
    
    
    public double getTreatmentFee(HealthCost c){
        double cost=0;
        
        String selected = " ";
        selected = treatmentComboUser.getSelectedItem().toString();
        
        if(selected.equalsIgnoreCase("Consultation Fee"))  cost=c.getConsultationFee();
        else if(selected.equalsIgnoreCase("MRI"))  cost = c.getMriCost();
        else if(selected.equalsIgnoreCase("EEG"))  cost = c.getEegCost();
        else if(selected.equalsIgnoreCase("ECG"))  cost = c.getEcgCost();
        else if(selected.equalsIgnoreCase("X-Ray"))  cost = c.getxRayCost();
        else if(selected.equalsIgnoreCase("Heart Bypass Surgery"))  cost = c.getHeartBypassSurgery();
        else if(selected.equalsIgnoreCase("Angioplasty Surgery"))  cost = c.getAngioplastySurgery();
        else if(selected.equalsIgnoreCase("Knee Replacement Surgery"))  cost = c.getKneeReplacementSurgery();
        else if(selected.equalsIgnoreCase("Cornea Surgery"))  cost = c.getCorneaSurgery();
        else if(selected.equalsIgnoreCase("Flu Vaccine"))  cost = c.getFluVaccine();
        else if(selected.equalsIgnoreCase("Hepatitis A Vaccine"))  cost = c.getHepatitisAVaccine();
        else if(selected.equalsIgnoreCase("Hepatitis B Vaccine"))  cost = c.getHepatitisBVaccine();
        else if(selected.equalsIgnoreCase("HPV Vaccine"))  cost = c.getHPVvaccine();
        else if(selected.equalsIgnoreCase("IPV Vaccine"))  cost = c.getIPVvaccine();
        else if(selected.equalsIgnoreCase("MMR Vaccine"))  cost = c.getMMRVaccine();
        
        
        return cost;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        healthCostsTbl = new javax.swing.JTable();
        btnBookAppointment = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        treatmentComboUser = new javax.swing.JComboBox();
        btnBack = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 153, 204));

        healthCostsTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Hospital Name", "Location", "Treatment Cost"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(healthCostsTbl);

        btnBookAppointment.setText("Book Appointment");
        btnBookAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookAppointmentActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Health Cost Data");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel2.setText("Show Costs For:");

        treatmentComboUser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        treatmentComboUser.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                treatmentComboUserItemStateChanged(evt);
            }
        });
        treatmentComboUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                treatmentComboUserFocusLost(evt);
            }
        });
        treatmentComboUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                treatmentComboUserActionPerformed(evt);
            }
        });

        btnBack.setText("<<WorkArea");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel3.setText("Top Four Budget-Friendly Hospitals");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnBack))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnBookAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(31, 31, 31)
                                            .addComponent(treatmentComboUser, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 74, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(btnBack)
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(treatmentComboUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(btnBookAppointment)
                .addContainerGap(109, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBookAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookAppointmentActionPerformed
        // TODO add your handling code here:
        int selectedRow = healthCostsTbl.getSelectedRow();
        if(selectedRow>=0)
        {
            //HealthCost hc = (HealthCost) healthCostsTbl.getValueAt(selectedRow, 0);
            String hospitalName = (String) healthCostsTbl.getValueAt(selectedRow, 0);
            String message = "Appointment for "+hospitalName;/*hc.getHospitalName()*/;
            
            BookAppointmentWorkRequest request = new BookAppointmentWorkRequest();
            request.setMessage(message);
            request.setSender(userAccount);
            request.setStatus("Sent");
            request.setHospitalName(hospitalName);
            request.setTreatmentType(treatmentComboUser.getSelectedItem().toString());
            
            request.setTreatmentFee((double) healthCostsTbl.getValueAt(selectedRow, 2));
            
            Organization org = null;
            
            for (Enterprise e : network.getEnterpriseDirectory().getEnterpriseList()) {
                if (!e.getName().equals(thcsEnterprise.getName())) {
                    for (Organization o : e.getOrganizationDirectory().getOrganizationList()) {
                        if (o instanceof HospitalEmployeeOrganization) {
                            org =o;
                            o.getWorkQueue().getWorkRequestList().add(request);
                        }
                    }
                }
            }
            
            if (org!=null){
                System.out.println("came here");
                userAccount.getWorkQueue().getWorkRequestList().add(request);
            }else{
                System.out.println("org is null");
            }
           
       
            
            JOptionPane.showMessageDialog(null, "Appointment Request successfully placed!!!");  
            
            
        }
        else{
            JOptionPane.showMessageDialog(null, "Please select a hospital from table to book appointment", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnBookAppointmentActionPerformed

    private void treatmentComboUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_treatmentComboUserActionPerformed
        // TODO add your handling code here:
        if(treatmentComboUser.getSelectedItem() != null){
            populateTable();
        }
        
    }//GEN-LAST:event_treatmentComboUserActionPerformed

    private void treatmentComboUserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_treatmentComboUserFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_treatmentComboUserFocusLost

    private void treatmentComboUserItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_treatmentComboUserItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_treatmentComboUserItemStateChanged

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBookAppointment;
    private javax.swing.JTable healthCostsTbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox treatmentComboUser;
    // End of variables declaration//GEN-END:variables
}
