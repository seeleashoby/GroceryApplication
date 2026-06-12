package testScript;



import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constent.Constent;
import groceryPages.HomePage;
import groceryPages.LoginPage;
import utilities.ExcelUtility;


import org.testng.Assert;

public class LoginTest extends GroceryBase{
	
	/*Assertion - Already passed test cases are revalidating and there are two types of assertion
	 * 1. Soft Assertion - soft assertion class needs to create an object to use the 3 methods and assertall method should be declraed first then only we can use the three methods 
	 * 2. Hard Assertion	- simple
	 * 
	 * Three methods using are :
	 * 1. assertTrue
	 * 2. asssertFalse
	 * 3. assertEquals
	 * 
	 * assertTure and AssertFalse can only used along with the isDispaled, isSelected, isEnabled methods
	 */
	
	//priority is used to proorities the test cases
	//description is used to describe the test case
	
	/* Gouping is used to run few testcases together there are 3 types of grouping
	 * 1. smoke -- used to test critical funtionality of application
	 * 2. sannity -- used to test newly updated features or test the edited module to fix a bug
	 * 3. regression -- if we add a feature or fixing a bug testing the other features in the application is effected or not 
	 */
	
	HomePage home;

@Test (priority = 1, description = "User is trying to login with valid credentials", groups = {"smoke"})
public void verifyloginusingvalidcredentials() throws IOException
{
	String usernamevalue = ExcelUtility.readStringData(0, 0, "GroceryLogin");
	String passwordvalue = ExcelUtility.readStringData(0, 1, "GroceryLogin");
	LoginPage l = new LoginPage(driver);
	l.enterUsernamefield(usernamevalue).enterPasswordfield(passwordvalue);
	home=l.signupButtonClick();
	boolean dashboardValue= l.dashboardDisplyed();
	Assert.assertTrue(dashboardValue, Constent.VALIDCREDENTIALERROR);
	
	
}

@Test (priority = 2,  description = "User is trying to login with invalid credentials", retryAnalyzer=retry.Retry.class)
public void verifloginusinginvalidcredentails() throws IOException
{
	String usernamevalue = ExcelUtility.readStringData(1, 0, "GroceryLogin");
	String passwordvalue = ExcelUtility.readStringData(1, 1, "GroceryLogin");
	LoginPage l = new LoginPage(driver);
	l.enterUsernamefield(usernamevalue).enterPasswordfield(passwordvalue).signupButtonClick();
	String actual = l.VerifyloginTextisDisplayed();
	String expected = "7rmart supermarket";
	Assert.assertEquals(actual, expected,Constent.INVALIDCREDENTIALERROR);
}

@Test (priority = 3,  description = "User is trying to login with invalid username")
public void verifyloginusinginvalidusername() throws IOException
{
	String usernamevalue = ExcelUtility.readStringData(2, 0, "GroceryLogin");
	String passwordvalue = ExcelUtility.readStringData(2, 1, "GroceryLogin");
	LoginPage l = new LoginPage(driver);
	l.enterUsernamefield(usernamevalue).enterPasswordfield(passwordvalue).signupButtonClick();
	String actual = l.VerifyloginTextisDisplayed();
	String expected = "7rmart supermarket";
	Assert.assertEquals(actual, expected,Constent.INVALIDUSERNAMEERROR);
}

@Test (priority = 4,  description = "User is trying to login with invalid password", groups = {"smoke"}, dataProvider = "loginProvider")
public void verifyloginusinginvalidpassword(String usernamevalue, String passwordvalue) throws IOException
{
	//String usernamevalue = ExcelUtility.readStringData(3, 0, "GroceryLogin");
	// passwordvalue = ExcelUtility.readStringData(3, 1, "GroceryLogin");
	LoginPage l = new LoginPage(driver);
	l.enterUsernamefield(usernamevalue).enterPasswordfield(passwordvalue).signupButtonClick();
	String actual = l.VerifyloginTextisDisplayed();
	String expected = "7rmart supermarket";
	Assert.assertEquals(actual, expected, Constent.INVALIDPASSWORDERROR);
}

//Dataprovider is used to get data or pass the values other than excel it is a anotation provided by the TestNG
@DataProvider(name = "loginProvider")
public Object[][] getDataFromDataProvider()
{
	return new Object[][] 
	{
		new Object[] {"admin", "admin22"}, new Object[] {"admin123", "123"}, 
	};
}
}
