package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
	public WebDriver driver;

	// Constructor to be used by test cases
	public loginPage(WebDriver driver) {
		// Represent local driver object, will now act as test case driver
		this.driver = driver;
	}

	// Page object model
	By emailUser = By.xpath("//input[@id='user_email']");
	By passwordUser = By.xpath("//input[@id='user_password']");
	By submitBtn = By.xpath("//input[@type='submit']");
	By forgotPassord = By.xpath("//a[@class='link-below-button']");

	public WebElement EmailInput() {
		return driver.findElement(emailUser);
	}

	public WebElement PasswordInput() {
		return driver.findElement(passwordUser);
	}

	public WebElement SubmitClick() {
		return driver.findElement(submitBtn);
	}

	public forgotPage ForgotPassword() {
		driver.findElement(forgotPassord).click();
		return new forgotPage(driver);
	}
}
