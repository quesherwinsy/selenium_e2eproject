package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class forgotPage {
	public WebDriver driver;

	// Constructor to be used by test cases
	public forgotPage(WebDriver driver) {
		// Represent local driver object, will now act as test case driver
		this.driver = driver;
	}

	// Page object model
	By emailUser = By.xpath("//input[@id='user_email']");
	By sendMeBtn = By.xpath("//input[@type='submit']");

	public WebElement EmailInput() {
		return driver.findElement(emailUser);
	}

	public WebElement SubmitClick() {
		return driver.findElement(sendMeBtn);
	}
}
