package testScript;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constent.Constent;
import utilities.ScreenshotUtility;

public class GroceryBase {

	public WebDriver driver; //Create an  interface of webdriver to launch the broweser for load the URL
	//alwaysrun is using when we grouping since grocery base is extending to different classes
	
	//Parameterization is used to change the values and test the cases
	
	//properies and FileInputStream classes are used to get the url from a file named config.property
	Properties prop;
	FileInputStream fio;
	
	@BeforeMethod (alwaysRun=true)
	@Parameters("browsers")
		public void InitialiseBrowser(String browsers) throws IOException
		{
		
		prop = new Properties();
		fio = new FileInputStream(Constent.CONFIGFILE);
		prop.load(fio);
		
			if (browsers.equalsIgnoreCase("chrome"))
			{
				driver = new ChromeDriver ();
			}
			else if(browsers.equalsIgnoreCase("firefox"))
			{
				driver = new FirefoxDriver();
			}
			else if(browsers.equalsIgnoreCase("edge"))
			{
				driver = new EdgeDriver();
			}
			//Intialising browser to launch 
			
			
			//driver = new FirefoxDriver();
			
			//launch url using get method (get method is from the predefined webdriver interface)
			
			driver.get(prop.getProperty("URL"));
			
			//properies and filedeclaration classes 
			
			//to maximize the window
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //applied implicitlywait() to apply implicit method
			
		}
	@AfterMethod(alwaysRun=true)
	public void closeBrowser(ITestResult itestresult) throws IOException //ITestResult is a predifned interface - for a test case life cycle is managed by ITestResult to check is failed, passed or skipped
	{
		if(itestresult.getStatus()==ITestResult.FAILURE) //checking the getstatus is failure or not using getStatus () from the ITestResult interface
		{
			ScreenshotUtility screenshotutility=new ScreenshotUtility(); // create an objevt for the ScreenshotUtility class
			screenshotutility.getScreenshot(driver, itestresult.getName());// call the parameterized method of getScreenshot from ScreenshotUtility class and getName method used to get the method name of the failure test case
		}
		 // driver.close();
		//driver.quit();
	}
	
	/* Wait commands are used to apply waiting time to an action, there are 3 types:
	 * 1. Implicit
	 * 2. Explicit
	 * 3. Fluent
	 * 
	 *Implicit wait is usuaally applied in the url launch page and it applies to all the elements and we cannot apply to one element
	 *Explicit wait can be traget on one element and apply waiting time , mostly we are using explicit wait for a project (WebElementCommands - applied)
	 *Fluent wait can be traget on one element and apply waiting time, trigger and time should be provided by us and we need to ignore on expection
	 */

}
