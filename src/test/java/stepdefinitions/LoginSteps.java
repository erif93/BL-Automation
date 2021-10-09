package stepdefinitions;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Login;

public class LoginSteps {
	
	private WebDriver driver = Hooks.driver;
	private static WebDriverWait wait;
	
	public LoginSteps() {
		
		this.wait = new WebDriverWait(driver, 3);
	}
	
	Login login;

	@Given("^I go to login page$")
	public void goToLogin() {
		
		login = new Login(driver,wait);
		login.clickLogin();
	}
	
	@When("^I input correct email$")
	public void setEmail() {
		
		login = new Login(driver,wait);
		login.setUsername("erifaisol93@gmail.com");
	}
	
	@When("^I input unregistered email$")
	public void setUnregisteredEmail() {
		
		login = new Login(driver,wait);
		login.setUsername("test55@gmail.com");
	}
	
	@When("^I not input username$")
	public void inputEmptyUsername() {
		
		login = new Login(driver,wait);
		login.setUsername("");
	}
	
	@And("^I input correct password$")
	public void setPassword() {
		
		login = new Login(driver,wait);
		login.setPassword("test@126");
	}
	
	@And("^I input wrong password$")
	public void setWrongPassword() {
		
		login = new Login(driver,wait);
		login.setPassword("test123");
	}
	
	@And("^I not input password$")
	public void setEmptyPassword() {
		
		login = new Login(driver,wait);
		login.setPassword("");
	}
	
	@And("^I click lanjut$")
	public void clickLanjut() {
		
		login = new Login(driver,wait);
		login.clickLanjut();
	}
	
	@And("^I click login$")
	public void clickLogin() {
		
		login = new Login(driver,wait);
		login.clickSignIn();
	}
	
	@Then("^I can login into bukalapak page$")
	public void validateLoginPage() {
		
		login = new Login(driver,wait);
		login.verifySuccessLogin();
	}
	
	@Then("^Error message should be displayed$")
	public void verifyErrMsg() {
		
		login = new Login(driver,wait);
		login.verifyErrorMessage();
	}
	
}
