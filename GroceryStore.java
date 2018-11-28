import java.util.*;
public class GroceryStore {
	//TODO: make a collection to hold this data
	
	HashMap<Item,Integer> Store = new HashMap<Item,Integer>();
	ArrayList<Membership> MemList = new ArrayList<Membership>();
	
	
	public void putOnSale() {
		//TODO: select either meat or produce, 
		//and input % to discount the item with less than x days till expiration
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
	
	
	
	
}
