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

public class validateTitle extends base {
	public WebDriver driver;
	landingPage lp;
	// log4j initialize log object
	public static Logger log = LogManager.getLogger(validateTitle.class.getName());

	@BeforeTest
	public void initiateBrowser() throws IOException, InterruptedException {
		driver = initializeDriver();
		log.info("Driver initialized");
		// maximize the window screen
		driver.manage().window().maximize();
		// webdriver go to URL
		driver.get(prop.getProperty("url"));
		log.info("Navigate to home page");
		// thread sleep
		Thread.sleep(3000);
	}

	@Test
	public void validateAppTitle() throws InterruptedException {
		lp = new landingPage(driver);
		// Compare text from browser with actual text
		Assert.assertEquals(lp.GetTitle().getText(), "FEATURED COURSES");
		log.info("Success validate text message");
	}

	@Test
	public void validateHeader() throws InterruptedException {
		// Compare text from header title with actual text
		Assert.assertEquals(lp.GetHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		log.info("Success validate header text");
	}

	@AfterTest
	public void endTest() {
		driver.quit();
	}
}
