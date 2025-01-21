package utilities;

import java.io.FileReader;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CommonActions {
	
	public String readValueFromPropertiesFile(String filePath, String valueOf) {
		String value = null;
		try {
			Properties prob = new Properties();
			FileReader readFile = new FileReader(System.getProperty("user.dir")+filePath);
			prob.load(readFile);
			value = prob.getProperty(valueOf);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
	public void scrollToPageBottom(WebDriver driver, WebElement footerElement) {
		try {
			Actions action = new Actions(driver);
			action.scrollToElement(footerElement).perform();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void OpenURL(WebDriver driver,String url) {
		try {
			driver.get(url);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void alertAccept(WebDriver driver) {
		try {
			driver.switchTo().alert().accept();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
