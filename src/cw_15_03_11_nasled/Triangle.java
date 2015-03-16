package cw_15_03_11_nasled;

public class Triangle extends Rectangle {
	
	public Triangle(int side1, int side2) {
		super(side1, side2);
	}
	
	@Override
	public int calcPerimeter() {
		return a + b + (int) Math.round(Math.sqrt(a * a + b * b));
	}
	
	@Override
	public int calcArea() {
		return super.calcArea() / 2;
	}
	
	@Override
	public void draw() {
		draw(false);
	}
	
	public void draw(boolean fill) {
		for (int i = 1; i <= b; i++) {
			for (int j = 1; j <= a; j++) {
				if ((double) j / i <= (double) a / b)
					System.out.print("*");			
			}
			System.out.println();
		}
	}

}
