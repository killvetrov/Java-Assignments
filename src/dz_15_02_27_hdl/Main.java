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
			System.out.print("Выберите режим работы с языком кодирования HDL (1 = кодирование; 2 = раскодирование; пустая строка = выход): ");
			inLine = scanIn.nextLine().trim();
			switch (inLine) {
			case "1":
				System.out.print("Введите строку для кодирования: ");
				inString = scanIn.nextLine().trim();
				if (inString.isEmpty()) {
					System.out.println("Строка не введена.");
					continue;
				}
				System.out.print("Введите пароль для защиты строки (\"gen\" = сгенерировать случайный пароль): ");
				inPass = scanIn.nextLine().trim();
				switch (inPass) {
				case "gen":
					inPass = PasswordGenerator.generate(PasswordGenerator.MEDIUM);
					System.out.println("Используемый пароль: " + inPass);
					break;
				case "":
					System.out.println("Пароль не указан - строка не будет защищена паролем.");
					break;
				}
				System.out.println("Результат кодирования:");
				System.out.println(HDL.encode(inString, inPass));
				break;
			case "2":
				System.out.print("Введите строку для раскодирования: ");
				inString = scanIn.nextLine().trim();
				if (inString.isEmpty()) {
					System.out.println("Строка не введена.");
					continue;
				}
				System.out.print("Если строка защищена паролем, введите его: ");
				inPass = scanIn.nextLine().trim();
				switch (inPass) {				
				case "":
					System.out.println("Пароль не указан - предполагается, что строка была зашифрована без пароля.");
					break;
				}
				System.out.println("Результат раскодирования:");
				System.out.println(HDL.decode(inString, inPass));
				break;			
			case "":
				System.out.println("Работа завершена.");
				bContinue = false;
				break;
			default:
				System.out.println("Указан неверный режим работы.");
				continue;	
			}
		}
		
		scanIn.close();
		
	}

}
