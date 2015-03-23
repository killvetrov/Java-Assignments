package my.pakage.test;

public abstract class Human {

	protected String name;

	protected int health;
	protected int damage;
	protected int experience;
	protected int level;	

	public int MAX_HEALTH;
	public int EXPERIENCE_FOR_KILL;
	public int EXPERIENCE_FOR_NEW_LEVEL;

	public abstract void atack(Human human);	
	public abstract boolean takeDamage(int damage);
	
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
		System.out.println(dagame_from + " causes damage "
				+ damage_to + ", hit " + damage + " health" + "\n");
	}

	public void messageKill(String dagame_from, String damage_to) {
		System.out
				.println(dagame_from + " kill " + damage_to + "\n");
	}

}
