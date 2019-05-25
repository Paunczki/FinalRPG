import java.util.Scanner;
public class Main{
	public static void main (String[] args) throws Exception{
		Scanner keyboard = new Scanner(System.in);
		
		Text clear = new Text("Clear Screen", 13232);
		Text fullSpeedAhead = new Text("Full Speed Ahead");
		Text credits = new Text("Credits");
		Text title = new Text("Title");
		title.TextToScreen(50);
		clear.TextToScreen(150);
		Text NameSelection = new Text("NameSelection");
		NameSelection.Text2Screen();
		String name = keyboard.next();
		Character player = new Character(name, 50, 1);
		clear.TextToScreen(150);
		
		System.out.println("Hi " + player.getName() + ".");
		Text tutorial = new Text("Tutorial");
		tutorial.Text2Screen();
		player.view();
		clear.TextToScreen(150);
		
		Text newText1 = new Text("Untitled 1");
		newText1.Text2Screen();
		Thread.sleep(5000);
		player.equipStarter();
		clear.TextToScreen(150);
		Text newText2 = new Text("Untitled 2");
		newText2.Text2Screen();
		choice newChoice = new choice(1,3);
		newChoice.setResponse(keyboard.next());
		
		if(newChoice.getResponse()==3) {
			player.view();
			newChoice.setResponse("1");
		}
		if(newChoice.getResponse() == 1) {
			Text exploreShip1 = new Text("exploreShip1");
			exploreShip1.Text2Screen();
			Item dadsLaserPistol = new Item("Dad's Laser Pistol", 18);
			player.addToWeaponsInventory(dadsLaserPistol);
			player.equip(1, 1);
			Text firstFight = new Text("First Fight");
			firstFight.Text2Screen();
			Character shipEnemy = new Character("Alien", 25, 0);
			player.battle(shipEnemy);
			Text shipLeave = new Text("Untitled 3");
			shipLeave.Text2Screen();
			newChoice.setResponse("2");
		}
		if(newChoice.getResponse() ==2) {
			fullSpeedAhead.Text2Screen();
		}
		
		clear.TextToScreen(150);
		
//planet 1
		Text zombiePlanet1 = new Text("zombie planet 1");
		zombiePlanet1.Text2Screen();
		ZombieSwing zombieBitch = new ZombieSwing();
		
		Character zombie1 = new Character();
		Character zombie2 = new Character();
		Character zombie3 = new Character();
		
		zombieBitch.main(null);
		player.battle(zombie1);
		zombieBitch.main(null);
		player.battle(zombie2);
		zombieBitch.main(null);
		player.battle(zombie3);
		Text zombiePlanet2 = new Text("zombie planet 2");
		zombiePlanet2.Text2Screen();
		Thread.sleep(2000);
		player.view();
		Character zombieBoss = new Character(141);
		zombieBitch.main(null);
		player.battle(zombieBoss);
		Thread.sleep(2000);
		player.encounterChest();
		Thread.sleep(2000);
		player.view();
		Text zombiePlanet3 = new Text("zombie planet 3");
		zombiePlanet3.Text2Screen();
		choice newChoice2 = new choice(1,3);
		newChoice2.setResponse(keyboard.next());
		if(newChoice2.getResponse() == 1) {
			Character zombie4 = new Character();
			zombieBitch.main(null);
			player.battle(zombie4);
			newChoice2.setResponse("2");
		}
		if(newChoice2.getResponse() == 2) {
			fullSpeedAhead.Text2Screen();
			player.nextPlanet();
		}
		if(newChoice2.getResponse() == 3) {
			Text zombieHordeDeath = new Text("Zombie Horde Death");
			zombieHordeDeath.Text2Screen();
			Thread.sleep(5000);
			credits.Text2Screen();
			System.exit(0);
		}
		clear.TextToScreen(150);
		
//planet 2
		Text wraithPlanet1 = new Text("wraith planet 1");
		wraithPlanet1.Text2Screen();
		Character wraiths1 = new Character();
		WraithSwing wraith = new WraithSwing();
		wraith.main(null);
		player.battle(wraiths1);
		Text wraithPlanet2 = new Text("wraith planet 2");
		wraithPlanet2.Text2Screen();
		Character wraithBoss = new Character(1312);
		wraith.main(null);
		player.battle(wraithBoss);
		player.encounterChest();
		Text wraithPlanet3 = new Text("wraith planet 3");
		wraithPlanet3.Text2Screen();
		choice newChoice3 = new choice(1,3);
		newChoice3.setResponse(keyboard.next());
		if(newChoice3.getResponse() == 1) {
			Character wraith2 = new Character();
			wraith.main(null);
			player.battle(wraith2);
			newChoice3.setResponse("2");
		}
		if(newChoice3.getResponse() == 2) {
			Text wraithPlanet4 = new Text("wraith planet 4");
			wraithPlanet4.Text2Screen();
			player.nextPlanet();
		}
		if(newChoice3.getResponse() == 3) {
			Character swoleWraith = new Character("Swole Wraith", 50, 4);
			wraith.main(null);
			player.battle(swoleWraith);
			Text wraithHordeDeath = new Text("Wraith Horde Death");
			wraithHordeDeath.Text2Screen();
			Thread.sleep(5000);
			credits.Text2Screen();
			System.exit(0);
		}
		clear.TextToScreen(150);
		
//planet 3
		Text chickenPlanet1 = new Text("chicken planet 1");
		chickenPlanet1.Text2Screen();
		MutantChickenSwing chicken = new MutantChickenSwing();
		Character chickenBoss = new Character(1313123);
		chicken.main(null);
		player.battle(chickenBoss);
		Thread.sleep(2000);
		player.encounterChest();
		Thread.sleep(2000);
		Text chickenPlanet2 = new Text("chicken planet 2");
		chickenPlanet2.Text2Screen();
		choice newChoice4 = new choice(1,3);
		newChoice4.setResponse(keyboard.next());
		if(newChoice4.getResponse()==3) {
			player.view();
			newChoice4.setResponse("1");
		}
		if(newChoice4.getResponse() == 1) {
			Text chickenPlanet3 = new Text("chicken planet 3");
			chickenPlanet3.Text2Screen();
			choice newChoice5 = new choice(1,2);
			newChoice5.setResponse(keyboard.next());
			if(newChoice5.getResponse() == 1) {
				Text chickenPlanet4 = new Text("chicken planet 4");
				chickenPlanet4.Text2Screen();
				Thread.sleep(5000);
				credits.Text2Screen();
				System.exit(0);
			}
			if(newChoice5.getResponse() == 2) {
				fullSpeedAhead.Text2Screen();
				player.nextPlanet();
			}
		}
		if(newChoice4.getResponse() == 2) {
			fullSpeedAhead.Text2Screen();
			player.nextPlanet();
		}
		clear.TextToScreen(150);
		
//planet 4
		Text squidPlanet1 = new Text("squid planet 1");
		squidPlanet1.Text2Screen();
		Character squid1 = new Character();
		Character squid2 = new Character();
		AlienSquidSwing squid = new AlienSquidSwing();
		squid.main(null);
		player.battle(squid1);
		Text squidPlanet2 = new Text("squid planet 2");
		squidPlanet2.Text2Screen();
		choice newChoice6 = new choice(1,4);
		newChoice6.setResponse(keyboard.next());
		if(newChoice6.getResponse()==4) {
			player.view();
			newChoice6.setResponse("1");
		}
		if(newChoice6.getResponse() == 1) {
			squid.main(null);
			player.battle(squid2);
			Text squidPlanet3 = new Text("squid planet 3");
			squidPlanet3.Text2Screen();
			player.nextPlanet();
		}
		if(newChoice6.getResponse() == 2) {
			Text squidPlanet4 = new Text("squid planet 4");
			squidPlanet4.Text2Screen();
			player.nextPlanet();
		}
		if(newChoice6.getResponse() == 3) {
			Text squidPlanet5 = new Text("squid planet 5");
			squidPlanet5.Text2Screen();
			Thread.sleep(5000);
			credits.Text2Screen();
			System.exit(0);
		}
		clear.TextToScreen(150);
		
//planet 5
		Text dragonDen = new Text("Dragon's Den");
		DragonSwing dragon = new DragonSwing();
		dragon.main(null);
		dragonDen.Text2Screen();
		Thread.sleep(2000);
		clear.Text2Screen();
		credits.TextToScreen(150);
		
//ending
		keyboard.close();
		System.exit(0);
	}
}
