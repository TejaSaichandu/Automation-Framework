package vtiger.OrganizationTests;

import org.testng.annotations.Test;

import vtigerGenericUtilities.BaseClass;
import vtigerObjectRepository.CreateOrganizationsPage;
import vtigerObjectRepository.HomePage;
import vtigerObjectRepository.OrganizationsInfoPage;
import vtigerObjectRepository.OrganizationsPage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

@Listeners(vtigerGenericUtilities.ListenersImplementation.class)
public class CreateMultipleOrgWithIndustryTest extends BaseClass
{
	
	@Test(dataProvider = "getData")
	public void createMultipleOrgTest(String Org, String INDUSTRY)
	{
		String ORGNAME = Org+jUtil.getRandomNumber();
		
		HomePage hp = new HomePage(dr);
		hp.getOrganizationsBtn().click();
		
		OrganizationsPage op = new OrganizationsPage(dr);
		op.gotoOrganizationsPage();
		
		CreateOrganizationsPage cnop = new CreateOrganizationsPage(dr);
		cnop.createNewOrganization(ORGNAME, INDUSTRY);
		
		OrganizationsInfoPage oip = new OrganizationsInfoPage(dr);
		String OrgHeader = oip.getOrgInfo().getText();
		Assert.assertTrue(OrgHeader.contains(ORGNAME));
	}
	
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		Object[][] data = eUtil.readMultipleDataFromExcel("Sheet2");
		return data;
	}

}
