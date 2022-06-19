package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPopUp {
	@FindBy(xpath = "//input[@name=\"Send\"]") private WebElement emailSendBtn;
	@FindBy(name = "subject") private WebElement subjectTxtArea;
	
	public ContactPopUp(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getEmailSendBtn() {
		return emailSendBtn;
	}
	
	public void enterIntoSubjectTxt() {
		subjectTxtArea.sendKeys("you leave for the day");
	}
	
	public void clickOnSendBtn() {
		emailSendBtn.click();
	}
}
