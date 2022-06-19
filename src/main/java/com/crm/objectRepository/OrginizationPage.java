package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrginizationPage {
	//declaration
	@FindBy(xpath = "//img[@title=\"Create Organization...\"]") 
	private WebElement createOrgLokUpBtn;
	
	
	
	
	//initialization
	public OrginizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getCreateOrgLokUpBtn() {
		return createOrgLokUpBtn;
	}
	
	
	
	

	//business library
	public void clickOnCreateOrgLokUp() {
		createOrgLokUpBtn.click();
	}
	
	
}
