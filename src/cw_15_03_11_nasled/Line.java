package cw_15_03_11_nasled;

public class Line {
	
	int a;
	
	public Line(int length) {
		this.a = length;
	}
	
	public int calcPerimeter() {
		return a;
	}
	
	public void draw() {
		for (int i = 0; i < a; i++)
			System.out.print("*");
		System.out.println();
	}

}
