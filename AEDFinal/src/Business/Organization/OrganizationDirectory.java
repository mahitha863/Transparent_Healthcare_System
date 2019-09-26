/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author Gaya 3
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type){
        Organization organization = null;
        if (type.getValue().equals(Type.THCSAdmin.getValue())){
            organization = new THCSAdminOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.THCSManager.getValue())){
            organization = new THCSManagerOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.THCSDataAnalyser.getValue())){
            organization = new THCSDataAnalyserOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.GovtAdmin.getValue())){
            organization = new GovtAdminOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.GovtEmployee.getValue())){
            organization = new GovtEmployeeOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.THCSDataCollector.getValue())){
            organization = new THCSDataCollectorOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Customer.getValue())){
            organization = new CustomerOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.HospitalAdmin.getValue())){
            organization = new HospitalAdminOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.HospitalEmployee.getValue())){
            organization = new HospitalEmployeeOrganization();
            organizationList.add(organization);
        }

        return organization;
    }
}