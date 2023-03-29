
package vtiger.ContactsTests;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import vtigerGenericUtilities.BaseClass;
import vtigerObjectRepository.ContactsInfoPage;
import vtigerObjectRepository.ContactsPage;
import vtigerObjectRepository.CreateContactsPage;
import vtigerObjectRepository.CreateOrganizationsPage;
import vtigerObjectRepository.HomePage;
import vtigerObjectRepository.OrganizationsInfoPage;
import vtigerObjectRepository.OrganizationsPage;

public class CreateContactWithOrgTest extends BaseClass {

	@Test
	public void createContactWithOrgTest() throws EncryptedDocumentException, IOException{
		
		
		//read data from excel
		String ORGNAME = eUtil.readDataFromExcel("Sheet3", 4, 2) + jUtil.getRandomNumber();
		String LASTNAME = eUtil.readDataFromExcel("Sheet3", 1, 2);
		
		
		//click on organizations 
		HomePage hp = new HomePage(dr);
		hp.getOrganizationsBtn().click();
		
		OrganizationsPage op = new OrganizationsPage(dr);
		op.gotoOrganizationsPage();
		
		//enter mandatory fields and save
		CreateOrganizationsPage cop = new CreateOrganizationsPage(dr);
		cop.createNewOrganization(ORGNAME);
		
		//validate 
		OrganizationsInfoPage oip = new OrganizationsInfoPage(dr);
		String orgHeader = oip.orgInfo();
		
		Assert.assertTrue(orgHeader.contains(ORGNAME));
		System.out.println(orgHeader+" --- Organization created");
		
		//Navigate to contacts link and click on create contacts
		hp.getContactsBtn().click();
		ContactsPage cp = new ContactsPage(dr);
		cp.gotoContactsPage();
		
		//create contact with lastname and organization name
		CreateContactsPage ccp = new CreateContactsPage(dr);
		ccp.getLastNameEdt().sendKeys(LASTNAME);
		ccp.getOrganizationNameIcon().click();
		
		//switch to window handle
		ccp.createNewContact(dr, LASTNAME, ORGNAME);
		//validate contact
		ContactsInfoPage cip = new ContactsInfoPage(dr);
		String ContactHeader = cip.contactInfo();
		
		Assert.assertTrue(ContactHeader.contains(LASTNAME));
		System.out.println(ContactHeader+" --- Contact created ");
	}
}
