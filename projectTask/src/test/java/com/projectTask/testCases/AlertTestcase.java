package com.projectTask.testCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.projectTask.browserSetup.BrowserSetup;
import com.projectTask.pages.AlertPage;

public class AlertTestcase extends BrowserSetup {
	
	@BeforeClass
	public void startUp() {
		initiateBrowser();
	}
	
	@Test
	public void alertCases() {
		AlertPage ATP = new AlertPage(driver);
		ATP.launchSite();
		ATP.clickAndAcceptalertOne();
		ATP.clickAndDismissAlert();
		ATP.clickAndAcceptPromptAlert();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
