package my.pakage.test;

public class MediumEnemy extends Enemy{
	final private static int MEDIUM_ENEMY_HELTH=50;

	public MediumEnemy(String name, int damage, int level,
			int eXPERIENCE_FOR_KILL, int eXPERIENCE_FOR_NEW_LEVEL) {
		super(name, damage, level, MEDIUM_ENEMY_HELTH, eXPERIENCE_FOR_KILL,
				eXPERIENCE_FOR_NEW_LEVEL);
		this.pickUpWeapon(new Weapon("Club", 12, 15, 0, 0));
	
	}
}	
