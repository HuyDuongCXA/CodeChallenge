package driver_wrapper;

import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import test_cases.RegistrationTest;

abstract class BaseDriver implements WebDriver {

   private static final Logger logger = LogManager.getLogger(RegistrationTest.class);

    protected static WebDriver getDriver() {
        return DriverManagement.getDriver();
    }

    public void get(String url) {
        /**
         * Not implemented yet
         */
    }

    public String getCurrentUrl() {
        /**
         *Not Implemented yet
         */
        return null;
    }


    public String getTitle() {
        return  "a";
        /**
         *Not Implemented yet
         */
    }


    public List<WebElement> findElements(By by) {
        /**
         *Not Implemented yet
         */
        return null;
    }


    public WebElement findElement(By by) {
        /**
         *Not Implemented yet
         */
        return null;
    }

    public String getPageSource() {
        /**
         *Not Implemented yet
         */
        return null;
    }

    public void close() {
        logger.info(String.format("Close the current window of the driver %s", DriverManagement.getThreadId()));
        getDriver().close();
    }

    public void quit() {
        logger.info(String.format("Quit the driver %s", DriverManagement.getThreadId()));
        getDriver().quit();
    }


    public Set<String> getWindowHandles() {
        /**
         *Not Implemented yet
         */
        return null;
    }


    public String getWindowHandle() {
        /**
         *Not Implemented yet
         */
        return null;
    }

    public TargetLocator switchTo() {
        /**
         *Not Implemented yet
         */
        return null;
    }

    public Navigation navigate() {
        logger.info(String.format("Navigate to a given url of the driver %s", DriverManagement.getThreadId()));
        return getDriver().navigate();
    }

    public Options manage() {
        logger.info(String.format("Get the option interface of the driver %s", DriverManagement.getThreadId()));
        return getDriver().manage();
    }

}
