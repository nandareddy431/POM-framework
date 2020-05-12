package com.qa.hubspot.tests;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.basepage.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.Constants;

public class LoginPagetTest {
WebDriver driver;
BasePage basepage;
Properties prop;
LoginPage loginpage;
HomePage homePage;
@BeforeMethod
public void setup() 
{
	basepage= new BasePage();
	prop=basepage.init_properties();
	driver=basepage.init_driver(prop);
    loginpage= new LoginPage(driver);
	}

@Test
public void verifyLoginPageTitleTest(){
String title=	loginpage.getLoginPageTitle();
System.out.println("login pagetitle is"+title);
Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	
}


@Test(priority = 2)
public void verifySignUpLinkTest() {
	Assert.assertTrue(loginpage.isSignUpDisplayed());
}
@Test(priority = 3)

public void verifyLoginTest() {
	homePage =loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	Assert.assertTrue(homePage.verifyLoggedAccountName());
	Assert.assertEquals(homePage.getLoggedAccountName(), prop.getProperty("accountname"));
	
}




@AfterMethod
public void quitBrowser()
{
	driver.quit();
	}

}


