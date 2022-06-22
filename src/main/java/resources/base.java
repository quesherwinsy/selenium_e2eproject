package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class base {
	public WebDriver driver;
	public Properties prop;

	// 1500 test case run sample
	public WebDriver initializeDriver() throws IOException {

		// Guide to read and write external property file
		// Instantiate properties object
		prop = new Properties();
		// Set read properties file location
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
		// Load properties file to read mode
		prop.load(fis);

		// mvn test -Dbrowser=chrome -P RegressionTest
		// Jenkin-MVN use check property of browser
		String browserName = System.getProperty("browser");

		// Get value of browser
		// String browserName = prop.getProperty("browser");

		// NOTE: use with Cucumber run via Eclipse IDE only
		browserName = "chrome";

		if (browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");
			// Chrome option object to make browser headless mode
			ChromeOptions coptions = new ChromeOptions();
			coptions.addArguments("--ignore-ssl-errors=yes");
			coptions.addArguments("--ignore-certificate-errors");
			if (browserName.contains("headless")) {
				coptions.addArguments("headless");
			}
			// webdriver.chrome.driver invoking browser, chrome browser
			driver = new ChromeDriver(coptions);
		} else {
			System.out.println("error webdriver undefined.");
		}

		// implicit wait 5 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}

	// Method for creating sreenshot image
	public String getSreenshotPath(String testCaseName, WebDriver driver) throws IOException {
		// Selenium take screenshot
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// Set filename and destination of screenshot
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}
}
