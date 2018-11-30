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
		System.out.println("3. Print Membership List");
		System.out.println("4. Generate Coupon List");
		System.out.println("5. Return to main menu");
		int menuInput = sc.nextInt();
		if (menuInput == 1) {
			myStore.addMember(sc);
		}
		else if (menuInput == 2) {
			System.out.println("~REMOVE A MEMBER~");
			System.out.println("What is the ID of membership to be cancelled?");
			int id = sc.nextInt();
			myStore.removeMember(id);
		}
		else if(menuInput == 3)   {
			myStore.printMembers();
		}
		else if (menuInput ==4)   {
			if (MemList.size()==0)   {
				System.out.println("No members exist.");
				continue;
			}
			else   {
				myStore.generateCoupons();
			}
		}
		else {
			break;
		}
	}
	
}

	private void addMember(Scanner scnr)   {
		System.out.println("Enter name:");
		String name = scnr.next();
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
			answer = scnr.next();
			
	}
}

	public void removeMember(int id)   {
		int counter = 0;
		Membership memberToRemove = null;
		for(Membership i : MemList)   {
			if(i.getID() == id) {
				memberToRemove = i;
				System.out.println("-----------------");
				System.out.println("Member Removed.");
				counter++;
			}

		}
		if (counter == 0)   {
			System.out.println("ID does not exist.");
		}
		MemList.remove(memberToRemove);
	}

	public void printMembers()   {
		for(Membership j : MemList)   {
			j.print();
		}
	}
	
	public void generateCoupons()   {
		Membership [] couponList = new Membership[MemList.size()];
		for(int i = 0; i<couponList.length; i++)   {
			couponList[i] = MemList.get(i);
		}
		System.out.println("Coupon List generated.");
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
	myStore.printCartReceipt(sc);
	}
	
	
	public void printCartReceipt(Scanner sc) {
		double totalPrice = 0;
		for (Item i : Cart.keySet()) { 
			i.printDesc();
			System.out.println(" : " + Cart.get(i));
			double linePrice = i.getItemPrice() * Cart.get(i);
			System.out.println("Line Price: $" + linePrice);
			totalPrice = totalPrice + linePrice;
		}
		double discount = 1.00;
		System.out.println("Are you a member? (Yes/No)");
		String input = sc.nextLine();
		if (input.equalsIgnoreCase("YES")) {
			System.out.println("Discount Applied.");
			discount = 0.9;
		}
		System.out.println("Total Price: $" + discount*totalPrice);
	}

	public void exit() {
		System.out.println("Thank you for visiting the MIS Farmers Market!");
		System.exit(0);
	}
	
}