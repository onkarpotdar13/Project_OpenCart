package com.utilities;

import java.awt.Desktop; 
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/** YOU WANT UNCOMMENT IT FOR EMAIL SEND **/

//import java.net.URL;
//import javax.activation.DataSource;
//
//import org.apache.commons.mail.DataSourceResolver;
//import org.apache.commons.mail.DefaultAuthenticator;
//import org.apache.commons.mail.ImageHtmlEmail;
//import org.apache.commons.mail.resolver.DataSourceUrlResolver;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.base.BaseTest;

public class OC_ExtentReportManager implements ITestListener{
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extentReport;
	public ExtentTest extentTest;
	
	String repoName;
	
	public void onStart(ITestContext testContext)
	{
		/*
		 * SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		 * Date date = new Date(); String currentDateTimeStamp =
		 * dateFormat.format(date);
		 */
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		repoName = "Test-Report-" + timeStamp + ".html";
		sparkReporter = new ExtentSparkReporter(".\\reports\\"+repoName); // specific location
		
		sparkReporter.config().setDocumentTitle("OpenCart Automation Report");		// title of the report
		sparkReporter.config().setReportName("Opencart Functional Testing");	// name of the report
		sparkReporter.config().setTheme(Theme.DARK); // set theme
		
		/* SET COMMON DETAILS RELETED THE PROJECT */
		
		extentReport = new ExtentReports();
		extentReport.attachReporter(sparkReporter);
		
		extentReport.setSystemInfo("Application", "OPENCART");
		extentReport.setSystemInfo("Module", "ADMIN");
		extentReport.setSystemInfo("Sub-Module", "CUSTOMERS");
		extentReport.setSystemInfo("User Name", System.getProperty("user.name"));
		extentReport.setSystemInfo("Enviroment", "QA");
		
		String os = testContext.getCurrentXmlTest().getParameter("os");
		extentReport.setSystemInfo("Operating-System", os);
		
		String browser = testContext.getCurrentXmlTest().getParameter("browser");
		extentReport.setSystemInfo("Browser", browser);
		
		List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
		
		if(!includedGroups.isEmpty()) 
		{
			extentReport.setSystemInfo("Groups", includedGroups.toString());
		}
	}
	
	public void onTestSuccess(ITestResult testResult) 
	{
		extentTest = extentReport.createTest(testResult.getTestClass().getName());
		
		extentTest.assignCategory(testResult.getMethod().getGroups()); // to display groups in report
		extentTest.log(Status.PASS, testResult.getName()+" : GOT SUCCESSFULLY EXECUTED");
	}
	
	public void onTestFailure(ITestResult testResult)
	{
		extentTest = extentReport.createTest(testResult.getTestClass().getName());
		
		extentTest.assignCategory(testResult.getMethod().getGroups());
		extentTest.log(Status.FAIL, testResult.getName()+" : GOT FAILED");
		extentTest.log(Status.INFO, testResult.getThrowable().getMessage());
		
		try
		{
			String imgPath = new BaseTest().captureScreenShot(testResult.getName());
			extentTest.addScreenCaptureFromPath(imgPath);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult testResult)
	{
		extentTest = extentReport.createTest(testResult.getTestClass().getName());
		
		extentTest.assignCategory(testResult.getMethod().getGroups());
		extentTest.log(Status.SKIP, testResult.getName()+" : GOT SKIPPED");
		extentTest.log(Status.INFO, testResult.getThrowable().getMessage());
	}
	
	public void onFinish(ITestContext testContext)
	{
		extentReport.flush();
		
		String pathOFExtentRepo = System.getProperty("user.dir")+"\\reports\\"+repoName;
		File extentReport = new File(pathOFExtentRepo);
		
		try
		{
			Desktop.getDesktop().browse(extentReport.toURI());
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		/* FOR AUTOMATIC EMAIL SEND TO GROUP MEMBER */
		
		/** NOTE : Follow code execute just one or two times only **/
		
//		try
//		{
//			URL url = new URL("file:///"+System.getProperty("user.dir")+"\\reporst\\"+repoName);
//			
//			// create the email message.
//			ImageHtmlEmail email = new ImageHtmlEmail();
//			
//			email.setDataSourceResolver(new DataSourceUrlResolver(url));
//			email.setHostName("smtp.googlemail.com"); // only perform gmail we can change as per requirement.
//			email.setSmtpPort(465);
//			email.setAuthenticator(new DefaultAuthenticator("onkarpotdar82@gmail.com", "OHP131297@om"));
//			email.setSSLOnConnect(true);
//			email.setFrom("onkarpotdar82@gmail.com"); // sender
//			email.setSubject("OC Test Result...");
//			email.setMsg("Please find attachment automation report..");
//			email.addTo("onkarpotdar13@gmail.com"); // receiver
//			email.attach(url, "extent report", "please check attachment report...");
//			email.send();	// send the email.
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
	}
	
}
