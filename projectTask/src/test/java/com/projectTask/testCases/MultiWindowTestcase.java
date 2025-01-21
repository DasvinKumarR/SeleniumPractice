package com.projectTask.testCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.projectTask.browserSetup.BrowserSetup;
import com.projectTask.pages.MultiWindowPage;

public class MultiWindowTestcase extends BrowserSetup {
	
	@BeforeClass
	public void startUp() {
		initiateBrowser();
	}
	
	@Test
	public void windowTest() {
		MultiWindowPage MWP = new MultiWindowPage(driver);
		MWP.launchWindowSite();
		MWP.openNewWindow();
		MWP.getWindowDetails();
		MWP.closeWindow();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
