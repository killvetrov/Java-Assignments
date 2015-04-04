package my.pakage.test;

import java.util.Random;

import dz_15_03_30_templates.MyCollection;

public class Main {
	
	public static void main(String[] args) {
				
		Random rnd = new Random();
		
//		Human[] mobs = new Human[10];		
//		
//		mobs[0] = new NormalPlayer("Normal Player 1", 5, 1, 10, 100);
//		mobs[1] = new NormalPlayer("Normal Player 2", 5, 1, 10, 100);
//		mobs[2] = new DonatePlayer("Donate Player 1", 15, 1, 10, 100);
//		mobs[3] = new DonatePlayer("Donate Player 2", 15, 1, 10, 100);
//		mobs[4] = new LowEnemy("LowEnemy-1", 5, 1, 10, 100);
//		mobs[5] = new LowEnemy("LowEnemy-2", 5, 1, 10, 100);
//		mobs[6] = new MediumEnemy("MediumEnemy-1", 12, 1, 10, 100);
//		mobs[7] = new MediumEnemy("MediumEnemy-2", 12, 1, 10, 100);
//		mobs[8] = new HardEnemy("HardEnemy-1", 20, 1, 10, 100);
//		mobs[9] = new HardEnemy("HardEnemy-2", 20, 1, 10, 100);
		
		MyCollection<Human> mobs = new MyCollection<Human>(new Human[0]);
		mobs.add(new NormalPlayer("Normal Player 1", 5, 1, 10, 100));
		mobs.add(new NormalPlayer("Normal Player 2", 5, 1, 10, 100));
		mobs.add(new DonatePlayer("Donate Player 1", 15, 1, 10, 100));
		mobs.add(new DonatePlayer("Donate Player 2", 15, 1, 10, 100));
		mobs.add(new LowEnemy("LowEnemy-1", 5, 1, 10, 100));
		mobs.add(new LowEnemy("LowEnemy-2", 5, 1, 10, 100));
		mobs.add(new MediumEnemy("MediumEnemy-1", 12, 1, 10, 100));
		mobs.add(new MediumEnemy("MediumEnemy-2", 12, 1, 10, 100));
		mobs.add(new HardEnemy("HardEnemy-1", 20, 1, 10, 100));
		mobs.add(new HardEnemy("HardEnemy-2", 20, 1, 10, 100));
		
		int countPlayers = 0, countEnemies = 0;
		for (int i = 0; i < mobs.size(); i++) {
			if (mobs.get(i) instanceof Player)
				countPlayers++;
			else if (mobs.get(i) instanceof Enemy)
				countEnemies++;
		}
		
		System.out.println("\nStarting the battle with " + mobs.size() + " players!\n");
		
		Human attacker, target;
		int attackerIndex, targetIndex;
		
		for (int i = 1; i <= 100; i++) {			
			if (mobs.size() < 2) {
				System.out.println("Only one player is still alive. " + mobs.get(0).name + " wins the game!");
				break;
			}
			
			if (countPlayers == 0) {
				System.out.println("All players are dead. Enemies team wins!");
				break;
			}
			
			if (countEnemies == 0) {
				System.out.println("All enemies are dead. Players team wins!");
				break;
			}
			
			attacker = mobs.get(attackerIndex = rnd.nextInt(mobs.size()));
			targetIndex = rnd.nextInt(mobs.size() - 1);
			if (targetIndex == attackerIndex) 
				targetIndex = mobs.size() - 1;
			target = mobs.get(targetIndex);
			
			if (attacker.getClass().getSuperclass().equals(target.getClass().getSuperclass())) {				
				i--;
				continue;
			};
			
			System.out.println("-------- Turn " + i + " (" + mobs.size() + " mobs in the game - " + countPlayers + "P/" + countEnemies + "E"  + ") --------------------------------");
			
			attacker.atack(target);
			
			if (target.isKilled()) {
				if (target instanceof Player) 
					countPlayers--;
				else if (target instanceof Enemy)
					countEnemies--;
				
				mobs.remove(target);
			}			
			
			try {
				Thread.sleep(2000);
			} catch (Exception e) {};
			
		}
		
		System.out.println("The battle is over.");
		
		
		
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
