package my.pakage.test;

public class DonatePlayer extends Player {
	final private static int DONATE_PLAYER_HEALTH = 100;

	public DonatePlayer(String name, int damage, int level, int eXPERIENCE_FOR_KILL, int eXPERIENCE_FOR_NEW_LEVEL) {
		super(name, damage, level, DONATE_PLAYER_HEALTH, eXPERIENCE_FOR_KILL,
				eXPERIENCE_FOR_NEW_LEVEL);
		this.pickUpWeapon(new Weapon("Long Sword", 15, 30, 0, 0));
	}	
}
