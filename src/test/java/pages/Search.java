package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.BaseTest;

public class Search extends BaseTest  {
	
	
	public Search(WebDriver driver, WebDriverWait wait) {
		 super(driver,wait);
		 PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="v-omnisearch__input")
	WebElement txtboxSearch;
	
	@FindBy(css="button.v-omnisearch__submit")
	WebElement btnSearch;
	
	@FindBy(css="p.bl-text.bl-text--body-small.bl-text--ellipsis__2")
	List<WebElement> textItem;
	
	@FindBy(css=".mb-8.bl-text.bl-text--subheading-1")
	WebElement txtNotFound;
	
	public void setSearchItem(String item) {
		
		txtboxSearch.sendKeys(item);
	}
	
	public void clickIconSearch() {
		
		waitUntilElementVisible(btnSearch);
		btnSearch.click();
	}
	
	public void clickProduct(int index) {
		
		waitAllElementVisible(textItem);
		textItem.get(index).click();
	}
	
	public boolean verifySearchItem(String expectedText) {
		
		waitAllElementVisible(textItem);
		String result = textItem.get(0).getText();
		System.out.println(result);
		boolean flag = false;
		
		if(result.contains(expectedText)) {
			
			flag = true;
			
		}
		
		return flag;
	}
	
	public boolean verifyItemNotFound() {
		
		waitUntilElementVisible(txtNotFound);
		return txtNotFound.isDisplayed();
	}
	
	
	

}
