package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPopUp {
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement serachTextField;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchButtun;
	
	@FindBy(xpath="//a[@href=\"javascript:window.close();\"]")
	private WebElement selectProduct;
	
	public OrganizationPopUp(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	// utilization 
	public WebElement getSerachTextField() {
		return serachTextField;
	}
	public WebElement getSearchButtun()
	{
		return searchButtun;
	}
	public WebElement getSelectProduct()
	{
		return selectProduct;
	}
	
	
	
	public void PassData(String org)
	{
		serachTextField.sendKeys(org);
	}
	public void clickOnSearchButton()
	{
		searchButtun.click();
	}
	public void clickOnProduct()
	{
		selectProduct.click();
	}

}
