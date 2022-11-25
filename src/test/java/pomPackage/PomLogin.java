package pomPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseHRMClass;

public class PomLogin extends BaseHRMClass {
	

	@FindBy(css="#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div:nth-child(2) > div > div:nth-child(2) > input")
	WebElement Username;
	
	@FindBy(css="#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div:nth-child(3) > div > div:nth-child(2) > input")
	WebElement Password;
	
	@FindBy(css="#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div.oxd-form-actions.orangehrm-login-action > button")
	WebElement Loginbt;
	
	//initiate page elements
	public PomLogin() {
		
		PageFactory.initElements(driver, this);
		
	}
	//Takes username parameter and types it in username
	public void typeusername(String name) {
		
		Username.sendKeys(name);
	}
	
	//Takes password parameter and types it in password
	public void typepassword(String pass) {
		Password.sendKeys(pass);
	}
	
	//Clicks login button
	public void clickbtn() {
		Loginbt.click();
	}
	
	public String verify() {
		
		return driver.getTitle();
	}
	
	
}
