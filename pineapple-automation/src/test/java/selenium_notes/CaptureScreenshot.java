package selenium_notes;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class CaptureScreenshot {

	WebDriver driver;

	@BeforeTest
	public void startUp() throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/rusmusus/Documents/Libraries/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.softwaretestingmaterial.com/capture-screenshot-using-selenium-webdriver");
		Thread.sleep(5000);

	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

	@Test(enabled = false)
	public void captureScreenshot() throws IOException {
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile,
				new File("/Users/rusmusus/git/pineapple-automation/pineapple-automation/test-output/screenshot.png"));
	}

	@Test
	public void fullPageScreenshot() throws IOException {
		Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
				.takeScreenshot(driver);
		ImageIO.write(fpScreenshot.getImage(), "PNG",
				new File("/Users/rusmusus/git/pineapple-automation/pineapple-automation/test-output/fpScreenshot.png"));
	}

}
