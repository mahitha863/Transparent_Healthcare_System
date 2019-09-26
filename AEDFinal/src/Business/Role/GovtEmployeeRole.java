/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.GovtEmployeeRole.GovtEmployeeWorkAreaJPanel;
import userinterface.THCSDataCollectorRole.DataCollectorWorkAreaJPanel;

/**
 *
 * @author Gaya 3
 */
public class GovtEmployeeRole extends Role{
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, Network network) {
        return new GovtEmployeeWorkAreaJPanel(userProcessContainer, account, organization, business, enterprise, network);
        
    }
    
}
