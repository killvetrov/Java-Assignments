package dz_15_01_30;

public class FIO {

	public static void main(String[] args) {
		
		// ������� ��� �������� ������� email 
		String input = "������ ���� ���������� 59 darth@vader.com.ua";		
		
		String F, N, O, email;		
		int age;
		
		int index = 0;		
		F = input.substring(index, input.indexOf(' ', index));
		
		index += F.length() + 1;	
		N = input.substring(index, input.indexOf(' ', index));
		
		index += N.length() + 1;
		O = input.substring(index, input.indexOf(' ', index));
		
		index += O.length() + 1;
		// ������������ � ������� ����� ��������, ���� ������ ������� �����
		index = input.indexOf(' ', index);
		
		// 1. �������� ������������� String � int �� ����������, �� �������� ��� char.
		// 2. char ��� �������������� � int ���� ��� �������, ������������� � ���. 
		// 3. �� ���� ������� ����� ����� �������� ���� �����, ����� 48 (����� �� ������� ASCII).
		// 4. � �������� �������� ����� ���� �� ������ �� ���� ��������, � �� �� ����� ������� ������� �� �����. 
		//    ��������� 3 ������� ������ ������ ������. ���������� ������� ���� ����������� �����, ������ ������� ����������. 
		age = input.charAt(index - 1) - 48;
		age += (input.charAt(index - 2) >= 48) && (input.charAt(index - 2) <= 57) ? (input.charAt(index - 2) - 48) * 10 : 0;
		age += (input.charAt(index - 3) >= 48) && (input.charAt(index - 3) <= 57) ? (input.charAt(index - 3) - 48) * 100 : 0;

		// index ��������� �� ������� ����� ��������, ���������� ����� ������ - ��� email
		email = input.substring(index + 1);		
		
		// ������� ��������� � ������ ������� ��� ������ �������� � �������
		System.out.print(
				"���:\t\t" + N + '\n' +
				"��������:\t" + O + '\n' +
				"�������:\t" + F + '\n' +
				"�������:\t" + age + '\n' +
				"email:\t\t" + email + ' ' +
				// email ���������, ���� � ��� ���� ������ � ���� �� ���� ������ ����� ���
				(email.indexOf('@') > 0 ? "(����� ���������)" : "(����� �����������)") + '\n'
				);

	}

}
