package driver_wrapper;

import java.util.HashMap;
import java.util.Map;

import common.DriverType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import test_cases.RegistrationTest;

public class DriverManagement {

    private static final Logger logger = LogManager.getLogger(RegistrationTest.class);
    private static Map<String, WebDriver> map = new HashMap<String, WebDriver>();

    public static void createDriver(DriverType type) {
        new Driver(type, false, null);
    }

    public static void createDriver(DriverType type, String hub) {
        new Driver(type, true, hub);
    }

    protected static String getThreadId() {
        return String.valueOf(Thread.currentThread().getId());
    }

    protected static void addDriver(WebDriver driver) {
        try {
            logger.info("DriverManagement are adding driver on thread " + getThreadId());
            map.put(getThreadId(), driver);
        } catch (Exception e) {
            logger.warn(e.getMessage());
        }
    }

    public static WebDriver getDriver() {
        return map.get(getThreadId());
    }
}

