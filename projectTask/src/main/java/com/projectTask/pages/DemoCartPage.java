package com.projectTask.pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.projectTask.utile.CommonActions;

public class DemoCartPage extends CommonActions {
	
	WebDriver driver;
	
	public DemoCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@FindBy(xpath = "//a[text()='Register']")
	private WebElement registerButton;
	
	@FindBy(xpath = "//input[@id='gender-male']")
	private WebElement MaleRadioBtn;
	
	@FindBy(xpath = "//input[@id='gender-female']")
	private WebElement femaleRadioBtn;
	
	@FindBy(id = "FirstName")
	private WebElement FirstNameTextbox;
	
	@FindBy(id = "LastName")
	private WebElement LastNameText;
	
	@FindBy(id = "Email")
	private WebElement emailTextbox;
	
	@FindBy(id = "Password")
	private WebElement passwordTextbox;
	
	@FindBy(id = "ConfirmPassword")
	private WebElement confirmPasswordTextbox;
	
	@FindBy(id = "register-button")
	private WebElement registerBtn;
	
	@FindBy(xpath = "//span[@class = 'field-validation-error']")
	private WebElement error;
	
	@FindBy(xpath = "//div[@class = 'result']")
	private WebElement resultText;
	
	@FindBy(xpath = "(//a[@class = 'account'])[1]")
	private WebElement loginMailUpdated;
	
	@FindBy(xpath = "//a[text() = 'Log out']")
	private WebElement logoutBtn;
	
	public void launchUrl() {
		String url = getPropertyFileValue("DemoCartLink");
		OpenSite(driver, url);
	}
	
	public void findNoOfLinksAndItsNames() {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Number of Links & Names: ");
		System.out.println("Total Links: "+links.size());
		for(int i=0; i<links.size(); i++) {
			String text = links.get(i).getText();
			if(text.length()<=0) {
				System.out.println((i+1)+" "+"No text binded with this link to display...");
			}else {
				System.out.println((i+1)+" "+links.get(i).getText());
			}
			
		}
	}
	
	public void clickRegisterationBtn() {
		clickButton(driver, registerButton);
	}
	
	public void enterRegisterationDetails(String gender, String firstName, String lastName, String password, String confirmPassword) {
		int num = generateRandomNumber();
		String email = Integer.toString(num)+"@gmail.com";
		if(gender.equalsIgnoreCase("male")) {
			clickButton(driver, MaleRadioBtn);
		}else if(gender.equalsIgnoreCase("female")) {
			clickButton(driver, femaleRadioBtn);
		}else {
			System.out.println("No Gender selected...");
		}
		writeTextinTextbox(driver, FirstNameTextbox, firstName);
		writeTextinTextbox(driver, LastNameText, lastName);
		writeTextinTextbox(driver, emailTextbox, email);
		writeTextinTextbox(driver, passwordTextbox, password);
		writeTextinTextbox(driver, confirmPasswordTextbox, confirmPassword);
		clickButton(driver, registerBtn);
		
		try {
			if(resultText.isDisplayed()) {
				System.out.println(resultText.getText());
				//Validate Mail Id
				WebElement mailValidate = driver.findElement(By.xpath("//a[text() = '"+email+"']"));
				mailValidate.isDisplayed();
				clickButton(driver, logoutBtn);
			}
		}catch (NoSuchElementException e) {
			System.out.println("Registeration Failed...");
		}
		
		try {
			if(error.isDisplayed()) {
				List<WebElement> errors = driver.findElements(By.xpath("//span[@class = 'field-validation-error']"));
				for(int i=0; i<errors.size(); i++) {
					System.out.println(errors.get(i).getText());
				}
			}
		}catch (NoSuchElementException e) {
			System.out.println("Registeration Success...");
		}
	
	}

}
