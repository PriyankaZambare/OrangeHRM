package TestCases;

import org.testng.annotations.Test;

import PageObject.LoginPage;
import PageObject.datapick;



public class TC_DataPicker_004 extends BaseClass
{
	@Test
	public void calender()
	{
	LoginPage lp=new LoginPage(driver);
	lp.SetUsername(username);
	lp.SetPassword(password);
	lp.ClickLoginBtn();
	
	datapick dp= new datapick(driver);
	dp.getActionClass();
//	dp.getRecruitment();
//	dp.getcandidatest();
	dp.clkOnDPbtn();
	dp.getmonth();
	dp.getyear();
	dp.getdata();
	
	
	
	}
}
