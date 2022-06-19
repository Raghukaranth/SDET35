package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericUtilities.FileUtility;

public class LoginPage extends FileUtility {
	//declaration
	@FindBy(name = "user_name")
	private WebElement usernameTxtEdt;

	@FindBy(name = "user_password")
	private WebElement passwordTxtEdt;

	@FindBy(id = "submitButton")
	private WebElement loginBtn;

	//initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getUsernameTxtEdt() {
		return usernameTxtEdt;
	}

	public WebElement getPasswordTxtEdt() {
		return passwordTxtEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	//business Libraries
	/**
	 * this is method is used to loging in to the application
	 * @param username
	 * @param password
	 * @throws Throwable
	 */
	public void loginToAppication(String username, String password) throws Throwable {
		usernameTxtEdt.sendKeys(username);
		passwordTxtEdt.sendKeys(password);
		loginBtn.submit();
	}
}
