package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.BaseTest;

public class Register extends BaseTest {
	
	public Register(WebDriver driver, WebDriverWait wait) {
		 super(driver,wait);
		 PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="a.pr-4.sigil-header__nav.bl-link.is-hide-underline")
	WebElement btnDaftarHome;
	
	@FindBy(css=".bl-button--primary")
	WebElement btnDaftar;
	
	@FindBy(css=".bl-text-field__input")
	WebElement txtboxEmail;
	
	@FindBy(css=".mb-8.bl-button.bl-button--primary.bl-button--medium.bl-button--block")
	WebElement btnKirimKode;
	
	@FindBy(css=".bl-text--subheading-3")
	WebElement titleVerification;
	
	public void setRegisterEmail(String mail) {
		
		waitUntilElementVisible(txtboxEmail);
		txtboxEmail.sendKeys(mail);
	}
	
	public void clickDaftarInHome() {
		
		waitUntilElementClickable(btnDaftarHome);
		btnDaftarHome.click();
	}
	
	public void clickRegister() {
		
		btnDaftar.click();
	}
	
	public void clickSentCode() {
		
		waitUntilElementClickable(btnKirimKode);
		btnKirimKode.click();
	}
	
	public boolean verifyAccountValid() {
		
		waitUntilElementVisible(titleVerification);
		return titleVerification.isDisplayed();
	}

}
