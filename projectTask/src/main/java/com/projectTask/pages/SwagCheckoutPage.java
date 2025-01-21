package com.projectTask.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.projectTask.utile.CommonActions;

public class SwagCheckoutPage extends CommonActions {

	WebDriver driver;
	
	public SwagCheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	@FindBy(id = "first-name")
	private WebElement firstNameTextbox;
	
	@FindBy(id = "last-name")
	private WebElement lastNameTextbox;
	
	@FindBy(id = "postal-code")
	private WebElement postalCodeTextbox;
	
	@FindBy(name = "continue")
	private WebElement continueBtn;
	
	@FindBy(xpath = "//div[@class='summary_info']")
	private WebElement summaryInfo;
	
	@FindBy(xpath = "//h2")
	private WebElement orderConfirm;
	
	@FindBy(name = "finish")
	private WebElement finishBtn;
	
	public void enterPersonalDetails() {
		writeTextinTextbox(driver, firstNameTextbox, getPropertyFileValue("name"));
		writeTextinTextbox(driver, lastNameTextbox, getPropertyFileValue("name"));
		writeTextinTextbox(driver, postalCodeTextbox, getPropertyFileValue("code"));
		clickButton(driver, continueBtn);
	}
	
	public void getOrderConfirmDetails() {
		System.out.println("Payment Information: ");
		List<WebElement> info = driver.findElements(By.xpath("//div[text()='Payment Information:']//following::div"));
		for(int i=0; i<=info.size()-3; i++) {
			System.out.println(info.get(i).getText());
		}
		clickButton(driver, finishBtn);
		System.out.println(orderConfirm.getText());
	}
	
}
