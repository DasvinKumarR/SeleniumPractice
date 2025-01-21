package pages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.CommonActions;

public class ChromePage {
	
	WebDriver driver;
	
	CommonActions ca = new CommonActions();
	
	public ChromePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
	}
	
	@FindBy(name = "q")
	private WebElement searchTextbox;
	
	@FindBy(xpath = "//div[@class='site-info']")
	private WebElement pageFooter;
	
	@FindBy(id = "alertexamples")
	private WebElement alertBtn;
	
	public void searchThis(String searchText) {
		searchTextbox.sendKeys(searchText);
		searchTextbox.sendKeys(Keys.RETURN);
	}
	
	public void scrollToBottomOfPage() {
		ca.scrollToPageBottom(driver, pageFooter);
	}
	
	public void simpleAlertAccept(){
		alertBtn.click();
		ca.alertAccept(driver);
	}
	
	public void alertDismiss() {
		
	}
	
	

}
