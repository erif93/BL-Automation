package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Login;
import pages.Search;
import pages.Shop;

public class ShopSteps {
	
	private WebDriver driver = Hooks.driver;
	private WebDriverWait wait;
	
	Shop shop;
	Search search;
	Login login;
	
	public ShopSteps() {
		
		this.wait = new WebDriverWait(driver, 3);
	}
	
	@Given("^I am not login into buka lapak website$")
	public void validateNotLogin() {
		shop = new Shop(driver,wait);
		shop.verifyNotLogin();
	}
	
	@Given("^I already login$")
	public void login() {
		login = new Login(driver,wait);
		login.clickLogin();
		login.setUsername("erifaisol93@gmail.com");
		login.clickLanjut();
		login.setPassword("test@126");
		login.clickSignIn();
	}
	
	
	
	@When("^I navigate to product detail page$")
	public void goToProductDetailPage() {
		search= new Search(driver,wait);
		search.setSearchItem("macbook");
		search.clickIconSearch();
		search.clickProduct(0);
	}
	
	@And("^I click add to cart$")
	public void addToCart() {
		shop = new Shop(driver,wait);
		shop.clickAddToCart();
	}
	
	
	@Then("^Login page should be displayed$")
	public void validate() {
		login= new Login(driver,wait);
		login.verifyMainLoginPage();
				
	}
	
	@Then("^product successfully added into chart$")
	public void verifySuccessAdded() {
		shop = new Shop(driver,wait);
		shop.verifyItemAdded();
	}
}
