package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import AutomationProject.DemoQA.CheckoutPage;
import AutomationProject.DemoQA.HomePage;

public class HomePageTests {

	private static WebDriver driver = null;

	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public static void testCheckoutPage() {

		String expectedURL = "https://rahulshettyacademy.com/seleniumPractise/#/cart";

		HomePage.goToHomePage(driver);
		HomePage.clickOnAddToCart(driver);
		HomePage.clickOnCart(driver);
		HomePage.clickOnProceedToCheckout(driver);

		assertEquals(driver.getCurrentUrl(), expectedURL);
	}

	@Test
	public static void testTermsConditionslink() {

		String expectedURL = "https://rahulshettyacademy.com/seleniumPractise/#/policy";

		HomePage.goToHomePage(driver);
		HomePage.clickOnAddToCart(driver);
		HomePage.clickOnCart(driver);
		HomePage.clickOnProceedToCheckout(driver);
		CheckoutPage.clickOnPlaceOrder(driver);
		CheckoutPage.clickOnTermsAndConditionsLink(driver);		
		
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));
		
		assertEquals(driver.getCurrentUrl(), expectedURL);
	}

	@Test
	public static void testBackToHomePage() {

		String expectedURL = "https://rahulshettyacademy.com/seleniumPractise/#/";

		HomePage.goToHomePage(driver);
		HomePage.clickOnAddToCart(driver);
		HomePage.clickOnCart(driver);
		HomePage.clickOnProceedToCheckout(driver);
		CheckoutPage.clickOnPlaceOrder(driver);
		CheckoutPage.clickOnTermsAndConditionsLink(driver);
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));	
		HomePage.clickOnHomeLink(driver);
		
        assertTrue(HomePage.isCartPresent(driver));
		assertEquals(driver.getCurrentUrl(), expectedURL);
	}

	@Test
	public static void testInputInSearchBar() {

		String item = "brocolli";
		HomePage.goToHomePage(driver);
		HomePage.inputSearchFields(driver, item);
		HomePage.clickOnSearchButton(driver);
		boolean a = HomePage.isChosenItemPresent(driver);
		
		assertTrue(a, "Chosen item is not present!");
	}

	@Test
	public static void testAddItem() {
		HomePage.goToHomePage(driver);
		HomePage.clickOnAddToCart(driver);
		String quantity = HomePage.getQuantity(driver);
		String price = HomePage.getPrice(driver);

		assertEquals(quantity, "1");
		assertEquals(price, "120");

	}

	@Test

	public static void testRemovedItems() {
		HomePage.goToHomePage(driver);
		HomePage.clickOnAddToCart(driver);
		HomePage.clickOnCart(driver);
		HomePage.clickOnRemove(driver);
		boolean a = HomePage.isEmtyCartPresent(driver);
		
		assertTrue(a, "Cart is not empty!");
	}

	@Test
	public static void testAddedNotification() {
		HomePage.goToHomePage(driver);
		HomePage.clickOnAddToCart(driver);
		boolean a = HomePage.isAddedItemPresent(driver);
		
		assertTrue(a, "Added notification is not shown.");

	}

	@Test
	public static void testAddedProductIsShownOnCheckoutPage() {

		String img = "https://rahulshettyacademy.com/seleniumPractise/images/broccoli.jpg";

		HomePage.goToHomePage(driver);
		HomePage.clickOnAddToCartByProductName(driver, "Brocolli");
		HomePage.clickOnCart(driver);
		HomePage.clickOnProceedToCheckout(driver);
		
		assertEquals(HomePage.getFirstCheckoutItemSrcAttribute(driver), img);
	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}

}
