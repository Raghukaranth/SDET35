package com.crm.purchase;

import org.testng.annotations.Test;

import com.crm.comcast.genericUtilities.BaseClass;
import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.NewPurchaseOrderPage;
import com.crm.objectRepository.PurchasePage;

public class CreatePurchaseOrderSelectBillingAddress26Test extends BaseClass{
	@Test
	public void createPurchaseOrderSelectBillingAddressTest() throws Throwable {
		
				
		HomePage homePage = new HomePage(driver);
		homePage.moveAndClickOnPurchaseOrder(driver);
		
		PurchasePage purchasePage = new PurchasePage(driver);
		purchasePage.clickOnCreatePurchase();
	
		NewPurchaseOrderPage newPurchaseBillDetails = new NewPurchaseOrderPage(driver);
		String address = eLib.getDataFromExcelVtiger("Purchase", 37, 2);
		//String address = workbook.getSheet("Test Cases").getRow(279).getCell(2).getStringCellValue();
		newPurchaseBillDetails.enterDetailsToBillSheet(address);
		

		
		fLib.closePropFiles();
	}
}
