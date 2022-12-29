package AutomationProject.DemoQA;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

	public static final String URL = "https://rahulshettyacademy.com/seleniumPractise/#/";
	public static final String ADD_TO_CART_XPATH = "//*[contains(text(),'Brocolli')]//..//button[text()='ADD TO CART']";
	public static final String CART_XPATH = "//a[@class='cart-icon']";
	public static final String PROCEED_TO_CHECKOUT_XPATH = "//button[contains(text(),'PROCEED TO CHECKOUT')]";
	public static final String URL_KART_PAGE = "https://rahulshettyacademy.com/seleniumPractise/#/cart";
	public static final String URL_TERMS_CONDITIONS_LINK = "https://rahulshettyacademy.com/seleniumPractise/#/policy";
	public static final String HOME_LINK_XPATH = "//*[@id=\"root\"]/div/div/div/div/a";
	public static final String FLIGHT_BOOKS_XPATH = "//a[contains(text(),'Flight Booking')]";
	public static final String TOP_DEALS__XPATH = "//a[contains(text(),'Top Deals')]";
	public static final String SEARCH_BUTTON_CSS = "button.search-button";
	public static final String SEARCH_FIELDS_CSS = "input.search-keyword";
	public static final String TERMS_CONDITIONS_CHECK_BOX_CSS = "input.chkagree";
	public static final String QUANTITY_ITEMS_XPATH = "//*[@class='cart-info']//tr[1]/td[3]/strong";
	public static final String PRICE_ITEMS_XPATH = "//*[@class='cart-info']//tr[2]/td[3]/strong";
	public static final String CHOSEN_ITEMS_XPATH = "//h4[@class='product-name']";
	public static final String EMPTY_CART_XPATH = "//h2[contains(text(),'You cart is empty!')]";
	public static final String REMOVE_ITEM_CSS = "a.product-remove";
	public static final String ADDED_ITEM_XPATH = "//button[text()='✔ ADDED']";
	public static final String TABLE_OF_ITEMS_XPATH = "//*[@src=\"./images/broccoli.jpg\"]";
	public static final String SUCCESSFUL_ORDER_MESSAGE_XPATH = "//*[@class='wrapperTwo']/span";
	public static final String FIRST_CHECKOUT_ITEM_XPATH = "//tbody/tr/td/img";

	public static void goToHomePage(WebDriver driver) {
		driver.get(URL);
		driver.manage().window().maximize();
		driver.navigate().refresh();

	}

	public static void clickOnAddToCart(WebDriver driver) {
		driver.findElement(By.xpath(ADD_TO_CART_XPATH)).click();
	}

	public static void clickOnAddToCartByProductName(WebDriver driver, String productName) {
		driver.findElement(By.xpath("//*[contains(text(),'" + productName + "')]//..//button[text()='ADD TO CART']"))
				.click();
	}

	public static void clickOnCart(WebDriver driver) {
		driver.findElement(By.xpath(CART_XPATH)).click();
	}

	public static void clickOnHomeLink(WebDriver driver) {
		driver.findElement(By.xpath(HOME_LINK_XPATH)).click();
	}

	public static void clickOnProceedToCheckout(WebDriver driver) {
		driver.findElement(By.xpath(PROCEED_TO_CHECKOUT_XPATH)).click();
		waitInSeconds(1);
	}


	public static void clickOnFlightBookLink(WebDriver driver) {
		driver.findElement(By.xpath(FLIGHT_BOOKS_XPATH)).click();
	}

	public static void clickOnSearchButton(WebDriver driver) {
		driver.findElement(By.cssSelector(SEARCH_BUTTON_CSS));
	}

	public static void inputSearchFields(WebDriver driver, String item) {
		WebElement element = driver.findElement(By.cssSelector(SEARCH_FIELDS_CSS));
		element.clear();
		element.sendKeys(item);
	}
	

	public static void click(WebDriver driver, WebElement element) {
		element.click();
	}

	
	public static boolean isCartPresent(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3)); // NE BRISI
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CART_XPATH)));
		return isElementPresent(driver, CART_XPATH);
	}

	public static String getQuantity(WebDriver driver) {
		return driver.findElement(By.xpath(QUANTITY_ITEMS_XPATH)).getText();
	}
	
	public static String getPrice(WebDriver driver) {
		return driver.findElement(By.xpath(PRICE_ITEMS_XPATH)).getText();
	}
	
	public static boolean isChosenItemPresent(WebDriver driver) {
		return isElementPresent(driver, CHOSEN_ITEMS_XPATH);
	}

	public static void clickOnRemove(WebDriver driver) {
		driver.findElement(By.cssSelector(REMOVE_ITEM_CSS)).click();
	}

	public static boolean isEmtyCartPresent(WebDriver driver) {
		return isElementPresent(driver, EMPTY_CART_XPATH);
	}

	public static boolean isAddedItemPresent(WebDriver driver) {
		return isElementPresent(driver, ADDED_ITEM_XPATH);
	}

	public static boolean isTablePresent(WebDriver driver) {
		return isElementPresent(driver, TABLE_OF_ITEMS_XPATH);
	}

	public static String getFirstCheckoutItemSrcAttribute(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath(FIRST_CHECKOUT_ITEM_XPATH));
		return getElementAttribute(element, "src");
	}
}
