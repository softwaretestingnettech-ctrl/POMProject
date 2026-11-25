package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver d;
	// locators
	By username = By.id("username");
	By passowrd = By.id("password");
	By login = By.xpath("//button[@type='submit']");
	By message = By.id("flash");

	// methods

	public void enterUsername(String u) {
		d.findElement(username).sendKeys(u);
	}

	public void enterPassword(String p) {
		d.findElement(passowrd).sendKeys(p);
	}

	public void clickonLogin() {
		d.findElement(login).click();
	}
	
	public String getMessage()
	{
		return d.findElement(message).getText();
		
	}
	public LoginPage(WebDriver d) {
		this.d = d;
	}

}
