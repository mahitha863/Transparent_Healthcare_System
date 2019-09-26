/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.HospitalEmployeeOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.HospitalEmployeeRole.HospEmployeeWorkAreaJPanel;

/**
 *
 * @author maheswararaogunturi
 */
public class HospitalEmployeeRole extends Role {
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, Network network) {
        return new HospEmployeeWorkAreaJPanel(userProcessContainer, account, (HospitalEmployeeOrganization)organization, business, enterprise);
    }
    
}
