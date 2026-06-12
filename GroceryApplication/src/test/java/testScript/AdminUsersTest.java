package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constent.Constent;
import groceryPages.AdminUsersPage;
import groceryPages.HomePage;
import groceryPages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUsersTest extends GroceryBase{
	
	AdminUsersPage a;
	HomePage gh;
	@Test (description = "User is trying to add new user")
	public void verifytheUserisabletoAddNewAdminUser() throws IOException
	{
		
		String usernamevalue = ExcelUtility.readStringData(0, 0, "GroceryLogin");
		String passwordvalue = ExcelUtility.readStringData(0, 1, "GroceryLogin");
		LoginPage l = new LoginPage(driver);
		l.enterUsernamefield(usernamevalue).enterPasswordfield(passwordvalue);
		gh=l.signupButtonClick();
		a=gh.moreInfoClick();
		RandomDataUtility rd = new RandomDataUtility();
		String adminusernamevalue = rd.generateRandomUsername();
		String adminpasswordvalue = rd.generateRandomPaswword();
		a.newButtonclick().enterAdminUsernamefield(adminusernamevalue).enterAdminUserPasswordfield(adminpasswordvalue).selectUserType().saveButtonClick();
		boolean alertValue= a.verifyAlertisDisplayedorNot();
		Assert.assertTrue(alertValue, Constent.USERCREATEERROR);
	}
	
	@Test(description = "User is trying to search newly added user")
	public void verifySearchNewlyAddedAdminUser() throws IOException
	{
		
		String usernamevalue = ExcelUtility.readStringData(0, 0, "GroceryLogin");
		String passwordvalue = ExcelUtility.readStringData(0, 1, "GroceryLogin");
		LoginPage l = new LoginPage(driver);
		l.enterUsernamefield(usernamevalue).enterPasswordfield(passwordvalue);
		gh=l.signupButtonClick();
		a=gh.moreInfoClick();
		String searchUsernameValue = ExcelUtility.readStringData(0, 0, "AdminUsers");
		a.searchButtonclick().enterSearchUsername(searchUsernameValue).searchforUserType().searchResultButtonClick();
		String actualUsername = a.getSearchedUsername();
		Assert.assertEquals(actualUsername, searchUsernameValue, Constent.SEARCHUSERERROR);
	}

}
