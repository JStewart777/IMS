import java.util.*;
public class Membership {
	private int memID;
	private String memName;
	private static int memCount = 0;
	
	
	public Membership()   {
		memID = memCount;
		memName = "TBD";
		memCount++;
	}
	
	public Membership(String name)   {
		memID = memCount;
		memName = name;
	}
	
	
	public int getID()   {
		return memID;
	}
	
	public void setID(int id)   {
		memID = id;
	}
	
	public String getName()   {
		return memName;
	}
	
	public void setName(String name)   {
		memName = name;
	}
	
	
	public void print()   {
		System.out.println("Name: " + memName);
		System.out.println("ID Number: " + memID);
	}

}
