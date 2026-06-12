package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


// If a test case failed it will take the screenshot of the brown current status and TakesScreenshot interface is used to capture the sreenshot

public class ScreenshotUtility {
	
	public void getScreenshot(WebDriver driver, String failedTestCase) throws IOException // failedTestCase name is used to store captured screenshot method name 
	{

		TakesScreenshot scrShot = (TakesScreenshot) driver; //TakesScreenshot ia apedefined interface used to capture the screenshot and this process is call casting
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE); //captued screenshot is temporarly stored in a screenShot file.

		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date()); //Fetching the time fo the capture and saved tn timestamp 

		File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot");// create file in directory
		if (!f1.exists()) {

		f1.mkdirs(); //if file is not created it will create the directory
		}
		String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedTestCase + timeStamp
		+ ".png";
		//String destination1 = f1.getPath() + "//" + failedTestCase + timeStamp + ".png";

		File finalDestination = new File(destination);
		FileHandler.copy(screenShot, finalDestination); // copying the screenShot to finalDesitination
		}

}
