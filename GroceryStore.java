package InventorySys;

import java.util.*;

import InventorySys.Item.PricingCategory;
public class GroceryStore {
	HashSet<Item> StoreCatalog = new HashSet<Item>(); 
	HashMap<Item,Integer> Cart = new HashMap<Item,Integer>();	
	ArrayList<Membership> MemList = new ArrayList<Membership>();
	
	public void memberManage(Scanner sc, GroceryStore myStore) {
		while (true) {
			System.out.println("~MEMBERSHIP MANAGEMENT~");
			System.out.println("1. Add a member");
			System.out.println("2. Remove a member");
			System.out.println("3. Return to main menu");
			String menuInput = sc.nextLine();
			char menuOption = menuInput.charAt(0);
			if (menuOption == '1') {
				myStore.addMember(sc);
			}
			else if (menuOption == '2') {
				System.out.println("~REMOVE A MEMBER~");
				System.out.println("What is the ID of membership to be cancelled?");
				String idString = sc.nextLine();
				int id = Integer.parseInt(idString);
				myStore.removeMember(id);
			}
			else {
				break;
			}
		}
		
	}
	
	
	private void addMember(Scanner scnr)   {
		System.out.println("Enter name:");
		String name = scnr.nextLine();
		scnr.nextLine();
		System.out.println("Did they pay the $50 membership fee? Enter 'Yes' or 'No'"); 
		String answer = scnr.next();
		while(answer.equalsIgnoreCase("No"))   {
			System.out.println("Membership cannot be obtained until $50 membership fee is paid. Please try again.");
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
	

	public void removeMember(int id)   {//TODO: This does not work
		for(Membership i : MemList)   {
			if(i.getID() == id)   {
				MemList.remove(i);
			}
			else {
				System.out.println("ID does not exist.");
			}
		}
	}
	
	//Only a one-line helper method - DEPRECATED
// 	public void addCartItem(Item item, Integer quantity) { 
// 		Cart.put(item, quantity);
// 	}
		
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
			//sc.nextLine(); 
			//may no longer need this dummy because we arent using nextInt().
			String userInput = sc.nextLine();
			for (Item i : StoreCatalog) {
				if (i.getItemDescription().equalsIgnoreCase(userInput)) {
					return i;
				}
			}
			System.out.println("Invalid entry.");
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
		String quantityString = sc.nextLine();
		Integer quantity = Integer.parseInt(quantityString);
		Cart.put(i, quantity);
		//myStore.addCartItem(i, quantity); DEPRECATED
	}

	public void goShopping(GroceryStore myStore, Scanner sc) {
		while (true) {
			System.out.println("Please select an item by typing its name to view item details.");
			myStore.addItemToCart(myStore.chooseItem(myStore, sc), sc, myStore);
			System.out.println("Add another item? (Yes/No)");
			String menu = sc.nextLine();
			if (menu.equalsIgnoreCase("NO"))
				break;
			else if (menu.equalsIgnoreCase("YES")) {
				continue;
			}
		}
	myStore.printCartReceipt();
	}
	
		
//		int counter = 0;
//		while (true) {
//			if (counter > 0) {
//					while (true) {
//						System.out.println("Add another item? Yes/No");
//						String menu = sc.nextLine();
//						if (menu.equalsIgnoreCase("NO"))
//							break;
//						else if (menu.equalsIgnoreCase("YES")) {
//							myStore.addItemToCart(myStore.chooseItem(myStore, sc), sc, myStore);
//							break;
//						}
//					else 
//						System.out.println("Invalid Entry.");
//					}
//			counter++;
//			System.out.println("Please select an item by typing its name to view item details.");
//			myStore.addItemToCart(myStore.chooseItem(myStore, sc), sc, myStore);
//			
//			
//			}
//			myStore.printCartReceipt();
	
	
	public void printCartReceipt() {
		double totalPrice = 0;
		for (Item i : Cart.keySet()) { 
			i.printDesc();
			System.out.println(" x" + Cart.get(i) + " @ $" + i.getItemPrice());
			double linePrice = i.getItemPrice() * Cart.get(i);
			System.out.println("= $" + linePrice);
			totalPrice = totalPrice + linePrice;
		}
		//TODO: If member, decrease price by x%
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Total: $" + totalPrice);
	}



	public void exit() {
		System.out.println("Thank you for visiting the MIS Farmers Market!");
		System.exit(0);
	}


	
}
