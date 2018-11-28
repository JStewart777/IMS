
import java.util.*;

import InventorySys.Item.PricingCategory;
public class GroceryStore {
	//TODO: make a collection to hold this data
	

	HashMap<Item,Integer> Store = new HashMap<Item,Integer>();
	ArrayList<Membership> MemList = new ArrayList<Membership>();
	

	GroceryCart myCart = new GroceryCart();
	HashMap<Item,Integer> Cart = new HashMap<Item,Integer>();	
	
	public void addCartItem(Item item, Integer quantity) { 
		Cart.put(item, quantity);
	}
		
	
	public void addProduce(String description, double price, boolean byPound) {
		Produce p = new Produce(description, price, byPound); 
		StoreCatalog.add(p);

	}
	
	public void addMember(Scanner scnr)   {
		System.out.println("Enter name:");
		String name = scnr.nextLine();
		scnr.nextLine();
		System.out.println("Did they pay the $50 membership fee? Enter 'Yes' or 'No'"); 
		String answer = scnr.next();
		while(answer.equalsIgnoreCase("No"))   {
			System.out.println("You cannot obtain a membership until you have paid the $50 membership fee. Please try again.");
			answer = scnr.next();
		}
		if(answer.equalsIgnoreCase("Yes"))   {
			Membership m1 = new Membership(name);
			MemList.add(m1);
		}
		else  {
			System.out.println("Please enter either 'Yes' or 'No'");
		}
	}
	

	public void removeMember(int id)   {//THIS MAY OR MAY NOT WORK
		for(Membership i : MemList)   {
			if(i.getID() == id)   {
				MemList.remove(i);
			}
		}
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

