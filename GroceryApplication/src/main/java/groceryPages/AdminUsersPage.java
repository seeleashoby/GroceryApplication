package groceryPages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import utilities.PageUtility;


public class AdminUsersPage {
public WebDriver driver;
	PageUtility p = new PageUtility ();
	
	public AdminUsersPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); //to initialize the driver using initElements methid from PageFactory a predefined interface
		
	}
	
	@FindBy(xpath="//a[@onclick='click_button(1)']") WebElement newButton;
	@FindBy(id="username") WebElement adminUsername;
	@FindBy(id="password") WebElement adminPassword;
	@FindBy(name="user_type") WebElement userType;
	@FindBy(name="Create") WebElement save;
	@FindBy(xpath="//h5[text()=' Alert!']") WebElement alert;
	@FindBy(xpath="//a[@onclick='click_button(2)']") WebElement search;
	@FindBy(id="un") WebElement searchUsername;
	@FindBy(id="ut") WebElement searchUserType;
	@FindBy(name="Search") WebElement searchResult;
	@FindBy(xpath="//table//tbody//tr[1]//td[1]") WebElement searchedUsername;

	public AdminUsersPage newButtonclick()
	{
		newButton.click();
		return this;
	}
	public AdminUsersPage enterAdminUsernamefield(String adminusernamevalue)
	{
		adminUsername.sendKeys(adminusernamevalue);
		return this;
	}
	public AdminUsersPage enterAdminUserPasswordfield(String adminpasswordvalue)
	{
		adminPassword.sendKeys(adminpasswordvalue);
		return this;
	}
	public AdminUsersPage selectUserType()
	{
		p.SelectDragandDropwithVisibleText(userType, "Admin");
		//Select s = new Select(userType);
		//s.selectByVisibleText("Admin");
		return this;
	}
	public AdminUsersPage saveButtonClick()
	{
		save.click();
		return this;
		 
	}
	
	public boolean verifyAlertisDisplayedorNot()
	{
		return alert.isDisplayed();
	}
	public AdminUsersPage searchButtonclick()
	{
		
		search.click();
		return this;
		
	}
	public AdminUsersPage enterSearchUsername(String searchUsernameValue)
	{
		searchUsername.sendKeys(searchUsernameValue);
		return this;
	}
	public AdminUsersPage searchforUserType()
	{
		p.SelectDragandDropwithVisibleText(searchUserType, "Admin");
		//Select s = new Select(searchUserType);
		//s.selectByVisibleText("Admin");
		return this;
	}
	
	public AdminUsersPage searchResultButtonClick()
	{
		searchResult.click();
		return this;
	}
	public String getSearchedUsername()
	{
	    return searchedUsername.getText();
	}
	
}
