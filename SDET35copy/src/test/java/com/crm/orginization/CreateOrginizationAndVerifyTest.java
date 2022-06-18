package com.crm.orginization;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.genericUtilities.BaseClass;
import com.crm.objectRepository.CreateNewOrginizationPage;
import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.OrganizationInfoPage;
import com.crm.objectRepository.OrginizationPage;

public class CreateOrginizationAndVerifyTest extends BaseClass {
	@Test(groups = {"regressionTest"}, retryAnalyzer = com.crm.comcast.genericUtilities.RetryAnalyserImtn.class)
	public void createOrginizationAndVerifyTest() throws Throwable {
		
		
		HomePage homePage = new HomePage(driver);
		homePage.clickOnOrgLnk();
		
		OrginizationPage orgPage = new OrginizationPage(driver);
		orgPage.clickOnCreateOrgLokUp();
		
		String orginization = eLib.getDataFromExcelVtiger("Orginization", 1, 2)+jLib.getRandomNumber();
		CreateNewOrginizationPage createNewOrg = new CreateNewOrginizationPage(driver);
		createNewOrg.enterOrgInfo(orginization);
		createNewOrg.clickOnSaveBtn();
		
//		//Thread.sleep(2000);
//		String orgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		
		OrganizationInfoPage orgName = new OrganizationInfoPage(driver);
		Assert.assertTrue(orginization.equals(orgName.getOrgName()));
		
		
//		if(orginization.equals(orgName))
//			System.out.println("pass");
//		else System.out.println("fail");
		
		fLib.closePropFiles();
		eLib.closeExcelFiles();
	}
}
