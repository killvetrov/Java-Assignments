package dz_15_02_23_2;

import java.util.Random;

public class PasswordGenerator {
	
	final public static int LOW = 0;
	final public static int MEDIUM = 1;
	final public static int HARD = 2;
	
	final private static int MAX_LENGTH = 16;
	final private static int HARD_MIN_LENGTH = 9;
	final private static int MEDIUM_MIN_LENGTH = 4;
	final private static int MIN_LENGTH = 2;
	
	private static Random rnd = new Random();
	
	public static String generate(int strength) {
		switch (strength) { 		
		case LOW:
			return generateLow();		
		case MEDIUM:
			return generateMedium();
		case HARD:
			return generateHard();
		default:
			return null;
		}		
	}
	
	private static String generateLow() {
		String password = "";
		// ���������� ������ ������ �� ���� � ����� ������ �� �������
		boolean onlyDigits = rnd.nextBoolean() && rnd.nextBoolean();
		// ���� ������ ����� ������� ������ �� ����, ����� �� ������������ - ��� ����� ����� �� ����� �������; 
		// ����� ��� ����� �� ��������� ���. ����� �������� ������
		int passLength = onlyDigits ? MIN_LENGTH + rnd.nextInt(MAX_LENGTH - MIN_LENGTH + 1) : 
			MIN_LENGTH + rnd.nextInt(MEDIUM_MIN_LENGTH - MIN_LENGTH);
		while (password.length() < passLength)
			password = password.concat(onlyDigits ? String.valueOf(randomNumChar()) : String.valueOf(randomChar()));
		return password;
	}
	
	private static String generateMedium() {					
		int passLength = MEDIUM_MIN_LENGTH + rnd.nextInt(MAX_LENGTH - MEDIUM_MIN_LENGTH + 1);
		char[] passChars = new char[passLength];
		
		// � ������� ������ ������ ���� ���� �� ���� ��������� ������ 
		passChars[rnd.nextInt(passChars.length)] = randomLoCaseChar();
		
		boolean oneDigit = false;
		boolean noUpCase = false;		
		if (passLength >= HARD_MIN_LENGTH) {
			// ����� ������ ��������� ����������� ����� ��������; ����� ��������� ������ �������� �������,  
			// ��� ���� �������� ��������� ���� ���� ����, ���� ������ � ������� ��������
			oneDigit = !(noUpCase = rnd.nextBoolean());
			if (oneDigit) {
				// ��������� ��������� ������ ����� ����� � ������, ��� ��� � ��� ����� ���� ������� � ������� ��������
				int digitsToPlace = 1;
				while (digitsToPlace > 0) {
					int i = rnd.nextInt(passChars.length);
					if (passChars[i] == 0) /* ��� �������� ����������, ����� �� �������� ����� ���������� ������ */ {
						passChars[rnd.nextInt(passChars.length)] = rnd.nextBoolean() ? randomNumChar() : 0;
						digitsToPlace--;
					}
					else
						continue;
				}
			}
		}
		
		// ��������� ��������� ������� ������ � ������������ � ���������� ������� ���������
		for (int i = 0; i < passChars.length; i++) {
			if (passChars[i] != 0) continue; 
			if (oneDigit)
				passChars[i] = rnd.nextBoolean() ? randomUpCaseChar() : randomLoCaseChar();
				else if (noUpCase)
					passChars[i] = rnd.nextBoolean() ? randomLoCaseChar() : randomNumChar();
					else
						passChars[i] = randomChar();					
		}		
		return String.valueOf(passChars);
	}
	
	private static String generateHard() {
		int passLength = HARD_MIN_LENGTH + rnd.nextInt(MAX_LENGTH - HARD_MIN_LENGTH + 1);
		char[] passChars = new char[passLength];
		
		// � ������� ������ ������ ���� ���� �� ���� ������ � ������� �������� 
		passChars[rnd.nextInt(passChars.length)] = randomUpCaseChar();
		
		// ����� � ������ ������ ���� ���� �� ��� �����
		int digitsToPlace = 2;
		while (digitsToPlace > 0) {
			int i = rnd.nextInt(passChars.length);
			if (passChars[i] == 0) {
				passChars[i] = randomNumChar();
				digitsToPlace--;
			}				
			else
				continue;
		}	
		
		// ��������� ������� ��������� �����������
		for (int i = 0; i < passChars.length; i++) {
			if (passChars[i] != 0) continue; 
			passChars[i] = randomChar();
		}		
		return String.valueOf(passChars);
	}
	
	private static char randomUpCaseChar() {
		return (char) ('A' + rnd.nextInt('Z' - 'A' + 1));
	}
	
	private static char randomLoCaseChar() {
		return (char) ('a' + rnd.nextInt('z' - 'a' + 1));
	}
	
	private static char randomNumChar() {
		return (char) ('0' + rnd.nextInt(10));
	}
	
	private static char randomChar() {
		return rnd.nextBoolean() ? randomUpCaseChar() : 
			rnd.nextBoolean() ? randomLoCaseChar() : randomNumChar(); 
	}
	
	public static int determinePasswordStrength(String password) {
		// ���� ���������� ����� ���������� ��� �� ������� �� �������� ��������� ������.
		// ���������� ��� �������� ������ ���������� :)
		
		boolean isNotShorter4 = password.length() >= 4;		
		boolean isLonger8 = password.length() > 8;		
				
		int i = 0, upcase = 0, digits = 0;
		while (i < password.length()) {
			if ((password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') || (password.charAt(i) >= '�' && password.charAt(i) <= '�')) {
				upcase++;
			}
			if (password.charAt(i) >= '0' && (password.charAt(i) <= '9')) {
				digits++;
			}
			i++;
		}
		
		boolean hasUpcase = (upcase > 0);		
		boolean hasTwoDigits = (digits >= 2);		
		boolean hasOnlyDigits = (digits == password.length());		
		
		if (isLonger8 && hasUpcase && hasTwoDigits) {
			return HARD;		
		}
		else if (isNotShorter4 && !hasOnlyDigits) {			
			return MEDIUM;			
		}
		else {
			return LOW;
		}
	}

}
