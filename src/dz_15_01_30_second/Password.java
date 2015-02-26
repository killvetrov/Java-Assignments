// Усложненная версия задачи в классной работе cw_15_02_04_Password

package dz_15_01_30_second;

import java.util.Random;

public class Password {
	
	public static void main(String[] args) {
		
		// Генерация пароля зависит от того, как инициализирована строка password. 
		// "ru" - для генерации используется русский алфавит; 
		// "en" или пустая строка - английский алфавит;
		// любое другое значение - переменная останется в исходном виде.
		String password = "en";
		
		Random rnd = new Random();
		char chGen;
		boolean isGenerated;	
		
		switch (password.trim()) {
		
		case "ru":
			// Генерируем строку из 10 случайных символов, каждый из которых может быть либо буквой русского алфавита
			// произвольного регистра, либо цифрой от 0 до 9. Вероятность выбора цифры или буквы одинакова.
			chGen = (char) (rnd.nextBoolean() ? ('А' + rnd.nextInt('я' - 'А' + 1)) : ('0' + rnd.nextInt(10)));
			password = String.valueOf(chGen);
			chGen = (char) (rnd.nextBoolean() ? ('А' + rnd.nextInt('я' - 'А' + 1)) : ('0' + rnd.nextInt(10)));
			password += chGen;
			chGen = (char) (rnd.nextBoolean() ? ('А' + rnd.nextInt('я' - 'А' + 1)) : ('0' + rnd.nextInt(10)));
			password += chGen;
			chGen = (char) (rnd.nextBoolean() ? ('А' + rnd.nextInt('я' - 'А' + 1)) : ('0' + rnd.nextInt(10)));
			password += chGen;
			chGen = (char) (rnd.nextBoolean() ? ('А' + rnd.nextInt('я' - 'А' + 1)) : ('0' + rnd.nextInt(10)));
			password += chGen;
			chGen = (char) (rnd.nextBoolean() ? ('А' + rnd.nextInt('я' - 'А' + 1)) : ('0' + rnd.nextInt(10)));
			password += chGen;
			chGen = (char) (rnd.nextBoolean() ? ('А' + rnd.nextInt('я' - 'А' + 1)) : ('0' + rnd.nextInt(10)));
			password += chGen;
			chGen = (char) (rnd.nextBoolean() ? ('А' + rnd.nextInt('я' - 'А' + 1)) : ('0' + rnd.nextInt(10)));
			password += chGen;
			chGen = (char) (rnd.nextBoolean() ? ('А' + rnd.nextInt('я' - 'А' + 1)) : ('0' + rnd.nextInt(10)));
			password += chGen;
			chGen = (char) (rnd.nextBoolean() ? ('А' + rnd.nextInt('я' - 'А' + 1)) : ('0' + rnd.nextInt(10)));
			password += chGen;
			isGenerated = true;
			break;			
					
		case "en":
		case "":	
			// В отличие от русского, блоки верхнего и нижнего регистра английского алфавита в таблице символов
			// идут не подряд. Берем только верхний регистр и понижаем его случайным образом. 
			chGen = (char) (rnd.nextBoolean() ? ('A' + rnd.nextInt('Z' - 'A' + 1)) : ('0' + rnd.nextInt(10)));
			password = rnd.nextBoolean() ? String.valueOf(chGen) : String.valueOf(chGen).toLowerCase();
			chGen = (char) (rnd.nextBoolean() ? ('A' + rnd.nextInt('Z' - 'A' + 1)) : ('0' + rnd.nextInt(10)));
			password += rnd.nextBoolean() ? String.valueOf(chGen) : String.valueOf(chGen).toLowerCase();
			chGen = (char) (rnd.nextBoolean() ? ('A' + rnd.nextInt('Z' - 'A' + 1)) : ('0' + rnd.nextInt(10)));
			password += rnd.nextBoolean() ? String.valueOf(chGen) : String.valueOf(chGen).toLowerCase();
			chGen = (char) (rnd.nextBoolean() ? ('A' + rnd.nextInt('Z' - 'A' + 1)) : ('0' + rnd.nextInt(10)));
			password += rnd.nextBoolean() ? String.valueOf(chGen) : String.valueOf(chGen).toLowerCase();
			chGen = (char) (rnd.nextBoolean() ? ('A' + rnd.nextInt('Z' - 'A' + 1)) : ('0' + rnd.nextInt(10)));
			password += rnd.nextBoolean() ? String.valueOf(chGen) : String.valueOf(chGen).toLowerCase();
			chGen = (char) (rnd.nextBoolean() ? ('A' + rnd.nextInt('Z' - 'A' + 1)) : ('0' + rnd.nextInt(10)));
			password += rnd.nextBoolean() ? String.valueOf(chGen) : String.valueOf(chGen).toLowerCase();
			chGen = (char) (rnd.nextBoolean() ? ('A' + rnd.nextInt('Z' - 'A' + 1)) : ('0' + rnd.nextInt(10)));
			password += rnd.nextBoolean() ? String.valueOf(chGen) : String.valueOf(chGen).toLowerCase();
			chGen = (char) (rnd.nextBoolean() ? ('A' + rnd.nextInt('Z' - 'A' + 1)) : ('0' + rnd.nextInt(10)));
			password += rnd.nextBoolean() ? String.valueOf(chGen) : String.valueOf(chGen).toLowerCase();
			chGen = (char) (rnd.nextBoolean() ? ('A' + rnd.nextInt('Z' - 'A' + 1)) : ('0' + rnd.nextInt(10)));
			password += rnd.nextBoolean() ? String.valueOf(chGen) : String.valueOf(chGen).toLowerCase();
			chGen = (char) (rnd.nextBoolean() ? ('A' + rnd.nextInt('Z' - 'A' + 1)) : ('0' + rnd.nextInt(10)));
			password += rnd.nextBoolean() ? String.valueOf(chGen) : String.valueOf(chGen).toLowerCase();
			isGenerated = true;
			break;
			
		default:
			isGenerated = false;
			
		}
		
		if (isGenerated) {
			// Произвольно укорачиваем строку, минимальное количество символов - 2 
			password = password.substring(0, 2 + rnd.nextInt(password.length() - 1));		
		}
		else {
			// Имеем дело с вводом пользователя, не помешает обрезать боковые пробелы
			password = password.trim();			
		}	
		
		System.out.print("Введенный пароль: " + password + "\n"
				       + "Длина: " + password.length() + " симв.\n\n");
		
		System.out.print("Критерии сложности:\n");
		
		boolean isNotShorter4 = password.length() >= 4;
		System.out.print("\t" + (isNotShorter4 ? "[+]" : "[ ]") + "  не короче 4 символов\n");
		
		boolean isLonger8 = password.length() > 8;
		System.out.print("\t" + (isLonger8 ? "[+]" : "[ ]") + "  длиннее 8 символов\n");	
		
		// boolean isFirstCharUpcase = (password.charAt(0) >= 'A' && password.charAt(0) <= 'Z') || (password.charAt(0) >= 'А' && password.charAt(0) <= 'Я');		
		boolean isFirstCharUpcase = !(String.valueOf(password.charAt(0)).toLowerCase().equals(String.valueOf(password.charAt(0)).toUpperCase()))
								  && (String.valueOf(password.charAt(0)).equals(String.valueOf(password.charAt(0)).toUpperCase()));
		System.out.print("\t" + (isFirstCharUpcase ? "[+]" : "[ ]") + "  первый символ - заглавная буква\n");
		
		boolean isLastDigit = (password.charAt(password.length() - 1) >= '0') && (password.charAt(password.length() - 1) <= '9');
		System.out.print("\t" + (isLastDigit ? "[+]" : "[ ]") + "  последний символ - число\n\n");
		
		
		if (isLonger8 && isFirstCharUpcase && isLastDigit) {
			System.out.print("Сложность пароля: ОТЛИЧНЫЙ.\n");		
		}
		else if (isNotShorter4) {
			System.out.print("Сложность пароля: СРЕДНИЙ.\n");			
		}
		else {
			System.out.print("Сложность пароля: ПРОСТОЙ.\n");
		}
	}

}
