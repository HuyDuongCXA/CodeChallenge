package test_base;

import common.DriverType;
import driver_wrapper.Driver;
import driver_wrapper.DriverManagement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import constant.Constant;
import driverUltils.DriverUtils;
import test_cases.RegistrationTest;

public class TestBase {
	Logger logger = LogManager.getLogger(RegistrationTest.class);
	@BeforeMethod
	public void beforeMethod() {
		String a = System.getProperty("os.name");
		DriverManagement.createDriver(DriverType.Chrome);
		DriverManagement.getDriver().navigate().to(Constant.AUT_URL);
		Driver.setImplicitlyWait();
		DriverManagement.getDriver().manage().window().maximize();

	}

	@AfterMethod
	public void afterMethod() {
		logger.info("Post-condition");
		DriverManagement.getDriver().quit();
	}

}

