package vtigerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {//rule1 : Create a POM class for every web page

	//rule2 : identify the web elements using @FindBy @FindAll and @FindBys
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement CreateOrganizationsIcon;
	
	//rule3 : create a constructor to initialize these web elements
	public OrganizationsPage(WebDriver dr)
	{
		PageFactory.initElements(dr, this);
	}
	
	//rule4 : create getters for the web elements
	public WebElement getCreateOrgnizationsIcon() {
		return CreateOrganizationsIcon;
	}
	
	//Generate Business Libraries
	public void gotoOrganizationsPage()
	{
		CreateOrganizationsIcon.click();
	}
}
