package test_base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import common.Common;
import constant.Constant;
import driverUltils.DriverUtils;

public class TestBase {
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Pre-condition");
		System.setProperty("webdriver.chrome.driver", Common.getProjectPath() + "/Executables/chromedriver");
		Constant.WEBDRIVER = new ChromeDriver();
		Constant.WEBDRIVER.navigate().to("https://feature-qa.customer-frontend.staging.aspireapp.com/sg");
		DriverUtils.setImplicitlyWait();
		DriverUtils.maximize();
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Post-condition");
		Constant.WEBDRIVER.quit();
	}

}

