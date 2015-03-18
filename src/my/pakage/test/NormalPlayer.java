package my.pakage.test;

public class NormalPlayer extends Player {
	
	final private static int NORMAL_PLAYER_HEALTH = 50;

	public NormalPlayer(String name, int damage, int level, int eXPERIENCE_FOR_KILL, int eXPERIENCE_FOR_NEW_LEVEL) {
		super(name, damage, level, NORMAL_PLAYER_HEALTH, eXPERIENCE_FOR_KILL,
				eXPERIENCE_FOR_NEW_LEVEL);
		this.pickUpWeapon(new Weapon("Short Sword", 5, 15, 0, 0));
	
	}	

}
