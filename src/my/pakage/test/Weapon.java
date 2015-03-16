package my.pakage.test;

import java.util.Random;

public class Weapon {
	private Random rnd = new Random();
	
	private String name = "short sword";
	private int damage = 40;
	private int critKoef = 3;
	private int critChance = 20;
	
	public Weapon(String name, int damage, int critKoef, int critChance) {
		this.name = name;
		this.damage = damage;
		this.critKoef = critKoef;
		this.critChance = critChance;
	}
	
	
	public int use(){
		int x = rnd.nextInt(101);
		int dmg = x > critChance ? damage * critKoef : damage;
		
		return dmg;
	}
	
	public String getName() {
		return this.name;
	}
	
	
	
}
