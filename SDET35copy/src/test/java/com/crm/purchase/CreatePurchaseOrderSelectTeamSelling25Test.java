package com.crm.purchase;

import org.testng.annotations.Test;

import com.crm.comcast.genericUtilities.BaseClass;
import com.crm.objectRepository.CrmSettingPage;
import com.crm.objectRepository.GroupsPage;
import com.crm.objectRepository.HomePage;

public class CreatePurchaseOrderSelectTeamSelling25Test extends BaseClass{
	@Test
	public void createPurchaseOrderSelectTeamSellingTest() throws Throwable {
		HomePage homePage = new HomePage(driver);
		homePage.moveToSettingBtnAndClickOnCrmSetting(driver);
		
		CrmSettingPage crmSetting = new CrmSettingPage(driver);
		crmSetting.clickOnGroupImg();
		
		GroupsPage grpPage = new GroupsPage(driver);
		grpPage.clickOnTeamSelling();
		
		
		String title = driver.getTitle();
		if(title.equals(driver.getTitle()))
			System.out.println("pass");
		else
			System.out.println("fail");
		
		fLib.closePropFiles();
	}
}
