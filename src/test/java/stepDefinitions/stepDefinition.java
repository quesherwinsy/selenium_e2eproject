package stepDefinitions;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import pageObjects.landingPage;
import pageObjects.loginPage;
import resources.base;

@RunWith(Cucumber.class)
public class stepDefinition extends base {
	public WebDriver driver;

	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
		driver = initializeDriver();
	}

	@And("^Navigate to \"([^\"]*)\" site$")
	public void navigate_to_something_site(String strArg1) throws Throwable {
		// maximize the window screen
		driver.manage().window().maximize();
		// webdriver go to URL
		driver.get(strArg1);
		// thread sleep
		Thread.sleep(3000);
	}

	@And("^Click on sign login link in home page to land on secure sign in page$")
	public void click_on_sign_login_link_in_home_page_to_land_on_secure_sign_in_page() throws Throwable {
		// Landing page
		landingPage lp = new landingPage(driver);
		if (lp.GetPopUpSize() > 0) {
			lp.GetPopUp().click();
		}
		lp.LogIn();
	}

	@When("^User enters (.+) and (.+) and logs in$")
	public void user_enters_something_and_something_and_logs_in(String strArg1, String strArg2) throws Throwable {
		loginPage logp = new loginPage(driver);
		// Login page
		logp.EmailInput().sendKeys(strArg1);
		logp.PasswordInput().sendKeys(strArg2);

		Thread.sleep(3000);
		logp.SubmitClick().click();
	}

	@Then("^Verify user successfully logged in$")
	public void verify_user_successfully_logged_in() throws Throwable {
		System.out.println("Verify user successfully logged in");
	}

	@And("^Close browser$")
	public void close_browser() throws Throwable {
		driver.close();
	}

}
