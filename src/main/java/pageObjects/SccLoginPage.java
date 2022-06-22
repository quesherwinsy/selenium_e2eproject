package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SccLoginPage {
	public WebDriver driver;

	// Constructor to be used by test cases
	public SccLoginPage(WebDriver driver) {
		// Represent local driver object, will now act as test case driver
		this.driver = driver;
	}

	// Page object model
	By clientID = By.xpath("//input[@formcontrolname='userId']");
	By clientSecret = By.xpath("//input[@formcontrolname='password']");
	By hideBtn = By.xpath("//a[@class='ng-tns-c32-237']");
	By loginBtn = By.xpath("//button[@color='primary']");
	By textMessage = By.xpath("//p[@class='form-error-label ng-star-inserted']");

	public WebElement IdInput() {
		return driver.findElement(clientID);
	}

	public WebElement SecretInput() {
		return driver.findElement(clientSecret);
	}

	public WebElement HideBtn() {
		return driver.findElement(hideBtn);
	}

	public WebElement LoginClick() {
		return driver.findElement(loginBtn);
	}

	public WebElement DisplayMessage() {
		return driver.findElement(textMessage);
	}

}
