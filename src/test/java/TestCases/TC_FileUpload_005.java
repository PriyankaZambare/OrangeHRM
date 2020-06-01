package TestCases;

import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

import PageObject.FileUploads;
import PageObject.LoginPage;

public class TC_FileUpload_005 extends BaseClass{
	
	@Test
	public void upload() throws FindFailed, InterruptedException
	{
		LoginPage lp= new LoginPage(driver);
		logger.info("URL is opened");
		lp.SetUsername(username);
		logger.info("Username id Entered");
		lp.SetPassword(password);
		logger.info("password is entered");
		lp.ClickLoginBtn();
		logger.info("login successful");
		
		FileUploads fp=new FileUploads(driver);
		fp.Actionpim();
		fp.FileUploadForBird("C:\\Users\\Priya\\Pictures\\birds img\\FiveBirds.jpg");
		logger.info("File is uploaded");
		
	}
	
	

}
