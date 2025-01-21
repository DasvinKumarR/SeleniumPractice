package testCases;

import org.testng.annotations.Test;
import BaseSetup.baseDriverConfig;
import pages.ChromePage;
import utilities.CommonActions;

public class PracticeCases extends baseDriverConfig {
	
	CommonActions ca = new CommonActions();
	
	@Test
	public void openGoogle() {
		ca.OpenURL(driver, "https://www.google.com");
		ChromePage pageChrome = new ChromePage(driver);
		pageChrome.searchThis("TVK");
	}
	
	@Test
	public void scrollIntoBottomOfPage() {
		ca.OpenURL(driver,"https://seleniumbase.com/");
		ChromePage pageChrome = new ChromePage(driver);
		pageChrome.scrollToBottomOfPage();
	}
	
	@Test
	public void simpleAlert() {
		ca.OpenURL(driver, "https://testpages.eviltester.com/styled/alerts/alert-test.html");
		ChromePage pageChrome = new ChromePage(driver);
		pageChrome.simpleAlertAccept();
	}

}
