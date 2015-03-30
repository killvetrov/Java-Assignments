package cw_15_03_18_2;

public class A {

	public void say() {
		System.out.println("Я объект класса А");
	}
	
	public static void main(String[] args) {
		A a = new A();
		A ab = new AB();
		A abc = new ABC();
		A ac = new AC();
		
		a.say();
		ab.say();
		abc.say();
		ac.say();
		
		if (abc instanceof AC)
			System.out.println("Является объектом ABC");
		
		if (ab instanceof ABC)
			((ABC) ab).sayNew();
		
	}
	
}
