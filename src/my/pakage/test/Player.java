package my.pakage.test;

public class Player extends Human {
	
	private Weapon weap; 
		
	public Player(String name, int damage, int level, int mAX_HEALTH,
			int eXPERIENCE_FOR_KILL, int eXPERIENCE_FOR_NEW_LEVEL) {
		MAX_HEALTH = mAX_HEALTH;
		EXPERIENCE_FOR_KILL = eXPERIENCE_FOR_KILL;
		EXPERIENCE_FOR_NEW_LEVEL = eXPERIENCE_FOR_NEW_LEVEL;

		this.name = name;
		this.damage = damage;
		this.experience = 0;
		this.level = level;
		this.health = mAX_HEALTH;
	}
	
	public void atack(Human human) {
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
	
	public boolean takeDamage(int damage) {
		boolean isKilled = false;

		this.health -= damage;

		if (this.health <= 0) {
			this.health = 0;
			isKilled = true;
		}

		return isKilled;
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
		//System.out.println("Player " + this.name + " picked up a weapon " + weap.getName());
	}
	
	public void messageDropWeapon() {
		System.out.println("Player " + this.name + " dropped a weapon.");
	}
	

}
