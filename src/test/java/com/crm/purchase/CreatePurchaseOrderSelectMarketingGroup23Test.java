package com.crm.purchase;

import org.testng.annotations.Test;

import com.crm.comcast.genericUtilities.BaseClass;
import com.crm.objectRepository.CrmSettingPage;
import com.crm.objectRepository.GroupsPage;
import com.crm.objectRepository.HomePage;

public class CreatePurchaseOrderSelectMarketingGroup23Test extends BaseClass{
	@Test
	public void createPurchaseOrderSelectMarketingGroupTest() throws Throwable {
		//perform mouse over action on setting button and click on crm setting
		HomePage homePage = new HomePage(driver);
		homePage.moveToSettingBtnAndClickOnCrmSetting(driver);
		
		//click on groups image
		CrmSettingPage crmSetting = new CrmSettingPage(driver);
		crmSetting.clickOnGroupImg();
		
		
		GroupsPage grpPage = new GroupsPage(driver);
		grpPage.clickOnMarketingGrpLnk();

		String title = driver.getTitle();

		if(driver.getTitle().equals(title))
			System.out.println("pass");
		else System.out.println("fail");

		//logout 		
		fLib.closePropFiles();
	}
}
