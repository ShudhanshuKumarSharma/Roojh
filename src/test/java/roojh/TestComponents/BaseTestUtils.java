package roojh.TestComponents;

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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import roojh.PageObjects.SelectUserType;

public class BaseTestUtils {

	public WebDriver driver;
	public SelectUserType selectUserType;
	String browserName;

	public String takeScreenshot(String testCaseName, WebDriver driver) throws IOException {

		TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
		File source = takeScreenshot.getScreenshotAs(OutputType.FILE);

		String filePath = System.getProperty("user.dir") + File.separator + "reports" + File.separator
				+ "FailedScreenshots" + File.separator + testCaseName + ".png";
		File destination = new File(filePath);

		FileUtils.copyFile(source, destination);

		return filePath;

	}

	public WebDriver initializeDriver() throws IOException {

		File globalPropertyFile = new File(
				System.getProperty("user.dir") + "\\src\\main\\java\\roojh\\TestResource\\globalProperty.properties");
		FileInputStream inputStream = new FileInputStream(globalPropertyFile);
		Properties property = new Properties();
		property.load(inputStream);

		if (System.getProperty("browser") == null) {
			browserName = property.getProperty("browser");
		} else {
			browserName = System.getProperty("browser");

		}

		if (browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			options.addArguments("--disable-notifications");
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-translate");

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}

		else {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		return driver;

	}

	@BeforeTest
	public void initializeBrowser() throws IOException {
		driver = initializeDriver();
		driver.get("https://app-qa.roojh.com/signin");
		selectUserType = new SelectUserType(driver);

	}

//	@AfterTest
//	public void tearDown() throws InterruptedException {
//
//		Thread.sleep(8000);
//		driver.quit();
//
//	}

}
