package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.basepage.BasePage;

public class LoginPage extends BasePage {
	WebDriver driver;
	// 1. Page Objects / By Locators
	By emailID = By.id("username");
	By password = By.id("password");
	By loginButton = By.id("loginBtn");
	By signUpLink = By.linkText("Sign up");

	// 2. page class constructor:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean isSignUpDisplayed() {
		return driver.findElement(signUpLink).isDisplayed();
	}

	public HomePage doLogin(String username, String pwd) {
		driver.findElement(emailID).sendKeys(username);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginButton).click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new HomePage(driver);
	}
	
	
}
