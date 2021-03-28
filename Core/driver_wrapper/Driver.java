package driver_wrapper;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import common.Common;
import common.DriverType;
import constant.Constant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import test_cases.RegistrationTest;


public class Driver extends BaseDriver {

    private static final Logger logger = LogManager.getLogger(RegistrationTest.class);
    private static DesiredCapabilities caps;
    private WebDriver _driver;

    public Driver(DriverType type, boolean parallel, String hub) {
        try {
            logger.info(String.format("Create new Driver with type %s", type.getValue()));
            switch (type.getValue()) {
                case "Chrome":
                    System.setProperty("webdriver.chrome.driver",
                            Common.getProjectPath() + "/Executables/chromedriver");
                    if (!parallel) {
                        _driver = new ChromeDriver();
                    } else if (parallel) {
                        caps = DesiredCapabilities.chrome();
                        _driver = new RemoteWebDriver(new URL(hub), caps);
                    }

                    DriverManagement.addDriver(_driver);

                    break;

                case "Firefox":
                    System.setProperty("webdriver.gecko.driver",
                            System.getProperty("user.dir") + "\\Core\\core.drivers\\geckodriver.exe");
                    if (!parallel) {
                        _driver = new FirefoxDriver();
                    } else if (parallel) {
                        caps = DesiredCapabilities.firefox();
                        _driver = new RemoteWebDriver(new URL(hub), caps);
                    }

                    DriverManagement.addDriver(_driver);

                    break;
            }
        } catch (Exception e) {
            logger.warn(e.getMessage());
        }
    }

    private static JavascriptExecutor jsExecutor() {
        return ((JavascriptExecutor) getDriver());
    }

    public static Object executeScript(String script, Object... args) {
        return jsExecutor().executeScript(script);
    }

    public static void scrollTillEnd() {
        logger.info(String.format("Scroll the driver %s till end", DriverManagement.getThreadId()));
        String js = String.format("window.scrollTo(0, document.body.scrollHeight)");
        jsExecutor().executeScript(js);
    }

    public static void setImplicitlyWait() {
        setImplicitlyWait(Constant.TIMEOUT);
    }

    public static void setLowImplicitlyWait() {
        setImplicitlyWait(Constant.SHORT_TIMEOUT);
    }

    public static void setImplicitlyWait(int timeOutInSecond) {
        logger.info(String.format("Set driver %s implicitly wait", DriverManagement.getThreadId()));
        getDriver().manage().timeouts().implicitlyWait(timeOutInSecond, TimeUnit.SECONDS);
    }

}
