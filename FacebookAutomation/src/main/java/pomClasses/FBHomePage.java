package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FBHomePage {
    WebDriver driver;
	@FindBy (xpath = "//a[@aria-label='Friends']")
	private WebElement Friends;
	
//	@FindBy (xpath = "//h1[text()='Friends']")
//	private WebElement Frndtext;
	
	@FindBy (xpath = "(//span[@class='l9j0dhe7'])[3]")
	private WebElement Watch;
	
	@FindBy (xpath = "//div[@aria-label='Your profile']")
	private WebElement Profile;
	
	@FindBy (xpath ="//span[text()='Log Out']")
	private WebElement LogOut;
	

	public FBHomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	public void FriendsTabclick() {
		Friends.click();
	}
//	public void Frndtext() {
//		Frndtext.getText();
//	}
	public void WatchTabclick() {
		Watch.click();
	}
	public void LogOutTabclick() {
		Actions act = new Actions(driver);
		act.moveToElement(Profile).click().perform();
		act.moveToElement(LogOut).click().perform();
	}
}
