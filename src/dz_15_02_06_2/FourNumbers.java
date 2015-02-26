// —оздайте массив из 4 случайных целых чисел из отрезка [10;99], выведите его на экран в строку. 
// ќпределить и вывести на экран сообщение о том, €вл€етс€ ли массив строго возрастающей последовательностью.

package dz_15_02_06_2;

import java.util.Random;

public class FourNumbers {

	public static void main(String[] args) {

		Random rnd = new Random();

		int arr[] = {0, 9, 30, 40}; //new int[4];		
		boolean goesUp;
		
		System.out.print("¬веденный массив: ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 10 + rnd.nextInt(90);
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		goesUp = true;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] <= arr[i-1]) {
				goesUp = false;
				break;
			}
		}
		
		System.out.println("ћассив " + (goesUp ? "€вл€етс€" : "не €вл€етс€") + " строго возрастающей последовательностью.");

	}

}
