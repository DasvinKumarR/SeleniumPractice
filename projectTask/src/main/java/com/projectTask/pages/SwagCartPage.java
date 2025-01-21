package com.projectTask.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.projectTask.utile.CommonActions;

public class SwagCartPage extends CommonActions {

	WebDriver driver;
	
	public SwagCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	@FindBy(xpath = "//div[@class='inventory_item_desc']")
	private WebElement productDescription;
	
	@FindBy(xpath = "//div[@class='inventory_item_price']")
	private WebElement productPrice;
	
	@FindBy(name = "checkout")
	private WebElement checkoutBtn;
	
	public void printProductDescPrice() {
		System.out.println("Product Description: "+productDescription.getText());
		System.out.println("Product Price: "+productPrice.getText());
	}
	
	public void clickCheckoutBtn() {
		clickButton(driver, checkoutBtn);
	}
	
}
