package cw_15_03_11_nasled;

public class Circle extends Line {

	final private static double PI = Math.PI;

	public Circle(int radius) {
		super(radius);
	}

	public double calcLength() {
		return 2 * PI * a;
	}
	
	public double calcArea() {
		return PI * a * a;
	}
	
	@Override
	public void draw() {
		draw(false);
	}
	
	public void draw(boolean fill) {
		for (int i = 0; i < a * 2 + 1; i++) {
			for (int j = 0; j < a * 2 + 1; j++)
				if (((a * a) >= (i - a) * (i - a) + (j - a) * (j - a)) ^ (!fill && ((a - 2) * (a - 2)) >= (i - a) * (i - a) + (j - a) * (j - a)))
					System.out.print("* ");
				else
					System.out.print("  ");
			System.out.println();
		}
	}

}
