package selenium_notes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HandleWindows {
	WebDriver driver;

	@BeforeClass
	public void startUp() {
		System.setProperty("webdriver.gecko.driver", "/Users/rusmusus/Documents/Libraries/drivers/geckodriver");
		driver = new FirefoxDriver();
		driver.get("https://www.amazon.com");
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void handleWindow() {
		String parentWindow = driver.getWindowHandle();
		
	}

}
