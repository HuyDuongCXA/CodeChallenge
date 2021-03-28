package test_cases;

import aspire.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import aspire.BusinessDetailsPage;
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
		CompleteVerificationPage completeVerificationPage = new CompleteVerificationPage();
		OnboardingNpsPage onboardingNpsPage = new OnboardingNpsPage();
		
		
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
		businessDetailsPage.clickSubmitBtn();
		completeVerificationPage.clickBeginVerificationBtn();
		completeVerificationPage.UploadPhoto();
		completeVerificationPage.clickContinueBtn();
		completeVerificationPage.uploadSelfiePhoto();
		completeVerificationPage.clickSelfieContinueBtn();
		onboardingNpsPage.clickContinueBtn();
		String actual = onboardingNpsPage.getOnboardingText();
		Assert.assertEquals(actual,"We are on it!");
	}

}