package cw_15_03_11_pract1;

public class Smartphone extends Phone {
	
	boolean hasGraphics;
	
	public Smartphone(String name, String number, boolean hasGraphics) {
		super(name, number);
		this.hasGraphics = hasGraphics;
	}
	
	public void playGames() {
		if (hasGraphics) {
			System.out.println("Вошли в игру.");
			System.out.println("Игровой процесс...");
			System.out.println("Выход из игры.");
		} else {
			System.out.println("Видеокарта не обнаружена, вход в игру невозможен.");
		}		
	}
	
	public void browseInternet() {
		System.out.println("Открыт браузер.");
		System.out.println("Просмотр страниц...");
		System.out.println("Выход из браузера.");
	}

}
