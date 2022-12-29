package tests;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import AutomationProject.DemoQA.CheckoutPage;
import AutomationProject.DemoQA.HomePage;

public class CheckoutPageTest {
	
	private static WebDriver driver = null;
	
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test

	public static void testIncorectCodeMessage() {

		String messageInvalidCode = "Invalid code ..!";
		String promocode = "Marina";
		HomePage.goToHomePage(driver);
		HomePage.clickOnAddToCart(driver);
		HomePage.clickOnCart(driver);
		HomePage.clickOnProceedToCheckout(driver);
		CheckoutPage.enterPromoCode(driver, promocode);
		CheckoutPage.clickOnApply(driver);
		CheckoutPage.waitMessageInvalidCode(driver);

		assertEquals(CheckoutPage.getMessageInvalidCode(driver), messageInvalidCode);
	}

	@Test
	public static void testPlaceOrderSuccessful() {

		String country = "Argentina";
		String successfulOrderMessage = "Thank you, your order has been placed successfully\nYou'll be redirected to Home page shortly!!";

		HomePage.goToHomePage(driver);
		HomePage.clickOnAddToCart(driver);
		HomePage.clickOnCart(driver);
		HomePage.clickOnProceedToCheckout(driver);
		CheckoutPage.clickOnPlaceOrder(driver);
		CheckoutPage.selectCountry(driver, country);
		CheckoutPage.clickOnCheckBoxTermConditions(driver);
		CheckoutPage.clickOnProceedButton(driver);

		assertEquals(CheckoutPage.getSuccessfulOrderMessage(driver), successfulOrderMessage);
	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}

}
