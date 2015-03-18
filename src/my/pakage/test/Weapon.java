package my.pakage.test;

import java.util.Random;

public class Weapon {
	private Random rnd = new Random();
	
	private String name = "short sword";
	private int minDamage = 40;
	private int maxDamage = 50;
	private int critKoef = 3;
	private int critChance = 20;
	
	public Weapon(String name, int minDamage, int maxDamage, int critKoef, int critChance) {
		this.name = name;
		this.minDamage = minDamage;
		this.maxDamage = maxDamage;
		this.critKoef = critKoef;
		this.critChance = critChance;
	}
	
	
	public int use(){
		int x = rnd.nextInt(101);
		
		int curDamage = minDamage + rnd.nextInt(maxDamage - minDamage + 1);
		
		int dmg = x > critChance ? curDamage * critKoef : curDamage;
		
		return dmg;
	}
	
	public String getName() {
		return this.name + " (damage: " + minDamage + "-" + maxDamage + ")";
	}
	
	
	
}
