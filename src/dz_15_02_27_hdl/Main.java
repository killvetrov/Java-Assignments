package dz_15_02_27_hdl;

import java.util.Scanner;

import dz_15_02_23_2.PasswordGenerator;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanIn = new Scanner(System.in);
		String inLine, inString, inPass;
		
		boolean bContinue = true;
		
		while (bContinue) {
			System.out.println();
			System.out.print("�������� ����� ������ � ������ ����������� HDL (1 = �����������; 2 = ��������������; ������ ������ = �����): ");
			inLine = scanIn.nextLine().trim();
			switch (inLine) {
			case "1":
				System.out.print("������� ������ ��� �����������: ");
				inString = scanIn.nextLine().trim();
				if (inString.isEmpty()) {
					System.out.println("������ �� �������.");
					continue;
				}
				System.out.print("������� ������ ��� ������ ������ (\"gen\" = ������������� ��������� ������): ");
				inPass = scanIn.nextLine().trim();
				switch (inPass) {
				case "gen":
					inPass = PasswordGenerator.generate(PasswordGenerator.MEDIUM);
					System.out.println("������������ ������: " + inPass);
					break;
				case "":
					System.out.println("������ �� ������ - ������ �� ����� �������� �������.");
					break;
				}
				System.out.println("��������� �����������:");
				System.out.println(HDL.encode(inString, inPass));
				break;
			case "2":
				System.out.print("������� ������ ��� ��������������: ");
				inString = scanIn.nextLine().trim();
				if (inString.isEmpty()) {
					System.out.println("������ �� �������.");
					continue;
				}
				System.out.print("���� ������ �������� �������, ������� ���: ");
				inPass = scanIn.nextLine().trim();
				switch (inPass) {				
				case "":
					System.out.println("������ �� ������ - ��������������, ��� ������ ���� ����������� ��� ������.");
					break;
				}
				System.out.println("��������� ��������������:");
				System.out.println(HDL.decode(inString, inPass));
				break;			
			case "":
				System.out.println("������ ���������.");
				bContinue = false;
				break;
			default:
				System.out.println("������ �������� ����� ������.");
				continue;	
			}
		}
		
		scanIn.close();
		
	}

}
