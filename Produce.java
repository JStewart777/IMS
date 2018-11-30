package InventorySys;
public class Produce extends Item {
	
	
	
	public Produce() {
		itemId = itemCount;
		itemDescription = "Tomato";
		itemPrice = 3.99;
		pricePer = PricingCategory.POUND;
		itemCount++;
	}
	
	public Produce(String description, double price, boolean byPound) {
		itemId = itemCount;
		itemDescription = description;
		itemPrice = price;
		if (byPound) 
			pricePer = PricingCategory.POUND;
		else
			pricePer = PricingCategory.UNIT;
		itemCount++;
	}
	
	

	public void printItem() {
		super.printItem();
		}
	
	
}