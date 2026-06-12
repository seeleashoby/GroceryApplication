package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constent.Constent;
import groceryPages.HomePage;
import groceryPages.LoginPage;
import groceryPages.ManageContactPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class ManageContactTest extends GroceryBase {
	
	HomePage gh;
	ManageContactPage mc;

	@Test(description = "User is trying to edit the manage contact details like phone number, email, address")
	public void verirytheuserabletoEditManageContactDetails() throws IOException {
		String usernamevalue = ExcelUtility.readStringData(0, 0, "GroceryLogin");
		String passwordvalue = ExcelUtility.readStringData(0, 1, "GroceryLogin");
		LoginPage l = new LoginPage(driver);
		l.enterUsernamefield(usernamevalue).enterPasswordfield(passwordvalue);
		gh=l.signupButtonClick();
		RandomDataUtility rd = new RandomDataUtility();
		String phonenumberValue = rd.generatePhoneNumber();
		String emailValue = rd.generateEmailId();
		String addressValue = ExcelUtility.readStringData(0, 0, "Address");
		mc=gh.ManageContactMoreInfoClick();
		mc.editButtonClick().enterPhoneNumber(phonenumberValue).enterEmailId(emailValue).enterAddress(addressValue).updatebuttonClick();

		boolean alertValue = mc.successAlertDisplayedorNot();
		Assert.assertTrue(alertValue, Constent.CONTACTUPDATEERROR);

	}

}
