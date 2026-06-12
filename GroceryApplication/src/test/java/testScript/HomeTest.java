package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constent.Constent;
import groceryPages.HomePage;
import groceryPages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends GroceryBase{
	HomePage gh;
	
	@Test (description = "User is trying to logout")
	public void verifywetheruserisabletosuccessfulltlogout() throws IOException
	{
		String usernamevalue = ExcelUtility.readStringData(0, 0, "GroceryLogin");
		String passwordvalue = ExcelUtility.readStringData(0, 1, "GroceryLogin");
		LoginPage l = new LoginPage(driver);
		l.enterUsernamefield(usernamevalue).enterPasswordfield(passwordvalue);
		gh=l.signupButtonClick();
		
		
		gh.adminClick();
		l=gh.logoutClick();
		
		String actual = l.VerifyloginTextisDisplayed();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constent.UNSUCCESSFULLLOGOUT);
		
	}
	
	

}
