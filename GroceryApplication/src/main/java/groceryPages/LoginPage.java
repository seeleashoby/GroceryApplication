package groceryPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage {
	
	
	WaitUtility w = new WaitUtility();
	
public WebDriver driver;
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); //to initialize the driver using initElements methid from PageFactory a predefined interface
		
	}
	@FindBy(name ="username") WebElement enterusername;
	@FindBy(name="password") WebElement enterpassword;
	@FindBy(xpath = "//button[text()='Sign In']") WebElement signup;
	@FindBy(xpath ="//p[text()='Dashboard']") WebElement dashboard;
	@FindBy(xpath="//b[text()='7rmart supermarket']") WebElement loginPageText;
	
	
	public LoginPage enterUsernamefield(String usernamevalue)
	{
		enterusername.sendKeys(usernamevalue);
		return this;
	}
	public LoginPage enterPasswordfield(String passwordvalue)
	{
		enterpassword.sendKeys(passwordvalue);
		return this;
	}
	public HomePage signupButtonClick()
	{
		w.waitUntilelementToBeClickable(driver, signup);
		signup.click();
		return new HomePage(driver);
	}
	public boolean dashboardDisplyed()
	{
		return dashboard.isDisplayed();
	}
	
	public String VerifyloginTextisDisplayed()
	{
		return loginPageText.getText();
	}
	
}
