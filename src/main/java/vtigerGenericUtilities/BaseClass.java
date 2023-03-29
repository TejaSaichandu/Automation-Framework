package vtigerGenericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtigerObjectRepository.HomePage;
import vtigerObjectRepository.LoginPage;

public class BaseClass {

	public PropertiesFileUtilities pUtil = new PropertiesFileUtilities();
	public ExcelFileUtilities eUtil = new ExcelFileUtilities();
	public WebDriverUtilities wUtil = new WebDriverUtilities();
	public JavaUtilities jUtil = new JavaUtilities();
	
	
	public WebDriver dr;
	public static WebDriver sDriver; // for listeners
	
	@BeforeSuite
	public void bsConfig()
	{
	   System.out.println("----- Database Connection successfull -----");
	}

	@BeforeClass
	public void bcConfig() throws IOException
	{
		String URL = pUtil.readDataFromProperties("url");
		String BROWSER = pUtil.readDataFromProperties("browser");
		
		// Step 2: Launch the browser - runtime polymorphism
		if (BROWSER.equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			dr = new ChromeDriver();
			System.out.println("----- "+BROWSER+" Launched succesfully-----");
			
		} else if (BROWSER.equalsIgnoreCase("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			dr = new FirefoxDriver();
			System.out.println("----- "+BROWSER+" Launched successfully-----");
			
		} else 
		{
			System.out.println("Invalid Browser name");
		}

		sDriver=dr;  //for listeners (for screenshots)
		wUtil.maximizeWindow(dr);
		wUtil.waitForPage(dr);
		dr.get(URL);
		
	}
	
	@BeforeMethod
	public void bmConfig() throws IOException
	{
		String USERNAME = pUtil.readDataFromProperties("username");
		String PASSWORD = pUtil.readDataFromProperties("password");
		
		LoginPage lp = new LoginPage(dr);
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("----- Login successful -----");
	}
	
	@AfterMethod
	public void amConfig()
	{
		HomePage hp = new HomePage(dr);
		hp.signOut(dr);
		System.out.println("----- Logout successful -----");
	}
	
	@AfterClass
	public void acConfig()
	{
		dr.quit();
		System.out.println("----- Browser Closed successfully -----");
	}
	
	@AfterSuite
	public void asConfig()
	{
		System.out.println("----- Database Connection successfully closed -----");
		
	}

}
