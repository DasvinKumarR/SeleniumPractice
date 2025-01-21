package com.projectTask.testCases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.projectTask.browserSetup.BrowserSetup;
import com.projectTask.pages.SeleniumPage;

public class SeleniumTestcase extends BrowserSetup {
	
	@BeforeClass
	public void startUp() {
		initiateBrowser();
	}
	
	@Test
	public void SeleniumPageTest() {
		SeleniumPage SP = new SeleniumPage(driver);
		//open selenium site
		SP.launchSeleniumSite();
		//validate paragraph
		assertEquals(SP.actualParagraph(), SP.expectedParagraph());
		System.out.println("Paragraph Validation Success...");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
