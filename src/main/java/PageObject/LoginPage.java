package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	
	WebDriver ldriver;
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="txtUsername")
	WebElement txtUsername;
	
	@FindBy(id="txtPassword")
	WebElement txtPassword;
	
	@FindBy(id="btnLogin")
	WebElement btnLogin;
	
	public void SetUsername(String username)
	{
		txtUsername.sendKeys(username);
	}
	
	public void SetPassword(String password)
	{
		txtPassword.sendKeys(password);
	}

	public void ClickLoginBtn()
	{
		btnLogin.click();
	}

	
	

}
