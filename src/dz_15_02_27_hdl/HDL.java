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
		new HDLChar('a', "001"),
		new HDLChar('b', "002"),
		new HDLChar('c', "003"),
		new HDLChar('d', "004"),
		new HDLChar('e', "005"),
		new HDLChar('f', "006"),
		new HDLChar('g', "007"),
		new HDLChar('h', "008"),
		new HDLChar('i', "009"),
		new HDLChar('j', "010"),
		new HDLChar('k', "011"),
		new HDLChar('l', "012"),
		new HDLChar('m', "013"),
		new HDLChar('n', "014"),
		new HDLChar('o', "015"),
		new HDLChar('p', "016"),
		new HDLChar('q', "017"),
		new HDLChar('r', "018"),
		new HDLChar('s', "019"),
		new HDLChar('t', "020"),
		new HDLChar('u', "021"),
		new HDLChar('v', "022"),
		new HDLChar('w', "023"),
		new HDLChar('x', "024"),
		new HDLChar('y', "025"),
		new HDLChar('z', "026"),
		new HDLChar('A', "027"),
		new HDLChar('B', "028"),
		new HDLChar('C', "029"),
		new HDLChar('D', "030"),
		new HDLChar('E', "031"),
		new HDLChar('F', "032"),
		new HDLChar('G', "033"),
		new HDLChar('H', "034"),
		new HDLChar('I', "035"),
		new HDLChar('J', "036"),
		new HDLChar('K', "037"),
		new HDLChar('L', "038"),
		new HDLChar('M', "039"),
		new HDLChar('N', "040"),
		new HDLChar('O', "041"),
		new HDLChar('P', "042"),
		new HDLChar('Q', "043"),
		new HDLChar('R', "044"),
		new HDLChar('S', "045"),
		new HDLChar('T', "046"),
		new HDLChar('U', "047"),
		new HDLChar('V', "048"),
		new HDLChar('W', "049"),
		new HDLChar('X', "050"),
		new HDLChar('Y', "051"),
		new HDLChar('Z', "052"),
		new HDLChar('à', "053"),
		new HDLChar('á', "054"),
		new HDLChar('â', "055"),
		new HDLChar('ã', "056"),
		new HDLChar('ä', "057"),
		new HDLChar('å', "058"),
		new HDLChar('æ', "059"),
		new HDLChar('ç', "060"),
		new HDLChar('è', "061"),
		new HDLChar('é', "062"),
		new HDLChar('ê', "063"),
		new HDLChar('ë', "064"),
		new HDLChar('ì', "065"),
		new HDLChar('í', "066"),
		new HDLChar('î', "067"),
		new HDLChar('ï', "068"),
		new HDLChar('ð', "069"),
		new HDLChar('ñ', "070"),
		new HDLChar('ò', "071"),
		new HDLChar('ó', "072"),
		new HDLChar('ô', "073"),
		new HDLChar('õ', "074"),
		new HDLChar('ö', "075"),
		new HDLChar('÷', "076"),
		new HDLChar('ø', "077"),
		new HDLChar('ù', "078"),
		new HDLChar('ú', "079"),
		new HDLChar('û', "080"),
		new HDLChar('ü', "081"),
		new HDLChar('ý', "082"),
		new HDLChar('þ', "083"),
		new HDLChar('ÿ', "084"),
		new HDLChar('À', "085"),
		new HDLChar('Á', "086"),
		new HDLChar('Â', "087"),
		new HDLChar('Ã', "088"),
		new HDLChar('Ä', "089"),
		new HDLChar('Å', "090"),
		new HDLChar('Æ', "091"),
		new HDLChar('Ç', "092"),
		new HDLChar('È', "093"),
		new HDLChar('É', "094"),
		new HDLChar('Ê', "095"),
		new HDLChar('Ë', "096"),
		new HDLChar('Ì', "097"),
		new HDLChar('Í', "098"),
		new HDLChar('Î', "099"),
		new HDLChar('Ï', "100"),
		new HDLChar('Ð', "101"),
		new HDLChar('Ñ', "102"),
		new HDLChar('Ò', "103"),
		new HDLChar('Ó', "104"),
		new HDLChar('Ô', "105"),
		new HDLChar('Õ', "106"),
		new HDLChar('Ö', "107"),
		new HDLChar('×', "108"),
		new HDLChar('Ø', "109"),
		new HDLChar('Ù', "110"),
		new HDLChar('Ú', "111"),
		new HDLChar('Û', "112"),
		new HDLChar('Ü', "113"),
		new HDLChar('Ý', "114"),
		new HDLChar('Þ', "115"),
		new HDLChar('ß', "116"),
		new HDLChar(' ', "117"),
		new HDLChar('!', "118"),
		new HDLChar('"', "119"),
		new HDLChar('#', "120"),
		new HDLChar('$', "121"),
		new HDLChar('%', "122"),
		new HDLChar('&', "123"),
		new HDLChar('\'', "124"),
		new HDLChar('(', "125"),
		new HDLChar(')', "126"),
		new HDLChar('*', "127"),
		new HDLChar('+', "128"),
		new HDLChar(',', "129"),
		new HDLChar('-', "130"),
		new HDLChar('.', "131"),
		new HDLChar('/', "132"),
		new HDLChar('0', "133"),
		new HDLChar('1', "134"),
		new HDLChar('2', "135"),
		new HDLChar('3', "136"),
		new HDLChar('4', "137"),
		new HDLChar('5', "138"),
		new HDLChar('6', "139"),
		new HDLChar('7', "140"),
		new HDLChar('8', "141"),
		new HDLChar('9', "142"),
		new HDLChar(':', "143"),
		new HDLChar(';', "144"),
		new HDLChar('<', "145"),
		new HDLChar('=', "146"),
		new HDLChar('>', "147"),
		new HDLChar('?', "148"),
		new HDLChar('@', "149")
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

