package com.test.mo.automation.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Parameters;

import com.test.mo.automation.costumlistners.Webeventlistners;

public class Testbase {

	public WebDriver dr;
	public EventFiringWebDriver driver;
	public Webeventlistners eventlistner;
	public Properties property = new Properties();

	public void init() throws IOException {
		loadPropertiesData();
		selectbrowser(property.getProperty("browser"));
		driver.manage().window().maximize();
		driver.get(property.getProperty("url"));

		/**
		 * this is required for eventfireing logs and add the log4j property
		 * file in the project folder
		 */
		String log4j = "log4j.properties";
		PropertyConfigurator.configure(log4j);

	}

	public void loadPropertiesData() throws IOException {
		File file = new File(
				System.getProperty("user.dir") + "/src/main/java/com/test/mo/automation/properties/config.properties");
		FileInputStream custom_file1 = new FileInputStream(file);
		property.load(custom_file1);

	}

	@Parameters("browser")
	public void selectbrowser(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
			dr = new ChromeDriver();
			driver = new EventFiringWebDriver(dr);
			eventlistner = new Webeventlistners();
			driver.register(eventlistner);
		} else if (browser.equalsIgnoreCase("opera")) {
			System.setProperty("webdriver.opera.driver", System.getProperty("user.dir") + "/driver/operadriver.exe");
			dr = new OperaDriver();
			driver = new EventFiringWebDriver(dr);
			eventlistner = new Webeventlistners();
			driver.register(eventlistner);

		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.firefox.marionette",
					System.getProperty("user.dir") + "/drivers/geckodriver.exe");
			dr = new FirefoxDriver();
			driver = new EventFiringWebDriver(dr);
			eventlistner = new Webeventlistners();
			driver.register(eventlistner);
		}

	}

}
