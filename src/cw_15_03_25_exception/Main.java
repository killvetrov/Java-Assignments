package cw_15_03_25_exception;

public class Main {

	public static void main(String[] args) {
		int i = 10;
		int[] mass = { 1, 2 };
		
		

		try {
			System.out.println(i / 1);
			mass[5] = 10;
		} catch (ArithmeticException e) {
			System.out.println("������ �� ���� ������.");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("����� �� ������� �������.");
		} finally {
			System.out.println("���������� ������.");
		}
		
		throw new NullPointerException("������ � �� ������");
		
	}

}
