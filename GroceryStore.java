
import java.util.*;
public class GroceryStore {
	public HashSet<Item> StoreCatalog = new HashSet<Item>();
	
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
		}
	}

	
	
}
