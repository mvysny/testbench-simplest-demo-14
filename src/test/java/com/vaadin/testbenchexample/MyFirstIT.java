package com.vaadin.testbenchexample;

import com.vaadin.flow.component.button.testbench.ButtonElement;
import com.vaadin.flow.component.html.testbench.SpanElement;
import com.vaadin.testbench.ScreenshotOnFailureRule;
import com.vaadin.testbench.TestBenchTestCase;
import com.vaadin.testbench.screenshot.ImageFileUtil;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;

import static org.junit.Assert.assertEquals;

/**
 * This test is run by the maven-failsafe-plugin, requires the app to be running
 * in a separate process (handled by jetty-maven-plugin's start-jetty and stop-jetty
 * Maven executions) and uses TestBench+Selenium to connect to the running app
 * and test using an actual browser.
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class MyFirstIT extends TestBenchTestCase {
	/**
	 * This will also close the Selenium Driver.
	 */
	@Rule
	public final ScreenshotOnFailureRule rule = new ScreenshotOnFailureRule(this);

	@Before
	public void setup() {
		// Chrome needs ChromeDriver installed.
		// Ubuntu users: sudo apt install chromium-chromedriver
//		System.setProperty("webdriver.chrome.driver", "/usr/lib/chromium-browser/chromedriver");
//		setDriver(new ChromeDriver());

		// Firefox needs GeckoDriver installed.
		// Ubuntu users: sudo apt install firefox-geckodriver
		setDriver(new FirefoxDriver());
	}

	@Test
	public void clickButtonShouldChangeTheLabel() throws Exception {
		driver.get("http://localhost:8080");
		$(ButtonElement.class).id("clickme").click();
		assertEquals("Clicked!", $(SpanElement.class).id("status").getText());
        dumpScreenshot();
	}

	private void dumpScreenshot() throws Exception {
		BufferedImage screenshotImage = ImageIO.read(new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
		// Store the screenshot in the errors directory
		ImageFileUtil.createScreenshotDirectoriesIfNeeded();
		ImageIO.write(screenshotImage, "png", new File("target/screenshot.png"));
	}
}
