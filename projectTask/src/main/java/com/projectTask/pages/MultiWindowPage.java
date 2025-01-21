package com.projectTask.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.projectTask.utile.CommonActions;

public class MultiWindowPage extends CommonActions {
	
	WebDriver driver;
	ArrayList<String> Windoows = new ArrayList<String>();
	Set<String> multiWindow;
	
	public MultiWindowPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	@FindBy(id = "windowButton")
	private WebElement newWindowButton;
	
	@FindBy(xpath = "(//iframe[contains(@id,'google_ads_iframe')])[1]")
	private WebElement Ads;
	
	@FindBy(xpath = "(//div[@id='cbb'])[1]")
	private WebElement close;
	
	public void launchWindowSite() {
		String url = getPropertyFileValue("MultiWindowURL");
		OpenSite(driver, url);
	}
	
	public void openNewWindow() {
		driver.switchTo().newWindow(WindowType.WINDOW);
	}
	
	public void getWindowDetails() {
		multiWindow = driver.getWindowHandles();
		int count = 1;
		for(String a: multiWindow) {
			System.out.println("Window Number "+count+": "+a);
			Windoows.add(a);
			count++;
		}
	}
	
	public void closeWindow() {
		driver.switchTo().window(Windoows.get(1));
		driver.close();
		driver.switchTo().window(Windoows.get(0));
	}

}
