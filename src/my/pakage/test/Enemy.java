package my.pakage.test;

public class Enemy extends Human {
	private Weapon weapons;

	public Enemy(String name, int damage, int level, int mAX_HEALTH,
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

	public void dropWeapon(Weapon weapons) {
		this.weapons = null;
		messageDropWeapon();
	}

	public void pickUpWeapon(Weapon weapons) {
		this.weapons = weapons;
		messagePickUpWeapon();
	}

	public void atack(Human human) {/* атака */
		if (human.isKilled() || this.isKilled())
			return;
		int currentdamage = this.weapons == null ? this.damage : weapons
				.use();

		boolean isKilled = human.takeDamage(currentdamage);// ----------------------------от
		// оружия
		/* если человек убит-идет счетчик на увелисение опыта на убийство */
		if (isKilled) {
			this.experience += human.EXPERIENCE_FOR_KILL;
			if (this.experience >= this.EXPERIENCE_FOR_NEW_LEVEL) {
				level++;/* счетчик для нового уровня */
				this.experience = 0;/* опыт */
			}
			messageKill(this.name, human.name);// ???????????
		} else {
			messageDamage(this.name, human.name, currentdamage);
		}
	}
	
	public boolean takeDamage(int damage) {
		boolean isKilled = false;

		this.health -= damage;

		if (this.health <= 0) {
			this.health = 0;
			isKilled = true;
		}
		
		status = "Takes " + damage + " damage";

		return isKilled;
	}	

	public void messagePickUpWeapon() {
		//System.out.println("Enemy " + this.name + " picked up a weapon " + weapons.getName());

	}

	public void messageDropWeapon() {
		System.out.println("Enemy " + this.name + " drop weapon");

	}
}