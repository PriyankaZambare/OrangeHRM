package PageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class datapick {
	
	WebDriver ldriver;
	
	public datapick(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(xpath="//b[text()='Recruitment']")
	WebElement  Recruitment;
	
	@FindBy(id="menu_recruitment_viewCandidates")
	WebElement candidates;
	
	@FindBy(xpath="//img[@class='ui-datepicker-trigger']")
	WebElement datepicker;
	
	@FindBy (xpath="//select[@class='ui-datepicker-month']")
	WebElement month;
	
	@FindBy(xpath="//select[@class='ui-datepicker-year']")
	WebElement year;
	
	
	@FindBy(linkText = "15")
	WebElement date;
	
	
	public void getActionClass()
	{
		Actions act= new Actions(ldriver);
		act.moveToElement(Recruitment).moveToElement(candidates).click().build().perform();
		
	}
	
	/*	public void getcandidatest()
	{
		candidates.click();
	}
	
	public void getRecruitment()
	{
		Recruitment.click();
	}*/
	
	public void clkOnDPbtn()
	{
		datepicker.click();
	}
	
	public void getmonth()
	{
		month.click();
		Select sel=new Select(month);
		System.out.println(sel.getOptions().size());
//		s.selectByIndex(9);
		
		List<WebElement> mon=sel.getOptions();
		for(WebElement m:mon)
		{
			System.out.println(m.getText());
			
			if(m.getText().equals("Jul"))
			{
				m.click();
				break;
			}
		}
		
	}
	
	public void getyear()
	{
		year.click();
		Select s= new Select(year);
		System.out.println(s.getOptions().size());
	//	s.selectByVisibleText("2018");
		
		List<WebElement>year=s.getOptions();
		
		for(WebElement y:year)
		{
			System.out.println(y.getText());
			if(("2016").equals(y.getText()))
				{
				y.click();
				break;
				
			}
		}		
		
}
	
	public void getdata()
	{
		date.click();
	}
	
	
	

}
