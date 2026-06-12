package groceryPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
public WebDriver driver;
	
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); //to initialize the driver using initElements methid from PageFactory a predefined interface
		
	}
	
	@FindBy(xpath="//a[@data-toggle='dropdown']") WebElement admin; 
	@FindBy(xpath = "//a[contains(@href,'logout')]") WebElement logout;
	@FindBy(xpath="//p[contains(text(),'Admin Users')]/following::a[contains(text(),'More info')][1]") WebElement moreInfo;
	@FindBy(xpath="//h1[@class='m-0 text-dark']") WebElement adminusersText;
	@FindBy(xpath="//p[contains(text(),'Manage Contact')]/parent::div/following-sibling::a") WebElement manageContactMoreInfo;
	@FindBy(xpath="//p[text()='Manage News']/ancestor::div[contains(@class,'small-box')]//a") WebElement manageNewMoreInfo;
	
	public HomePage adminClick()
	{
		admin.click();
		return this;
	}
	
	public LoginPage logoutClick()
	{
		logout.click();
		return new LoginPage(driver);
	}
	
	public AdminUsersPage moreInfoClick()
	{
		moreInfo.click();
		return new AdminUsersPage(driver);
	}
	
	public String VerifyAdminUsersTextDisplayed()
	{
		return adminusersText.getText();
	}
	
	public ManageContactPage ManageContactMoreInfoClick()
	{
		manageContactMoreInfo.click();
		return new ManageContactPage(driver);
	}
	
	public ManageNewsPage ManageNewMoreInfoClick()
	{
		manageNewMoreInfo.click();
		return new ManageNewsPage(driver);
	}
}
