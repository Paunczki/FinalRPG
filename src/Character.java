import java.util.Random;
import java.util.Scanner;

public class Character{
	private int health;
	private int level;
	private int damage = 1;
	private String name;
	private Inventory weapons = new Inventory();
	private Inventory armor = new Inventory();
	private Inventory food = new Inventory();
	private Item[] equipped = new Item[6];
	private int wins = 0;
	private int winsLevel =0;
	private int monsterID;
	private int maxHealth;
	private static int planet = 1;
	private String[] monsters = {"Zombie Recruit", "Zombie Captain", "Zombie Runner",
			"Wraith Baby", "Wraith Child", "Wraith Teen", "Mutant Chicken", "Mutant Chicken Enforcer",
			"Mutant Chicken Pusher", "Alien Squid", "Alien Squid Chef", "Alien Squid Dancer"};
	private String[] weaponMaterial = {"Wood", "Leather", "Steel", "Grpahene"};
	
	public Character(int monsterID, int h, int l) {
		//make monster
		setHealth(h);
		setLevel(l);
		setName(monsters[monsterID]);
		setMonsterID(monsterID);
	}
	public Character() {
		//default monster
		createNewEnemy();
	}
	public Character(int b) {
		callBoss();
	}
	public Character(String n, int h, int l) {
		//player
		setHealth(h);
		setLevel(l);
		setName(n);
		setMaxHealth(h);
	}
	public void setMaxHealth(int i) {
		maxHealth = i;
	}
	public int getMaxHealth() {
		return maxHealth;
	}
	public void nextPlanet() {
		planet++;
	}
	public void setMonsterID(int id)
	{
		this.monsterID = id;
	}
	public int getMonsterID()
	{
		return this.monsterID;
	}
	public void setName(String n) {
		name = n;
	}
	public String getName() {
		return name;
	}
	public void setLevel(int l) {
		level = l;
	}
	public int getLevel() {
		return level;
	}
	public void setHealth(int h) {
		health = h;
	}
	public int getHealth() {
		return health;
	}
	public int getDamage() {
		return damage;
	}
	
	public int numItemsWeapons() {
		return weapons.getNumItems();
	}
	public int numItemsArmor() {
		return armor.getNumItems();
	}
	public int numItemsFood() {
		return food.getNumItems();
	}
	
	public void battle(Character newCharacter) throws Exception {
		int playerHealth = health;
		int enemyHealth = newCharacter.getHealth();
		int playerDamage = (level*10) + (damage/2);
		int enemyDamage = (newCharacter.getLevel()*10) + (newCharacter.getDamage()/2);
		Random playerAttack = new Random();
		Random enemyAttack = new Random();
		Random crit = new Random();
		
		System.out.println(name + "(lvl. " + getLevel() + ") vs. " + 
				newCharacter.getName() + "(lvl. " + newCharacter.getLevel() + ")");
		Thread.sleep(2000);
		System.out.println(name + "'s health: " + playerHealth);
		System.out.println(newCharacter.getName() + "'s health: " + enemyHealth + "\n");
		Thread.sleep(2000);
		
		while ((enemyHealth>0) && (playerHealth>0)) {
			if ((this.health < (30 + this.level*5))&&(this.numItemsFood()>0)) {
				System.out.println("You may want to consider healing. Eat some food");
				Thread.sleep(1500);
				this.view();
				System.out.println("");
			}
			System.out.println(name + " attacks...");
			Thread.sleep(1000);
			enemyHealth -= playerDamage + playerAttack.nextInt(damage);
			if(crit.nextInt(10)==0) {
				enemyHealth -= (damage*2);
				System.out.println("Critical Hit by " + name + "!");
				Thread.sleep(1000);
			}
			System.out.println(newCharacter.getName() + "'s health: " + enemyHealth + "\n");
			Thread.sleep(2500);
			if(enemyHealth<=0) {
				System.out.println("You win this battle!");
				wins++; winsLevel++;
				System.out.println("You have: " + wins+" wins!\n"); 
				Thread.sleep(5000);break;
			}
			
			
			System.out.println(newCharacter.getName() + " attacks...");
			Thread.sleep(1000);
			health -= enemyDamage + enemyAttack.nextInt(newCharacter.getDamage());
			if(crit.nextInt(20)==0) {
				health -= (damage*2);
				System.out.println("Critical Hit by " + newCharacter.getName() + "!");
				Thread.sleep(1000);
			}
			System.out.println(name + "'s health: " + health + "\n");
			Thread.sleep(2500);
			if(health<=0) {
				System.out.println("You Died \nThe End :(");
				Thread.sleep(5000);
				Text credits = new Text("Credits");
				credits.Text2Screen();
				System.exit(0);
			}	
		}
		if(winsLevel>=5) {
			level++;
			System.out.println("Level Up!");
			winsLevel=0;
			maxHealth += 25;
			health = maxHealth;
			System.out.println("Your health: " + health + " / " + maxHealth);
		}
	}

	
	public void addHealth(int addition) {
		health += addition;
		if(health > maxHealth) {
			health = maxHealth;
			System.out.println("Max Health!");
			System.out.println("Your health: " + health);
		}
	}
	
	public void subtractHealth(int subtraction) {
		health -= subtraction;
	}

	public void showInventory(int numOfInventory)
	{
		if(numOfInventory == 1)
		{
			weapons.displayInventory();
		}
		else if(numOfInventory == 2)
		{
			armor.displayInventory();
		}
		else if(numOfInventory == 3)
		{
			food.displayInventory();
		}
	}
	
	public void equip(int numOfInventory, int itemNumber)
	{
		if(numOfInventory == 1)
		{
			Item weaponToEquip = weapons.getFromInventory(itemNumber);
			equipped[5] = weaponToEquip;
			damage = equipped[5].getItemDamage();
		}
		else if(numOfInventory == 2)
		{
			Item armorToEquip = armor.getFromInventory(itemNumber);
			if(armorToEquip.getArmorID() == 0)
			{
				equipped[0] = armorToEquip;
				health+=equipped[0].getItemHealthAdded();
				maxHealth+=equipped[0].getItemHealthAdded();
			}
			else if(armorToEquip.getArmorID() == 1)
			{
				equipped[1] = armorToEquip;
				health+=equipped[1].getItemHealthAdded();
				maxHealth+=equipped[1].getItemHealthAdded();
			}
			else if(armorToEquip.getArmorID() == 2)
			{
				equipped[2] = armorToEquip;
				health+=equipped[2].getItemHealthAdded();
				maxHealth+=equipped[2].getItemHealthAdded();
			}
			else if(armorToEquip.getArmorID() == 3)
			{
				equipped[3] = armorToEquip;
				health+=equipped[3].getItemHealthAdded();
				maxHealth+=equipped[3].getItemHealthAdded();
			}
			else if(armorToEquip.getArmorID() == 4)
			{
				equipped[4] = armorToEquip;
				health+=equipped[4].getItemHealthAdded();
				maxHealth+=equipped[4].getItemHealthAdded();
			}
		}
	}
	
	public void displayEquipped() {
		System.out.println("Weapon: " + (equipped[5].getName()));
		System.out.println("Head Armor: " + (equipped[0].getName()));
		System.out.println("Chest Armor: " + (equipped[1].getName()));
		System.out.println("Leg Armor: " + (equipped[2].getName()));
		System.out.println("Feet Armor: " + equipped[3].getName());
		System.out.println("Hand Armor: " + equipped[4].getName());
		System.out.println("");
	}
	public void equipStarter() {
		Item weapon1 = new Item("Rope",5);
		Item armor1 = new Item("Grandpa's cowboy hat",1,0);
		Item armor2 = new Item("Ancient NASA t-shirt", 1, 1);
		Item armor3 = new Item("American blue jeans", 2, 2);
		Item armor4 = new Item("Ancient Nike Boots", 1, 3);
		Item armor5 = new Item("Ripped gloves", 0, 4);
		Item chicagoDeepDish = new Item("Deep Dish Chicago pizza", 25);
		this.addToWeaponsInventory(weapon1);
		this.addToArmorInventory(armor1);
		this.addToArmorInventory(armor2);
		this.addToArmorInventory(armor3);
		this.addToArmorInventory(armor4);
		this.addToArmorInventory(armor5);
		this.addToFoodInventory(chicagoDeepDish);
		this.addToFoodInventory(chicagoDeepDish);
		this.equip(1,0);
		this.equip(2,0);
		this.equip(2,1);
		this.equip(2,2);
		this.equip(2,3);
		this.equip(2,4);
	}
	
	public void addToWeaponsInventory(Item itemToAdd)
	{
		this.weapons.addToInventory(itemToAdd);
		System.out.println(itemToAdd.getName() + " added to weapon inventory");
	}
	
	public void displayWeapons()
	{
		this.weapons.displayInventory();
	}
	
	public void addToArmorInventory(Item itemToAdd)
	{
		this.armor.addToInventory(itemToAdd);
		System.out.println(itemToAdd.getName() + " added to armor inventory");
	}
	
	public void displayArmor()
	{
		this.armor.displayInventory();
	}
	
	public void addToFoodInventory(Item itemToAdd)
	{
		this.food.addToInventory(itemToAdd);
		System.out.println(itemToAdd.getName() + " added to food inventory");
	}
	
	public void removeFromFoodInventory(Item itemToRemove) {
		this.food.removeFromInventory(itemToRemove);
	}
	
	public void displayFood()
	{
		this.food.displayInventory();
	}
	public String getEquipped(int i) {
		return equipped[i].getName();
	}
	
	public void createNewWeapon() {
		String[] weaponTypes = {"Axe", "Sword", "Laser Rifle", "Bow and Arrow", "Laser Pistol"};
		String weaponName;
		int weaponDamage;
		String weaponType;
		String weaponu;
		
		Random random = new Random();
		Random weapons = new Random();
		Random newDamage = new Random();
		weaponu = weaponTypes[weapons.nextInt(5)];
		weaponDamage = (newDamage.nextInt(6))+(this.getLevel()*4);
		
		if ((level > 0) && (level<3)) {
			weaponType = weaponMaterial[random.nextInt(2)];
		}
		if (level>=3) {
			if(random.nextInt(3) == 0) {
				weaponType = weaponMaterial[3];
			}
			else {
				weaponType = weaponMaterial[2];
			}
		}
		else {
			weaponType = weaponMaterial[0];
		}
		
		weaponName = (weaponType + " " + weaponu);
		Item newItem = new Item(weaponName, weaponDamage);
		this.addToWeaponsInventory(newItem);
	}
	public void createNewArmor() {
		String[] armorTypes = {"Helmet", "Chestplate", "Leggings", "Boots", "Gloves"};
		String armorName;
		int healthAdded;
		int armorID;
		String weaponType;
		String armoru;
		
		Random random = new Random();
		Random armors = new Random();
		Random newHealthAdded = new Random();
		int j = armors.nextInt(5);
		armoru = armorTypes[j];
		armorID = j;
		healthAdded = (newHealthAdded.nextInt(10))+(this.getLevel()*5);
		
		if ((level > 0) && (level<3)) {
			weaponType = weaponMaterial[random.nextInt(2)];
		}
		if (level>=3) {
			if(random.nextInt(3) == 0) {
				weaponType = weaponMaterial[3];
			}
			else {
				weaponType = weaponMaterial[2];
			}
		}
		else {
			weaponType = weaponMaterial[0];
		}
		armorName = (weaponType + " " + armoru);
		Item newItem = new Item(armorName, healthAdded, armorID);
		this.addToArmorInventory(newItem);
	}
	public void createNewFood() {
		String[] foodTypes = {"Nutritious Watermelon", "Space Zombie Meat", "Goober Sauce!",
				"Alien Squid Pasta", "Chocolate Brains"};
		String foodName;
		int addedHealth;
		
		Random random = new Random();
		Random tasty = new Random();
		foodName = foodTypes[random.nextInt(5)];
		addedHealth = ((this.getLevel()*5)+(tasty.nextInt(10)))+10;
		
		Item newItem = new Item(foodName, addedHealth);
		this.addToFoodInventory(newItem);
	}
	
	public void getEquipped() {
		System.out.println("Head Armor: " + (equipped[0].getName()));
		System.out.println("Chest Armor: " + (equipped[1].getName()));
		System.out.println("Leg Armor: " + (equipped[2].getName()));
		System.out.println("Feet Armor: " + equipped[3].getName());
		System.out.println("Hand Armor: " + equipped[4].getName());
		System.out.println("");
	}
	
	public void view() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Would you like to access inventory?");
		System.out.println("1. Yes \n2. No");
		choice inventoryChoice = new choice();
		System.out.print("Your response: ");
		inventoryChoice.setResponse(keyboard.next());
		boolean moveAround = true;
		while(moveAround ==true) {
			if (inventoryChoice.getResponse() == 01) {
				System.out.println("1. Weapons \n2. Armor \n3. Food \n4. View Equipped \n5. Exit");
				choice directory = new choice(1, 5);
				System.out.print("Your response: ");
				directory.setResponse(keyboard.next());
				System.out.println("");
				if (directory.getResponse() == 1) {
					this.displayWeapons();
					System.out.println("1. Equip Item # \n2. View Equipped Weapon \n3. Back \n4. Exit");
					choice weaponChoice = new choice(1,4);
					System.out.print("Your response: ");
					weaponChoice.setResponse(keyboard.next());
					System.out.println("");
					if(weaponChoice.getResponse() == 1) {
						this.displayWeapons();
						choice equippingWeapon = new choice(1,this.numItemsWeapons());
						System.out.println("What weapon would you like to equip?");
						System.out.print("Your response: ");
						equippingWeapon.setResponse(keyboard.next());
						this.equip(1,equippingWeapon.getResponse()-1);
					}
					if(weaponChoice.getResponse() == 2) {
						System.out.println(this.getEquipped(5) + "\n");
					}
					if(weaponChoice.getResponse() == 3) {
						continue;
					}
					if(weaponChoice.getResponse() == 4) {
						moveAround=false;
					}
				}
				if (directory.getResponse() == 2) {
					this.displayArmor();
					System.out.println("1. Equip Armor \n2. View Equipped Armor \n3. Back \n4. Exit");
					choice armorChoice = new choice(1,4);
					System.out.print("Your response: ");
					armorChoice.setResponse(keyboard.next());
					System.out.println("");
					if(armorChoice.getResponse() == 1) {
						System.out.println("1. Head Armor \n2. Chest Armor \n3. Leg Armor \n4. "
								+ "Feet Armor \n5. Hand Armor \n6. Back");
						choice armorDirectory = new choice(1,6);
						System.out.print("Your response: ");
						armorDirectory.setResponse(keyboard.next());
						System.out.println("");
						if (armorDirectory.getResponse() == 1) {
							this.armor.displayHeadArmor();
							choice equippingArmor = new choice(1,this.armor.getNumItemsHead());
							System.out.println("What head armor would you like to equip?");
							System.out.print("Your response: ");
							equippingArmor.setResponse(keyboard.next());
							this.equip(2,equippingArmor.getResponse()-1);
						}
						if (armorDirectory.getResponse() ==2) {
							this.armor.displayChestArmor();
							choice equippingArmor = new choice(1,this.armor.getNumItemsChest());
							System.out.println("What head armor would you like to equip?");
							System.out.print("Your response: ");
							equippingArmor.setResponse(keyboard.next());
							this.equip(2,equippingArmor.getResponse()-1);
						}
						if (armorDirectory.getResponse() ==3) {
							this.armor.displayLegsArmor();
							choice equippingArmor = new choice(1,this.armor.getNumItemsLegs());
							System.out.println("What head armor would you like to equip?");
							System.out.print("Your response: ");
							equippingArmor.setResponse(keyboard.next());
							this.equip(2,equippingArmor.getResponse()-1);
						}
						if (armorDirectory.getResponse() ==4) {
							this.armor.displayFeetArmor();
							choice equippingArmor = new choice(1,this.armor.getNumItemsFeet());
							System.out.println("What head armor would you like to equip?");
							System.out.print("Your response: ");
							equippingArmor.setResponse(keyboard.next());
							this.equip(2,equippingArmor.getResponse()-1);
						}
						if (armorDirectory.getResponse() ==5) {
							this.armor.displayHandArmor();
							choice equippingArmor = new choice(1,this.armor.getNumItemsHand());
							System.out.println("What head armor would you like to equip?");
							System.out.print("Your response: ");
							equippingArmor.setResponse(keyboard.next());
							this.equip(2,equippingArmor.getResponse()-1);
						}
						if (armorDirectory.getResponse() ==6) {
							continue;
						}
					}
					if(armorChoice.getResponse() == 2) {
						this.getEquipped();
					}
					if(armorChoice.getResponse() == 3) {
						continue;
					}
					if(armorChoice.getResponse() == 4) {
						moveAround=false;
					}	
				}
				if (directory.getResponse() == 3) {
					if(this.numItemsFood()==0) {
						System.out.println("Looks Like you have no food \n");
						continue;
					}
					this.displayFood();
					System.out.println("1. Eat Item # \n2. See Health \n3. Back \n4. Exit");
					choice foodChoice = new choice(1,4);
					System.out.print("Your response: ");
					foodChoice.setResponse(keyboard.next());
					System.out.println("");
					if(foodChoice.getResponse() == 1) {
						this.displayFood();
						choice equippingFood = new choice(1,this.numItemsFood());
						System.out.println("What food would you like to eat?");
						System.out.print("Your response: ");
						equippingFood.setResponse(keyboard.next());
						int add=food.getFromInventory(equippingFood.getResponse()-1).getItemDamage();
						food.removesFromInventory(equippingFood.getResponse()-1);
						this.addHealth(add);
						System.out.println("Your Health: " + this.health + " / " + this.maxHealth);
					}
					if(foodChoice.getResponse() == 2) {
						System.out.println("Your Health: " + this.getHealth());
					}
					if(foodChoice.getResponse() == 3) {
						continue;
					}
					if(foodChoice.getResponse() == 4) {
						moveAround=false;
					}	
				}
				if (directory.getResponse() == 4) {
					this.displayEquipped();
				}
				if (directory.getResponse() == 5) {
					System.out.println("");
					moveAround = false;
				}
			}
			if (inventoryChoice.getResponse() == 02) {
				System.out.println("Returning to game...\n");
				moveAround = false;
			}
		}
	}
	
	public void createNewEnemy() {
		int enemyLevel;
		int monsterID;
		int enemyHealth;
		Random random = new Random();
		enemyLevel = planet;
		monsterID = ((random.nextInt(3))+(3*(planet-1)));
		enemyHealth = enemyLevel * 30;
		
		setHealth(enemyHealth);
		setLevel(enemyLevel);
		setName(monsters[monsterID]);
		setMonsterID(monsterID);
	}
	public void callBoss() {
		String[] bossPlanets = {"Zombie Boss", "Queen Wraith", "The Creator of Mutant Chicken World", 
				"Squid CEO","Dragon"};
		name = bossPlanets[planet-1];
		int bossLevel = planet;
		int bossHealth = ((bossLevel)*50);
		
		setHealth(bossHealth);
		setLevel(bossLevel);
		setName(bossPlanets[planet-1]);
	}
	
	public void encounterChest() {
		System.out.println("\nYou find a chest and take all its items...");
		Random pizza = new Random();
		int decision = pizza.nextInt(5);
		for(int i = 0; i<=decision; i++) {
			this.createNewFood();
		}
		Random armory = new Random();
		int decision2 = armory.nextInt(3);
		for(int j=0; j<=decision2; j++) {
			this.createNewArmor();
		}
		Random weaponry = new Random();
		int decision3 = weaponry.nextInt(2);
		for(int k=0; k<=decision3; k++) {
			this.createNewWeapon();
		}	
		System.out.println("");
	}
}