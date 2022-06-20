package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	@FindBy(id = "dtlview_First Name") private WebElement pageFirstName;
	@FindBy(id = "dtlview_Last Name") private WebElement pageLastName;
	@FindBy(xpath = "//span[@class=\"dvHeaderText\"]") private WebElement pageHeader;
	
	
	public ContactInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getPageFirstName() {
		return pageFirstName;
	}
	public WebElement getPageLastName() {
		return pageLastName;
	}
	public WebElement getPageHeader() {
		return pageHeader;
	}
	
	public String getFirstName() {
		return pageFirstName.getText();
	}
	
	public String getLastName() {
		return pageLastName.getText();
	}

	
	
}
