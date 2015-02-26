package dz_15_02_23;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Translator {

	public static void main(String[] args) throws IOException {
		
		Random rnd = new Random();

		Scanner scanIn = new Scanner(System.in);
		SuperDictionary mySD = new SuperDictionary();
		System.out.println("—ловарь готов к работе. —лов в словаре: " + mySD.getWordCount() + ". языков в словаре: " + mySD.getLangCount() + ".");
		String word;
		int targetLang;
		
		boolean enough = false;
		while (!enough) {
			System.out.print("¬ведите слово дл€ перевода и нажмите ENTER: ");
			String inLine = scanIn.nextLine();
			if (!inLine.trim().isEmpty())
				word = inLine;			
			else {
				word = mySD.getRandomWord();
				System.out.println("—лово не было введено, дл€ работы выбрано случайное слово из словар€: " + word);
			}				
			
			System.out.print("Ќа какой €зык выполнить перевод? (");
			// ѕеречисл€ем все доступные €зыки словар€ дл€ выбора
			for (int i = 1; i <= mySD.getLangCount(); i++)
				System.out.print(i + " = " + mySD.getLangNameByID(i - 1) + (i < mySD.getLangCount() ? "; " : ""));
			System.out.print("): ");
			inLine = scanIn.nextLine().trim();
			if (!inLine.isEmpty())
				targetLang = Integer.valueOf(inLine) - 1;
			else {				
				targetLang = rnd.nextInt(mySD.getLangCount());
				System.out.println("язык не был указан, дл€ работы выбран случайный €зык: " + mySD.getLangNameByID(targetLang));
			}
			
			System.out.println(mySD.translate(word, targetLang));
			
			System.out.print("ѕеревести еще одно слово? (1 = да; другой символ = нет): ");
			inLine = scanIn.nextLine();
			if (!inLine.trim().equals("1")) enough = true; 
		}
		scanIn.close();
		
		System.out.println("—ловарь закрыт.");

	}

}
