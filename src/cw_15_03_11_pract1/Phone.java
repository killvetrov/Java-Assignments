package cw_15_03_11_pract1;

public class Phone {
	
	String name;
	String number;
	
	public Phone(String name, String number) {
		this.name = name;
		this.number = number;
	}
	
	public void call(String number) {
		System.out.println("������\n��:\t" + this.number + "\n����:\t" + number);
		System.out.println("���������� ������");
	}
	
	public void sendMessage(String number, String text) {
		System.out.println("SMS\n��:\t" + this.number + "\n����:\t" + number + "\n�����:\t" + text);
		System.out.println("��������� ����������");
	}
	
	public void printInfo() {
		System.out.println("������ ��������: " + this.name + "\n����� ���-�����: " + this.number);
	}

}
