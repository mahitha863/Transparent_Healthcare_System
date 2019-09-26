/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import userinterface.THCSAdminRole.THCSAdminWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Gaya 3
 */
public class THCSAdminRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, Network network) {
        return new THCSAdminWorkAreaJPanel(userProcessContainer, enterprise);
    }

    
    
}
