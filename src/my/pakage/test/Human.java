package my.pakage.test;

import static org.fusesource.jansi.Ansi.*;

import org.fusesource.jansi.AnsiConsole;

public abstract class Human {

	protected String name;

	protected int health;
	protected int damage;
	protected int experience;
	protected int level;
	
	protected String status = "Ready to fight";

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
//		System.out.println(dagame_from + " causes damage "
//				+ damage_to + ", hit " + damage + " health" + "\n");
		status = "Hit " + damage + " health";
	}

	public void messageKill(String dagame_from, String damage_to) {
//		System.out.print(ansi().bg(Color.RED));
//		System.out
//				.println(dagame_from + " kill " + damage_to + "\n");
//		System.out.print(ansi().reset());
		status = "Kill " + damage_to;
	}
	
	public void printHealthBar() {
		System.out.printf("%3d/%3d [", health, MAX_HEALTH);
		if (health == 0) status = "@|red Killed x_x|@";
		for (int i = 0; i <= 5; i++) {
			if ( (health != 0) && ((double) health / (double) MAX_HEALTH) >= ((double) i / 5.0) ) {
				System.out.print(ansi().bg(Color.RED));
			} else {
				System.out.print(ansi().bg(Color.BLACK));				
			}	
			System.out.print(' ');
		}		
		System.out.print(ansi().reset());
		System.out.print("]");
	}
	
	public void heal() {
		status = "Healed and ready to fight";
		health = MAX_HEALTH;
	}

}
