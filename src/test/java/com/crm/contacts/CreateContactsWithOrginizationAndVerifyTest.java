package com.crm.contacts;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.genericUtilities.BaseClass;
import com.crm.objectRepository.ContactsPage;
import com.crm.objectRepository.CreateNewContactPage;
import com.crm.objectRepository.CreateNewOrginizationPage;
import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.OrganizationInfoPage;
import com.crm.objectRepository.OrganizationPopUp;
import com.crm.objectRepository.OrginizationPage;

public class CreateContactsWithOrginizationAndVerifyTest extends BaseClass {
	@Test(groups = {"smokeTest"},retryAnalyzer = com.crm.comcast.genericUtilities.RetryAnalyserImtn.class)
	public void createContactsWithOrginizationAndVerifyTest() throws Throwable {	
		int ranNum = jLib.getRandomNumber();
		
		//click on organization Link
		HomePage homeOrgPage = new HomePage(driver);
		homeOrgPage.clickOnOrgLnk();
		
		OrginizationPage orgPage = new OrginizationPage(driver);
		orgPage.clickOnCreateOrgLokUp();
	
		String orginization = eLib.getDataFromExcelVtiger("Orginization", 1, 2)+ranNum;
		CreateNewOrginizationPage createOrg = new CreateNewOrginizationPage(driver);
		createOrg.enterOrgInfo(orginization);
		createOrg.clickOnSaveBtn();
		
		OrganizationInfoPage orgInfo = new OrganizationInfoPage(driver);
		String orgName = orgInfo.getOrgName();
		
		Assert.assertTrue(orgName.equals(orginization));
	//	Assert.fail();

		
//		if(orgName.equals(orginization))
//			System.out.println("orginization created");
//		else System.out.println("orginization not created");

		HomePage homeContactsPage = new HomePage(driver);
		homeContactsPage.clickOnContactsLnk();

		ContactsPage contactPage = new ContactsPage(driver);
		contactPage.createNewContacts();
		
		String firstname = eLib.getDataFromExcelVtiger("Contacts", 1, 2)+ranNum;
		String lastname = eLib.getDataFromExcelVtiger("Contacts", 1, 3)+ranNum;
		
		CreateNewContactPage createNewContactPage = new CreateNewContactPage(driver);
		createNewContactPage.createContacts(firstname, lastname);
		createNewContactPage.clickOrganizationLookipImg();
		String parent = driver.getWindowHandle();
		
		wLib.switchToWindowUsingForEach(driver);
		
		OrganizationPopUp orgPopUp = new OrganizationPopUp(driver);
		orgPopUp.PassData(orgName);
		orgPopUp.clickOnSearchButton();
		orgPopUp.clickOnProduct();
		
		driver.switchTo().window(parent);
		
		
		

//		Set<String> childWid = driver.getWindowHandles();
//
//		for (String ele : childWid) {
//			driver.switchTo().window(ele);
//		}

//		CreateNewOrginizationPage  contactOrg = new CreateNewOrginizationPage(driver);
//		contactOrg.clickOnOrgLnk(orginization);
//		//driver.findElement(By.linkText(orginization)).click();
//		wLib.switchBackToMainPage(driver);
////		createNewContactPage.getSaveBtn().click();
//////		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
////
////		
//		String firstName = driver.findElement(By.id("dtlview_First Name")).getText();

//		if(firstName.equals(firstname))
//			System.out.println("Contacts created");
//		else System.out.println("contacts not created");

		fLib.closePropFiles();
		eLib.closeExcelFiles();

	}
}
