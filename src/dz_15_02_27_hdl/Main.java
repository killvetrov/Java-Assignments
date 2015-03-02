package dz_15_02_27_hdl;

public class Main {
	
	public static void main(String[] args) {
		
//		for (int i = 1; i < 60; i++) {
//			System.out.printf("new HDLChar('%s', \"%03d\"),%n", (char) (' ' + i - 1), i + 116);
//		}
		
		System.out.println(HDL.encode("066 212-27-59"));
		
		System.out.println(HDL.decode("118124124141120119120133120125133123127"));
		
		System.out.println(HDL.encodeWithPassword("секрет сект", "pass1"));
		
		System.out.println(HDL.decodeWithPassword("227198214229150228", "pass1"));
		
	}

}
