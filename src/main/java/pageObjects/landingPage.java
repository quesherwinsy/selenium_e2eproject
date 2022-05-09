package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingPage {
	public WebDriver driver;

	// Constructor to be used by test cases
	public landingPage(WebDriver driver) {
		// Represent local driver object, will now act as test case driver
		this.driver = driver;
	}

	// Page object model
	private By signIn = By.cssSelector("a[href*='sign_in']");
	private By titleText = By.cssSelector(".text-center>h2");
	private By navigationBar = By.xpath("//ul[@class='nav navbar-nav navbar-right']");
	private By headerText = By.xpath("//div[contains(@class,'video-banner')]/h3");
	private By popUp = By.xpath("//button[normalize-space()='NO THANKS']");

	public loginPage LogIn() {
		// return driver.findElement(signIn);
		driver.findElement(signIn).click();
		loginPage logp = new loginPage(driver);
		return logp;
	}

	public WebElement GetTitle() {
		return driver.findElement(titleText);
	}

	public WebElement GetNavigation() {
		System.out.println("trying to identify navigation bar");
		return driver.findElement(navigationBar);
	}

	public WebElement GetHeader() {
		return driver.findElement(headerText);
	}

	public WebElement GetPopUp() {
		return driver.findElement(popUp);
	}
	
	public int GetPopUpSize(){
		return driver.findElements(popUp).size();
	}
}
