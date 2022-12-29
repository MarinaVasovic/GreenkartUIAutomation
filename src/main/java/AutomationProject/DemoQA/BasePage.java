package AutomationProject.DemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

	public static boolean isElementPresent(WebDriver driver, String xPathLocator) {
		boolean isPresent = true;
		try {
			driver.findElement(By.xpath(xPathLocator));
		} catch (Exception e) {
			isPresent = false;
		}
		return isPresent;
	}

	public static void waitInSeconds(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static String getElementAttribute(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}
}
