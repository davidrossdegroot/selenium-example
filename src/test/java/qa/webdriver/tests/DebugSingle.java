package qa.webdriver.tests;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
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
		driver.get("http://www.nytimes.com");
		String text = driver.findElement(By.xpath("//article[@class='story theme-summary lede']")).getText();
		System.out.println(text);
		System.out.println(StringUtils.substringBetween(text, "KATE", "HABERMAN"));
//		driver.findElement(By.id("log")).sendKeys("testuser_3");
		
		DateTime today = new DateTime();
		DateTimeFormatter fmt = DateTimeFormat.forPattern("dd-MMMM-yyyy");
		String todayStr = fmt.print(today);
		
		try{
		    PrintWriter writer = new PrintWriter(todayStr + "-" + "payment-deets.txt", "UTF-8");
		    writer.println("The first line");
		    writer.println("The second line");
		    writer.close();
		} catch (IOException e) {
		   // do something
		}
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
