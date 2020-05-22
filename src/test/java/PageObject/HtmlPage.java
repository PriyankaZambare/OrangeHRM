package PageObject;

import java.lang.module.FindException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import freemarker.core.ReturnInstruction.Return;

public class HtmlPage {
	
WebDriver ldriver;
	
	public HtmlPage (WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//b[text()='PIM']")
	WebElement lnkpim;
	
	@FindBy(id="menu_pim_viewEmployeeList")
	WebElement lnkempList;
	
	@FindBy(xpath="/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr")
	List<WebElement> row;
	
	@FindBy(xpath="/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr[1]/td")
	List<WebElement> coloumns;

/*	@FindBy(xpath="/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr[\"+i+\"]/td[\"+j+\"]")
    WebElement table; */ 
	
public void getlinPIM()
{
	lnkpim.click();
}
public void getemplist()
{
	lnkempList.click();
}

public  int getrows()
{
	 return row.size();
}
public int getcol()
{
	 return coloumns.size();
}

/*public String getTable()
{
	return table.getText();
} */

}