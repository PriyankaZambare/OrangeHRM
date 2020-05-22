package TestCases;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import Utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();
	public String BaseURL=readconfig.getApplicationurl();
	public String username=readconfig.getusername();
	public String password=readconfig.getpassword();
	public static WebDriver driver;
	
	public static  Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void Setup(String br)
	{
		logger=Logger.getLogger("OrangeDemo");
		PropertyConfigurator.configure("log4j.properties");
	if(br.equals("Chrome"))	
	{
	  System.setProperty("webdriver.chrome.driver", readconfig.getChromepath());
	  driver=new ChromeDriver();
	}
	
	else if(br.equals("FireFox"))
	{
		System.setProperty("webdriver.gecko.driver", readconfig.getChromepath());
		driver=new FirefoxDriver();
	}

	else if(br.equals("ie"))
	{
		System.setProperty("webdriver.ie.driver", readconfig.getIEpath());
		driver=new InternetExplorerDriver();
	}
	
	driver.get(BaseURL);
	

}
	@AfterClass
	public void tearDown()
	{
	//	driver.quit();
	}
	
	public void CaptureScreen(WebDriver driver,String tname) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+ "/Screenshots/"+tname +".png");
		FileUtils.copyFile(source, target);
		
	}
	
}