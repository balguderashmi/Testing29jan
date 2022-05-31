package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FBLoginPage {
	
	@FindBy (xpath = "//input[@id='email']")
	private WebElement email;
	
	@FindBy (xpath = "//input[@type='password']")
	private WebElement password;
	
	@FindBy (xpath = "//button[text()='Log In']")
	private WebElement loginbutton;
	
	public FBLoginPage(WebDriver driver)
	  {
	   PageFactory.initElements(driver, this);
	  }
	public void sendemail() 
   	  {
		email.sendKeys("7721821547");
	  }
	public void sendpassword() 
	  {
		password.sendKeys("1234567890@");
	  }
	public void loginclick() 
	  {
		loginbutton.click();
	  }
}
