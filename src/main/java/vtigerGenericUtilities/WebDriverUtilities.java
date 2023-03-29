package vtigerGenericUtilities;

import java.io.File;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtilities {
	
	/**
	 * This method is to maximize the window
	 * @param dr
	 */
	public void maximizeWindow(WebDriver dr)
	{
		dr.manage().window().maximize();
	}
	/**
	 * This method is to minimize the window
	 * @param dr
	 */
	public void minimizeWindow(WebDriver dr)
	{
		dr.manage().window().minimize();
	}
	/**
	 * This method is for implicit wait
	 * @param dr
	 */
	public void waitForPage(WebDriver dr)
	{
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**
	 * This method is for explicitly wait till element is visible
	 * @param dr
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver dr, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method is for explicitly wait till element is clicable
	 * @param dr
	 * @param element
	 */
	public void waitForElementToBeClicable(WebDriver dr, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method is for handling dropdown by index
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element, int index)
	{
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * This method is for handling dropdown by value
	 * @param element
	 * @param value
	 */
	public void handleDropdown(WebElement element, String value)
	{
		Select s = new Select(element);
		s.selectByValue(value);
	}
	/**
	 * This method is for handling dropdown by visible text
	 * @param text
	 * @param element
	 */
	public void handleDropdown(String text, WebElement element)
	{
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	/**
	 * This method is for handling mouse Hover action
	 * @param dr
	 * @param element
	 */
	public void mouseHoverAction(WebDriver dr, WebElement element)
	{
		Actions act = new Actions(dr);
		act.moveToElement(element).perform();
	}
	/**
	 * This method is for right clicking anywhere in the webpage
	 * @param dr
	 */
	public void rightClickAction(WebDriver dr)
	{
		Actions act = new Actions(dr);
		act.contextClick();
	}
	/**
	 * This method will perform right click on a web element
	 * @param dr
	 * @param element
	 */
	public void rightClickAction(WebDriver dr, WebElement element)
	{
		Actions act = new Actions(dr);
		act.contextClick(element).perform();
	}
	
	/**
	 * This method will perform double click anywhere on web page
	 * @param dr
	 */
	public void doubleClickAction(WebDriver dr)
	{
		Actions act = new Actions(dr);
		act.doubleClick().perform();
	}
	
	/**
	 * This method will perform double click on a web element
	 * @param dr
	 * @param element
	 */
	public void doubleClickAction(WebDriver dr, WebElement element)
	{
		Actions act = new Actions(dr);
		act.doubleClick(element).perform();
	}
	
	/**
	 * This method will perform drag and drop action
	 * @param dr
	 * @param srcElement
	 * @param dstElement
	 */
	public void dragAndDropAction(WebDriver dr, WebElement srcElement, WebElement dstElement)
	{
		Actions act = new Actions(dr);
		act.dragAndDrop(srcElement, dstElement).perform();
	}
	
	/**
	 * This method will aceept the alert
	 * @param dr
	 */
	public void acceptAlert(WebDriver dr)
	{
		dr.switchTo().alert().accept();
	}
	
	/**
	 * This method will dismiss the alert
	 * @param dr
	 */
	public void dismissAlert(WebDriver dr)
	{
		dr.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will capture the text from Alert popup
	 * @param dr
	 * @return
	 */
	public String getAlertText(WebDriver dr)
	{
		return dr.switchTo().alert().getText();
	}
	
	/**
	 * This method will handle frame based on index
	 * @param dr
	 * @param index
	 */
	public void handleFrame(WebDriver dr, int index)
	{
		dr.switchTo().frame(index);
	}
	
	/**
	 * This method will handle frame based on name or ID
	 * @param dr
	 * @param nameOrId
	 */
	public void handleFrame(WebDriver dr, String nameOrId)
	{
		dr.switchTo().frame(nameOrId);
	}
	
	/**
	 * This method will handle frame based on web element
	 * @param dr
	 * @param element
	 */
	public void handleFrame(WebDriver dr, WebElement element)
	{
		dr.switchTo().frame(element);
	}
	
	/**
	 * This method will switch to immediate parent frame
	 * @param dr
	 */
	public void switchToParentFrame(WebDriver dr)
	{
		dr.switchTo().parentFrame();
	}
	
	/**
	 * This method will switch to default frame
	 * @param dr
	 */
	public void switchToDefaultFrame(WebDriver dr)
	{
		dr.switchTo().defaultContent();
	}
	/**
	 * This method is to switch from parent window to any of the child windows
	 * @param dr
	 * @param partialTitle
	 */
	public void switchToWindow(WebDriver dr, String partialTitle)
	{
		//step1 : Capture all window Id's
		Set<String> winId = dr.getWindowHandles();
		//step2 : Navigate to each windown
		for(String win:winId)
		{
			//step3 : switch to window and capture title
			String wintitle = dr.switchTo().window(win).getTitle();
			//step4 : compare the window title with the partial title given by user
			if(wintitle.contains(partialTitle))
			{
				break;
			}
		}
	}
	/**
	 * This method is to take the screenshot and store in a folder
	 * @param dr
	 * @param screenshotName
	 * @return
	 * @throws Exception
	 */
	public String takeScreenshoot(WebDriver dr, String screenshotName) throws Exception
	{
		TakesScreenshot ss = (TakesScreenshot) dr;
		File src = ss.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\Screenshot\\"+screenshotName+".png");
		FileUtils.copyFile(src, dst);
		return dst.getAbsolutePath();//user for extent reports
	}
	/**
	 * This method is to scroll down the web page randomly
	 * @param dr
	 */
	public void scrollAction(WebDriver dr)
	{
		JavascriptExecutor js = (JavascriptExecutor) dr;
		js.executeScript("window.scrollBy(0,500)", "");
	}
	/**
	 * This method is to scroll down the web page until the particular element found
	 * @param dr
	 * @param element
	 */
	public void scrollAction(WebDriver dr, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) dr;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
	}
}
