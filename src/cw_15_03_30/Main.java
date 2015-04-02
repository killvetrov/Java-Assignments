package cw_15_03_30;

public class Main {

	public static void main(String[] args) {

		Box<Integer> intBox = new Box<Integer>();
		
		intBox.box(10);
		int i = intBox.unbox();
		
		System.out.println(intBox.toString());
		
		Box doubleBox = new Box<Double> (15.555);		
		System.out.println(doubleBox.toString());
		
		Box strBox = new Box<String> ("Привет");
		System.out.println(strBox);
		
		System.out.println(Dictionary.concat(new String ("Строка"), new Boolean ("true")));

	}

}
