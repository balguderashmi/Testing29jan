package testClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import browsers.Base;
import pomClasses.FBHomePage;
import pomClasses.FBLoginPage;
import utils.Utility;

public class LastClass {
	WebDriver driver;
	FBHomePage homePage;
	FBLoginPage loginPage;
	
	@Parameters ("Browsername")
	@BeforeTest
	public void LaunchBrowser(String browser) {
		System.out.println(browser);
		
		if(browser.equals("Chrome"))
		{
			driver=Base.openchromebrowser();
		}
		if(browser.equals("Firefox"))
		{
			driver=Base.openfirefoxbrowser();
		}
//		if(browser.equals("Opera"))
//		{
//			driver=Base.openOperaBrowser();
//		}
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
	}
	
	@BeforeClass
	public void CreatePOMobjects() {
     	homePage = new FBHomePage(driver);
	    loginPage = new FBLoginPage(driver);
	}
	
	@BeforeMethod
	public void LogInToApplication() {
		driver.get("https://www.facebook.com/");
		
		
		loginPage.sendemail();
		loginPage.sendpassword();
		loginPage.loginclick();
		
		
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
	public void LogOutFromApplication(ITestResult result) throws IOException {
		  if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.CaptureScreenshot(driver, result.getName());
		}
		Utility.FetchDataFromExcelSheet(2,4,3);
		homePage.LogOutTabclick();
	}
	
	@AfterClass
	public void ClearPOMobjects() {
		homePage=null;
		loginPage=null;
	}
	
	@AfterTest
	public void CloseBrowser() {
		driver.close();
		driver=null;
		System.gc();
	}
}
