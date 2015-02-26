package dz_15_02_23;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Translator {

	public static void main(String[] args) throws IOException {
		
		Random rnd = new Random();

		Scanner scanIn = new Scanner(System.in);
		SuperDictionary mySD = new SuperDictionary();
		System.out.println("������� ����� � ������. ���� � �������: " + mySD.getWordCount() + ". ������ � �������: " + mySD.getLangCount() + ".");
		String word;
		int targetLang;
		
		boolean enough = false;
		while (!enough) {
			System.out.print("������� ����� ��� �������� � ������� ENTER: ");
			String inLine = scanIn.nextLine();
			if (!inLine.trim().isEmpty())
				word = inLine;			
			else {
				word = mySD.getRandomWord();
				System.out.println("����� �� ���� �������, ��� ������ ������� ��������� ����� �� �������: " + word);
			}				
			
			System.out.print("�� ����� ���� ��������� �������? (");
			// ����������� ��� ��������� ����� ������� ��� ������
			for (int i = 1; i <= mySD.getLangCount(); i++)
				System.out.print(i + " = " + mySD.getLangNameByID(i - 1) + (i < mySD.getLangCount() ? "; " : ""));
			System.out.print("): ");
			inLine = scanIn.nextLine().trim();
			if (!inLine.isEmpty())
				targetLang = Integer.valueOf(inLine) - 1;
			else {				
				targetLang = rnd.nextInt(mySD.getLangCount());
				System.out.println("���� �� ��� ������, ��� ������ ������ ��������� ����: " + mySD.getLangNameByID(targetLang));
			}
			
			System.out.println(mySD.translate(word, targetLang));
			
			System.out.print("��������� ��� ���� �����? (1 = ��; ������ ������ = ���): ");
			inLine = scanIn.nextLine();
			if (!inLine.trim().equals("1")) enough = true; 
		}
		scanIn.close();
		
		System.out.println("������� ������.");

	}

}
