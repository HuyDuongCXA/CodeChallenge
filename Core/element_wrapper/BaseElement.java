package element_wrapper;

import constant.Constant;
import driverUltils.DriverUtils;
import driver_wrapper.Driver;
import driver_wrapper.DriverManagement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseElement implements WebElement {

    private static final Logger logger = LogManager.getLogger(BaseElement.class);
    protected WebElement element = null;
    protected List<WebElement> _elements = null;
    private By byLocator;

    public BaseElement(WebElement webelement, By locator) {
        this.element = webelement;
        this.byLocator = locator;
    }

    public BaseElement(By locator) {
        this.byLocator = locator;
    }

    public BaseElement(String xpath) {
        this.byLocator = By.xpath(xpath);
    }


    protected WebDriver getDriver() {
        return DriverManagement.getDriver();
    }

    protected By getLocator() {
        return this.byLocator;
    }

    protected WebElement waitForPresent() {
        logger.info(String.format("Wait for control %s to be present in DOM with timeOut %s", getLocator().toString(),
                Constant.TIMEOUT));
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Constant.TIMEOUT);
            element = wait.until(ExpectedConditions.presenceOfElementLocated(getLocator()));
        } catch (Exception error) {
            logger.warn(String.format("Has error with control '%s': %s", getLocator().toString(), error.getMessage()));
            throw error;
        }
        return element;
    }

    public WebElement waitForClickable() {
        try {
            logger.info(String.format("Wait for control %s to be clickable", getLocator().toString()));
            WebDriverWait wait = new WebDriverWait(getDriver(), Constant.TIMEOUT);
            element = wait.until(ExpectedConditions.elementToBeClickable(getLocator()));
        } catch (Exception error) {
            logger.warn(String.format("Has error with control '%s': %s", getLocator().toString(), error.getMessage()));
            throw error;
        }
        return element;
    }

    @Override
    public void click() {
        waitForClickable().click();
    }

    @Override
    public void submit() {

    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        waitForClickable().sendKeys(keysToSend);
    }

    @Override
    public void clear() {

    }

    @Override
    public String getTagName() {
        return null;
    }

    @Override
    public String getAttribute(String name) {
        return null;
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String getText() {
        return waitForPresent().getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return null;
    }

    @Override
    public WebElement findElement(By by) {
        waitForPresent();
        getDriver().findElement(by);
        return null;
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }

    @Override
    public Point getLocation() {
        return null;
    }

    @Override
    public Dimension getSize() {
        return null;
    }

    @Override
    public Rectangle getRect() {
        return null;
    }

    @Override
    public String getCssValue(String propertyName) {
        return null;
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return null;
    }
}
