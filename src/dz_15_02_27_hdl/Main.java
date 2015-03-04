package dz_15_02_27_hdl;

import java.util.Scanner;

import dz_15_02_23_2.PasswordGenerator;

public class Main {
	
	public static void main(String[] args) {
		
//		for (int i = 1; i < 60; i++) {
//			System.out.printf("new HDLChar('%s', \"%03d\"),%n", (char) (' ' + i - 1), i + 116);
//		}
		
		System.out.println((int) 'a');
		System.out.println(encryption.OurCode.encode("тест тест тест", "00b"));
		System.out.println(encryption.HDL.decode("022106036105036023035092106106022106036105"));
		
//		Scanner scanIn = new Scanner(System.in);
//		String inLine, inString, inPass;
//		
//		boolean bContinue = true;
//		
//		while (bContinue) {
//			System.out.println();
//			System.out.print("Выберите режим работы с языком кодирования HDL (1 = кодирование; 2 = раскодирование; пустая строка = выход): ");
//			inLine = scanIn.nextLine().trim();
//			switch (inLine) {
//			case "1":
//				System.out.print("Введите строку для кодирования: ");
//				inString = scanIn.nextLine().trim();
//				if (inString.isEmpty()) {
//					System.out.println("Строка не введена.");
//					continue;
//				}
//				System.out.print("Введите пароль для защиты строки (\"gen\" = сгенерировать случайный пароль): ");
//				inPass = scanIn.nextLine().trim();
//				switch (inPass) {
//				case "gen":
//					inPass = PasswordGenerator.generate(PasswordGenerator.MEDIUM);
//					System.out.println("Используемый пароль: " + inPass);
//					break;
//				case "":
//					System.out.println("Пароль не указан - строка не будет защищена паролем.");
//					break;
//				}
//				System.out.println("Результат кодирования:");
//				System.out.println(HDL.encode(inString, inPass));
//				break;
//			case "2":
//				System.out.print("Введите строку для раскодирования: ");
//				inString = scanIn.nextLine().trim();
//				if (inString.isEmpty()) {
//					System.out.println("Строка не введена.");
//					continue;
//				}
//				System.out.print("Если строка защищена паролем, введите его: ");
//				inPass = scanIn.nextLine().trim();
//				switch (inPass) {				
//				case "":
//					System.out.println("Пароль не указан - предполагается, что строка была зашифрована без пароля.");
//					break;
//				}
//				System.out.println("Результат раскодирования:");
//				System.out.println(HDL.decode(inString, inPass));
//				break;			
//			case "":
//				System.out.println("Работа завершена.");
//				bContinue = false;
//				break;
//			default:
//				System.out.println("Указан неверный режим работы.");
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
//		System.out.println(HDL.decode("Ё2A(2)723/5/ 1№35055 25022*913*3:1 47104128(1)4-423515 3251+155+2Ф33..034 037199037 25 5 131 2431592 5115002-02#4504323-2236(1)28(2)27132-1542341 9415005513 4138158141231 = 016+057037A0?44039062", "Password-Codirovka"));
		
	}

}
