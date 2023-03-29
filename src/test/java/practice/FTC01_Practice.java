package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FTC01_Practice {
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
		WebElement ele = dr.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
		Actions act = new Actions(dr);
		act.moveToElement(ele).click();
		dr.findElement(By.linkText("Quotes")).click();
		//step 4
		dr.findElement(By.xpath("//img[@title='Create Quote...']")).click();
		//step 5
		dr.findElement(By.xpath("//input[@name='subject']")).sendKeys("ORIGIN BOARDS");
		dr.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		
	}
}
