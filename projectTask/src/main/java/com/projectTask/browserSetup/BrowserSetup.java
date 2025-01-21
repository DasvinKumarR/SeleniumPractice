package com.projectTask.browserSetup;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserSetup {
	
	protected WebDriver driver;
	
	public void initiateBrowser(){
		Properties prob = new Properties();
		FileReader file;
		try {
			file = new FileReader(System.getProperty("user.dir")+"/src/test/resources/com/projectTask/propertyFile/BaseFile.properties");
			prob.load(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		switch (prob.getProperty("browser")) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(option);
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions FireOption = new FirefoxOptions();
			FireOption.addArguments("--remote-allow-origins=*");
			driver = new FirefoxDriver(FireOption);
			break;
		default:
			System.out.println("Select valid driver...");
			break;
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

}
