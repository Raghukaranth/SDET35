package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewPurchaseOrderPage {
	//declatarion
	@FindBy(name = "bill_street") private WebElement billSheet;

	//initialization
	public NewPurchaseOrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getBillSheet() {
		return billSheet;
	}
	
	//business libraries
	public void enterDetailsToBillSheet(String address) {
		billSheet.sendKeys(address);
	}
	
}
