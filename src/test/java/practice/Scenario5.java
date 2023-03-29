package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scenario5 {

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
		dr.findElement(By.linkText("Contacts")).click();
		
		//step 4
		dr.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		//step 5
		dr.findElement(By.name("lastname")).sendKeys("Teja");
		dr.findElement(By.xpath("//input[@type='submit']")).click();
		
		//step 6
		
	}
}
