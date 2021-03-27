package aspire;

import driverUltils.DriverUtils;

public class RegistrationPage extends LoginToAspirePage {
UserInfo userInfo = new UserInfo();

	//Locator
	private final String FULL_NAME_TXT = "//input[@name='full_name']";
	private final String EMAIL_ADDRESS_TXT = "//input[@name='email']";
	private final String MOBILE_NUMBER_TXT = "//input[@name='phone']";
	private final String APPOINTED_DIRECTOR_RB = "//div[@aria-label='Appointed director']//div[@class='q-radio__inner relative-position q-radio__inner--falsy']";
	private final String WHERE_DID_YOU_HEAR_ABOUT_US_CBB = "//input[@type='search']";
	private final String MARKETING_ITEM = "//div[@class='q-item__label' and .='%s']";
	private final String PROMO_CODE_TXT = "//input[@id='f_88d3b879-f56d-4570-9c65-cf8d3b3514aa']";
	private final String AGREE_TNC_CB = "//div[@class='q-checkbox__bg absolute']";
	private final String CONTINUE_BTN = "//button[@role='button']";
	private final String COMPLETED_CONTINUE_BTN = "//button[@class='q-btn q-btn-item non-selectable no-outline aspire-button aspire-button--cta q-btn--standard q-btn--rectangle bg-primary text-white q-btn--actionable q-focusable q-hoverable q-btn--wrap']";
	private final String FLAG_ICN = "//div[@class='flag-select__icon q-img overflow-hidden']";
	
	//Methods
	public void enterFullName(UserInfo userInfo) {
		getElement(FULL_NAME_TXT).sendKeys(userInfo.getFullName());
	}
	
	public void enterEmailAddress(UserInfo userInfo) {
		DriverUtils.waitForElementDisplayed(EMAIL_ADDRESS_TXT);
		getElement(EMAIL_ADDRESS_TXT).sendKeys(userInfo.getemailAddress());
	}
	
	public void enterPhoneNumber(UserInfo userInfo) {
		DriverUtils.waitForElementDisplayed(FLAG_ICN);
		getElement(MOBILE_NUMBER_TXT).sendKeys(userInfo.getPhoneNumber());
	}
	
	public void clickOnDirectorRb() {
		getElement(APPOINTED_DIRECTOR_RB).click();
	}
	
	public void fillMarketingQues(UserInfo userInfo) {
		String item = MARKETING_ITEM.format(MARKETING_ITEM, userInfo.getMarketingQues());
		getElement(WHERE_DID_YOU_HEAR_ABOUT_US_CBB).click();
		getElement(item).click();
	}
	
	public void clickAgreeTncCB() {
		getElement(AGREE_TNC_CB).click();
	}
	
	public void clickContinueBtn() {
		DriverUtils.waitForElementDisplayed(CONTINUE_BTN);
		getElement(CONTINUE_BTN).click();
	}
	
	public void registerAccount(UserInfo userInfo) {
		enterFullName(userInfo);
		enterEmailAddress(userInfo);
		enterPhoneNumber(userInfo);
		clickOnDirectorRb();
		fillMarketingQues(userInfo);
		clickAgreeTncCB();
		clickContinueBtn();
	}
	
	public void clickCompletedContinueBtn() {
		DriverUtils.waitForPageLoadedCompletely();
		getElement(COMPLETED_CONTINUE_BTN).click();
	}
	
}
