package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.LoginPage;
import Utilities.XLUtiles;

public class TC_LoginTest_002 extends BaseClass {
	
	@Test(dataProvider="LoginTest")
	public void Data(String user,String pwd)
	{
		LoginPage lp=new LoginPage(driver);
	     
		lp.SetUsername(user);
		lp.SetPassword(pwd);
		lp.ClickLoginBtn();
		
		if(driver.getTitle().equals("OrangeHRM"))
		{
			Assert.assertTrue(true);
			logger.info("Test case pass");
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Test Case Fail");
		}
		
		
	}

	@DataProvider(name="LoginTest")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"\\src\\test\\java\\TestData\\LoginData.xlsx";
		
		int rownum=XLUtiles.rowcount(path, "Sheet1");
		int colcount=XLUtiles.colcount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtiles.getcellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return logindata;
	}
	
	
		
	
}
