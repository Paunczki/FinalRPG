public class Item {
	
	private String name;
	private int damage;
	private int healthAdded;
	//The value for Damage also includes the amount of health
	private int armorID;
	
	public Item(String name, int damage)
	{
		this.name = name;
		this.damage = damage;
	}
	
	public Item(String name, int healthAdded, int armorID)
	{
		this.name = name;
		this.healthAdded = healthAdded;
		this.armorID = armorID;
	}

	public String getName()
	{
		return this.name;
	}
	
	public int getItemDamage()
	{
		return this.damage;
	}
	
	public int getItemHealthAdded()
	{
		return this.healthAdded;
	}
	
	public int getArmorID()
	{ 
		return this.armorID;
	}
	
	
//	public boolean equals(Item otherItem) MIGHT NOT NEED THIS
//	{
//		if(this.name.equals(otherItem.getName()) && this.damage == otherItem.getItemDamage())
//		{
//			return true;
//		}
//		else
//		{
//			return false;
//		}
//	}
}