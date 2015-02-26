package dz_15_02_18;

public class Translator {

	public static void main(String[] args) {		
		
		SuperDictionary mySD = new SuperDictionary();
		
		System.out.println(mySD.translateToEnglish("   ����� "));
		System.out.println(mySD.translateToRussian(" andROID "));
		System.out.println(mySD.translate("     FroYo  "));
		
	}

}

class SuperDictionary {
	
	private String[] rus = {
			"����",    
			"������", 
			"�����",  
			"������������ ������", 
			"�������� ������", 
			"������� ����",
			"���������-�������",
			"�������� ���",
			"������",
			"�������",
			"�������",
			"�����"
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
			return "(����� �� �������)";
		}
		
		int index = indexOfWord(rus, word);
		return (index != -1) ? eng[index] : "(��� � �������)";
	}
	
	public String translateToRussian(String word) {
		word = validate(word);
		if (word.isEmpty()) {
			return "(����� �� �������)";
		}
		
		int index = indexOfWord(eng, word); 
		return (index != -1) ? rus[index] : "(��� � �������)";
	}
	
	public String translate(String word) {
		word = validate(word);
		if (word.isEmpty()) {
			return "(����� �� �������)";
		}
		
		if (word.charAt(0) >= '�' /*�������*/ && word.charAt(0) <= '�') {
			return translateToEnglish(word);
		} else if (word.charAt(0) >= 'a' /*����������*/ && word.charAt(0) <= 'z') {
			return translateToRussian(word);
		} else {
			return "(��� � �������)";
		}
		
	}
	
}
