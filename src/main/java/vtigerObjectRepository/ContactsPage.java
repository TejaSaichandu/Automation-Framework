package vtigerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {//create POM classes for every web page
	
	//find web elements using @FindBy @FindAll and @FindBys
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement CreateContactsIcon;
	
	//create constructor to initialize the web elements
	public ContactsPage(WebDriver dr)
	{
		PageFactory.initElements(dr, this);
	}

	//create getters for web element
	public WebElement getCreateContactsIcon() {
		return CreateContactsIcon;
	}
	
	//create business library
	public void gotoContactsPage()
	{
		CreateContactsIcon.click();
	}
	
}
