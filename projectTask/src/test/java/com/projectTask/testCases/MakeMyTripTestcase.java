package com.projectTask.testCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.projectTask.browserSetup.BrowserSetup;
import com.projectTask.pages.MakeMyTripPage;

public class MakeMyTripTestcase extends BrowserSetup {
	
	@BeforeClass
	public void startUp() {
		initiateBrowser();
	}
	
	@Test
	public void MakeMyTripTest() {
		MakeMyTripPage MMTP = new MakeMyTripPage(driver);
		//open make my trip site
		MMTP.launchMakeMyTripSite();
		//get page titlename and title length
		MMTP.getPageTitleTextAndLength();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
