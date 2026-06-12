package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {

	public void selectDragDropWithValue(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByValue(value);
	}

	public void SelectDragandDropwithVisibleIndex(WebElement element, int value) {
		Select object = new Select(element);
		object.selectByIndex(value);
	}

	public void SelectDragandDropwithVisibleText(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByVisibleText(value);
	}

	public void javascriptClick(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void scrollToElement(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
	}

}
