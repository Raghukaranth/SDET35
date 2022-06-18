package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * organization creation page
 * @author Raghavendra
 *
 */
public class OrganizationInfoPage {
	//declaration
	@FindBy(id = "dtlview_Organization Name") private WebElement nameOfOrg;
	@FindBy(id = "dtlview_Industry") private WebElement nameOfInd;
	
	//initialization
	public OrganizationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//business libraries
	public WebElement getNameOfOrg() {
		return nameOfOrg;
	}
	
	public WebElement getNameOfInd() {
		return nameOfInd;
	}

	/**
	 * get the organization name 
	 * @return
	 */
	public String getOrgName() {
		return nameOfOrg.getText();
	}
	
	/**
	 * get the organization industry
	 * @return
	 */
	public String getIndName() {
		return nameOfInd.getText();
	}
}
