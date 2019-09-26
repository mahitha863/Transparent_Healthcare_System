/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CustomerRole;

import Business.Enterprise.THCSEnterprise;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.BookAppointmentWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author maheswararaogunturi
 */
public class AppointmentInfoJPanel extends javax.swing.JPanel {
    
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private THCSEnterprise thcsEnterprise;
    private Map<Integer, WorkRequest> rowRequest;
    

    /**
     * Creates new form RequestHospitalInfoJPanel
     */
    public AppointmentInfoJPanel(JPanel userProcessContainer, UserAccount account, THCSEnterprise thcsEnterprise) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.thcsEnterprise = thcsEnterprise;
        
        rowRequest = new HashMap<Integer, WorkRequest>();
        
        populateRequestTable();
    }
    
    public void populateRequestTable(){
       // Map<Integer, WorkRequest> rowRequest = new HashMap<Integer, WorkRequest>();
        int rowIndex = 0;
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();
        
        model.setRowCount(0);
        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()){
            Object[] row = new Object[4];
            row[0] = ((BookAppointmentWorkRequest)request).getHospitalName();
            row[1] = request.getReceiver();
            row[2] = request.getStatus();
            String result = ((BookAppointmentWorkRequest) request).getInfoResult();
            row[3] = result == null ? "Waiting" : result;
            
            model.addRow(row);
            rowRequest.put(rowIndex, request);
            rowIndex++;
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        refreshTableJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        backJButton3 = new javax.swing.JButton();
        btnViewAppoin = new javax.swing.JButton();
        priceAnalysisBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 204));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Appointment Info");

        refreshTableJButton.setText("Refresh");
        refreshTableJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshTableJButtonActionPerformed(evt);
            }
        });

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Hospital Name", "Receiver", "Status", "Result"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workRequestJTable);

        backJButton3.setText("<<Back");
        backJButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButton3ActionPerformed(evt);
            }
        });

        btnViewAppoin.setText("View Appointment Details");
        btnViewAppoin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAppoinActionPerformed(evt);
            }
        });

        priceAnalysisBtn.setText("Check Price Analysis");
        priceAnalysisBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceAnalysisBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backJButton3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(priceAnalysisBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnViewAppoin)
                        .addComponent(refreshTableJButton)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 898, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addComponent(refreshTableJButton)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnViewAppoin)
                .addGap(18, 18, 18)
                .addComponent(priceAnalysisBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                .addComponent(backJButton3)
                .addGap(16, 16, 16))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void refreshTableJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshTableJButtonActionPerformed
        populateRequestTable();
    }//GEN-LAST:event_refreshTableJButtonActionPerformed

    private void backJButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton3ActionPerformed

        userProcessContainer.remove(this);
        /*Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ViewHealthCostsJPanel dcwajp = (ViewHealthCostsJPanel) component;
        dcwajp.populateTable();*/
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButton3ActionPerformed

    private void btnViewAppoinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAppoinActionPerformed
        // TODO add your handling code here:
        int selectedRow = workRequestJTable.getSelectedRow();
        if(selectedRow>=0)
        {
            
            String statusInSelected = (String) workRequestJTable.getValueAt(selectedRow, 2);
            if(statusInSelected.equalsIgnoreCase("completed")){
                BookAppointmentWorkRequest request = (BookAppointmentWorkRequest) rowRequest.get(selectedRow);
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                userProcessContainer.add("ViewAppointmentDetailsJPanel", new ViewAppointmentDetails(userProcessContainer, request));
                layout.next(userProcessContainer);
            }else{
                JOptionPane.showMessageDialog(null, "Appointment Request is still in progress", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
            
            
        }else{
            JOptionPane.showMessageDialog(null, "Please select an appointment request to view details", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_btnViewAppoinActionPerformed

    private void priceAnalysisBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceAnalysisBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = workRequestJTable.getSelectedRow();
        if(selectedRow>=0)
        {
            BookAppointmentWorkRequest req =  (BookAppointmentWorkRequest) rowRequest.get(selectedRow);
            String treatment_type = req.getTreatmentType();
            PriceAnalysisChart paChart = new PriceAnalysisChart();
            paChart.launchChart(req, thcsEnterprise);
        }else{
            JOptionPane.showMessageDialog(null, "Please select an appointment request to view price analysis", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_priceAnalysisBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton3;
    private javax.swing.JButton btnViewAppoin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton priceAnalysisBtn;
    private javax.swing.JButton refreshTableJButton;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}