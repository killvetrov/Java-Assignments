package dz_15_02_27_hdl;

import java.util.Scanner;

import dz_15_02_23_2.PasswordGenerator;

public class Main {
	
	public static void main(String[] args) {
		
//		for (int i = 1; i < 60; i++) {
//			System.out.printf("new HDLChar('%s', \"%03d\"),%n", (char) (' ' + i - 1), i + 116);
//		}
		
		System.out.println((int) 'a');
		System.out.println(encryption.OurCode.encode("���� ���� ����", "00b"));
		System.out.println(encryption.HDL.decode("022106036105036023035092106106022106036105"));
		
//		Scanner scanIn = new Scanner(System.in);
//		String inLine, inString, inPass;
//		
//		boolean bContinue = true;
//		
//		while (bContinue) {
//			System.out.println();
//			System.out.print("�������� ����� ������ � ������ ����������� HDL (1 = �����������; 2 = ��������������; ������ ������ = �����): ");
//			inLine = scanIn.nextLine().trim();
//			switch (inLine) {
//			case "1":
//				System.out.print("������� ������ ��� �����������: ");
//				inString = scanIn.nextLine().trim();
//				if (inString.isEmpty()) {
//					System.out.println("������ �� �������.");
//					continue;
//				}
//				System.out.print("������� ������ ��� ������ ������ (\"gen\" = ������������� ��������� ������): ");
//				inPass = scanIn.nextLine().trim();
//				switch (inPass) {
//				case "gen":
//					inPass = PasswordGenerator.generate(PasswordGenerator.MEDIUM);
//					System.out.println("������������ ������: " + inPass);
//					break;
//				case "":
//					System.out.println("������ �� ������ - ������ �� ����� �������� �������.");
//					break;
//				}
//				System.out.println("��������� �����������:");
//				System.out.println(HDL.encode(inString, inPass));
//				break;
//			case "2":
//				System.out.print("������� ������ ��� ��������������: ");
//				inString = scanIn.nextLine().trim();
//				if (inString.isEmpty()) {
//					System.out.println("������ �� �������.");
//					continue;
//				}
//				System.out.print("���� ������ �������� �������, ������� ���: ");
//				inPass = scanIn.nextLine().trim();
//				switch (inPass) {				
//				case "":
//					System.out.println("������ �� ������ - ��������������, ��� ������ ���� ����������� ��� ������.");
//					break;
//				}
//				System.out.println("��������� ��������������:");
//				System.out.println(HDL.decode(inString, inPass));
//				break;			
//			case "":
//				System.out.println("������ ���������.");
//				bContinue = false;
//				break;
//			default:
//				System.out.println("������ �������� ����� ������.");
//				continue;	
//			}
//		}
//		
//		scanIn.close();
		
//		System.out.println(HDL.filterHDLString("066 aaa212-2a-5a"));
//		
//		System.out.println(HDL.encode("066 212-27-59"));
//		
//		System.out.println(HDL.decode("188169131043148131224241012252055192052211155188155057"));
//		
//		System.out.println(HDL.encode("alphabet", "ekk1Pd9"));
//		
//		System.out.println(HDL.decode("�2A(2)723/5/ 1�35055 25022*913*3:1 47104128(1)4-423515 3251+155+2�33..034 037199037 25 5 131 2431592 5115002-02#4504323-2236(1)28(2)27132-1542341 9415005513 4138158141231 = 016+057037A0?44039062", "Password-Codirovka"));
		
	}

}
