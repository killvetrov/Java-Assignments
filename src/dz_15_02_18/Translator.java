package dz_15_02_18;

public class Translator {

	public static void main(String[] args) {		
		
		SuperDictionary mySD = new SuperDictionary();
		
		System.out.println(mySD.translateToEnglish("   ПоТОП "));
		System.out.println(mySD.translateToRussian(" andROID "));
		System.out.println(mySD.translate("     FroYo  "));
		
	}

}

class SuperDictionary {
	
	private String[] rus = {
			"кекс",    
			"пончик", 
			"эклер",  
			"замороженный йогурт", 
			"имбирный пряник", 
			"медовая сота",
			"мороженое-сэндвич",
			"желейный боб",
			"киткат",
			"леденец",
			"андроид",
			"потоп"
			};
	private String[] eng = {
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
			};
		
	private String validate(String word) {
		return word.trim().toLowerCase();
	}
	
	private int indexOfWord(String[] dictionary, String word) {		
		int i = -1;
		for (int j = 0; j < dictionary.length; j++) {
			if (dictionary[j].equals(word)) {
				i = j;
				break;
			}
			
		}
		return i;		
	}
	
	public String translateToEnglish(String word) {
		word = validate(word);
		if (word.isEmpty()) {
			return "(слово не введено)";
		}
		
		int index = indexOfWord(rus, word);
		return (index != -1) ? eng[index] : "(нет в словаре)";
	}
	
	public String translateToRussian(String word) {
		word = validate(word);
		if (word.isEmpty()) {
			return "(слово не введено)";
		}
		
		int index = indexOfWord(eng, word); 
		return (index != -1) ? rus[index] : "(нет в словаре)";
	}
	
	public String translate(String word) {
		word = validate(word);
		if (word.isEmpty()) {
			return "(слово не введено)";
		}
		
		if (word.charAt(0) >= 'а' /*русская*/ && word.charAt(0) <= 'я') {
			return translateToEnglish(word);
		} else if (word.charAt(0) >= 'a' /*английская*/ && word.charAt(0) <= 'z') {
			return translateToRussian(word);
		} else {
			return "(нет в словаре)";
		}
		
	}
	
}
