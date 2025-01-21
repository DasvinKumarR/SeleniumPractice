package com.projectTask.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.projectTask.utile.CommonActions;

public class SwagHomePage extends CommonActions {
	
	WebDriver driver;
	String productName;
	
	public SwagHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	
	@FindBy(xpath = "//select[contains(@class,'product_sort_container')]")
	private WebElement sortDropdown;
	
	@FindBy(xpath = "(//div[@class='inventory_item_description']//a)[6]")
	private WebElement selectFirstProductOption;
	
	@FindBy(name = "add-to-cart")
	private WebElement addToCartBtn;
	
	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	private WebElement cartLink;
	
	public void sortPrice() {
		selectOptionByText(driver, sortDropdown, "Price (high to low)");
	}
	
	public void selectRandomProduct() {
		productName = selectFirstProductOption.getText();
		System.out.println("Selected Product Name: "+ productName + " is selected.");
		scrollElementIntoView(driver, selectFirstProductOption);
	}
	
	public void clickAddToCart() {
		clickButton(driver, addToCartBtn);
		WebElement cartProductName = driver.findElement(By.xpath("//div[text()='"+productName+"']"));
		if(cartProductName.isDisplayed()) {
			System.out.println("Item Added to cart...");
		}else {
			System.out.println("Item Not added to cart..");
		}
	}
	
	public void clickCartLink() {
		wait.until(ExpectedConditions.visibilityOf(cartLink));
		clickButton(driver, cartLink);
	}

}
