package aspire;

import driver_wrapper.DriverManagement;
import element_wrapper.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import constant.Constant;
import driverUltils.DriverUtils;

public class GeneralPage {

    public static WebElement getElement(String locator)
    {
        Element element = new Element(By.xpath(locator));
        return element;
    }


    public static boolean isElementPresent(String locator) {

        try {
            DriverManagement.getDriver().findElement(By.xpath(locator));
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

}
