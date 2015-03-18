package my.pakage.test;

public class Enemy extends Human {
	private Weapon weapons;

	public Enemy(String name, int damage, int level, int mAX_HEALTH,
			int eXPERIENCE_FOR_KILL, int eXPERIENCE_FOR_NEW_LEVEL) {
		super(name, damage, level, mAX_HEALTH, eXPERIENCE_FOR_KILL,
				eXPERIENCE_FOR_NEW_LEVEL);
		// TODO Auto-generated constructor stub
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

	public void messagePickUpWeapon() {
		System.out.println("Enemy " + this.name + " pick up weapon");

	}

	public void messageDropWeapon() {
		System.out.println("Enemy " + this.name + " drop weapon");

	}
}