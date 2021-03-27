package aspire;

import driverUltils.DriverUtils;

public class BusinessDetailsPage extends GeneralPage {

	//Locators
	private final String CONTINUE_BTN  = "//button[@role='button']";
	private final String BUSINESS_NAME_TXT = "//input[@placeholder='The full legal business name']";
	private final String ENTITY_TYPE_CATEGORY_CBB_ICON = "//div[@label='Entity Type Category']//i[@class='q-select__dropdown-icon fas fa-caret-down q-icon notranslate']";
	private final String ENTITY_TYPE_CATEGORY_LBL = "//div[@class='q-item__label' and .='%s']";
	private final String ENTITY_TYPE_CBB = "//div[@label='Entity Type']//input[@placeholder='Select any of the following']";
	private final String ENTITY_TYPE_LBL = "//div[@class='q-item__label' and .='%s']";
	private final String UEN_TXT = "//input[@placeholder='Business Registration Number UEN']";
	private final String LIVE_BUSINESS_WEBSITE_TXT = "//input[@placeholder='Enter your business website URL']";
	private final String INDUSTRY_CBB = "//div[@label='Industry']//input[@placeholder='Select any of the following']";
	private final String INDUSTRY_LBL = "//div[@class='q-item__label' and .='%s']";
	private final String SUB_INDUSTRY_CBB_ICON = "//div[@label='Sub Industry']//i[@class='q-select__dropdown-icon fas fa-caret-down q-icon notranslate']";
	private final String SUB_INDUSTRY_LBL = "//div[@class='q-item__label' and .='%s']";
	private final String SUBMIT_BTN = "//button[@type='button']";

	//Methods
	public void clickContinueBtn() {
		DriverUtils.waitForElementDisplayed(CONTINUE_BTN);
		getElement(CONTINUE_BTN).click();
	}
	
	public void enterBusinessName(BusinessInfo businessInfo) {
		getElement(BUSINESS_NAME_TXT).sendKeys(businessInfo.getBusinessName());
	}
	
	public void selectEntityTypes(BusinessInfo businessInfo) {
		String entityTypeCategory = ENTITY_TYPE_CATEGORY_LBL.format(ENTITY_TYPE_CATEGORY_LBL, businessInfo.getEntityTypeCategory());
		String entityType = ENTITY_TYPE_LBL.format(ENTITY_TYPE_LBL, businessInfo.getEntityType());
		DriverUtils.waitForPageLoadedCompletely();
		getElement(ENTITY_TYPE_CATEGORY_CBB_ICON).click();
		getElement(entityTypeCategory).click();
		getElement(ENTITY_TYPE_CBB).click();
		getElement(entityType).click();
	}
	
	public void enterUen(BusinessInfo businessInfo) {
		getElement(UEN_TXT).sendKeys(businessInfo.getUen());
	}
	
	public void enterLiveBusinessWebsite(BusinessInfo businessInfo) {
		getElement(LIVE_BUSINESS_WEBSITE_TXT).sendKeys(businessInfo.getLiveBusinessWebsite());
	}
	
	public void selectIndustries(BusinessInfo businessInfo) {
		String industry = INDUSTRY_LBL.format(INDUSTRY_LBL, businessInfo.getIndustry());
		String subIndustry = SUB_INDUSTRY_LBL.format(SUB_INDUSTRY_LBL, businessInfo.getSubIndustry());
		
		getElement(INDUSTRY_CBB).click();
		getElement(industry).click();
		getElement(SUB_INDUSTRY_CBB_ICON).click();
		getElement(subIndustry).click();
	}
	
	public void fillBusinessDetails(BusinessInfo businessInfo) {
		enterBusinessName(businessInfo);
		selectEntityTypes(businessInfo);		
		enterUen(businessInfo);
		enterLiveBusinessWebsite(businessInfo);
		selectIndustries(businessInfo);
	}
	
	public void clickSubmitBtn() {
		getElement(SUBMIT_BTN).click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
