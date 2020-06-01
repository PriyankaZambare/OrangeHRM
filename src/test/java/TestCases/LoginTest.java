package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.LoginPage;

public class LoginTest extends BaseClass {
	
	@Test
	public void loginTest() throws IOException
	{
		logger.info("Url is opened");
		LoginPage lp=new LoginPage(driver);
		lp.SetUsername(username);
		logger.info("Entered username");
		
		lp.SetPassword(password);
		logger.info("Entered password");
		
		lp.ClickLoginBtn();
		
		
		if(driver.getTitle().equals("Orange11111"))
		{
			Assert.assertTrue(true);
			logger.info("Test case Passed.");
		}
		else
		{
			CaptureScreen(driver, "LoginTest");
			Assert.assertTrue(false);
			logger.warning("Test case failed ......");
		}
	}
	
	

}
