package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	//declaration
	@FindBy(linkText = "Organizations")
	private WebElement organizationLnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactLnk;
	
	@FindBy(linkText = "More")
	private WebElement moreDropDown;
	
	@FindBy(name = "Purchase Order")
	private WebElement purchaseOrderLink;
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/mainSettings.PNG\"]")
	private WebElement settingBtn;
	
	@FindBy(linkText = "CRM Settings")
	private WebElement crmSettingBtn;
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement administratorLink;

	@FindBy(linkText = "Sign Out")
	private WebElement signoutLink;
	
	//initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//business library
	public WebElement getOrganizationLnk() {
		return organizationLnk;
	}
		
	public WebElement getContactLnk() {
		return contactLnk;
	}

	
	public WebElement getMoreDropDown() {
		return moreDropDown;
	}

	public WebElement getPurchaseOrderLink() {
		return purchaseOrderLink;
	}
	
	public WebElement getSettingBtn() {
		return settingBtn;
	}

	public WebElement getCrmSettingBtn() {
		return crmSettingBtn;
	}

	//utilization
	public void clickOnOrgLnk() {
		organizationLnk.click();
	}
	/**
	 * clicks on contact link in home page
	 */
	public void clickOnContactsLnk() {
		contactLnk.click();
	}
	
	public void moveAndClickOnPurchaseOrder(WebDriver driver) {
		moveOverAnElement(driver, moreDropDown);
		purchaseOrderLink.click();
	}
	
	public void moveToSettingBtnAndClickOnCrmSetting(WebDriver driver) {
		moveOverAnElement(driver, settingBtn);
		crmSettingBtn.click();
	}
	
	public WebElement getAdministratorLink() {
		return administratorLink;
	}
	/**
	 * used to logout from the application
	 * @param driver
	 */
	//utilization
	public void logout(WebDriver driver) {
		moveOverAnElement(driver, administratorLink);
		signoutLink.click();
	}
}
