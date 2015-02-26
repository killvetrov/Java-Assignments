// Создайте массив из 11 случайных целых чисел из отрезка [-1;1], выведите массив на экран в строку. 
// Определите какой элемент встречается в массиве чаще всего и выведите об этом сообщение на экран. 
// Если два каких-то элемента встречаются одинаковое количество раз, то не выводите ничего.

package dz_15_02_06_3;

import java.util.Random;

public class ElevenNumbers {
	
	public static void main(String[] args) {
		
		Random rnd = new Random();
		int arr[] = new int[11];
		int arr_freq[] = new int[arr.length];
		
		int indexMax;
		boolean hasTwoEle = false;
		
		System.out.print("Введенный массив:\t");
		for (int i = 0; i < arr.length; i++) {			
			arr[i] = -1 + rnd.nextInt(3);
			System.out.print(String.format("%2d", arr[i]) + " ");
		}
		System.out.println();		
		
		int iterations1 = 0;
		indexMax = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr_freq[i] == -1) continue;
			for (int j = 0; j < arr.length; j++) {
				if (arr_freq[j] == -1) continue;
				iterations1++;
				if (arr[i] == arr[j]) {
					arr_freq[i]++;
					if (arr_freq[indexMax] < arr_freq[i]) indexMax = i; 
					if (j > i) arr_freq[j] = -1;
				}				
			}
		}
		
		System.out.print("Количество повторений:\t");
		for (int i = 0; i < arr.length; i++) {		
			System.out.print((arr_freq[i] != -1 ? String.format("%2d", arr_freq[i]) : "  " ) + " ");
		}
		System.out.println();
		
		int iterations2 = 0;
		for (int i = 0; i < arr_freq.length - 1; i++) {
			if (arr_freq[i] == -1) continue;
			for (int j = i + 1; j < arr_freq.length; j++) {
				if (arr_freq[j] == -1) continue;
				iterations2++;
				if ((i != j) && (arr_freq[i] == arr_freq[j])) {
					hasTwoEle = true;
					break;
				}								
			}
			if (hasTwoEle) break;
		}
		
		if (!hasTwoEle) System.out.println("Элемент, встречающийся чаще всего: " + arr[indexMax]);
		
		System.out.println("Пройдено итераций: " + iterations1 + " + " + iterations2);
		
	}

}
