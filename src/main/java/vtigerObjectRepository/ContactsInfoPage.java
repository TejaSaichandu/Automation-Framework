package vtigerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {//create POM classes for every web page

	//find web elements using @FindBy, @FindAll and @FindBys
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement ContactInfo; 
	
	//create constructor for web element
	public ContactsInfoPage(WebDriver dr)
	{
		PageFactory.initElements(dr, this);
	}

	//create getters
	public WebElement getContactInfo() {
		return ContactInfo;
	}

	//create business lib
	public String contactInfo() {
		return ContactInfo.getText();
	}

}
