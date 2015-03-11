package cw_15_03_11_pract1;

public class Phone {
	
	String name;
	String number;
	
	public Phone(String name, String number) {
		this.name = name;
		this.number = number;
	}
	
	public void call(String number) {
		System.out.println("Звонок\nОт:\t" + this.number + "\nКому:\t" + number);
		System.out.println("Завершение звонка");
	}
	
	public void sendMessage(String number, String text) {
		System.out.println("SMS\nОт:\t" + this.number + "\nКому:\t" + number + "\nТекст:\t" + text);
		System.out.println("Сообщение отправлено");
	}
	
	public void printInfo() {
		System.out.println("Модель телефона: " + this.name + "\nНомер сим-карты: " + this.number);
	}

}
