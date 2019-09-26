/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CustomerRole;

import Business.Enterprise.Enterprise;
import Business.Enterprise.THCSEnterprise;
import Business.Network.Network;
import Business.Organization.CustomerOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author mahitha
 */
public class CustomerWorkAreaJPanel extends javax.swing.JPanel {
    
    private THCSEnterprise thcsEnterprise; 
    private JPanel userProcessContainer;
    private CustomerOrganization organization;
    private UserAccount userAccount;
    private Network network;

    /**
     * Creates new form CustomerWorkAreaJPanel
     */
    public CustomerWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network) {
        initComponents();
        
        this.thcsEnterprise = (THCSEnterprise)enterprise;
        this.userProcessContainer = userProcessContainer;
        this.organization = (CustomerOrganization) organization;
        this.userAccount = account;
        this.network = network;
        
        custNameLabel.setText("Name: "+account.getEmployee().getName()+" ");
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
        custNameLabel = new javax.swing.JLabel();
        btnViewHC = new javax.swing.JButton();
        btnViewAppointment = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 204));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Customer Work Area");

        custNameLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        custNameLabel.setForeground(new java.awt.Color(51, 0, 51));
        custNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        btnViewHC.setText("View Health Costs");
        btnViewHC.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnViewHC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewHCActionPerformed(evt);
            }
        });

        btnViewAppointment.setText("View Appointment Status");
        btnViewAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAppointmentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(custNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(379, 379, 379)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnViewAppointment)
                    .addComponent(btnViewHC))
                .addContainerGap(346, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(custNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(144, 144, 144)
                .addComponent(btnViewHC)
                .addGap(18, 18, 18)
                .addComponent(btnViewAppointment)
                .addContainerGap(349, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewHCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewHCActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("HealthCostsJPanel", new ViewHealthCostsJPanel(userProcessContainer,userAccount, organization, thcsEnterprise, network));
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnViewHCActionPerformed

    private void btnViewAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAppointmentActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("AppointmentInfoJPanel", new AppointmentInfoJPanel(userProcessContainer, userAccount, thcsEnterprise));
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnViewAppointmentActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnViewAppointment;
    private javax.swing.JButton btnViewHC;
    private javax.swing.JLabel custNameLabel;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
