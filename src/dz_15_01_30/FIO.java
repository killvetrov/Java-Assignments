package dz_15_01_30;

public class FIO {

	public static void main(String[] args) {
		
		// Фамилия Имя Отчество Возраст email 
		String input = "Вейдер Дарт Алексеевич 59 darth@vader.com.ua";		
		
		String F, N, O, email;		
		int age;
		
		int index = 0;		
		F = input.substring(index, input.indexOf(' ', index));
		
		index += F.length() + 1;	
		N = input.substring(index, input.indexOf(' ', index));
		
		index += N.length() + 1;
		O = input.substring(index, input.indexOf(' ', index));
		
		index += O.length() + 1;
		// Переместимся к пробелу после возраста, ниже станет понятно зачем
		index = input.indexOf(' ', index);
		
		// 1. Напрямую преобразовать String в int не получилось, но вспомним про char.
		// 2. char при преобразовании в int дает код символа, содержащегося в нем. 
		// 3. Из кода символа цифры можно получить саму цифру, отняв 48 (видно из таблицы ASCII).
		// 4. В возрасте человека может быть от одного до трех разрядов, и мы не знаем заранее сколько их будет. 
		//    Прочитаем 3 символа подряд справа налево. Прибавляем разряды если встречаются цифры, другие символы игнорируем. 
		age = input.charAt(index - 1) - 48;
		age += (input.charAt(index - 2) >= 48) && (input.charAt(index - 2) <= 57) ? (input.charAt(index - 2) - 48) * 10 : 0;
		age += (input.charAt(index - 3) >= 48) && (input.charAt(index - 3) <= 57) ? (input.charAt(index - 3) - 48) * 100 : 0;

		// index находится на пробеле после возраста, оставшаяся часть строки - это email
		email = input.substring(index + 1);		
		
		// Двойные табуляции в выводе сделаны для ровных отступов в консоли
		System.out.print(
				"Имя:\t\t" + N + '\n' +
				"Отчество:\t" + O + '\n' +
				"Фамилия:\t" + F + '\n' +
				"Возраст:\t" + age + '\n' +
				"email:\t\t" + email + ' ' +
				// email корректен, если в нем есть собака и хотя бы один символ перед ней
				(email.indexOf('@') > 0 ? "(адрес корректен)" : "(адрес некорректен)") + '\n'
				);

	}

}
