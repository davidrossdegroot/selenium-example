package qa.webdriver.tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import qa.webdriver.util.EtsySearchPage;

// this class runs a single test for debugging purposes
public class DebugSingle {

	private static String testName, searchString, ddMatch;
	
	private static WebDriver driver;

	public DebugSingle() {
		testName = "debugTest";
		searchString = "daft punk";
		ddMatch = "tshirt";
	}

	@BeforeClass
	public static void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "/Users/ddegroot/apps/selenium-gradle-example/etsy/src/test/resources/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testWithPageObject() {
		driver.get("http://www.google.com");
		driver.get("http://www.nytimes.com");
		String text = driver.findElement(By.xpath("//article[@class='story theme-summary lede']")).getText();
		System.out.println(text);
//		driver.findElement(By.id("log")).sendKeys("testuser_3");
		EtsySearchPage gs = new EtsySearchPage();
	}

	@Test
	public void testFluentPageObject() {
		driver.get(System.getProperty("testURL") + "webhp?hl=en&tab=ww");
		EtsySearchPage esp = new EtsySearchPage();
	}

	@After
	public void cleanUp() {
		driver.get("about:about");
	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}

}
