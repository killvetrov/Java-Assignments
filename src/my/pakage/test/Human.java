package my.pakage.test;

public class Human {

	protected String name;

	protected int health;
	protected int damage;
	protected int experience;
	protected int level;
	
	

	public int MAX_HEALTH;
	public int EXPERIENCE_FOR_KILL;
	public int EXPERIENCE_FOR_NEW_LEVEL;

	public Human(String name, int damage, int level, int mAX_HEALTH,
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
		if (human.isKilled())
			return;

		boolean isKilled = human.takeDamage(this.damage);

		if (isKilled) {
			this.experience += human.EXPERIENCE_FOR_KILL;
			if (this.experience >= this.EXPERIENCE_FOR_NEW_LEVEL) {
				level++;
				this.experience = 0;
			}
			messageKill(this.name, human.name);
		} else {
			messageDamage(this.name, human.name, this.damage);
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

	public boolean isKilled() {
		if (this.health <= 0)
			return true;
		else
			return false;
	}

	public void info() {
		System.out.println("Name: " + this.name);
		System.out.println("Health: " + this.health);
		System.out.println("Damage: " + this.damage);
		System.out.println("Experience: " + this.experience + "/"
				+ this.EXPERIENCE_FOR_NEW_LEVEL);
		System.out.println("Level: " + this.level + "\n");
	}

	public void messageDamage(String dagame_from, String damage_to, int damage) {
		System.out.println("Human " + dagame_from + " causes damage "
				+ damage_to + ", hit " + damage + " health" + "\n");
	}

	public void messageKill(String dagame_from, String damage_to) {
		System.out
				.println("Human " + dagame_from + " kill " + damage_to + "\n");
	}

	public static void main(String... args) {
		Human p1 = new Human("Player 1", 30, 1, 50, 1, 10);
		Human p2 = new Human("Player 2", 30, 1, 50, 1, 10);

		p1.info();
		p2.atack(p1);
		p2.atack(p1);
		p2.atack(p1);

		p1.info();
		p2.info();
	}
}
