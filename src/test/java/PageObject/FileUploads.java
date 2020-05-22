package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;




public class FileUploads {
	WebDriver ldriver;
	
	public FileUploads(WebDriver rdriver)
	{
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//b[text()='PIM']")
	WebElement lnkpimbtn;
	
	@FindBy(id="menu_pim_addEmployee")
	WebElement addEmployee;
	
	@FindBy(id="photofile")
	WebElement browserbtn;
	
	
	
	public void Actionpim()
	{
		Actions act=new Actions(ldriver);
		act.moveToElement(lnkpimbtn).moveToElement(addEmployee).click().build().perform();
		
	}
	
	public void clkbrowserbtn() throws InterruptedException, FindFailed
	{
		
		Actions act=new Actions(ldriver);
		act.moveToElement(browserbtn).click().build().perform();
		Screen s= new Screen();
		Pattern FileInputTextBox= new Pattern("C:/Users/Priya/Pictures/birds img/snipping tool/FileTextBox.PNG.png");
		Pattern OpenButton= new Pattern("C:/Users/Priya/Pictures/birds img/snipping tool/OpenButton.png");
		
		Thread.sleep(6000);
		
		s.wait(FileInputTextBox,20);
		s.type(FileInputTextBox,"C:\\Users\\Priya\\Pictures\\birds img\\Peachock.jpg");
		s.click(OpenButton);
	
		
	}
	

}
