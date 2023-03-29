package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario2 {

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
		dr.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String ele = dr.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		if(ele.equals("UZUMAKI")) {
			System.out.println(ele+" ---Pass");
		}
		else {
			System.out.println("---Fail---");
		}
		//step 7
		WebElement elem = dr.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(dr);
		act.moveToElement(elem).perform();
		dr.findElement(By.linkText("Sign Out")).click();
		System.out.println("Sign out successfull");
		dr.quit();
	}
}
