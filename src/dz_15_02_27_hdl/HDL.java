package dz_15_02_27_hdl;

public class HDL {
	
	private static class HDLChar {
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
	
	final private static HDLChar[] hdlAlphabet = {
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
		new HDLChar('à', "052"), new HDLChar('á', "053"), new HDLChar('â', "054"),
		new HDLChar('ã', "055"), new HDLChar('ä', "056"), new HDLChar('å', "057"),
		new HDLChar('¸', "058"), new HDLChar('æ', "059"), new HDLChar('ç', "060"),
		new HDLChar('è', "061"), new HDLChar('é', "062"), new HDLChar('ê', "063"),
		new HDLChar('ë', "064"), new HDLChar('ì', "065"), new HDLChar('í', "066"),
		new HDLChar('î', "067"), new HDLChar('ï', "068"), new HDLChar('ð', "069"),
		new HDLChar('ñ', "070"), new HDLChar('ò', "071"), new HDLChar('ó', "072"),
		new HDLChar('ô', "073"), new HDLChar('õ', "074"), new HDLChar('ö', "075"),
		new HDLChar('÷', "076"), new HDLChar('ø', "077"), new HDLChar('ù', "078"),
		new HDLChar('ú', "079"), new HDLChar('û', "080"), new HDLChar('ü', "081"),
		new HDLChar('ý', "082"), new HDLChar('þ', "083"), new HDLChar('ÿ', "084"),
		new HDLChar('À', "085"), new HDLChar('Á', "086"), new HDLChar('Â', "087"),
		new HDLChar('Ã', "088"), new HDLChar('Ä', "089"), new HDLChar('Å', "090"),
		new HDLChar('¨', "091"), new HDLChar('Æ', "092"), new HDLChar('Ç', "093"),
		new HDLChar('È', "094"), new HDLChar('É', "095"), new HDLChar('Ê', "096"),
		new HDLChar('Ë', "097"), new HDLChar('Ì', "098"), new HDLChar('Í', "099"),
		new HDLChar('Î', "100"), new HDLChar('Ï', "101"), new HDLChar('Ð', "102"),
		new HDLChar('Ñ', "103"), new HDLChar('Ò', "104"), new HDLChar('Ó', "105"),
		new HDLChar('Ô', "106"), new HDLChar('Õ', "107"), new HDLChar('Ö', "108"),
		new HDLChar('×', "109"), new HDLChar('Ø', "110"), new HDLChar('Ù', "111"),
		new HDLChar('Ú', "112"), new HDLChar('Û', "113"), new HDLChar('Ü', "114"),
		new HDLChar('Ý', "115"), new HDLChar('Þ', "116"), new HDLChar('ß', "117"),
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
		new HDLChar('@', "148"), new HDLChar('#', "149"), new HDLChar('¹', "150"),
		new HDLChar('%', "151"), new HDLChar('$', "152"), new HDLChar('^', "153")
	};
	
	private static char getOriginFromCode(String code) {
		char result = 0;
		if (code.length() == 3) {
			for (int i = 0; i < hdlAlphabet.length; i++)
				if (hdlAlphabet[i].getCode().equals(code)) {
					result = hdlAlphabet[i].getOrigin();
					break;
				}
		}
		return result;
	}
	
	private static String getCodeFromOrigin(char origin) {
		String result = null;
		if (origin != 0) {
			for (int i = 0; i < hdlAlphabet.length; i++)
				if (hdlAlphabet[i].getOrigin() == origin) {
					result = hdlAlphabet[i].getCode();
					break;
				}
		}
		return result;
	}
	
	public static String encode(String data) {
		String encodedString = "";
		
		for (int i = 0; i < data.length(); i++) {
			String code = getCodeFromOrigin(data.charAt(i));
			if (code != null)
				encodedString = encodedString.concat(code);
		}
		
		return encodedString;		
	}
	
	public static String encodeWithPassword(String data, String password) {
		String encodedString = "";
		
		password = password.trim();
		
		for (int i = 0; i < data.length(); i++) {
			encodedString = encodedString.concat(String.format("%03d", data.charAt(i) + password.charAt(i % (password.length()))));
		}
		
		return encodedString;
	}
	
	public static String decodeWithPassword(String data, String password) {
		String decodedString = "";
		
		password = password.trim();
		
		for (int i = 2; i < data.length(); i += 3) {
			decodedString = decodedString.concat(String.valueOf((char) (Integer.valueOf(data.substring(i - 2, i + 1)) - password.charAt((i / 3) % (password.length())))));
		}
		
		return decodedString;
	}
	
	public static String decode(String data) {
		String decodedString = "";
		
		for (int i = 2; i < data.length(); i += 3) {
			char origin = getOriginFromCode(data.substring(i - 2, i + 1));
			if (origin != 0)
				decodedString = decodedString.concat(String.valueOf(origin));
		}
		
		return decodedString;
	}
	
}

