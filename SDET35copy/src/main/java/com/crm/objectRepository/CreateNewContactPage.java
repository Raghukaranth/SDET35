package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericUtilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility {
	@FindBy(name = "salutationtype") private WebElement genderDrop;
	@FindBy(name = "firstname") private WebElement firstNameTxtEdt;
	@FindBy(name = "lastname") private WebElement lastNameTxtEdt;
	@FindBy(xpath = "//input[@name = 'account_id']/..//img[@title=\"Select\"]") private WebElement OrganizationLookupImg;
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]") private WebElement contSaveBtn;
	
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getGenderDrop() {
		return genderDrop;
	}

	public WebElement getFirstNameTxtEdt() {
		return firstNameTxtEdt;
	}

	public WebElement getLastNameTxtEdt() {
		return lastNameTxtEdt;
	}

	

	public WebElement getContSaveBtn() {
		return contSaveBtn;
	}
	
	public void createContacts(String firstname, String lastname) {
		selectDropDown(genderDrop, "Mr.");
		firstNameTxtEdt.sendKeys(firstname);
		lastNameTxtEdt.sendKeys(lastname);
	}
	public void clickOrganizationLookipImg()
	{
		OrganizationLookupImg.click();
	}
	
	public void clickOnSaveBtn() {
		contSaveBtn.click();
	}
	
}