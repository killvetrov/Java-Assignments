package my.pakage.test;

public class Player extends Human {
	
	private Weapon weap; 
		
	public Player(String name, int damage, int level, int mAX_HEALTH,
			int eXPERIENCE_FOR_KILL, int eXPERIENCE_FOR_NEW_LEVEL) {
		super(name, damage, level, mAX_HEALTH, eXPERIENCE_FOR_KILL,
				eXPERIENCE_FOR_NEW_LEVEL);
		// TODO Auto-generated constructor stub
	}
	
	public void attack(Human human) {
		if (human.isKilled() || this.isKilled())
			return;
		
		int curDmg = this.weap == null ? this.damage : weap.use();
		
		boolean isKilled = human.takeDamage(curDmg);
		
		if (isKilled) {
			this.experience += human.EXPERIENCE_FOR_KILL;
			if (this.experience >= this.EXPERIENCE_FOR_NEW_LEVEL) {
				level++;
				this.experience = 0;
			}
			messageKill(this.name, human.name);
		} else {
			messageDamage(this.name, human.name, curDmg);
		}
	}
	
	public void pickUpWeapon(Weapon weapon) {
		this.weap = weapon;
		messagePickUpWeapon();
	}
	
	public void dropWeapon(Weapon weapon) {
		this.weap = null;
		messageDropWeapon();
	}

	
	public void messagePickUpWeapon() {
		System.out.println("Player " + this.name + " picked up a weapon " + weap.getName());
	}
	
	public void messageDropWeapon() {
		System.out.println("Player " + this.name + " dropped a weapon.");
	}
	

}
