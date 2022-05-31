package testClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pomClasses.FBHomePage;
import pomClasses.FBLoginPage;

public class VerifyHeaderofFB {
	WebDriver driver;
	FBHomePage homePage;                 
	FBLoginPage loginPage;
	@BeforeClass
	public void LaunchBrowser() {
		System.setProperty("webdriver.chrome.driver", "E:\\VELOCITY\\Automation\\selenium\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		driver= new ChromeDriver(opt);
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		
	}
	
	@BeforeMethod
	public void LogInToApplication() {
		driver.get("https://www.facebook.com/");
		
		loginPage = new FBLoginPage(driver);
		loginPage.sendemail();
		loginPage.sendpassword();
		loginPage.loginclick();
		
		homePage =new FBHomePage(driver);
	}
	
	@Test
	public void VerifyWatchTab() {
		homePage.WatchTabclick();
		String url = driver.getCurrentUrl();
		System.out.println(url);
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("https://www.facebook.com/", url);
		Assert.assertEquals("Facebook", title);
		
		
		
		
	}
	@Test
	public void VerifyFriendsTab() {

		homePage.FriendsTabclick();
		String url1 = driver.getCurrentUrl();
		System.out.println(url1);
		String title1 = driver.getTitle();
	    System.out.println(title1);
		
		Assert.assertEquals("https://www.facebook.com/friends", url1);
		Assert.assertEquals("Facebook", title1);
	    //homePage.Frndtext();
	
	}
	
	@AfterMethod
	public void LogOutFromApplication() {
		homePage.LogOutTabclick();
	}
	
	@AfterClass
	public void CloseBrowser() {
		driver.close();
	}

}
