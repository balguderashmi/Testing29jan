package testClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import pomClasses.FBHomePage;
import pomClasses.FBLoginPage;

public class VerifyFbLogInPage {
	public static void main(String[] args, WebElement Frndtext) {
		System.setProperty("webdriver.gecko.driver", "E:\\VELOCITY\\Automation\\selenium\\Firefox\\64\\geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
  //1st 
		driver.get("https://www.facebook.com/");
			
		FBLoginPage loginPage = new FBLoginPage(driver);
		loginPage.sendemail();
		loginPage.sendpassword();
		loginPage.loginclick();
		
		FBHomePage homePage =new FBHomePage(driver);
		
	    homePage.WatchTabclick();
		String url = driver.getCurrentUrl();
		System.out.println(url);
		String title = driver.getTitle();
		System.out.println(title);
		if(url.equals("https://www.facebook.com/watch/?ref=tab") && title.equals("Facebook"))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		homePage.LogOutTabclick();
		
		//2nd
		driver.get("https://www.facebook.com/");
		
		loginPage = new FBLoginPage(driver);
		loginPage.sendemail();
		loginPage.sendpassword();
		loginPage.loginclick();
		
		homePage.FriendsTabclick();
		String url1 = driver.getCurrentUrl();
		System.out.println(url1);
		String title1 = driver.getTitle();
		System.out.println(title1);
		
		if(url.equals("https://www.facebook.com/friends") && title.equals("Friends|Facebook"))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		//homePage.Frndtext();
		homePage.LogOutTabclick();
}
}
