package academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.landingPage;
import resources.base;

//add log4j
//generate html report
//screenshot on failed
//jenkins integration

public class validateNavigationBar extends base {
	public WebDriver driver;
	
	// log4j initialize log object
	public static Logger log = LogManager.getLogger(validateNavigationBar.class.getName());

	@BeforeTest
	public void initiateBrowser() throws IOException, InterruptedException {
		driver = initializeDriver();
		// maximize the window screen
		driver.manage().window().maximize();
		// webdriver go to URL
		driver.get(prop.getProperty("url"));
		// thread sleep
		Thread.sleep(3000);
	}

	@Test
	public void basePageNavigation() throws InterruptedException {
		landingPage lp = new landingPage(driver);
		// Check navigation bar if visible
		Assert.assertTrue(lp.GetNavigation().isDisplayed());
		log.info("Success navigation bar displayed");
	}

	@AfterTest
	public void endTest() {
		driver.quit();
	}
}
