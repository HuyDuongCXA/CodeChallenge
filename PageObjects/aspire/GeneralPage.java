package aspire;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import constant.Constant;
import driverUltils.DriverUtils;

public class GeneralPage {
	
	public static WebElement getElement(String locator) {
		return Constant.WEBDRIVER.findElement(By.xpath(locator));
	}
	
	
	public static boolean isElementPresent(String locator) {
		
		try {
			  getElement(locator);
		    return true;
		  }
		catch (org.openqa.selenium.NoSuchElementException e) {
		    return false;
		  }
		}

}
