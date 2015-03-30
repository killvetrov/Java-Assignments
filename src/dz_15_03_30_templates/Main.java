package dz_15_03_30_templates;

public class Main {
	
	public static void main(String[] args) {
		Integer[] iArray = {1, 2, 3};
		MyCollection myc1 = new MyCollection<Integer>(new Integer[] {1, 2, 3});
		
		System.out.println(myc1.toString());
			
	}	
	
}
