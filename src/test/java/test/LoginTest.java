package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest {

	@Test
	public void verifyLogin() {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("https://the-internet.herokuapp.com/login");
			driver.manage().window().maximize();
			LoginPage page = new LoginPage(driver);
			page.enterUsername("tomsmith");
			page.enterPassword("SuperSecretPassword!");
			page.clickonLogin();

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(
					ExpectedConditions.textToBePresentInElementLocated(By.id("flash"), "You logged into a secure area!"));

			Assert.assertTrue(page.getMessage().contains("You logged into a secure area!"));
			System.out.println("login successfully");
		} finally {
			driver.quit();
		}

	}

}
