package com.projectTask.pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.projectTask.utile.CommonActions;

public class MakeMyTripPage extends CommonActions {
	
	WebDriver driver;
	
	public MakeMyTripPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	public void launchMakeMyTripSite() {
		String url = getPropertyFileValue("makeMyTripURL");
		OpenSite(driver, url);
	}
	
	public void getPageTitleTextAndLength() {
		String title = getPagesTitle(driver);
		String subString = title.replaceAll("\\s", "");
		int titleLength = subString.length();
		System.out.println("Page Title: "+title);
		System.out.println("Title Length without removing whitespace: "+ title.length());
		System.out.println("Title Length after removing whitespace: "+titleLength);
	}

}
