/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.THCSManagerOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import userinterface.THCSManagerRole.ManagerWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Gaya 3
 */
public class THCSManagerRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, Network network) {
        return new ManagerWorkAreaJPanel(userProcessContainer,account, (THCSManagerOrganization)organization, enterprise, network);
    }
    
    
}
