package utility;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseTest {
	
	
	private static WebDriver driver;
	private static WebDriverWait wait;

	
	public BaseTest(WebDriver driver, WebDriverWait wait) {
		
			BaseTest.driver=driver;
			BaseTest.wait=wait;
	}
		
	protected void waitUntilElementVisible(WebElement element) {
		
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	protected void waitUntilElementClickable(WebElement element) {
		
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	protected void waitAllElementVisible(List<WebElement> elements) {
		
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}


}
