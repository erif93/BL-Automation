package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Search;

public class SearchSteps {
	
	private WebDriver driver = Hooks.driver;
	private WebDriverWait wait;
	
	public SearchSteps() {
		
		this.wait = new WebDriverWait(driver, 3);
	}
	
	Search search;
	
	@Given("^I search a product$")
	public void searchProduct() {
		
		search = new Search(driver,wait);
		search.setSearchItem("macbook");
	}
	
	@Given("^I search unavailable product$")
	public void searchUnavailableProduct() {
		
		search = new Search(driver,wait);
		search.setSearchItem("zxcvbn");
	}
	
	@When("^I click search icon$")
	public void clickIconSearch() {
		
		search = new Search(driver,wait);
		search.clickIconSearch();
	}
	
	@Then("^I verify my search result$")
	public void verifyAvailableSearchItem() {
		
		search = new Search(driver,wait);
		search.verifySearchItem("macbook");
	}
	
	@Then("^I verify not found$")
	public void verifyNotFound() {
		
		search = new Search(driver,wait);
		search.verifyItemNotFound();
	}

}
