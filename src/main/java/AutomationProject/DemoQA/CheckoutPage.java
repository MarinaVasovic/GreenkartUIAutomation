package AutomationProject.DemoQA;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

	public static final String INPUT_PROMOCODE_CSS = "input.promocode";
	public static final String APPLY_BUTTON_CSS = "button.promoBtn";
	public static final String PLACE_ORDER_XPATH = "//button[contains(text(),'Place Order')]";
	public static final String MESSAGE_INVALID_CODE_CSS = "span.promoinfo";
	public static final String URL_CHOOSE_COUNTRY_PAGE = "https://rahulshettyacademy.com/seleniumPractise/#/country";
	public static final String SELECT_XPATH = "//select";
	public static final String TERMS_CONDITIONS_LINK_XPATH = "//a[contains(text(),'Conditions')]";
	public static final String URL_TERMS_CONDITIONS_LINK = "https://rahulshettyacademy.com/seleniumPractise/#/policy";
	public static final String TERMS_CONDITIONS_CHECK_BOX_CSS = "input.chkagree";
	public static final String SUCCESSFUL_ORDER_MESSAGE_XPATH = "//*[@class='wrapperTwo']/span";
	public static final String FIRST_CHECKOUT_ITEM_XPATH = "//tbody/tr/td/img";
	public static final String PROCEED_XPATH = "//button[contains(text(),'Proceed')]";
    
    
	public static void enterPromoCode(WebDriver driver, String promocode) {
		WebElement element = driver.findElement(By.cssSelector(INPUT_PROMOCODE_CSS));
		element.clear();
		element.sendKeys(promocode);
	}

	public static void clickOnApply(WebDriver driver) {
		driver.findElement(By.cssSelector(APPLY_BUTTON_CSS)).click();
	}

	public static String getMessageInvalidCode(WebDriver driver) {
		WebElement element = driver.findElement(By.cssSelector(MESSAGE_INVALID_CODE_CSS));
		return element.getText();
	}

	public static void clickOnPlaceOrder(WebDriver driver) {
		driver.findElement(By.xpath(PLACE_ORDER_XPATH)).click();
	}

	public static void selectCountry(WebDriver driver, String country) {
		WebElement selectElement = driver.findElement(By.xpath(SELECT_XPATH));
		Select select = new Select(selectElement);
		select.selectByValue(country);
	}

	public static String getSuccessfulOrderMessage(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath(SUCCESSFUL_ORDER_MESSAGE_XPATH));
		return element.getText();
	}

	public static void clickOnTermsAndConditionsLink(WebDriver driver) {
		driver.findElement(By.xpath(TERMS_CONDITIONS_LINK_XPATH)).click();
	}

	public static void waitMessageInvalidCode(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(MESSAGE_INVALID_CODE_CSS)));
	}

	public static void clickOnCheckBoxTermConditions(WebDriver driver) {
		driver.findElement(By.cssSelector(TERMS_CONDITIONS_CHECK_BOX_CSS)).click();
	}

	public static void clickOnProceedButton(WebDriver driver) {
		driver.findElement(By.xpath(PROCEED_XPATH)).click();
	}

	
	
	
	
	
}
