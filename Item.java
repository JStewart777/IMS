

public abstract class Item {

	int itemId;
	String itemDescription;
	double itemPrice;
	enum PricingCategory {POUND, UNIT};
	PricingCategory pricePer;
	String vendorName;
	protected static int itemCount = 0;
	
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	
//	public abstract void printItem();
	
	public void printItem()   {
		System.out.println("Item ID: " + itemId + ", " + itemDescription);
		System.out.println("Vendor Name: " + vendorName);
		System.out.println("Price: " + itemPrice + " per " + pricePer);
	}
	
	
	
	
	
}
