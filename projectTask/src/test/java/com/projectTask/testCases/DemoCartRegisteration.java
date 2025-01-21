package com.projectTask.testCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.projectTask.browserSetup.BrowserSetup;
import com.projectTask.pages.DemoCartPage;

public class DemoCartRegisteration extends BrowserSetup {

	@BeforeClass
	public void startUp() {
		initiateBrowser();
	}
	
	@Test
	//Validate success scenario for registeration by entering valid details
	public void ValidTest1() {
		DemoCartPage DCP = new DemoCartPage(driver);
		DCP.launchUrl();
		DCP.clickRegisterationBtn();
		DCP.enterRegisterationDetails("male", "test", "test", "tester", "tester");
	}
	
	@Test
	//Validate register flow only by providing mandatory fields
	public void ValidTest2() {
		DemoCartPage DCP = new DemoCartPage(driver);
		DCP.launchUrl();
		DCP.clickRegisterationBtn();
		DCP.enterRegisterationDetails("", "test", "test", "tester", "tester");
	}
	
	@Test
	//Validate success scenario for registeration by entering valid details
	public void ValidTest3() {
		DemoCartPage DCP = new DemoCartPage(driver);
		DCP.launchUrl();
		DCP.clickRegisterationBtn();
		DCP.enterRegisterationDetails("female", "test", "test", "tester", "tester");
	}
	
	@Test
	//Validate register flow if no data is given for any mandatory fields
	public void InvalidRTest1() {
		DemoCartPage DCP = new DemoCartPage(driver);
		DCP.launchUrl();
		DCP.clickRegisterationBtn();
		DCP.enterRegisterationDetails("", "", "", "", "");
	}
	
	@Test
	//validate register flow if password lenght is  less then 6 Char
	public void InvalidTest2() {
		DemoCartPage DCP = new DemoCartPage(driver);
		DCP.launchUrl();
		DCP.clickRegisterationBtn();
		DCP.enterRegisterationDetails("male", "test", "test", "test", "test");
	}
	
	@Test
	//validate register flow if password and confirmpassword mismatch
	public void InvalidTest3() {
		DemoCartPage DCP = new DemoCartPage(driver);
		DCP.launchUrl();
		DCP.clickRegisterationBtn();
		DCP.enterRegisterationDetails("male", "test", "test", "tester", "tester1");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
