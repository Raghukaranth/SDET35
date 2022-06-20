package com.crm.comcast.genericUtilities;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * contains all reusable Actions of WebDriver
 * @author Raghavendra Karanth S
 *
 */
public class WebDriverUtility {
	/**
	 * *   it's an implicitly wait  Always wait for Element in DOM document & release the control if element available 
	 * @param driver
	 */
	public void waitForElementInDOM(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	/**
	 * it will wait for js elements
	 * @param driver
	 */
	public void waitForPageToLoadForJSElent(WebDriver driver) {
		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
	}
	
	/**
	 * it will check for element to be clickable in the GUI for polling time of 500 ms
	 * @param driver
	 * @param element
	 */
	public void waitForEelementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * it will check for the title in GUI for polling time of 500 ms
	 * @param drivers
	 * @param title
	 */
	public void waitForTitleContains(WebDriver drivers, String title) {
		WebDriverWait wait = new WebDriverWait(drivers, 10);
		wait.until(ExpectedConditions.titleContains(title));
	}
	
	public void waitForElementVisiblity(WebDriver driver, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	/**
	 * hear we can change polling time from default 500 ms to any polling time
	 * @param driver
	 * @param polling_time
	 * @param element
	 */
	public void waitForElementToCustom(WebDriver driver, int polling_time, WebElement element) {
		FluentWait wait = new FluentWait(driver);
		wait.pollingEvery(polling_time, TimeUnit.SECONDS);
		wait.ignoring(Exception.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * hear we are giving custom timeouts
	 * @param element
	 * @throws InterruptedException 
	 */
	public void waitAndClick(WebElement element) throws InterruptedException {
		int count = 0;
		while(count < 10) {
			try {
				element.click();
			}catch(Exception e) {	
				Thread.sleep(1000);
				count++;
			}
		}
	}
	
	/**
	 * used to switch to any window based on window titles
	 * @param driver
	 * @param partialWindow
	 */
	public void switchToWindow(WebDriver driver, String partialWindow) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String wTle = it.next();
			driver.switchTo().window(wTle);
			String currentWindow = driver.getTitle();
			if(currentWindow.contains(partialWindow)) {
				break;
			}
		}
	}
	
	public void switchToWindowUsingForEach(WebDriver driver) {
		Set<String> allIds = driver.getWindowHandles();
		
		for (String ele : allIds) {
			driver.switchTo().window(ele);
		}
	}
	
	/**
	 * used to Switch to Frame Window based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	/**
	 * used to Switch to Frame Window based on id or name attribute
	 * @param driver
	 * @param id_attribute
	 */
	public void switchTFrame(WebDriver driver, String id_attribute) {
		driver.switchTo().frame(id_attribute);
	}
	
	/**
	 * switch from one frame to another frame using absolute_path
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	
	/**
	 * used to switch back from child window to parent window
	 * @param driver
	 */
	public void switchBackToMainPage(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	/**
	 * Used to switch to Alert window and click on OK button
	 * @param driver
	 */
	public void switchToAlertPopUpAndAccept(WebDriver driver) { 
		driver.switchTo().alert().accept();
	}
	
	/**
	 * Used to switch to Alert window & click on cancel button
	 * @param driver
	 */
	public void switchToAlertPopUpAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * used to select the value from the dropDwon  based on index
	 * @param element
	 * @param index
	 */
	public void selectDropDown(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	/**
	 * used to switch to select drop down using value
	 * @param element
	 * @param value
	 */
	public void selectDropDown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	/**
	 * it is used to switch to select dropdown using visible_text
	 * @param element
	 * @param visible_text
	 */
	public void selectDropDownVtxt(WebElement element, String visible_text) {
		Select select = new Select(element);
		select.selectByVisibleText(visible_text);
	}
	
	/**
	 * used to mouse over on an element
	 * @param driver
	 * @param element
	 */
	public void moveOverAnElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	/**
	 * used to right click on the webelement
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver , WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}
	
	/**
	 * it is used to click on enter button using keyboard actions
	 * @param driver
	 */
	public void clickOnEnterButton(WebDriver driver) {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER);
	}
	
	/**
	 * it is used to take screenshot
	 * @param driver
	 * @param screenshot
	 * @throws IOException 
	 */
	public void takeScreenShot(WebDriver driver, String screenshot) throws IOException {
		TakesScreenshot takeScreenShot = (TakesScreenshot)driver;
		File src = takeScreenShot.getScreenshotAs(OutputType.FILE);
		File dst = new File("./screenshots/"+screenshot+".png");
		Files.copy(src, dst);
	}
	
	/**
	 * used to perform scrollBar Actions
	 * @param driver
	 */
	public void scrollBarAction(WebDriver driver) {
		 JavascriptExecutor javaScript = (JavascriptExecutor)driver;
		javaScript.executeScript("window.scrollBy(0, 500)");
	}
	
	
}
