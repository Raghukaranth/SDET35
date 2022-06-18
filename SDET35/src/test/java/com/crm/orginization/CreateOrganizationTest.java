package com.crm.orginization;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.genericUtilities.BaseClass;
import com.crm.objectRepository.CreateNewOrginizationPage;
import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.OrganizationInfoPage;
import com.crm.objectRepository.OrginizationPage;

public class CreateOrganizationTest extends BaseClass {
	@Test
	public void createOrginizationAndVerifyTest() throws Throwable {


		HomePage homePage = new HomePage(driver);
		homePage.clickOnOrgLnk();

		OrginizationPage orgPage = new OrginizationPage(driver);
		orgPage.clickOnCreateOrgLokUp();

		String orginization = eLib.getDataFromExcelVtiger("Orginization", 1, 2)+jLib.getRandomNumber();
		CreateNewOrginizationPage createNewOrg = new CreateNewOrginizationPage(driver);
		createNewOrg.enterOrgInfo(orginization);
		createNewOrg.clickOnSaveBtn();

		//Thread.sleep(2000);
		String orgName = driver.findElement(By.id("dtlview_Organization Name")).getText();

		Assert.assertTrue(orginization.equals(orgName));


		//		if(orginization.equals(orgName))
		//			System.out.println("pass");
		//		else System.out.println("fail");

		fLib.closePropFiles();
		eLib.closeExcelFiles();
	}

	@Test
	public void createOrginizationWithIndustryAndVerifyTest() throws Throwable {

		HomePage homePage = new HomePage(driver);
		homePage.clickOnOrgLnk();


		OrginizationPage orgPage = new OrginizationPage(driver);
		orgPage.clickOnCreateOrgLokUp();


		int RandNum = jLib.getRandomNumber();
		String orginization = eLib.getDataFromExcelVtiger("Orginization", 1, 2)+RandNum;		
		CreateNewOrginizationPage createNewOrg = new CreateNewOrginizationPage(driver);


		//		driver.findElement(By.name("accountname")).sendKeys(orginization);
		//		
		//		WebElement industryDrop = driver.findElement(By.name("industry"));
		String industry = eLib.getDataFromExcelVtiger("orginization", 6, 3);

		createNewOrg.enterOrgInfo(orginization);
		createNewOrg.enterIndInfo(industry);
		createNewOrg.clickOnSaveBtn();

		//		wLib.selectDropDown(createNewOrg.getIndDropDown(), industry);
		//		
		//		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();

		Thread.sleep(2000);

		OrganizationInfoPage NameOfOrg = new OrganizationInfoPage(driver);
		OrganizationInfoPage NameofInd = new OrganizationInfoPage(driver);

		String orgName = NameOfOrg.getOrgName();
		String indust = NameofInd.getIndName();

		//		String orgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		//		String indust = driver.findElement(By.id("dtlview_Industry")).getText();

		if(orginization.contains(orgName))
			System.out.println("orginization pass");
		else System.out.println("orginization fail");

		if(indust.contains(industry))
			System.out.println("industy pass");
		else System.out.println("industry fail");

		fLib.closePropFiles();
		eLib.closeExcelFiles();
	}
}
