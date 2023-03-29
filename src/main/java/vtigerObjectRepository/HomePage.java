package vtigerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtigerGenericUtilities.WebDriverUtilities;

public class HomePage extends WebDriverUtilities{//create POM classes for every web page
	
	//find web elements using @FindBy @FindAll and @FindBys
	@FindBy(linkText = "Organizations")
	private WebElement OrganizationsBtn;
	
	@FindBy(linkText = "Contacts")
	private WebElement ContactsBtn;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement UserIcon;
	
	@FindBy(linkText = "Sign Out")
	private WebElement SignoutBtn;
	
	//create constructor
	public HomePage(WebDriver dr) {
		PageFactory.initElements(dr, this);
	}

	//create getters
	public WebElement getOrganizationsBtn() {
		return OrganizationsBtn;
	}

	public WebElement getContactsBtn() {
		return ContactsBtn;
	}

	public WebElement getUserIcon() {
		return UserIcon;
	}

	public WebElement getSignoutBtn() {
		return SignoutBtn;
	}
	
	//create business libraries
	public void signOut(WebDriver dr) {
		mouseHoverAction(dr, UserIcon);
		SignoutBtn.click();
	}
}
