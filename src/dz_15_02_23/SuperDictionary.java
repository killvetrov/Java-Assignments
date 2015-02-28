package dz_15_02_23;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class SuperDictionary {
	
	final private static String DATA_DIR = "data"; // путь к папке с файлами дополнительных словарей
	
	final public static int LANG_UNKNOWN = -1;
	final public static int LANG_RU = 0;
	final public static int LANG_EN = 1;
	final public static int LANG_UA = 2;
	final public static int LANG_DATAFILE = 3;
	
	final private static int ALPHABET_OTHER = 0;
	final private static int ALPHABET_CYRILLIC = 1;
	final private static int ALPHABET_LATIN = 2;
	
	private static String[][] dictionary = {
		{
			"русский",
			"кекс",    
			"пончик", 
			"эклер",  
			"замороженный йогурт", 
			"имбирный пряник", 
			"медовые соты",
			"мороженое-сэндвич",
			"желейный боб",
			"киткат",
			"леденец",
			"андроид",
			"потоп"
		}, 
		{
			"english",
			"cupcake", 
			"donut",  
			"eclair", 
			"froyo",               
			"gingerbread",     
			"honeycomb", 
			"ice cream sandwich", 
			"jelly bean", 
			"kitkat", 
			"lollipop",
			"android",
			"flood"
		},
		{
			"українська",
			"кекс",    
			"пончик", 
			"еклер",  
			"заморожений йогурт", 
			"імбирний пряник", 
			"медові стільники",
			"морозиво-сендвич",
			"желе боб",
			"кіткат",
			"льодяник",
			"андроїд",
			"потоп"
		}
	};
	
	private static String dictionarySorted[][];
	private static int dictionaryAlphabet[];
	
	private static boolean isDictionaryReady = false;
	
	private Random rnd = new Random();
	
	public SuperDictionary() throws IOException {		
		
		// Построение словаря необходимо выполнить только один раз при создании первого экземпляра
		if (!isDictionaryReady) {
			// Проходимся по всем файлам в папке данных и считываем их в массив словаря
			File dataDir = new File(DATA_DIR);
			String dataList[] = dataDir.list();
			for (int i = 0; i < dataList.length; i++) {			
				dictionary = Arrays.copyOf(dictionary, dictionary.length + 1);
				dictionary[dictionary.length - 1] = new String[dictionary[LANG_RU].length];
				BufferedReader br = new BufferedReader(new FileReader(DATA_DIR + "/" + dataList[i]));
				String line;
				int iline = 0;
				while ((line = br.readLine()) != null) {
					line = validate(line);
					if (!line.isEmpty()) {
						dictionary[dictionary.length - 1][iline] = line;
						iline++;
						if (iline > dictionary[dictionary.length - 1].length - 1) break; 
					}  
				}
				br.close();			
			}

			// Создадим отсортированную копию словаря, чтобы в ней можно было пользоваться бинарным поиском
			dictionarySorted = new String[dictionary.length][];
			dictionaryAlphabet = new int[dictionary.length];
			for (int i = 0; i < dictionary.length; i++) {
				dictionaryAlphabet[i] = detectAlphabet(dictionary[i][0]); 
				dictionarySorted[i] = Arrays.copyOfRange(dictionary[i], 1, dictionary[i].length);
				Arrays.sort(dictionarySorted[i]);
			}
			
			isDictionaryReady = true;
		}
		
	}		
		
	private String validate(String word) {
		return word.trim().toLowerCase();
	}
	
	public int detectLanguage(String word) {
		// Используемые оптимизации:
		// 1. При поиске исключаются языки с алфавитами отличными от введенного слова.
		// 2. Вместо пробежки по элементам массива используется бинарный поиск.
		int result = LANG_UNKNOWN; 
		int alphabet = detectAlphabet(word);
		for (int i = 0; i < dictionarySorted.length; i++) {
			if (alphabet != dictionaryAlphabet[i]) continue;
			if (Arrays.binarySearch(dictionarySorted[i], word) >= 0) {
				result = i;
				break;
			}
		}
		return result;
	}
	
	private int indexOfWord(String[] dictionary, String word) {		
		int i = -1;
		for (int j = 1; j < dictionary.length; j++) {
			if (dictionary[j].equals(word)) {
				i = j;
				break;
			}			
		}
		return i;		
	}
	
	public String translate(String word, int targetLang) {
		word = validate(word);
		if (word.isEmpty()) {
			return "(слово не введено)";
		}
		
		if ((targetLang < 0) || (targetLang > getLangCount() - 1))
			return "(словаря для целевого языка нет)";
		
		int sourceLang = detectLanguage(word);		
		if (sourceLang == LANG_UNKNOWN)
			return "(слова нет в словаре)";
		else if (sourceLang == targetLang)
			return "(исходный язык совпадает с целевым)";		
		
		return dictionary[targetLang][indexOfWord(dictionary[sourceLang], word)];
	}
	
	private static boolean isCharCyrillic(char ch) {
		return ch >= 0x400 /*диапазон кириллицы в Юникоде*/ && ch <= 0x4FF;
	}
	
	private static boolean isCharLatin(char ch) {
		return ch >= 'A' /*английская*/ && ch <= 'z';
	}
	
	private static int detectAlphabet(String word) {
		return isCharLatin(word.charAt(0)) ? ALPHABET_LATIN : 
			(isCharCyrillic(word.charAt(0)) ? ALPHABET_CYRILLIC : ALPHABET_OTHER);
	}
	
	public int getLangCount() {
		return dictionary.length;
	}
	
	public int getWordCount() {
		return dictionarySorted[LANG_RU].length;
	}
	
	public String getLangNameByID(int lang) {
		return (lang >= 0) && (lang <= getLangCount() - 1) ?
				dictionary[lang][0] : "";
	}
	
	public String getRandomWord() {
		return dictionarySorted[rnd.nextInt(getLangCount())][rnd.nextInt(getWordCount())];
	}
	
}
