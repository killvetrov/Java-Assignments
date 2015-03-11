package cw_15_03_11_nasled;

public class Square extends Line {
	
	public Square(int side) {
		super(side);
	}
	
	@Override
	public int calcPerimeter() {
		return 4 * this.a;
	}
	
	public int calcArea() {
		return this.a * this.a;
	}
	
	@Override
	public void draw() {
		for (int i = 0; i < a; i++)
			super.draw();
	}

}
