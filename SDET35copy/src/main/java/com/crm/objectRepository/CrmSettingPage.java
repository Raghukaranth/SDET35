package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CrmSettingPage {
//declaration
	@FindBy(xpath = "//img[@alt=\"Groups\"]")
	private WebElement groupImage;
	
//initialization	
	public CrmSettingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getGroupImage() {
		return groupImage;
	}	
	
	public void clickOnGroupImg() {
		groupImage.click();
	}
}
