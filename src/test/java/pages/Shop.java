package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.BaseTest;

public class Shop extends BaseTest {
	

	public Shop(WebDriver driver, WebDriverWait wait) {
		 super(driver,wait);
		 PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".c-main-product__action__cart")
	WebElement btnAddToCart;
	
	@FindBy(css=".c-main-product__title")
	WebElement productTitle;
	
	@FindBy(css=".c-cart-dialog__item")
	List<WebElement> listChartItem;
	
	@FindBy(css="a.pr-4.sigil-header__nav.bl-link.is-hide-underline")
	WebElement btnDaftar;
	
	public void clickAddToCart() {
		
		waitUntilElementVisible(btnAddToCart);
		btnAddToCart.click();
	}
	
	public boolean verifyItemAdded() {
		
		waitUntilElementVisible(productTitle);
		String title= productTitle.getText();
		boolean flag = false;
		waitAllElementVisible(listChartItem);
		
		for(int a=0; a<listChartItem.size();a++) {
			
			String textInChart= listChartItem.get(a).getText();
			
			if(textInChart.contains(title)) {
				
				flag = true;
			}
		}
		
		return flag;
	}
	
	public void verifyNotLogin() {
		
		waitUntilElementVisible(btnDaftar);
		btnDaftar.isDisplayed();
	}

	
	

}
