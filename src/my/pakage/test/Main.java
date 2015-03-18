package my.pakage.test;

import java.util.Random;

public class Main {
	
	public static void main(String[] args) {
		Random rnd = new Random();
		
		Human[] mobs = new Human[10];
		
		mobs[0] = new NormalPlayer("Normal Player 1", 5, 1, 10, 100);
		mobs[1] = new NormalPlayer("Normal Player 2", 5, 1, 10, 100);
		mobs[2] = new DonatePlayer("Donate Player 1", 15, 1, 10, 100);
		mobs[3] = new DonatePlayer("Donate Player 2", 15, 1, 10, 100);
		
		
		for (int i = 1; i <= 100; i++) {
			System.out.println("Õîä " + i + ".");
			
			try {
				Thread.currentThread().sleep(2000);
			} catch (Exception e) {};
			
		}
		
		
		
//		Player paladin = new Player("Paladin", 10, 5, 80, 40, 150);
//		Player enemy1 = new Player("Orc", 15, 3, 55, 25, 150);
//		Enemy enemy2 = new Enemy("Zombie", 7, 2, 40, 10, 70);
//		Weapon shortSword = new Weapon("Short Sword", 25, 3, 25);
				
//		paladin.info();
////		enemy1.info();
////		paladin.attack(enemy1);
////		enemy1.info();
//		enemy2.info();
//		
//		if (rnd.nextBoolean())
//		    enemy2.pickUpWeapon(shortSword);
//		if (rnd.nextBoolean())
//			paladin.pickUpWeapon(shortSword);
//		paladin.attack(enemy2);
//		enemy2.info();
//		
//		enemy2.atack(paladin);
//		paladin.info();
		
	}

}
