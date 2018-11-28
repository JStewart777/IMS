
public class Produce extends Item {
	
	int daysToExpiry;
	enum Season {SPRING, SUMMER, FALL, WINTER};
	String region;
	Season harvestSeason;
	
	public Produce() {
		itemId = itemCount;
		itemDescription = "Tomato";
		itemPrice = 3.99;
		pricePer = PricingCategory.POUND;
		vendorName = "AJAX Vegetables";
		daysToExpiry = 7;
		harvestSeason = Season.SUMMER;
		region = "Southeast US";
		itemCount++;
	}
	
	public int getDaysToExpiry() {
		return daysToExpiry;
	}
	public void setDaysToExpiry(int daysToExpiry) {
		this.daysToExpiry = daysToExpiry;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
	@Override
	public void printItem() {
		super.printItem();
		System.out.println(daysToExpiry + " days until expiration.");
		System.out.println("Region: " + region + "Harvest Season: " + harvestSeason);
		
		
		
		}
	
	
}
