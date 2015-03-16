package dz_15_02_27_hdl;

public class HDL {
	
	public static class HDLChar {
		private char origin;
		private String code;
		
		public HDLChar(char origin, String code) {
			this.origin = origin;
			this.code = code;
		}
		
		public char getOrigin() {
			return origin;
		}
		
		public String getCode() {
			return code;
		}
		
	}
	
	final public static HDLChar[] hdlAlphabet = {
		new HDLChar('a', "000"),
		new HDLChar('b', "001"), new HDLChar('c', "002"), new HDLChar('d', "003"),
		new HDLChar('e', "004"), new HDLChar('f', "005"), new HDLChar('g', "006"),
		new HDLChar('h', "007"), new HDLChar('i', "008"), new HDLChar('j', "009"),
		new HDLChar('k', "010"), new HDLChar('l', "011"), new HDLChar('m', "012"),
		new HDLChar('n', "013"), new HDLChar('o', "014"), new HDLChar('p', "015"),
		new HDLChar('q', "016"), new HDLChar('r', "017"), new HDLChar('s', "018"),
		new HDLChar('t', "019"), new HDLChar('u', "020"), new HDLChar('v', "021"),
		new HDLChar('w', "022"), new HDLChar('x', "023"), new HDLChar('y', "024"),
		new HDLChar('z', "025"), new HDLChar('A', "026"), new HDLChar('B', "027"),
		new HDLChar('C', "028"), new HDLChar('D', "029"), new HDLChar('E', "030"),
		new HDLChar('F', "031"), new HDLChar('G', "032"), new HDLChar('H', "033"),
		new HDLChar('I', "034"), new HDLChar('J', "035"), new HDLChar('K', "036"),
		new HDLChar('L', "037"), new HDLChar('M', "038"), new HDLChar('N', "039"),
		new HDLChar('O', "040"), new HDLChar('P', "041"), new HDLChar('Q', "042"),
		new HDLChar('R', "043"), new HDLChar('S', "044"), new HDLChar('T', "045"),
		new HDLChar('U', "046"), new HDLChar('V', "047"), new HDLChar('W', "048"),
		new HDLChar('X', "049"), new HDLChar('Y', "050"), new HDLChar('Z', "051"),
		new HDLChar('а', "052"), new HDLChar('б', "053"), new HDLChar('в', "054"),
		new HDLChar('г', "055"), new HDLChar('д', "056"), new HDLChar('е', "057"),
		new HDLChar('ё', "058"), new HDLChar('ж', "059"), new HDLChar('з', "060"),
		new HDLChar('и', "061"), new HDLChar('й', "062"), new HDLChar('к', "063"),
		new HDLChar('л', "064"), new HDLChar('м', "065"), new HDLChar('н', "066"),
		new HDLChar('о', "067"), new HDLChar('п', "068"), new HDLChar('р', "069"),
		new HDLChar('с', "070"), new HDLChar('т', "071"), new HDLChar('у', "072"),
		new HDLChar('ф', "073"), new HDLChar('х', "074"), new HDLChar('ц', "075"),
		new HDLChar('ч', "076"), new HDLChar('ш', "077"), new HDLChar('щ', "078"),
		new HDLChar('ъ', "079"), new HDLChar('ы', "080"), new HDLChar('ь', "081"),
		new HDLChar('э', "082"), new HDLChar('ю', "083"), new HDLChar('я', "084"),
		new HDLChar('А', "085"), new HDLChar('Б', "086"), new HDLChar('В', "087"),
		new HDLChar('Г', "088"), new HDLChar('Д', "089"), new HDLChar('Е', "090"),
		new HDLChar('Ё', "091"), new HDLChar('Ж', "092"), new HDLChar('З', "093"),
		new HDLChar('И', "094"), new HDLChar('Й', "095"), new HDLChar('К', "096"),
		new HDLChar('Л', "097"), new HDLChar('М', "098"), new HDLChar('Н', "099"),
		new HDLChar('О', "100"), new HDLChar('П', "101"), new HDLChar('Р', "102"),
		new HDLChar('С', "103"), new HDLChar('Т', "104"), new HDLChar('У', "105"),
		new HDLChar('Ф', "106"), new HDLChar('Х', "107"), new HDLChar('Ц', "108"),
		new HDLChar('Ч', "109"), new HDLChar('Ш', "110"), new HDLChar('Щ', "111"),
		new HDLChar('Ъ', "112"), new HDLChar('Ы', "113"), new HDLChar('Ь', "114"),
		new HDLChar('Э', "115"), new HDLChar('Ю', "116"), new HDLChar('Я', "117"),
		new HDLChar('0', "118"), new HDLChar('1', "119"), new HDLChar('2', "120"),
		new HDLChar('3', "121"), new HDLChar('4', "122"), new HDLChar('5', "123"),
		new HDLChar('6', "124"), new HDLChar('7', "125"), new HDLChar('8', "126"),
		new HDLChar('9', "127"), new HDLChar(',', "128"), new HDLChar('[', "129"),
		new HDLChar(']', "130"), new HDLChar(':', "131"), new HDLChar('\'', "132"),
		new HDLChar('-', "133"), new HDLChar('(', "134"), new HDLChar(')', "135"),
		new HDLChar('.', "136"), new HDLChar('!', "137"), new HDLChar('?', "138"),
		new HDLChar('\"', "139"), new HDLChar(';', "140"), new HDLChar(' ', "141"),
		new HDLChar('_', "142"), new HDLChar('<', "143"), new HDLChar('>', "144"),
		new HDLChar('+', "145"), new HDLChar('*', "146"), new HDLChar('&', "147"),
		new HDLChar('@', "148"), new HDLChar('#', "149"), new HDLChar('№', "150"),
		new HDLChar('%', "151"), new HDLChar('$', "152"), new HDLChar('^', "153")
	};
	
	public static String filterHDLString (String data) {
		String filteredString = data;
		for (int i = 0; i < filteredString.length(); i++) {			
			if (getHDLCharByOrigin(filteredString.charAt(i)) == null) {
				filteredString = filteredString.replace("" + filteredString.charAt(i), "");
				i--;
			}
		}
		return filteredString;
	}
	
	private static HDLChar getHDLCharByCode(String code) {
		HDLChar result = null;
		if (code.length() == 3) {
			for (int i = 0; i < hdlAlphabet.length; i++)
				if (hdlAlphabet[i].getCode().equals(code)) {
					result = hdlAlphabet[i];
					break;
				}
		}
		return result;
	}
	
	private static HDLChar getHDLCharByOrigin(char origin) {
		HDLChar result = null;
		if (origin != 0) {
			for (int i = 0; i < hdlAlphabet.length; i++)
				if (hdlAlphabet[i].getOrigin() == origin) {
					result = hdlAlphabet[i];
					break;
				}
		}
		return result;
	}
	
	public static String encode(String data) {
		String encodedString = "";
		
		data = filterHDLString(data);
		
		for (int i = 0; i < data.length(); i++) {
			HDLChar hdlch = getHDLCharByOrigin(data.charAt(i));
			if (hdlch != null)
				encodedString = encodedString.concat(hdlch.getCode());
		}
		
		return encodedString;		
	}
	
	public static String encode(String data, String password) {		
		if (password.trim().isEmpty())
			return encode(data);
		
		String encodedString = "";
		
		data = encode(data);
		
		password = encode(password.trim());		
		int checksum = 0;
		for (int i = 2; i < password.length(); i += 3)
			checksum += Integer.valueOf(password.substring(i - 2, i + 1)) * (password.length() - i) + 1;
		checksum = checksum % hdlAlphabet.length;
		
		for (int i = 2; i < data.length(); i += 3) {
			encodedString = encodedString.concat(String.format("%03d", 
					((Integer.valueOf(data.substring(i - 2, i + 1))) ^ 
					(Integer.valueOf(password.substring((i - 2) % password.length(), (i - 2) % password.length() + 3)) + 1))
					^ checksum));
		}
		
		return encodedString;
	}
	
	public static String decode(String data) {
		String decodedString = "";
		
		data = filterdecode(data);
		
		for (int i = 2; i < data.length(); i += 3) {
			HDLChar hdlch = getHDLCharByCode(data.substring(i - 2, i + 1));
			if (hdlch != null)
				decodedString = decodedString.concat(String.valueOf(hdlch.getOrigin()));
		}
		
		return decodedString;
	}
	
	public static String decode(String data, String password) {
		if (password.trim().isEmpty())
			return decode(data);
		
		String decodedString = "";
		
		data = filterdecode(data);
		
		password = encode(password.trim());		
		int checksum = 0;
		for (int i = 2; i < password.length(); i += 3)
			checksum += Integer.valueOf(password.substring(i - 2, i + 1)) * (password.length() - i) + 1;
		checksum = (checksum % hdlAlphabet.length) / 2;
		
		for (int i = 2; i < data.length(); i += 3) {
			HDLChar hdlch = getHDLCharByCode(String.format("%03d", 
					((Integer.valueOf(data.substring(i - 2, i + 1))) ^ checksum) ^ 
					(Integer.valueOf(password.substring((i - 2) % password.length(), (i - 2) % password.length() + 3)) + 1)
					));
			if (hdlch != null) 
				decodedString = decodedString.concat("" + hdlch.getOrigin());
		}
		
		return decodedString;
	}
	
	private static String filterdecode(String text) {

		if (text.isEmpty() == true) {
			text = "HDL версия 1.1 - пустая строка";
		}
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == (char) ' ') {
				text = text.replace("" + text.charAt(i), "");
			}
		}
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) < (char) '0' || text.charAt(i) > (char) '9') {
				text = text.replace("" + text.charAt(i), "");
			}
		}
		if (text.length() % 3 != 0) {
			text = "HDL версия 1.2 - неверная длинна";
		}
		return text;
	}
	
}

