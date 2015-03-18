package cw_15_03_18;

public abstract class Figure {
	
	public String name;
	public abstract void draw();
	public abstract int calcS();
	
	public void printName() {
		System.out.println("Имя фигуры: " + name);
	}
	

}
