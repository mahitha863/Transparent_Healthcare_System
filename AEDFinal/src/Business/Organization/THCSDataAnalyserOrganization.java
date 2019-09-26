/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.THCSDataAnalyserRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Gaya 3
 */
public class THCSDataAnalyserOrganization extends Organization{

    public THCSDataAnalyserOrganization() {
        super(Type.THCSDataAnalyser.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new THCSDataAnalyserRole());
        return roles;
    }
     
   
    
    
}
