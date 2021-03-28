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
        //logger.info(String.format("Load a new web page for the driver %s", DriverManagement.getThreadId()));
        //getDriver().get(url);
    }

    public String getCurrentUrl() {
        //logger.info(String.format("Get current url of the driver %s", DriverManagement.getThreadId()));
        return getDriver().getCurrentUrl();
    }


    public String getTitle() {
        //logger.info(String.format("Get current title of the driver %s", DriverManagement.getThreadId()));
        return getDriver().getTitle();
    }

    @Deprecated
    public List<WebElement> findElements(By by) {
        throw new UnsupportedOperationException("This method is not supported");
    }


    public WebElement findElement(By by) {
        return getDriver().findElement(by);

        //throw new UnsupportedOperationException("This method is not supported");
    }

    public String getPageSource() {
        logger.info(String.format("Get source of the last load page of the driver %s", DriverManagement.getThreadId()));
        return getDriver().getPageSource();
    }

    public void close() {
        logger.info(String.format("Close the current window of the driver %s", DriverManagement.getThreadId()));
        getDriver().close();
    }

    public void quit() {
        logger.info(String.format("Quit the driver %s", DriverManagement.getThreadId()));
        getDriver().quit();
    }

    @Deprecated
    public Set<String> getWindowHandles() {
        throw new UnsupportedOperationException("This method is not supported");
    }

    @Deprecated
    public String getWindowHandle() {
        throw new UnsupportedOperationException("This method is not supported");
    }

    public TargetLocator switchTo() {
        logger.info(String.format("Send commands to the different frame or window of the driver %s",
                DriverManagement.getThreadId()));
        return getDriver().switchTo();
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
