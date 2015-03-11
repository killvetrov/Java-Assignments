package cw_15_03_11_pract1;

public class Smartphone extends Phone {
	
	boolean hasGraphics;
	
	public Smartphone(String name, String number, boolean hasGraphics) {
		super(name, number);
		this.hasGraphics = hasGraphics;
	}
	
	public void playGames() {
		if (hasGraphics) {
			System.out.println("����� � ����.");
			System.out.println("������� �������...");
			System.out.println("����� �� ����.");
		} else {
			System.out.println("���������� �� ����������, ���� � ���� ����������.");
		}		
	}
	
	public void browseInternet() {
		System.out.println("������ �������.");
		System.out.println("�������� �������...");
		System.out.println("����� �� ��������.");
	}

}
