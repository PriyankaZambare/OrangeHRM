package Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.internal.TestResult;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter  {
	
	
	public  ExtentHtmlReporter htmlreporter;
	public ExtentReports reporter;
	public ExtentTest test;
	
	
	public void onStart(ITestContext testcontext)
	{
		
		String timeSpam=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName="Test-Report-"+timeSpam+".html";
		
		htmlreporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/"+repName);
		htmlreporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		
		reporter=new ExtentReports();
		
		reporter.attachReporter(htmlreporter);
		reporter.setSystemInfo("Os", "Windows 10");
		reporter.setSystemInfo("user", "pria");
		reporter.setSystemInfo("Env", "QA");
		
		htmlreporter.config().setDocumentTitle("OrangeHrmProject");
		htmlreporter.config().setReportName("Demo Orangehrm");
		htmlreporter.config().setTheme(Theme.DARK);
		
	
}
	public void onTestSuccess(ITestResult tr)
	{
		test=reporter.createTest(tr.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}
	
	public void onTestFailure(ITestResult tr)
	{
		test= reporter.createTest(tr.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		
		String Screenshotpath=System.getProperty("user.dir")+"/Screenshots/"+ tr.getName()+".png";
		
		File f=new File(Screenshotpath);
		
		if(f.exists())
		{
			try
			{
				test.fail("Screenshot is below"+test.addScreenCaptureFromPath(Screenshotpath));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	public void onTestSkipped(ITestResult tr)
	{
		test=reporter.createTest(tr.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
		
	}

		public void onFinish(ITestContext testContext)
		{
			reporter.flush();
	}
}
