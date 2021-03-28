package test_cases;

import aspire.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import aspire.BusinessDetailsPage;
import test_base.TestBase;

public class RegistrationTest extends TestBase {

	@Test
	public void TC01() {
		System.out.println("TC01 - Verify that do the registration flow until the user meets the step for waiting the approval.");

		// Declaration
		String expected = "We are on it!";
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
		
		//Execution
		loginToAspirePage.clickRegisterLink();
		System.out.println("1. Registration Page is reached");
		registrationPage.registerAccount(userInfo);
		enterPhoneOtpPage.enterPhoneOtp(userInfo);
		System.out.println("2. Mobile Verification (OTP) Page is reached");
		registrationPage.clickCompletedContinueBtn();
		personalDetailsPage.clickYesContinueBtn();
		personalDetailsPage.clickStandardGetStartedBtn();
		personalDetailsPage.clickGetStartedBtn();
		personalDetailsPage.fillPersonalInfo(userInfo);
		System.out.println("3. Personal Details Page is reached");
		personalDetailsPage.clickSubmitBtn();
		enterEmailOtpPage.enterEmailOtp(userInfo);
		System.out.println("4. Email Verification (OTP) Page is reached");
		businessDetailsPage.clickContinueBtn();
		businessDetailsPage.fillBusinessDetails(businessInfo);
		System.out.println("5. Business Details Page is reached");
		businessDetailsPage.clickSubmitBtn();
		completeVerificationPage.clickBeginVerificationBtn();
		completeVerificationPage.UploadPhoto();
		completeVerificationPage.clickContinueBtn();
		completeVerificationPage.uploadSelfiePhoto();
		System.out.println("6. Identity Verification Page is reached");
		completeVerificationPage.clickSelfieContinueBtn();
		onboardingNpsPage.clickContinueBtn();
		String actual = onboardingNpsPage.getOnboardingText();
		Assert.assertEquals(actual,expected);
		System.out.println("7. Onboarding NPS Page is reached");
	}

}