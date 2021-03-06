package driverUltils;

import java.util.concurrent.TimeUnit;

import driver_wrapper.DriverManagement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constant.Constant;

public class DriverUtils {

    public static void waitForElementDisplayed(String locator) {
        WebDriverWait wait = new WebDriverWait(DriverManagement.getDriver(), Constant.TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }

    public static void waitForPageLoadedCompletely() {
        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {

            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };

        WebDriverWait wait = new WebDriverWait(DriverManagement.getDriver(), Constant.TIMEOUT);
        wait.until(pageLoadCondition);

    }

}
