// ������ �1
// � ���������� ������ ��������� ����� ���������� ��������, ��� ��������, ��� � ����� ������.
// ���������� ���������� ������ ��������� ������ � ������� �� ����� ��������� ���������� � �������:
//   1)	���������� ��������� � �������, ���� 0 , �� ��������, ��� ������ ����.
//   2)	����� ��� �������� �������, ��������� �� ������� �������������� � ����� ������������ �����. 
//   3)	������� �������������� ������, � ������� �������� ��� �������, ������� �� ����������� �������� �������� � �������� ����������� ��������.

//String str_ending;
//
//switch (mass_char.length % 10) {
//
//case 1:
//	str_ending = mass_char.length != 11 ? "" : "��";
//	break;
//	
//case 2:
//case 3:
//case 4:
//	str_ending = ((mass_char.length / 10) % 10) != 1 ? "�" : "��";
//	break;
//
//default:
//	str_ending = "��";
//	
//}

package dz_15_02_04;

import java.util.Random;

public class Massive {

	public static void main(String[] args) {

		Random rnd = new Random();

		char[] mass_char = new char[rnd.nextInt(101)];
		char[] mass_char2 = new char[mass_char.length]; // ����� ���. ������� ������� �� �������� ����� ���������
		int i, i2;
		int num, num_count, sum, max;

		if (mass_char.length > 0) {			
			
			// ��� ������ ����������� ������ �������� � ������� ��� ��� �����������.
			i = 0;
			while (i < mass_char.length) {
				// ��������� ���� �������� �� ��������� �� '!' �� ���� 126 - ��� �������, ������� ����� ������ � ����������.
				mass_char[i] = (char) ('!' + rnd.nextInt(127 - '!'));
				System.out.print(mass_char[i] + " ");
				i++;
			}
			System.out.println();
			
			System.out.println("��������� � �������: " + mass_char.length);
			
			num_count = 0;
			sum = 0;
			max = 0;
			i = 0;
			i2 = -1;
			while (i < mass_char.length) {
				if (mass_char[i] >= '0' && mass_char[i] <= '9') {
					num_count++;
					num = mass_char[i] - '0'; // ����������� ��� ������� � ��������������� ����� 
					sum += num;
					if (max < num) max = num;
				}
				else if (!((mass_char[i] >= 'A' && mass_char[i] <= 'Z') || (mass_char[i] >= 'a' && mass_char[i] <= 'z'))) {
					// ������� ���� ���� ������ �� �������� �� ������, �� ������ ����. �������� 
					i2++;
					mass_char2[i2] = mass_char[i];					
				}
				i++;
			}
			
			if (num_count > 0) {
				System.out.print("���������� �������� ��������: " + num_count + "\n"
						+ "������� �������������� = " + (double)sum / num_count + "\n"
						+ "������������� �����: " + max + "\n");						
			}
			else {				
				System.out.print("�������� �������� �� �������.\n");
			}
			
			// � i2 ����� ������ ���������� ����������� �������� � ���. ������
			if (i2 >= 0) {
				System.out.print("��������� � �������������� �������: " + (i2 + 1) + ", ���������� ����.\n");
				i = 0;
				while (i <= i2) {
					System.out.print(mass_char2[i] + " ");
					i++;
				}
				System.out.println();
			}
			else {
				System.out.println("������ ����� ���� ��� ���� � ������� ���.");
			}
				
			
		}
		else {
			System.out.println("������ ���� :/");
		}
			
	}

}
