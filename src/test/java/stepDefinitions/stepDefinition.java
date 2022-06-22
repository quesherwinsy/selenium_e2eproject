package stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import pageObjects.SccLoginPage;
import pageObjects.SccMainPage;
import pageObjects.guru99PageFactory;
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

	@When("^User enters (.+) and (.+) and logs in SCC admin$")
	public void user_enters_something_and_something_and_logs_in_scc_admin(String strArg1, String strArg2)
			throws Throwable {
		SccLoginPage logp = new SccLoginPage(driver);
		// Login page
		logp.IdInput().sendKeys(strArg1);
		logp.SecretInput().sendKeys(strArg2);

		Thread.sleep(3000);
		logp.LoginClick().click();
	}

	@Then("^Verify user successfully logged in$")
	public void verify_user_successfully_logged_in() throws Throwable {
		System.out.println("Verify user successfully logged in");
	}

	@And("^Close browser$")
	public void close_browser() throws Throwable {
		driver.close();
	}

	@Then("^Verify (.+) if existing$")
	public void verify_client_id_if_exist(String strArg1) throws InterruptedException {
		SccMainPage logp = new SccMainPage(driver);

		logp.InputDateCreate().sendKeys("5/10/2022");

		logp.DropdownClientType().click();
		Thread.sleep(3000);
		System.out.println("size is " + logp.GetClientType().size());
		for (int i = 0; i < logp.GetClientType().size(); i++) {
			System.out.println("Now in " + logp.GetClientType().get(i).getText());
			if (logp.GetClientType().get(i).getText().equalsIgnoreCase(strArg1)) {
				// option.click();
				System.out.println("Hello " + logp.GetClientType().get(i).getText());
				logp.GetClientType().get(i).click();
				break;
			}
		}
	}

	@Then("^Verify if logo profile and configuration module exist$")
	public void verify_if_logo_profile_and_configuration_module_exist() throws Throwable {
		SccMainPage logp = new SccMainPage(driver);
		Thread.sleep(3000);
		ExpectedConditions.elementToBeClickable(logp.configurationLink());
		ExpectedConditions.elementToBeClickable(logp.profilesLink());
		Assert.assertEquals(logp.mainLogo().isDisplayed(), true);
	}

	@And("^Verify if Password is (.+)$")
	public void verify_if_password_is(String visible) throws Throwable {
		SccLoginPage logp = new SccLoginPage(driver);
		Thread.sleep(3000);
		logp.HideBtn().click();
	}

	@When("^User inputs (.+) and (.+) in SCC admin$")
	public void user_enters_and_in_scc_admin(String username, String password) throws Throwable {
		SccLoginPage logp = new SccLoginPage(driver);
		// Login page
		if (!username.equalsIgnoreCase("empty")) {
			logp.IdInput().sendKeys(username);
		}
		if (!password.equalsIgnoreCase("empty")) {
			logp.SecretInput().sendKeys(password);
		}
		Thread.sleep(2000);
	}

	@Then("^Verify login error (.+)$")
	public void verify_login_error(String message) throws Throwable {
		SccLoginPage logp = new SccLoginPage(driver);
		Thread.sleep(3000);
		Assert.assertEquals(logp.DisplayMessage().getText(), message);
	}

	@Then("^Verify if login button is disabled$")
	public void verify_if_login_button_is_disabled() throws Throwable {
		SccLoginPage logp = new SccLoginPage(driver);
		Assert.assertEquals(logp.LoginClick().isEnabled(), false);
	}

	@Then("^Verify if user logout sucessful$")
	public void verify_if_user_logout_sucessful() throws Throwable {
		SccMainPage logp = new SccMainPage(driver);
		Thread.sleep(2000);
		logp.UserInfo().click();
		Thread.sleep(2000);
		logp.LogoutBtn().click();
		Thread.sleep(2000);
		logp.SignOutBtn().click();
		Thread.sleep(2000);
	}

	@And("^Test Guru99 fields and iframe$")
	public void test_guru99_fields_and_iframe() throws Throwable, AssertionError {
		// Guru99 page factory
		guru99PageFactory g99 = new guru99PageFactory(driver);
		g99.emailField().sendKeys("rahulshetty");
		
		Thread.sleep(2000);
		driver.switchTo().frame(g99.frame1());
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		//g99.frameLink().click();
		
		g99.submitBtn().click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.switchTo().alert().getText().toString(), "Form Submitted Successfully...");
		driver.switchTo().alert().accept();
		
	}
}
