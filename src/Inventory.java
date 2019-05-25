import java.util.ArrayList;
/*
 * Armor - Helmet, chestplate, pants, boots, gloves
 * Weapons - wooden, stone, iron, diamond (Sword, axe)
 * Food
 * Potions (Magic)
 */
public class Inventory {
	
	private ArrayList<Item> inventory = new ArrayList<Item>();
	private int numItemsHead=0;
	private int numItemsChest=0;
	private int numItemsLegs=0;
	private int numItemsBoots=0;
	private int numItemsGloves=0;
	
	public int getNumItems() {
		return inventory.size();
	}
	
	public void addToInventory(Item itemToAdd)
	{
		inventory.add(itemToAdd);
	}
	public void removeFromInventory(Item itemToRemove) {
		inventory.remove(itemToRemove);
	}
	
	public void displayInventory()
	{
		String msg = "";
		for(int i = 0; i < inventory.size(); i++)
		{
			msg += ("Item " + (i+1) + ": " + inventory.get(i).getName() + "\n");
		}
		System.out.println(msg); 
	}
	
	public Item getFromInventory(int itemNumber)
	{
			return inventory.get(itemNumber);
	}
	public Item removesFromInventory(int itemNumber)
	{
			return inventory.remove(itemNumber);
	}
	
	public ArrayList<Item> getInventory()
	{
		return this.inventory;
	}
	
	public void displayHeadArmor() {
		for (int i=0; i<inventory.size(); i++) {
			if(inventory.get(i).getArmorID() == 0) {
				System.out.println((i+1)+". " + inventory.get(i).getName());
				numItemsHead++;
			}
		}
		System.out.println("");
	}
	public int getNumItemsHead() {
		return numItemsHead;
	}
	
	public void displayChestArmor() {
		for (int i=0; i<inventory.size(); i++) {
			if(inventory.get(i).getArmorID() == 1) {
				System.out.println((i)+". " + inventory.get(i).getName());
				numItemsChest++;
			}
		}
		System.out.println("");
	}
	public int getNumItemsChest() {
		return numItemsChest;
	}
	
	public void displayLegsArmor() {
		for (int i=0; i<inventory.size(); i++) {
			if(inventory.get(i).getArmorID() == 2) {
				System.out.println((i+1)+". " + inventory.get(i).getName());
				numItemsLegs++;
			}
		}
		System.out.println("");
	}
	public int getNumItemsLegs() {
		return numItemsLegs;
	}
	
	public void displayFeetArmor() {
		for (int i=0; i<inventory.size(); i++) {
			if(inventory.get(i).getArmorID() == 3) {
				System.out.println((i+1)+". " + inventory.get(i).getName());
				numItemsBoots++;
			}
		}
		System.out.println("");
	}
	public int getNumItemsFeet() {
		return numItemsBoots;
	}
	
	public void displayHandArmor() {
		for (int i=0; i<inventory.size(); i++) {
			if(inventory.get(i).getArmorID() == 4) {
				System.out.println((i+1)+". " + inventory.get(i).getName());
				numItemsGloves++;
			}
		}
		System.out.println("");
	}
	public int getNumItemsHand() {
		return numItemsGloves;
	}
	
}