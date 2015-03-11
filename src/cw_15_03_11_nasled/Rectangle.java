package cw_15_03_11_nasled;

public class Rectangle extends Square {
	
	int b;
	
	public Rectangle(int width, int height) {
		super(width);
		this.b = height;
	}
	
	@Override
	public int calcPerimeter() {
		return 2 * (a + b);
	}
	
	@Override
	public int calcArea() {
		return a * b;
	}
	
	@Override
	public void draw() {
		for (int i = 0; i < b; i++) {
			for (int j = 0; j < a; j++)
				System.out.print("*");
		System.out.println();	
		}
	}

}
