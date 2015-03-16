package my.pakage.test;

import java.util.Random;

public class Main {
	
	public static void main(String[] args) {
		Random rnd = new Random();
		
		Player paladin = new Player("Paladin", 10, 5, 80, 40, 150);
		Player enemy1 = new Player("Orc", 15, 3, 55, 25, 150);
		Enemy enemy2 = new Enemy("Zombie", 7, 2, 40, 10, 70);
		Weapon shortSword = new Weapon("Short Sword", 25, 3, 25);
				
		paladin.info();
//		enemy1.info();
//		paladin.attack(enemy1);
//		enemy1.info();
		enemy2.info();
		
		if (rnd.nextBoolean())
		    enemy2.pickUpWeapon(shortSword);
		if (rnd.nextBoolean())
			paladin.pickUpWeapon(shortSword);
		paladin.attack(enemy2);
		enemy2.info();
		
		enemy2.atack(paladin);
		paladin.info();
		
	}

}
