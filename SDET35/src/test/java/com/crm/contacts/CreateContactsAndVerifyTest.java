
package com.crm.contacts;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.genericUtilities.BaseClass;
import com.crm.objectRepository.ContactInfoPage;
import com.crm.objectRepository.ContactsPage;
import com.crm.objectRepository.CreateNewContactPage;
import com.crm.objectRepository.HomePage;

@Listeners(com.crm.comcast.genericUtilities.ItestListnerImtn.class)
public class CreateContactsAndVerifyTest extends BaseClass{
	@Test(groups = {"smokeTest"})
	public void createContactAndVerifyTest() throws Throwable {
		//hi hello
		//this is to find the random number for a test script
		int ranNum = jLib.getRandomNumber();
		
		//find and click on contacts
		HomePage homePage = new HomePage(driver);
		homePage.clickOnContactsLnk();
		
		//find and click on create contacts button
		ContactsPage contactPage = new ContactsPage(driver);
		contactPage.createNewContacts();
		
		
		
		//get the firstname from the excel
		String firstName = eLib.getDataFromExcelVtiger("Contacts", 1, 2)+ranNum;
		//get the last name from the excel
		String lastName = eLib.getDataFromExcelVtiger("Contacts", 1, 3)+ranNum;
		//find and insert first, last names and click on save button 
		CreateNewContactPage newContactPage = new CreateNewContactPage(driver);
		newContactPage.createContacts(firstName, lastName);
		newContactPage.clickOnSaveBtn();
		
		//get text from the webpage
		//Thread.sleep(2000);
		ContactInfoPage contactInfo = new ContactInfoPage(driver);
		String firstVerify = contactInfo.getFirstName();
		
		Assert.assertTrue(firstName.contains(firstVerify));
			
		fLib.closePropFiles();
		eLib.closeExcelFiles();
	}
}
