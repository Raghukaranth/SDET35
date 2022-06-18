package com.crm.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GroupsPage {
	//initialization
	public GroupsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//declaration
	@FindBy(linkText = "Support Group") private WebElement supportGrpLnk;
	
	@FindBy(linkText = "Team Selling") private WebElement teamSellingLnk;

	@FindBy(linkText = "Marketing Group") private WebElement marketingGrpLnk;
	
	//utilization
	public WebElement getSupportGrpLnk() {
		return supportGrpLnk;
	}
	
	public void clickOnSupportGroup() {
		supportGrpLnk.click();
	}
	
	public WebElement getTeamSellingLnk() {
		return teamSellingLnk;
	}

	public WebElement getMarketingGrpLnk() {
		return marketingGrpLnk;
	}

	public void clickOnTeamSelling() {
		teamSellingLnk.click();
	}
	
	public void clickOnMarketingGrpLnk() {
		marketingGrpLnk.click();
	}
}
