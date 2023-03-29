package vtigerObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtigerGenericUtilities.WebDriverUtilities;

public class CreateContactsPage extends WebDriverUtilities {//create POM classes for every web page

	//locate the web elements using @FindBy @FindAll and @FindBys
	@FindBy(name="lastname")
	private WebElement LastNameEdt;
	
	@FindBy(xpath="//input[@name='account_id']/following-sibling::img[@title='Select']")
	private WebElement OrganizationNameIcon;
	
	@FindBy(name = "search_text")
	private WebElement SearchBoxEdt;
	
	@FindBy(name = "search")
	private WebElement SearchBtn;
		
	@FindAll({@FindBy(xpath="//input[@title='Save [Alt+S]']"),@FindBy(xpath="//input[@class='crmButton small save']")})               
	private WebElement SaveBtn;
	
	//create constructor for the web element
	public CreateContactsPage(WebDriver dr)
	{
		PageFactory.initElements(dr, this);
	}

	//create getters for the web elements
	public WebElement getLastNameEdt() {
		return LastNameEdt;
	}

	public WebElement getOrganizationNameIcon() {
		return OrganizationNameIcon;
	}

	public WebElement getSearchBoxEdt() {
		return SearchBoxEdt;
	}

	public WebElement getSearchBtn() {
		return SearchBtn;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	//create business libraries
	/**
	 * This is to create contact with last name
	 */
	public void createNewContact(String lastname)
	{
		LastNameEdt.sendKeys(lastname);
		SaveBtn.click();
	}

	public void createNewContact(WebDriver dr,String lastname, String orgname)
	{
		LastNameEdt.sendKeys(lastname);
		OrganizationNameIcon.click();
		switchToWindow(dr, "Accounts");
		SearchBoxEdt.sendKeys(orgname);
		SearchBtn.click();
		dr.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		switchToWindow(dr, "Contacts");
		SaveBtn.click();
	}
		
}
