package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class guru99PageFactory {
	public WebDriver driver;

	// Constructor to be used by test cases
	public guru99PageFactory(WebDriver driver) {
		// Represent local driver object, will now act as test case driver
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Page factory
	@FindBy(id = "philadelphia-field-email")
	WebElement emailField;
	@FindBy(id = "philadelphia-field-submit")
	WebElement submitBtn;
	@FindBy(id = "awf_field-91977689")
	WebElement courseSelect;
	@FindBy(id = "a077aa5e")
	WebElement frame1;
	@FindBy(css = "a[href='http://www.guru99.com/live-selenium-project.html']")
	WebElement frameLink;

	public WebElement emailField() {
		return emailField;
	}

	public WebElement submitBtn() {
		return submitBtn;
	}

	public WebElement courseSelect() {
		return courseSelect;
	}

	public WebElement frame1() {
		return frame1;
	}

	public WebElement frameLink() {
		return frameLink;
	}
}
