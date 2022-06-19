package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	//declaration
	@FindBy(xpath = "//img[@title=\"Create Contact...\"]")
	private WebElement createNewContactLokUpBtn;
	
	@FindBy(xpath = "//tr[@id=\"row_154\"]//input[@name=\"selected_id\"]")
	private WebElement checkBox;
	
	@FindBy(xpath = "//input[@value=\"Send Mail\"]") private WebElement sendMailBtn;
	
	@FindBy(xpath = "//input[@name=\"Select\"]") private WebElement emailSelectBtn;
	
	//initialization
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//business Libraries
	public WebElement getCreateNewContactLokUpBtn() {
		return createNewContactLokUpBtn;
	}
	/**
	 * clicks on new contact lookup button
	 */
	//utilization
	public void createNewContacts() {
		createNewContactLokUpBtn.click();
	}
	
	public void checkBoxClick() {
		checkBox.click();
	}
	
	public void clickOnSendMailBtn() {
		sendMailBtn.click();
	}
	
	public void clickOnEmailSelectBtn() {
		emailSelectBtn.click();
	}
}
