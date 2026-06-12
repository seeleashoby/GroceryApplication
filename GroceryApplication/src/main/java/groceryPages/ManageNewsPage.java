package groceryPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	
public WebDriver driver;
	
	
	public ManageNewsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); //to initialize the driver using initElements methid from PageFactory a predefined interface
		
	}
	
	@FindBy(xpath="//a[@onclick='click_button(1)']") WebElement newButton;
	@FindBy(name="news") WebElement addNews;
	@FindBy(name="create") WebElement saveButton;
	@FindBy(xpath="//div[contains(@class,'alert alert-success alert-dismissible')]") WebElement successAlert;
	@FindBy(xpath="//a[@onclick='click_button(2)']") WebElement searchButton;
	@FindBy(name="un") WebElement searchnewsText;
	@FindBy(name="Search") WebElement finalSearchButton;
	@FindBy(xpath="//table//tbody//tr[1]//td[1]") WebElement firstRowNews;
	
	public ManageNewsPage newButtonClick()
	{
		newButton.click();
		return this;
	}
	
	public ManageNewsPage enterNews(String addNewsValue)
	{
		addNews.sendKeys(addNewsValue);
		return this;
	}
	
	public ManageNewsPage saveButtonClick()
	{
		saveButton.click();
		return this;
	}
	
	public boolean successAlertDisplayedorNot()
	{
	    return successAlert.isDisplayed();
	}
	
	public ManageNewsPage searchButtonClick()
	{
		searchButton.click();
		return this;
	}
	
	public ManageNewsPage searchNews(String searchnewsTextValue)
	{
		searchnewsText.sendKeys(searchnewsTextValue);
		return this;
	}
	
	public ManageNewsPage finalSearchButtonClick()
	{
		finalSearchButton.click();
		return this;
	}
	
	public String getFirstRowNews()
	{
	    return firstRowNews.getText();
	}
}
