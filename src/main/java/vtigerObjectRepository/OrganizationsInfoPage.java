package vtigerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsInfoPage {//create POM classes for every web page

	//find web elements using @FindBy, @FindAll and @FindBys
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement OrgInfo; 
	
	//create constructor for web element
	public OrganizationsInfoPage(WebDriver dr)
	{
		PageFactory.initElements(dr, this);
	}

	//create getters
	public WebElement getOrgInfo() {
		return OrgInfo;
	}
	
	//create business lib
	public String orgInfo() {
		return OrgInfo.getText();
	}
	
	
}
