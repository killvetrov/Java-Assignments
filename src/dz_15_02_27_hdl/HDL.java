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
		new HDLChar('�', "052"), new HDLChar('�', "053"), new HDLChar('�', "054"),
		new HDLChar('�', "055"), new HDLChar('�', "056"), new HDLChar('�', "057"),
		new HDLChar('�', "058"), new HDLChar('�', "059"), new HDLChar('�', "060"),
		new HDLChar('�', "061"), new HDLChar('�', "062"), new HDLChar('�', "063"),
		new HDLChar('�', "064"), new HDLChar('�', "065"), new HDLChar('�', "066"),
		new HDLChar('�', "067"), new HDLChar('�', "068"), new HDLChar('�', "069"),
		new HDLChar('�', "070"), new HDLChar('�', "071"), new HDLChar('�', "072"),
		new HDLChar('�', "073"), new HDLChar('�', "074"), new HDLChar('�', "075"),
		new HDLChar('�', "076"), new HDLChar('�', "077"), new HDLChar('�', "078"),
		new HDLChar('�', "079"), new HDLChar('�', "080"), new HDLChar('�', "081"),
		new HDLChar('�', "082"), new HDLChar('�', "083"), new HDLChar('�', "084"),
		new HDLChar('�', "085"), new HDLChar('�', "086"), new HDLChar('�', "087"),
		new HDLChar('�', "088"), new HDLChar('�', "089"), new HDLChar('�', "090"),
		new HDLChar('�', "091"), new HDLChar('�', "092"), new HDLChar('�', "093"),
		new HDLChar('�', "094"), new HDLChar('�', "095"), new HDLChar('�', "096"),
		new HDLChar('�', "097"), new HDLChar('�', "098"), new HDLChar('�', "099"),
		new HDLChar('�', "100"), new HDLChar('�', "101"), new HDLChar('�', "102"),
		new HDLChar('�', "103"), new HDLChar('�', "104"), new HDLChar('�', "105"),
		new HDLChar('�', "106"), new HDLChar('�', "107"), new HDLChar('�', "108"),
		new HDLChar('�', "109"), new HDLChar('�', "110"), new HDLChar('�', "111"),
		new HDLChar('�', "112"), new HDLChar('�', "113"), new HDLChar('�', "114"),
		new HDLChar('�', "115"), new HDLChar('�', "116"), new HDLChar('�', "117"),
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
		new HDLChar('@', "148"), new HDLChar('#', "149"), new HDLChar('�', "150"),
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

