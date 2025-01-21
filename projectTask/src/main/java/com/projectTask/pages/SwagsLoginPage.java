package com.projectTask.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.projectTask.utile.CommonActions;

public class SwagsLoginPage extends CommonActions {
	
	WebDriver driver;
	
	public SwagsLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	@FindBy(id = "user-name")
	private WebElement usernameTextbox;
	
	@FindBy(id = "password")
	private WebElement passowrdTextbox;
	
	@FindBy(id = "login-button")
	private WebElement loginBtn;
	
	public void login(){
		String url = getPropertyFileValue("SwagURL");
		OpenSite(driver, url);
		writeTextinTextbox(driver, usernameTextbox, getPropertyFileValue("userName"));
		writeTextinTextbox(driver, passowrdTextbox, getPropertyFileValue("password"));
		clickButton(driver, loginBtn);
	}
}
