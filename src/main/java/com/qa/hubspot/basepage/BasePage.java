package com.qa.hubspot.basepage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	WebDriver driver;
	Properties prop;

	public WebDriver init_driver(Properties prop)  {
		String browser=prop.getProperty("browser");
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("safari")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
			driver = new SafariDriver();
		} else {
			System.out.println("Please Pass the correct browser name");
		}
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
	}

	public Properties init_properties() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("\\Users\\NANDA\\workspace\\POM_Framework\\src\\main\\java\\com"
					+ "\\qa\\hubspot\\config\\config");
			prop.load(ip);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return prop;
	}

}
