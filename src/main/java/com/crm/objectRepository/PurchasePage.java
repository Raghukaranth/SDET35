package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchasePage {
	//declaration
	@FindBy(xpath = "//img[@title=\"Create Purchase Order...\"]")
	private WebElement createPurchaseLokUpBtn;
	
	//initialization
	public PurchasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//business libraries
	public WebElement getCreatePurchaseLokUpBtn() {
		return createPurchaseLokUpBtn;
	}
		
	
	public void clickOnCreatePurchase() {
		createPurchaseLokUpBtn.click();
	}
}
