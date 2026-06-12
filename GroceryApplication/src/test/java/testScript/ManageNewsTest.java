package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constent.Constent;
import groceryPages.HomePage;
import groceryPages.LoginPage;
import groceryPages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends GroceryBase {
	HomePage gh ;
	ManageNewsPage mn ;

	@Test(description = "User is trying to add a news in manage news page")
	public void verifyUserisAbleToAddNews() throws IOException {
		String usernamevalue = ExcelUtility.readStringData(0, 0, "GroceryLogin");
		String passwordvalue = ExcelUtility.readStringData(0, 1, "GroceryLogin");
		LoginPage l = new LoginPage(driver);
		l.enterUsernamefield(usernamevalue).enterPasswordfield(passwordvalue);
		gh=l.signupButtonClick();
		mn=gh.ManageNewMoreInfoClick();
		String addNewNews = ExcelUtility.readStringData(0, 0, "News");
		mn.newButtonClick().enterNews(addNewNews).saveButtonClick();

		boolean alertValue = mn.successAlertDisplayedorNot();
		Assert.assertTrue(alertValue, Constent.ADDNEWSERROR);
	}

	@Test(description = "User is trying to search for a news")
	public void verifytheAddedNewscanfindbySearch() throws IOException {
		String usernamevalue = ExcelUtility.readStringData(0, 0, "GroceryLogin");
		String passwordvalue = ExcelUtility.readStringData(0, 1, "GroceryLogin");
		LoginPage l = new LoginPage(driver);
		l.enterUsernamefield(usernamevalue).enterPasswordfield(passwordvalue);
		gh=l.signupButtonClick();
		mn=gh.ManageNewMoreInfoClick();
		String searchaddedNews = ExcelUtility.readStringData(0, 0, "News");
		mn.searchButtonClick().searchNews(searchaddedNews).finalSearchButtonClick();

		String actualNews = mn.getFirstRowNews();
		Assert.assertEquals(actualNews, searchaddedNews, Constent.SEARCHNEWSERROR);
	}

}
