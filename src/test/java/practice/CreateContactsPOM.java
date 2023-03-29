package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtigerGenericUtilities.ExcelFileUtilities;
import vtigerGenericUtilities.JavaUtilities;
import vtigerGenericUtilities.PropertiesFileUtilities;
import vtigerGenericUtilities.WebDriverUtilities;
import vtigerObjectRepository.ContactsInfoPage;
import vtigerObjectRepository.ContactsPage;
import vtigerObjectRepository.CreateContactsPage;
import vtigerObjectRepository.CreateOrganizationsPage;
import vtigerObjectRepository.HomePage;
import vtigerObjectRepository.LoginPage;
import vtigerObjectRepository.OrganizationsInfoPage;
import vtigerObjectRepository.OrganizationsPage;

public class CreateContactsPOM {

	public static void main(String[] args) throws Exception {
		
		//create objects for all utilities
		PropertiesFileUtilities pUtil = new PropertiesFileUtilities();
		ExcelFileUtilities eUtil = new ExcelFileUtilities();
		WebDriverUtilities wUtil = new WebDriverUtilities();
		JavaUtilities jUtil = new JavaUtilities();
		
		//read all necessary data
		String URL = pUtil.readDataFromProperties("url");
		String BROWSER = pUtil.readDataFromProperties("browser");
		String USERNAME = pUtil.readDataFromProperties("username");
		String PASSWORD = pUtil.readDataFromProperties("password");
		
		//read data from excel
		String ORGNAME = eUtil.readDataFromExcel("Sheet2", 4, 3) + jUtil.getRandomNumber();
		String LASTNAME = eUtil.readDataFromExcel("Sheet2", 4, 2);
		
		WebDriver dr = null;
		if(BROWSER.equalsIgnoreCase("Chrome"))
		{
			dr = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			dr = new FirefoxDriver();
		}
		else
		{
			System.out.println("Invalid Driver");
		}
		wUtil.maximizeWindow(dr);
		wUtil.waitForPage(dr);
		dr.get(URL);
		
		//login to application
		LoginPage lp = new LoginPage(dr);
		lp.loginToApp(USERNAME, PASSWORD);
		
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
		if (orgHeader.contains(ORGNAME)) {
			System.out.println(orgHeader + "Organizationm created");
		} else {
			System.out.println("Organization not created");
		}
		
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
		if(ContactHeader.contains(LASTNAME))
		{
			System.out.println(LASTNAME+" --- PASS ---");
		}
		else
		{
			System.out.println("-- FAIL --");
		}
		
		//Logout of Application
		WebElement ele = hp.getUserIcon();
		wUtil.mouseHoverAction(dr, ele);
		hp.getSignoutBtn().click();
		System.out.println("Sign out successfull");

		
		
		
		
		
		
		
		
		
	}
}
