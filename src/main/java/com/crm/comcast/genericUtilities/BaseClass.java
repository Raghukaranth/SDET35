package com.crm.comcast.genericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * Base class for vtiger project
 * @author Raghavendra
 *
 */
public class BaseClass {
	public static WebDriver sdriver;
	public WebDriver driver;
	public DataBaseUtility dLib = new DataBaseUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public FileUtility fLib = new FileUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public JavaUtility jLib = new JavaUtility();
	
	/**
	 * establishing the connection to the database
	 */
	@BeforeSuite(groups = {"smokeTest", "regressionTest"})
	public void dbConfig() {
		dLib.connectToDB();
	}
	
//	@Parameters("BROWSER")
	@BeforeClass(groups = {"smokeTest", "regressionTest"})
	public void launchingBrowser() throws Throwable {

		String BROWSER = System.getProperty("browser");
		String URL = System.getProperty("url");
		//String BROWSER = fLib.getPropertiesForVtiger("browser");
		//String URL = fLib.getPropertiesForVtiger("url");
		
		if(BROWSER.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		wLib.waitForElementInDOM(driver);
		sdriver = driver;
		sdriver.get(URL);
		driver.manage().window().maximize();
	}
	
	/**
	 * login to the application
	 * @throws Throwable
	 */
	@BeforeMethod(groups = {"smokeTest", "regressionTest"})
	public void loginToApp() throws Throwable {
		String USERNAME = fLib.getPropertiesForVtiger("username");
		String PASSWORD = fLib.getPropertiesForVtiger("password");
		
		LoginPage login = new LoginPage(driver);
		login.loginToAppication(USERNAME, PASSWORD);
	}
	/**
	 * logout from the application
	 */
	@AfterMethod(groups = {"smokeTest", "regressionTest"})
	public void logoutFromTheApp() {
		HomePage homePage = new HomePage(driver);
		homePage.logout(driver);
	}
	
	/**
	 * close the browser
	 */
	@AfterClass(groups = {"smokeTest", "regressionTest"})
	public void closeTheBrowser() {
		driver.quit();
	}
	
	/**
	 * closing the database connection
	 */
	@AfterSuite(groups = {"smokeTest", "regressionTest"})
	public void closeDB() {
		System.out.println("database connection closed");
	}
}
