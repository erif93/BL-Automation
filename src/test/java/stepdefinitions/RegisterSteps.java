package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Login;
import pages.Register;

public class RegisterSteps {
	
	private WebDriver driver = Hooks.driver;
	private static WebDriverWait wait;
	
	public RegisterSteps() {
		
		this.wait = new WebDriverWait(driver, 3);
	}
	
	Register register;
	Login login;

	@Given("^I go to bukalapak register page$")
	public void goToRegister() {
		
		register= new Register(driver,wait);
		register.clickDaftarInHome();
	}
	
	@When("^I input invalid email$")
	public void setInvalidEmail() {
		
		register= new Register(driver,wait);
		register.setRegisterEmail("asdfgh");
	}
	
	@When("^I input empty email$")
	public void setEmptyEmail() {
		
		register= new Register(driver,wait);
		register.setRegisterEmail("");
	}
	
	@When("^I input valid email$")
	public void setValidEmail() {
		
		register= new Register(driver,wait);
		register.setRegisterEmail("test999@gmail.com");
	}
	
	@And("^I click daftar$")
	public void clickDaftar() {
		
		register= new Register(driver,wait);
		register.clickRegister();
	}
	
	@And("^I click kirim kode$")
	public void sentCode() {
		
		register = new Register(driver,wait);
		register.clickSentCode();
	}
	
	@Then("^verification page should be displayed$")
	public void validateVerifcationPage() {
		
		register= new Register(driver,wait);
		register.verifyAccountValid();
	}

}
