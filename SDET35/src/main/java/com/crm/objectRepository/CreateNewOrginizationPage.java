package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericUtilities.WebDriverUtility;

public class CreateNewOrginizationPage extends WebDriverUtility{
	//declaration
	@FindBy(name = "accountname") private WebElement orgNameTxtEnt;
	
	@FindBy(name = "industry") private WebElement indDropDown;
	
	
	@FindBy(xpath = "//input[@accesskey=\"S\"]") private WebElement saveBtn;
	
	
	//initialization
	public CreateNewOrginizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//business libraries
	public WebElement getOrgNameTxtEnt() {
		return orgNameTxtEnt;
	}
	
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public WebElement getIndDropDown() {
		return indDropDown;
	}
	

//	public void setOrgNameTxtEnt(WebElement orgNameTxtEnt) {
//		OrgNameTxtEnt = orgNameTxtEnt;
//	}
	
	
	
	//utilization
	/**
	 * used to enter the organization name 
	 * @param orginizationName
	 */
	public void enterOrgInfo(String organizationName) { 
		orgNameTxtEnt.sendKeys(organizationName);
	}
	

	public void enterIndInfo(String value) {
		selectDropDown(indDropDown, value);
	}

	
	public void clickOnSaveBtn() {
		saveBtn.click();
	}
	
}
