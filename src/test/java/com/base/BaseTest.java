package com.base;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager; //log4j
import org.apache.logging.log4j.Logger; //log4j

public class BaseTest {

	public static WebDriver driver;
	public Logger logger;
	public Properties properties;

	// that method use for open application
	@BeforeClass(groups = {"sanity","regression","datadriven","master"})
	@Parameters({ "os", "browser" })
	public void startUp(String os, String br) throws IOException {
		
		// Here we can read the file
		FileReader file = new FileReader("./src//test//resources//config.properties");
		properties=new Properties();
		properties.load(file);

		logger = LogManager.getLogger(this.getClass()); // log4j

		switch (br.toLowerCase())
		{
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			logger.info("** INVALID BROWSER PLEASE CHECK **");
			return;
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(properties.getProperty("appURL2"));	// register.properties file config data use here...
		driver.manage().window().maximize();
	}

	// that method use for exit of the method
	@AfterClass(groups = {"sanity","regression","datadriven","master"})
	public void tearDown() {
		driver.quit();
	}

	/*
	 * NOTE : email use one user one time other wise exception throw, thats why we
	 * create dynamic data also use static data using excel
	 */

// here we can create dynamic data using RandomStringUtils class method under customized methods.

	public String randomString() {
		String generatedStr = RandomStringUtils.randomAlphabetic(9);
		return generatedStr;
	}

	public String randomNumeric() {
		String generatedNum = RandomStringUtils.randomNumeric(10);
		return generatedNum;
	}

	public String randomAlphaNumeric() {
		String generatedStr = RandomStringUtils.randomAlphabetic(3);
		String generatedNum = RandomStringUtils.randomNumeric(3);
		return (generatedStr + "@" + generatedNum);
	}

	// capturing screen shot (OC_ExtentReportManager class - onTestFailure() method - call following (below) method)
	public String captureScreenShot(String tName) throws IOException{

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\"+tName+"_"+timeStamp+".png";
		File targetFile = new File(targetFilePath);
		
		sourFile.renameTo(targetFile);
		
		return targetFilePath;
	}

}
