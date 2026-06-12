package constent;


// the values are never change during the exceution of the project are declared in the Constent class
public class Constent {
	
	public static final String CONFIGFILE = System.getProperty("user.dir")+"\\src\\main\\resources\\Config.property";
	
	public static final String TESTDATA = System.getProperty("user.dir")+"\\src\\test\\resources\\GroceryTestData.xlsx";
	
	public static final String VALIDCREDENTIALERROR = "User is unable to login with valid credentials";
	
	public static final String INVALIDCREDENTIALERROR = "User is able to login with invalid credentials";
	
	public static final String INVALIDUSERNAMEERROR = "User is able to login with invalid username";
	
	public static final String INVALIDPASSWORDERROR =  "User is able to login with invalid password";
	
	public static final String UNSUCCESSFULLLOGOUT = "User is unable to logout";
	
	public static final String USERCREATEERROR = "User is able to create an new admin user";
	
	public static final String SEARCHUSERERROR = "Username is not matching";
	
	public static final String CONTACTUPDATEERROR = "User is not able to update manage contact";
	
	public static final String ADDNEWSERROR = "User is not able to add new News";
	
	public static final String SEARCHNEWSERROR =  "Search result is not matching";

}
