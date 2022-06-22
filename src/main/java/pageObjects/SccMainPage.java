package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SccMainPage {
	public WebDriver driver;

	// Constructor to be used by test cases
	public SccMainPage(WebDriver driver) {
		// Represent local driver object, will now act as test case driver
		this.driver = driver;
	}

	// Page object model
	By sccLogo = By.xpath("//img[@id='scc-logo']");
	By profilesLink = By.xpath("//a[normalize-space()='PROFILES']");
	By configurationLink = By.xpath("//a[normalize-space()='CONFIGURATION']");
	By userDetailBtn = By.xpath("//mat-icon[normalize-space()='person_outline']");
	By addClientBtn = By.xpath("//span[normalize-space()='+ Create']");
	By signOutBtn = By.xpath("//span[normalize-space()='Logout']");
	By logoutBtn = By.xpath("//button[normalize-space()='Logout']");
	By idField = By.xpath("//input[@placeholder='ID']");
	By nameField = By.xpath("//input[@placeholder='Name']");
	By dateCreateField = By.xpath("//input[@placeholder='Date of Creation']");
	By dateModifyField = By.xpath("//input[@placeholder='Date of Modification']");
	By clientTypeBtn = By.xpath("//div[@class='mat-form-field-infix ng-tns-c32-6']");
	By clientTypeDrop = By.xpath("//div/mat-option");

	By dataIdRow = By.xpath("//tbody/tr/td[1]");

	public WebElement mainLogo() {
		return driver.findElement(sccLogo);
	}

	public WebElement profilesLink() {
		return driver.findElement(profilesLink);
	}

	public WebElement configurationLink() {
		return driver.findElement(configurationLink);
	}

	public WebElement UserInfo() {
		return driver.findElement(userDetailBtn);
	}

	public WebElement AddClient() {
		return driver.findElement(addClientBtn);
	}

	public WebElement LogoutBtn() {
		return driver.findElement(signOutBtn);
	}
	
	public WebElement SignOutBtn() {
		return driver.findElement(logoutBtn);
	}

	public WebElement InputId() {
		return driver.findElement(idField);
	}

	public WebElement InputName() {
		return driver.findElement(nameField);
	}

	public WebElement InputDateCreate() {
		return driver.findElement(dateCreateField);
	}

	public WebElement InputDateModify() {
		return driver.findElement(dateModifyField);
	}

	public WebElement DropdownClientType() {
		return driver.findElement(clientTypeBtn);
	}

	public List<WebElement> GetClientType() {
		return driver.findElements(clientTypeDrop);
	}
}
