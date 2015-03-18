package my.pakage.test;

public class LowEnemy extends Enemy{
	final private static int LOW_ENEMY_HELTH=20;

	public LowEnemy(String name, int damage, int level,
			int eXPERIENCE_FOR_KILL, int eXPERIENCE_FOR_NEW_LEVEL) {
		super(name, damage, level, LOW_ENEMY_HELTH, eXPERIENCE_FOR_KILL,
				eXPERIENCE_FOR_NEW_LEVEL);
		this.pickUpWeapon(new Weapon("Bat", 5, 5, 0, 0));

	}

}