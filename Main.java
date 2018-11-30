package InventorySys;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		GroceryStore myStore = new GroceryStore();
		Scanner sc = new Scanner(System.in);
		
		
		myStore.addMeat("Filet Mignon", 14.99, true, "Cow");
		myStore.addMeat("Burgers", 5, false, "Cow");
		myStore.addMeat("Chile Lime Chicken",8.99,true, "Chicken");
		myStore.addProduce("Spinach", 3.00, false);
		myStore.addProduce("Romaine", 0.10, false);
		myStore.addProduce("Avocados",3.79,false);
		
		
		
		System.out.println("Welcome to the MIS Farmers Market!");
		
		while (true) { 
			System.out.println("What would you like to do?" + "\n");
			System.out.println("1. Begin shopping");
			System.out.println("2. Manage memberships");
			System.out.println("3. Exit the store.");
			sc.nextLine();//TODO
			String menuInput = sc.nextLine();
			char menuOption = menuInput.charAt(0);
			if (menuOption == '1') {
				myStore.goShopping(myStore, sc);
				myStore.exit();
			}
			else if (menuOption == '2') {
				myStore.memberManage(sc, myStore);
			}
			else if (menuOption == '3')
				myStore.exit();
			else 
				System.out.println("Invalid Entry");
		}


	}

}