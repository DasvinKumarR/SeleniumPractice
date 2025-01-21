package com.projectTask.utile;

import java.io.FileInputStream;


import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.Random;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CommonActions {
	
	String title;
	String text;
	boolean flag;
	
	//get values from property file
	public String getPropertyFileValue(String text) {
		Properties prob = new Properties();
		FileInputStream file;
		try {
			file = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/com/projectTask/propertyFile/BaseFile.properties");
			prob.load(file);
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		String value = prob.getProperty(text);
		return value;
	}
	
	//get pages title
	public String getPagesTitle(WebDriver driver) {
		try {
			title = driver.getTitle();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return title;
	}
	
	//validate text
	public String getElementText(WebDriver driver, WebElement ele) {
		try {
			text = ele.getText();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return text;
	}
	
	//Open mentioned sites
	public void OpenSite(WebDriver driver, String url) {
		try {
			driver.get(url);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//scroll element into view
	public void scrollElementIntoView(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).click().perform();
		
	}
	
	//click button
	public void clickButton(WebDriver driver, WebElement ele) {
		try {
			ele.click();
		}catch (NoSuchElementException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void writeTextinTextbox(WebDriver driver, WebElement ele, String text) {
		try {
			ele.sendKeys(text);
		}catch (NoSuchElementException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void selectOptionByText(WebDriver driver, WebElement ele, String text) {
		try {
			Select dropdown = new Select(ele);
			dropdown.selectByVisibleText(text);
		}catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}
	
	//get current date time
	public String getCurrentDateTime() {
		DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
		LocalDateTime now = LocalDateTime.now();
		String currentDateTime = dft.format(now);
		return currentDateTime;
	}
	
	//generate random strings
	public int generateRandomNumber() {
		Random ran = new Random();
		int RandomNumber = ran.nextInt(20000);
		return RandomNumber;
	}
	
	//check for element
	public boolean checkElement(WebDriver driver, WebElement ele) {
		try {
			if(ele.isDisplayed()) {
				flag = true;
			}
		}catch (NoSuchElementException e) {
			System.out.println("Registeration Failed...");
		}
		return flag;
	}

}
