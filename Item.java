package InventorySys;

public abstract class Item {

	int itemId;
	String itemDescription;
	double itemPrice;
	enum PricingCategory {POUND, UNIT};
	PricingCategory pricePer;
	protected static int itemCount = 1;
	
	
	
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

	
//	public abstract void printItem();
	
	public void printItem()   {
		System.out.println("Item ID: " + itemId + ", " + itemDescription);
		System.out.println("Price: " + itemPrice + " per " + pricePer);
	}
	
	public void printDesc() {
		System.out.print(itemDescription);
	}
	
	
	
	
	
}
