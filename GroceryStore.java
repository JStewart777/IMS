package InventorySys;

import java.util.*;

import InventorySys.Item.PricingCategory;
public class GroceryStore {
	public HashSet<Item> StoreCatalog = new HashSet<Item>();
	
	GroceryCart myCart = new GroceryCart();
	
	HashMap<Item,Integer> Cart = new HashMap<Item,Integer>();	
	
	public void addCartItem(Item item, Integer quantity) { 
		Cart.put(item, quantity);
	}
		
	
	public void addProduce(String description, double price, boolean byPound) {
		Produce p = new Produce(description, price, byPound); 
		StoreCatalog.add(p);
	}
	
	public void addMeat(String description, double price, boolean byPound, String animal) {
		Meat m = new Meat(description, price, byPound, animal);
		StoreCatalog.add(m);
	}
	
	public void printCatalogItems() {
		for (Item i : StoreCatalog) {
			i.printDesc();
			System.out.print("\n");
		}
	}
	
	public Item chooseItem(GroceryStore store, Scanner sc) { 
		while (true) {
			store.printCatalogItems();
			sc.nextLine();
			String userInput = sc.nextLine();
			for (Item i : StoreCatalog) {
				if (i.getItemDescription().equalsIgnoreCase(userInput)) {
					return i;
				}
			}
			System.out.println("Invalid entry. Please try again.");
		}
	}
	
	public void addItemToCart (Item i, Scanner sc, GroceryStore myStore) {
		i.printItem();
		if (i.getPricingCategory() == PricingCategory.POUND) {
			System.out.println("How many pounds of " + i.getItemDescription() + "?");
		}
		else {
			System.out.println("How many units of " + i.getItemDescription() + "?");
		}
		Integer quantity = sc.nextInt();
		myStore.addCartItem(i, quantity);
	}

	public void goShopping(GroceryStore myStore, GroceryCart myCart, Scanner sc) {
		
		while (true) {
			System.out.println("Add another item? Yes/No");
			String menu = sc.nextLine();
			if (menu.equalsIgnoreCase("NO"))
				break;
			else if (menu.equalsIgnoreCase("YES"))
				myStore.addItemToCart(myStore.chooseItem(myStore, sc), sc, myStore);
			else 
				System.out.println("Invalid Entry.");
		}
			myStore.printCartReceipt();
	}
	
	public void printCartReceipt() {
		double totalPrice = 0;
		for (Item i : Cart.keySet()) { 
			i.printDesc();
			System.out.println(" : " + Cart.get(i));
			double linePrice = i.getItemPrice() * Cart.get(i);
			System.out.println("Line Price: $" + linePrice);
			totalPrice = totalPrice + linePrice;
		}
		
		System.out.println("Total Price: $" + totalPrice);
	}
	
	
}

