package com.projectTask.pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.projectTask.utile.CommonActions;

public class AlertPage extends CommonActions {
	
	WebDriver driver;
	
	public AlertPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	@FindBy(xpath = "//button[text()='Click for JS Alert']")
	private WebElement AlertOne;
	
	@FindBy(xpath = "//button[text()='Click for JS Confirm']")
	private WebElement AlertTwo;
	
	@FindBy(xpath = "//button[text()='Click for JS Prompt']")
	private WebElement AlertThree;
	
	public void launchSite() {
		String url = getPropertyFileValue("AlertURL");
		OpenSite(driver, url);
	}
	
	public void clickAndAcceptalertOne() {
		clickButton(driver, AlertOne);
		driver.switchTo().alert().accept();
		System.out.println("Alert Accepted");
	}
	
	public void clickAndDismissAlert() {
		clickButton(driver, AlertTwo);
		driver.switchTo().alert().dismiss();
		System.out.println("Alert Dismissed");
	}
	
	public void clickAndAcceptPromptAlert() {
		clickButton(driver, AlertThree);
		driver.switchTo().alert().sendKeys("Ok");
		driver.switchTo().alert().accept();
		System.out.println("Content send 'OK' and Alert Accepted");
	}
	

}
