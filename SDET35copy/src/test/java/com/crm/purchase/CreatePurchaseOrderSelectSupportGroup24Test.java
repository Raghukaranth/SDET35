package com.crm.purchase;

import org.testng.annotations.Test;

import com.crm.comcast.genericUtilities.BaseClass;
import com.crm.objectRepository.CrmSettingPage;
import com.crm.objectRepository.GroupsPage;
import com.crm.objectRepository.HomePage;

public class CreatePurchaseOrderSelectSupportGroup24Test extends BaseClass{
	@Test
	public void createPurchaseOrderSelectSupportGroupTest() throws Throwable {
		
		HomePage homePage = new HomePage(driver);
		homePage.moveToSettingBtnAndClickOnCrmSetting(driver);
		
		CrmSettingPage crmSeting = new CrmSettingPage(driver);
		crmSeting.clickOnGroupImg();
		
		
		GroupsPage grpsPage = new GroupsPage(driver);
		grpsPage.clickOnSupportGroup();
		
		String title = driver.getTitle();
		if(title.equals(driver.getTitle()))
			System.out.println("pass");
		else System.out.println("fail");


		fLib.closePropFiles();
	}
}
