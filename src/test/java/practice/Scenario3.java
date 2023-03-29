package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Scenario3 {

	public static void main(String[] args) {
		//step 1
		WebDriver dr = new ChromeDriver();
		dr.get("http://localhost:8888");
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		//step 2
		dr.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		dr.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		dr.findElement(By.xpath("//input[@type='submit']")).click();
		
		//step 3
		dr.findElement(By.linkText("Organizations")).click();
		
		//step 4
		dr.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//step 5
		dr.findElement(By.xpath("//input[@name='accountname']")).sendKeys("UZUMAKI");
		
		//step 6
		WebElement ele = dr.findElement(By.xpath("//select[@name='industry']"));
		Select s = new Select(ele);
		s.selectByValue("Chemicals");
		dr.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//step 7
		String elem2 = dr.findElement(By.xpath("//span[@id='dtlview_Industry']")).getText();
		String elem1 = dr.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		if((elem1.equals("UZUMAKI"))&&(elem2.equals("Chemicals"))) {
			System.out.println(elem1+"\t"+elem2+"\n"+"PASS");
		}
		else {
			System.out.println("---FAIL---");
		}
		
		//step 8
		WebElement elem = dr.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(dr);
		act.moveToElement(elem).perform();
		dr.findElement(By.linkText("Sign Out")).click();
		System.out.println("Sign out successfull");
		dr.quit();
	}
}
