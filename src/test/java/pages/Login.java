package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.BaseTest;

public class Login extends BaseTest {
	
	
	public Login (WebDriver driver, WebDriverWait wait) {
		
		 super(driver, wait);
		 PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css=".te-header-login")
	WebElement btnLoginHome;
	
	@FindBy(id="user_identity_textfield")
	WebElement  txtUsername;
	
	@FindBy(id="input-password")
	WebElement txtPassword;
	
	@FindBy(id="submit_button")
	WebElement btnLanjut;
	
	@FindBy(id="btn-login")
	WebElement btnLogin;
	
	@FindBy(css=".bl-badge__content.bl-badge__content--small.bl-badge__content--navy")
	WebElement iconChart;
	
	@FindBy(css=".bl-text.bl-text--caption.bl-text--error")
	WebElement errMsg;
	
	
	public void clickLogin() {
		
		waitUntilElementVisible(btnLoginHome);
		waitUntilElementClickable(btnLoginHome);
		btnLoginHome.click();
	}
	
	public void setUsername(String name) {
		
		waitUntilElementVisible(txtUsername);
		txtUsername.sendKeys(name);
	}
	
	public void setPassword(String pass) {
		
		waitUntilElementVisible(txtPassword);
		txtPassword.sendKeys(pass);
	}
	
	public void clickLanjut() {
		
		waitUntilElementVisible(btnLanjut);
		btnLanjut.click();
	}
	
	public void clickSignIn() {
		
		waitUntilElementVisible(btnLogin);
		btnLogin.click();
	}
	
	public boolean verifySuccessLogin() {
		
		waitUntilElementVisible(iconChart);
		return iconChart.isDisplayed();
	}
	
	public boolean verifyErrorMessage() {
		
		waitUntilElementVisible(errMsg);
		return errMsg.isDisplayed();
	}
	
	public boolean verifyMainLoginPage() {
		
		waitUntilElementVisible(txtUsername);
		return txtUsername.isDisplayed();
	}
	
	

}
