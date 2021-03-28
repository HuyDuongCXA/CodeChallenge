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
		String a = System.getProperty("os.name");
		System.out.println("Pre-condition");
		if(a.equals("Mac OS X")){
			System.setProperty("webdriver.chrome.driver", Common.getProjectPath() + "/Executables/chromedriver");
		}

		else{System.setProperty("webdriver.chrome.driver", Common.getProjectPath() + "/Executables/chromedriver.exe");}
		System.setProperty("webdriver.chrome.driver", Common.getProjectPath() + "/Executables/chromedriver");
		Constant.WEBDRIVER = new ChromeDriver();
		Constant.WEBDRIVER.navigate().to(Constant.AUT_URL);
		DriverUtils.setImplicitlyWait();
		DriverUtils.maximize();
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Post-condition");
		Constant.WEBDRIVER.quit();
	}

}

