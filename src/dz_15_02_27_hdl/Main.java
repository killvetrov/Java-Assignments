package dz_15_02_27_hdl;

public class Main {
	
	public static void main(String[] args) {
		
//		for (int i = 1; i < 60; i++) {
//			System.out.printf("new HDLChar('%s', \"%03d\"),%n", (char) (' ' + i - 1), i + 116);
//		}
		
		System.out.println(HDL.encode("<сек–ет>"));
		
		System.out.println(HDL.decode("145070058063101058071147"));
		
	}

}
