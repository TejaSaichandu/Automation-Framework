package vtiger.OrganizationTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import vtigerGenericUtilities.BaseClass;
import vtigerObjectRepository.CreateOrganizationsPage;
import vtigerObjectRepository.HomePage;
import vtigerObjectRepository.OrganizationsInfoPage;
import vtigerObjectRepository.OrganizationsPage;

public class CreateOrganizationsTest extends BaseClass {
	@Test
	public void createOrg() throws Exception {
		
		//Read data from Excel sheet
		String ORGNAME = eUtil.readDataFromExcel("Sheet1", 1, 2); 
		
		//navigate to organisations tab
		HomePage hp = new HomePage(dr);
		hp.getOrganizationsBtn().click();
		
		//click on new organizations icon
		OrganizationsPage op = new OrganizationsPage(dr);
		op.gotoOrganizationsPage();
		
		//create new organization with name
		CreateOrganizationsPage cop = new CreateOrganizationsPage(dr);
		cop.createNewOrganization(ORGNAME+jUtil.getRandomNumber());
		
		//validate
		OrganizationsInfoPage oip = new OrganizationsInfoPage(dr);
		String orgheader = oip.orgInfo();
		
		Assert.assertTrue(orgheader.contains(ORGNAME));
		System.out.println(ORGNAME +"--- Organization created");
		
		
		
	}
}
