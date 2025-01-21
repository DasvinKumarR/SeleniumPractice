package com.projectTask.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.projectTask.utile.CommonActions;

public class SeleniumPage extends CommonActions {
	
	WebDriver driver;
	
	public SeleniumPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	@FindBy(xpath = "(//h4[text()='Selenium WebDriver'])//following::p[2]")
	private WebElement paraText;
	
	public void launchSeleniumSite() {
		String url = getPropertyFileValue("seleniumURL");
		OpenSite(driver, url);
	}
	
	public String expectedParagraph() {
		String ExpectedText = getPropertyFileValue("paragraph");
		return ExpectedText;
	}
	
	public String actualParagraph() {
		String ActualText = getElementText(driver, paraText);
		return ActualText;
	}

}
