package selenium_notes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Hooks {
	
	WebDriver driver;

	@BeforeTest
	public void startUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/rusmusus/Documents/Libraries/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://online.citi.com/US/login.do");
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
