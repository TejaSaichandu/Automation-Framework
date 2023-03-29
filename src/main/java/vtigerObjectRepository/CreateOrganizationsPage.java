package vtigerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtigerGenericUtilities.WebDriverUtilities;

public class CreateOrganizationsPage extends WebDriverUtilities{//create a POM class for every web page
	
	//identify all the web elements using @FindBy @FindAll and @FindBys
	@FindBy(name="accountname")
	private WebElement OrganizationNameEdt;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	@FindBy(xpath = "//select[@name='industry']")
	private WebElement IndustryDropdwn;
	
	//create constructor to initialize the webelements
	public CreateOrganizationsPage(WebDriver dr)
	{
		PageFactory.initElements(dr, this);
	}

	//create getters for private web elements
	public WebElement getOrganizationNameEdt() {
		return OrganizationNameEdt;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	public WebElement getIndustryDropdwn() {
		return IndustryDropdwn;
	}
	
	//create business libraries
	public void createNewOrganization(String orgname)
	{
		OrganizationNameEdt.sendKeys(orgname);
		SaveBtn.click();
	}
	
	public void createNewOrganization(String orgname, String industry)
	{
		OrganizationNameEdt.sendKeys(orgname);
		handleDropdown(IndustryDropdwn, industry);
		SaveBtn.click();
	}
}
