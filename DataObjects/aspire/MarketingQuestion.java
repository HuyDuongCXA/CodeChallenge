package aspire;

public enum MarketingQuestion {
	REFERRAL("Referral"), BROCHURE("Brochure"), FACEBOOK("Facebook"),
	INSTAGRAM("Instagram"), GOOGLE("Google"), LINKEDIN("LinkedIn"),
	FRIENDS_AND_RELATIVES("Friends and relatives"),ONLINE_ARTICLES("Online Articles"),
	PAYMENT_INVITATION("Payment Invitation"), BROKERS("Brokers"), OTHERS("Others");

	private final String value;

	private MarketingQuestion(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
