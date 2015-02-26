package dz_15_02_23_2;

import java.util.Scanner;

// Создать класс PasswordGenerator.  В класс предусмотреть константы уровня сложности (LOW, MEDIUM, HARD), метод generate 
// (алгоритм метода см. пред. задание с процедурного программирования), закрытые методы для соотв. генераторов. 
// В классе использовать спецификаторы доступа, константы, статические поля и методы и обязательно использовать соглашение имен. 

public class PwdGenMain {
	
	public static void main(String[] args) {
		
		Scanner scanIn = new Scanner(System.in);
		String inLine, password;
		int passStrength = Integer.MIN_VALUE, numPasswords, errorCount;
		
		boolean enough = false;
		while (!enough) {			
			
			System.out.print("Укажите желаемую сложность пароля (0 = простой; 1 = средний; 2 = сложный" + (passStrength != Integer.MIN_VALUE ? "; пустая строка = предыдущий выбор" : "") + "): ");
			inLine = scanIn.nextLine().trim();
			if (!inLine.isEmpty()) {
				passStrength = Integer.valueOf(inLine);				
			}	
			else
				if (passStrength == Integer.MIN_VALUE) {
					passStrength = PasswordGenerator.MEDIUM;
					System.out.println("Сложность не указана, по умолчанию будут генерироваться пароли средней сложности.");
				}
			
			if (!(passStrength >= PasswordGenerator.LOW && passStrength <= PasswordGenerator.HARD)) {
				passStrength = Integer.MIN_VALUE;
				System.out.println("Указана неверная сложность.");				
				continue;				
			}
			
			System.out.print("Сколько паролей нужно сгенерировать? (пустая строка = 10): ");
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
			
			System.out.println("Количество паролей с неверным уровнем сложности: " + errorCount);
			System.out.print("Продолжить генерацию паролей? (1 = да; другой символ = нет): ");
			inLine = scanIn.nextLine().trim();
			if (!inLine.equals("1")) enough = true; 
		}		
		
		scanIn.close();
		System.out.println("Генерация завершена.");	
		
	}

}
