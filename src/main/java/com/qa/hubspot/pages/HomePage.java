package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.basepage.BasePage;

public class HomePage extends BasePage {
	WebDriver driver;
	

	By header = By.cssSelector("h1.private-page__title");
	
	By accountname = By.cssSelector("span.account-name ");
	By logo = By.cssSelector("li>a#nav-primary-home");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyHomePageHeader() {
		return driver.findElement(header).isDisplayed();
	}
	public String getHomePageHeader() {
		return driver.findElement(header).getText();
	}
	public boolean verifyLoggedAccountName() {
		return driver.findElement(accountname).isDisplayed();
	}

	public String getLoggedAccountName() {
		return driver.findElement(accountname).getText();
	}

	public boolean verifyApplicationLogo() {
		return driver.findElement(logo).isDisplayed();
	}


	

}
