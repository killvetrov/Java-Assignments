package my.pakage.test;

public class HardEnemy extends Enemy {
	final private static int HARD_ENEMY_HELTH = 100;

	public HardEnemy(String name, int damage, int level,
			int eXPERIENCE_FOR_KILL, int eXPERIENCE_FOR_NEW_LEVEL) {
		super(name, damage, level, HARD_ENEMY_HELTH, eXPERIENCE_FOR_KILL,
				eXPERIENCE_FOR_NEW_LEVEL);
		this.pickUpWeapon(new Weapon("Spear", 20, 25, 0, 0));

	}
}
