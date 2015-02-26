// Задача №1
// В символьный массив вводиться любое количество символов, как числовых, так и любых других.
// Необходимо произвести анализ введенных данных и вывести на экран следующую информацию о массиве:
//   1)	Количество элементов в массиве, если 0 , то написать, что массив пуст.
//   2)	Найти все числовые символы, посчитать их среднее арифметическое и найти максимальное число. 
//   3)	Создать дополнительный массив, в который записать все символы, которые не принадлежат числовым символам и символам английского алфавита.

//String str_ending;
//
//switch (mass_char.length % 10) {
//
//case 1:
//	str_ending = mass_char.length != 11 ? "" : "ов";
//	break;
//	
//case 2:
//case 3:
//case 4:
//	str_ending = ((mass_char.length / 10) % 10) != 1 ? "а" : "ов";
//	break;
//
//default:
//	str_ending = "ов";
//	
//}

package dz_15_02_04;

import java.util.Random;

public class Massive {

	public static void main(String[] args) {

		Random rnd = new Random();

		char[] mass_char = new char[rnd.nextInt(101)];
		char[] mass_char2 = new char[mass_char.length]; // длина доп. массива никогда не превысит длину исходного
		int i, i2;
		int num, num_count, sum, max;

		if (mass_char.length > 0) {			
			
			// Для начала сгенерируем массив символов и выведем его для наглядности.
			i = 0;
			while (i < mass_char.length) {
				// Случайные коды символов из интервала от '!' до кода 126 - это символы, которые можно ввести с клавиатуры.
				mass_char[i] = (char) ('!' + rnd.nextInt(127 - '!'));
				System.out.print(mass_char[i] + " ");
				i++;
			}
			System.out.println();
			
			System.out.println("Элементов в массиве: " + mass_char.length);
			
			num_count = 0;
			sum = 0;
			max = 0;
			i = 0;
			i2 = -1;
			while (i < mass_char.length) {
				if (mass_char[i] >= '0' && mass_char[i] <= '9') {
					num_count++;
					num = mass_char[i] - '0'; // преобразуем код символа в соответствующее число 
					sum += num;
					if (max < num) max = num;
				}
				else if (!((mass_char[i] >= 'A' && mass_char[i] <= 'Z') || (mass_char[i] >= 'a' && mass_char[i] <= 'z'))) {
					// Попадем сюда если символ не является ни числом, ни буквой англ. алфавита 
					i2++;
					mass_char2[i2] = mass_char[i];					
				}
				i++;
			}
			
			if (num_count > 0) {
				System.out.print("Количество числовых символов: " + num_count + "\n"
						+ "Среднее арифметическое = " + (double)sum / num_count + "\n"
						+ "Максимсальное число: " + max + "\n");						
			}
			else {				
				System.out.print("Числовых символов не найдено.\n");
			}
			
			// В i2 будет индекс последнего записанного элемента в доп. массив
			if (i2 >= 0) {
				System.out.print("Элементов в дополнительном массиве: " + (i2 + 1) + ", содержимое ниже.\n");
				i = 0;
				while (i <= i2) {
					System.out.print(mass_char2[i] + " ");
					i++;
				}
				System.out.println();
			}
			else {
				System.out.println("Ничего кроме цифр или букв в массиве нет.");
			}
				
			
		}
		else {
			System.out.println("Массив пуст :/");
		}
			
	}

}
