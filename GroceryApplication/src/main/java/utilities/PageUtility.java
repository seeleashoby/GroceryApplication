package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	public void selectDragDropWithValue(WebElement element, String value) {
		Select object=new Select(element);
		object.selectByValue(value);
	}
	
	public void SelectDragandDropwithVisibleIndex(WebElement element, int value)
	{
		Select object=new Select(element);
		object.selectByIndex(value);
	}
	
	public void SelectDragandDropwithVisibleText(WebElement element, String value)
	{
		Select object=new Select(element);
		object.selectByVisibleText(value);
	}

}
