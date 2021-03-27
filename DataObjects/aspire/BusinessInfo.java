package aspire;

import utilities.Utilities;

public class BusinessInfo {
	
	private String businessName="Aspire";
	private String entityTypeCategory="Limited companies";
	private String entityType="Limited partnership";
	private String uen;
	private String liveBusinessWebsite="https://www.google.com.vn/";
	private String industry="Manufacturing";
	private String subIndustry="Chemicals";
	
	//Getters
		public String getBusinessName(){return businessName;}
		public String getEntityTypeCategory(){return entityTypeCategory;}
		public String getEntityType(){return entityType;}
		public String getUen(){return uen;}
		public String getLiveBusinessWebsite(){return liveBusinessWebsite;}
		public String getIndustry(){return industry;}
		public String getSubIndustry(){return subIndustry;}
	
	//Setters
		public void setBusinessName(String businessName) {this.businessName = businessName;}
		public void setEntityTypeCategory(String entityTypeCategory) {this.entityTypeCategory = entityTypeCategory;}
		public void setEntityType(String entityType) {this.entityType = entityType;}
		public void setUen(String uen) {this.uen = uen;}
		public void setLiveBusinessWebsite(String liveBusinessWebsite) {this.liveBusinessWebsite = liveBusinessWebsite;}
		public void setIndustry(String industry) {this.industry = industry;}
		public void setSubIndustry(String subIndustry) {this.subIndustry = subIndustry;}
		
	//constructors
		
		public BusinessInfo() {}
		public BusinessInfo (String businessName,String entityTypeCategory,String entityType, String uen,String liveBusinessWebsite
				,String industry,String subIndustry ){
			this.businessName = businessName;
			this.entityTypeCategory = entityTypeCategory;
			this.entityType = entityType;
			this.uen = uen;
			this.liveBusinessWebsite = liveBusinessWebsite;
			this.industry = industry;
			this.subIndustry = subIndustry;
		}
		
		public BusinessInfo initBusinessInfo() {
			this.uen = Utilities.generateRandomUen();
			return this;
			
		}
}
