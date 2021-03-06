package InventorySys;
public class Meat extends Item{
	
	String animal;
	
	
	public Meat() {
		itemId = itemCount;
		itemDescription = "NA";
		itemPrice = 0.00;
		pricePer = PricingCategory.POUND;
		animal = "NA";
		itemCount++;
	}
	
	public Meat(String description, double price, boolean byPound, String animal) {
		itemId = itemCount;
		itemDescription = description;
		itemPrice = price;
		if (byPound) 
			pricePer = PricingCategory.POUND;
		else
			pricePer = PricingCategory.UNIT;
		this.animal = animal;
		itemCount++;
	}
	
	@Override
	public void printItem() {
		super.printItem();
		System.out.println("Source Animal: " + animal);
		
	}
	
}