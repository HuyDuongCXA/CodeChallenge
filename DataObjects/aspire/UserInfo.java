package aspire;

import utilities.Utilities;

public class UserInfo {
	private String marketingQues = MarketingQuestion.BROKERS.getValue();
	private String phoneNumber;
	private String phoneOtp = "123456";
	private String emailOtp = "123456";
	private String fullName="Aspire Test";
	private String emailAddress;
	private String idCardNumber;
	private String day = "29";
	private String month= "Nov";
	private String year="1992";
	private String nationality="Afghanistan";
	private String gender="Male";
	private String interest="Debit Card";
	//private String marketingQues;
	
	//Getters	
	public String getPhoneNumber() {return phoneNumber;}
	public String getPhoneOtp() {return phoneOtp;}
	public String getEmailOtp() {return emailOtp;}
	public String getFullName() {return fullName;}
	public String getemailAddress() {return emailAddress;}
	public String getMarketingQues() {return marketingQues;}
	public String getIdCardNumber() {return idCardNumber;}
	public String getDay() {return day;}
	public String getMonth() {return month;}
	public String getYear() {return year;}
	public String getNationality() {return nationality;}
	public String getGender() {return gender;}
	public String getInterest() {return interest;}
	

	//Setters
	public void SetPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}
	public void SetPhoneOtp(String phoneOtp) {this.phoneOtp = phoneOtp;}
	public void SetEmailOtp(String emailOtp) {this.emailOtp = emailOtp;}
	public void SetFullName(String fullName) {this.fullName = fullName;}
	public void SetEmailAddress(String emailAddress) {this.emailAddress = emailAddress;}
	public void SetIdCardNumber(String idCardNumber) {this.idCardNumber = idCardNumber;}
	public void SetDay(String day) {this.day = day;}
	public void SetMonth(String month) {this.month = month;}
	public void SetYear(String year) {this.year = year;}
	public void SetNationality(String nationality) {this.nationality = nationality;}
	public void SetGender(String gender) {this.gender = gender;}
	public void SetInterest(String interest) {this.interest = interest;}
	
	//public void SetMarketingQues(String marketingQues) {this.marketingQues = marketingQues;}
	
	public UserInfo() {}
	public UserInfo(String phoneNumber, String phoneOtp,String emailOtp, String fullName, String emailAddress,String idCardNumber, String day,
			String month, String year, String nationality, String gender, String interest) {
		this.phoneNumber = phoneNumber;
		this.phoneOtp = phoneOtp;
		this.emailOtp = emailOtp;
		this.fullName = fullName;
		this.emailAddress = emailAddress;
		this.idCardNumber = idCardNumber;
		this.day = day;
		this.month = month;
		this.year = year;
		this.nationality = nationality;
		this.gender = gender;
		this.interest = interest;
	}

	
	public UserInfo initUserInfo() {
		this.phoneNumber = Utilities.generateRandomPhoneNumber();
		this.emailAddress = Utilities.generateRandomEmail();
		this.idCardNumber = Utilities.generateRandomIdCard();
		return this;
	}
}
