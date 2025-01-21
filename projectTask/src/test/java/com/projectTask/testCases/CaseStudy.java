package com.projectTask.testCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.projectTask.browserSetup.BrowserSetup;
import com.projectTask.pages.SwagCartPage;
import com.projectTask.pages.SwagCheckoutPage;
import com.projectTask.pages.SwagHomePage;
import com.projectTask.pages.SwagsLoginPage;

public class CaseStudy extends BrowserSetup {
	
	@BeforeClass
	public void loginSwag() {
		initiateBrowser();
		SwagsLoginPage SLP = new SwagsLoginPage(driver);
		SLP.login();
	}
	
	@Test
	public void caseStudyTest() {
		SwagHomePage SHP = new SwagHomePage(driver);
		SwagCartPage CP = new SwagCartPage(driver);
		SwagCheckoutPage SCP = new SwagCheckoutPage(driver);
		SHP.sortPrice();
		SHP.selectRandomProduct();
		SHP.clickAddToCart();
		SHP.clickCartLink();
		CP.printProductDescPrice();
		CP.clickCheckoutBtn();
		SCP.enterPersonalDetails();
		SCP.getOrderConfirmDetails();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
