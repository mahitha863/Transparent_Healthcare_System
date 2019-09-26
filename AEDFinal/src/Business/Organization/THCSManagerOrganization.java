/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.THCSManagerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Gaya 3
 */
public class THCSManagerOrganization extends Organization{

    public THCSManagerOrganization() {
        super(Type.THCSManager.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new THCSManagerRole());
        return roles;
    }
     
}