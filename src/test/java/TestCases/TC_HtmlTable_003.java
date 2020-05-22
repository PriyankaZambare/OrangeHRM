package TestCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import PageObject.HtmlPage;
import PageObject.LoginPage;

public class TC_HtmlTable_003  extends BaseClass{
	
	
	@Test
	public void htmltable()
	{
		logger.info("url is open");
	LoginPage lp =new LoginPage(driver);
	
	lp.SetUsername(username);
	logger.info("Entered username");
	
	lp.SetPassword(password);
	logger.info("Entered password");
	lp.ClickLoginBtn();
	
	
	HtmlPage  hp= new HtmlPage(driver);
	hp.getlinPIM();
	hp.getemplist();
    int rownum=	hp.getrows();
	int colnum= hp.getcol();
	
	
	for(int i=1;i<rownum;i++)
	{
		for(int j=1;j<=colnum;j++)
		{
			System.out.println(driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr["+i+"]/td["+j+"]")).getText());
		}
	}
	
	
	
	
	
	}
	

}
