package dz_15_02_23_2;

import java.util.Scanner;

// ������� ����� PasswordGenerator.  � ����� ������������� ��������� ������ ��������� (LOW, MEDIUM, HARD), ����� generate 
// (�������� ������ ��. ����. ������� � ������������ ����������������), �������� ������ ��� �����. �����������. 
// � ������ ������������ ������������� �������, ���������, ����������� ���� � ������ � ����������� ������������ ���������� ����. 

public class PwdGenMain {
	
	public static void main(String[] args) {
		
		Scanner scanIn = new Scanner(System.in);
		String inLine, password;
		int passStrength = Integer.MIN_VALUE, numPasswords, errorCount;
		
		boolean enough = false;
		while (!enough) {			
			
			System.out.print("������� �������� ��������� ������ (0 = �������; 1 = �������; 2 = �������" + (passStrength != Integer.MIN_VALUE ? "; ������ ������ = ���������� �����" : "") + "): ");
			inLine = scanIn.nextLine().trim();
			if (!inLine.isEmpty()) {
				passStrength = Integer.valueOf(inLine);				
			}	
			else
				if (passStrength == Integer.MIN_VALUE) {
					passStrength = PasswordGenerator.MEDIUM;
					System.out.println("��������� �� �������, �� ��������� ����� �������������� ������ ������� ���������.");
				}
			
			if (!(passStrength >= PasswordGenerator.LOW && passStrength <= PasswordGenerator.HARD)) {
				passStrength = Integer.MIN_VALUE;
				System.out.println("������� �������� ���������.");				
				continue;				
			}
			
			System.out.print("������� ������� ����� �������������? (������ ������ = 10): ");
			inLine = scanIn.nextLine().trim();
			if (!inLine.isEmpty())
				numPasswords = Integer.valueOf(inLine);
			else
				numPasswords = 10;

			errorCount = 0;
			for (int i = 0; i < numPasswords; i++) {
				password = PasswordGenerator.generate(passStrength);
				if (PasswordGenerator.determinePasswordStrength(password) != passStrength) 
					errorCount++;  
				System.out.println(password);
			}	
			
			System.out.println("���������� ������� � �������� ������� ���������: " + errorCount);
			System.out.print("���������� ��������� �������? (1 = ��; ������ ������ = ���): ");
			inLine = scanIn.nextLine().trim();
			if (!inLine.equals("1")) enough = true; 
		}		
		
		scanIn.close();
		System.out.println("��������� ���������.");	
		
	}

}
