package academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.forgotPage;
import pageObjects.landingPage;
import pageObjects.loginPage;
import resources.base;

public class homepage extends base {
	public WebDriver driver;

	// log4j initialize log object
	public static Logger log = LogManager.getLogger(homepage.class.getName());

	@BeforeTest
	public void initiateBrowser() throws IOException, InterruptedException {
		driver = initializeDriver();

	}

	// Use getData method for parameter
	@Test(dataProvider = "getData")
	public void basePageNavigation(String uname, String pword, String msg) throws InterruptedException, IOException {
		// maximize the window screen
		driver.manage().window().maximize();
		// webdriver go to URL
		driver.get(prop.getProperty("url"));
		// thread sleep
		Thread.sleep(3000);

		// Landing page
		landingPage lp = new landingPage(driver);
		loginPage logp = lp.LogIn();

		// Login page
		logp.EmailInput().sendKeys(uname);
		logp.PasswordInput().sendKeys(pword);
		log.info(msg);
		Thread.sleep(3000);
		logp.SubmitClick().click();
		Thread.sleep(3000);
		forgotPage fp = logp.ForgotPassword();

		// Forgot email page
		fp.EmailInput().sendKeys("xxx");
		fp.SubmitClick().click();
	}

	@AfterTest
	public void endTest() {
		driver.close();
	}

	// Provides data and parameter use for test case
	@DataProvider
	public Object[][] getData() {
		// create 2 test case with 3 parameter
		Object[][] data = new Object[2][3];
		data[0][0] = "nonrestricteduser@gw.com";
		data[0][1] = "123456";
		data[0][2] = "Unrestricted";

		data[1][0] = "restricteduser@gw.com";
		data[1][1] = "123456";
		data[1][2] = "Restricted";
		return data;
	}
}
