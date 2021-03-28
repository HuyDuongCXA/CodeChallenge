package test_base;

import common.DriverType;
import driver_wrapper.Driver;
import driver_wrapper.DriverManagement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import common.Common;
import constant.Constant;
import driverUltils.DriverUtils;
import test_cases.RegistrationTest;

public class TestBase {
	Logger logger = LogManager.getLogger(RegistrationTest.class);
	@BeforeMethod
	public void beforeMethod() {
		String a = System.getProperty("os.name");
		logger.info("Pre-condition");
		if(a.equals("Mac OS X")){
			System.setProperty("webdriver.chrome.driver", Common.getProjectPath() + "/Executables/chromedriver");
		}

		else{System.setProperty("webdriver.chrome.driver", Common.getProjectPath() + "/Executables/chromedriver.exe");}
		System.setProperty("webdriver.chrome.driver", Common.getProjectPath() + "/Executables/chromedriver");
		//Constant.WEBDRIVER = new ChromeDriver();
		DriverManagement.createDriver(DriverType.Chrome);
		//Constant.WEBDRIVER.navigate().to(Constant.AUT_URL);
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

