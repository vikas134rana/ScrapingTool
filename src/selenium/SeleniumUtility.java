package selenium;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.scraping.Property;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumUtility {

	private WebDriver driver;

	public WebDriver openChrome(String url) {
//		System.setProperty("webdriver.chrome.driver", Property.CHROME_DRIVER_PATH);

		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(Property.IS_HEADLESS);

		if (Property.IS_HEADLESS) {
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			options.addArguments("window-size=" + screenSize.width + "," + screenSize.height);
		}

		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(url);
		takeSnapShot();
		return driver;
	}
	
	public void waitForEle(WebDriver driver, String xpath, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}

	public void takeSnapShot() {

		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		try {
			// Move image file to new destination
			File DestFile = File.createTempFile("ThreadToolSnapshot", ".png");

			// Copy file at destination
			FileUtils.copyFile(SrcFile, DestFile);

			System.out.println("## Snapshot Taken: " + DestFile);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
