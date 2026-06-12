package groceryPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageContactPage {

	
public WebDriver driver;
	
	
	public ManageContactPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); //to initialize the driver using initElements methid from PageFactory a predefined interface
		
	}
	
	@FindBy(xpath="//i[@class='fas fa-edit']") WebElement edit;
	@FindBy(id="phone") WebElement phoneNumber;
	@FindBy(id="email") WebElement email;
	@FindBy(id="content") WebElement address;
	@FindBy(name="Update") WebElement update;
	@FindBy(xpath="//div[contains(@class,'alert-success')]") WebElement successAlert;
	
	public ManageContactPage editButtonClick()
	{
		edit.click();
		return this;
	}
	public ManageContactPage enterPhoneNumber(String phonenumberValue)
	{
		phoneNumber.clear();
		phoneNumber.sendKeys(phonenumberValue);
		return this;
	}
	
	public ManageContactPage enterEmailId(String emailValue)
	{
		email.clear();
		email.sendKeys(emailValue);
		return this;
	}
	
	public ManageContactPage enterAddress(String addressValue)
	{
		address.clear();
		address.sendKeys(addressValue);
		return this;
		
	}
	public ManageContactPage updatebuttonClick()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", update);
		js.executeScript("window.scrollBy(0,350)", "");
		return this;
	}
	public boolean successAlertDisplayedorNot()
	{
	    return successAlert.isDisplayed();
	}
}
