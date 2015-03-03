package dz_15_02_27_hdl;

public class Main {
	
	public static void main(String[] args) {
		
//		for (int i = 1; i < 60; i++) {
//			System.out.printf("new HDLChar('%s', \"%03d\"),%n", (char) (' ' + i - 1), i + 116);
//		}
		
		System.out.println(HDL.filterHDLString("066 aaa212-2a-5a"));
		
		System.out.println(HDL.encode("066 212-27-59"));
		
		System.out.println(HDL.decode("118124125141123124124141121119141125119"));
		
		System.out.println(HDL.encode("alphabet", "ekk1Pd9"));
		
		System.out.println(HDL.decode("178183179198159180205161", "ekk1Pd9"));
		
	}

}
