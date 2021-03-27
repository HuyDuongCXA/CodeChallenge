package test_cases;

import org.testng.annotations.Test;

import aspire.UserInfo;
import aspire.BusinessDetailsPage;
import aspire.BusinessInfo;
import aspire.BusinessDetailsPage;
import aspire.EnterEmailOtpPage;
import aspire.EnterPhoneOtpPage;
import aspire.LoginToAspirePage;
import aspire.PersonalDetailsPage;
import aspire.RegistrationPage;
import test_base.TestBase;

public class LoginTest extends TestBase {
	
	@Test
	public void TC01() {
		LoginToAspirePage loginToAspirePage = new LoginToAspirePage();
		UserInfo userInfo = new UserInfo();
		userInfo.initUserInfo();
		BusinessInfo businessInfo = new BusinessInfo();
		businessInfo.initBusinessInfo();
		RegistrationPage registrationPage = new RegistrationPage();
		EnterPhoneOtpPage enterPhoneOtpPage = new EnterPhoneOtpPage();
		PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage();
		EnterEmailOtpPage enterEmailOtpPage = new EnterEmailOtpPage();
		BusinessDetailsPage businessDetailsPage = new BusinessDetailsPage();
		
		
		loginToAspirePage.clickRegisterLink();
		registrationPage.registerAccount(userInfo);
		enterPhoneOtpPage.enterPhoneOtp(userInfo);
		registrationPage.clickCompletedContinueBtn();
		personalDetailsPage.clickYesContinueBtn();
		personalDetailsPage.clickStandardGetStartedBtn();
		personalDetailsPage.clickGetStartedBtn();
		personalDetailsPage.fillPersonalInfo(userInfo);
		personalDetailsPage.clickSubmitBtn();
		enterEmailOtpPage.enterEmailOtp(userInfo);
		businessDetailsPage.clickContinueBtn();
		businessDetailsPage.fillBusinessDetails(businessInfo);
		
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}