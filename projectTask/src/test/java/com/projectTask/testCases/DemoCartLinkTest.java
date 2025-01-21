package com.projectTask.testCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.projectTask.browserSetup.BrowserSetup;
import com.projectTask.pages.DemoCartPage;

public class DemoCartLinkTest extends BrowserSetup {
	
	@BeforeClass
	public void startUp() {
		initiateBrowser();
	}
	
	@Test
	public void LinkTest() {
		DemoCartPage DCP = new DemoCartPage(driver);
		DCP.launchUrl();
		DCP.findNoOfLinksAndItsNames();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
