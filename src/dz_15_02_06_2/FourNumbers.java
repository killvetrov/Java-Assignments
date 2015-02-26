// �������� ������ �� 4 ��������� ����� ����� �� ������� [10;99], �������� ��� �� ����� � ������. 
// ���������� � ������� �� ����� ��������� � ���, �������� �� ������ ������ ������������ �������������������.

package dz_15_02_06_2;

import java.util.Random;

public class FourNumbers {

	public static void main(String[] args) {

		Random rnd = new Random();

		int arr[] = {0, 9, 30, 40}; //new int[4];		
		boolean goesUp;
		
		System.out.print("��������� ������: ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 10 + rnd.nextInt(90);
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		goesUp = true;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] <= arr[i-1]) {
				goesUp = false;
				break;
			}
		}
		
		System.out.println("������ " + (goesUp ? "��������" : "�� ��������") + " ������ ������������ �������������������.");

	}

}
