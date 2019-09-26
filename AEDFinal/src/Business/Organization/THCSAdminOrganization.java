/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.THCSAdminRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Gaya 3
 */
public class THCSAdminOrganization extends Organization{

    public THCSAdminOrganization() {
        super(Type.THCSAdmin.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new THCSAdminRole());
        return roles;
    }
     
}
