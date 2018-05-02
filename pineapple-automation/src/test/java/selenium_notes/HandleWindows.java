package selenium_notes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class HandleWindows {
	static WebDriver driver;
	int count = 0;

	@Test
	public void startUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/rusmusus/Documents/Libraries/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://online.citi.com/US/login.do");

	}

	@Test(priority = 0, enabled = false)
	public void handleAlert() {
		for (String alert : driver.getWindowHandles()) {
			driver.switchTo().window(alert).close();
			count++;
			if (count == 3) {
				break;
			}
		}

	}

	@Test(enabled = true)
	public void handleWindow() {
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);
		driver.findElement(By.partialLinkText("Private")).click();

		for (String subWindow : driver.getWindowHandles()) {
			driver.switchTo().window(subWindow);
		}

		System.out.println(driver.getCurrentUrl());
		driver.close();

		driver.switchTo().window(parentWindow);
		System.out.println(driver.getTitle());

	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
