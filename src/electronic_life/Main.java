package electronic_life;

public class Main {
	
	public static void main(String[] args) {
		
		Grid myGrid = new Grid(5, 5);		
		System.out.println(myGrid.get(new Vector(1, 1)));
		myGrid.set(new Vector(1, 1), "X");
		System.out.println(myGrid.get(new Vector(1, 1)));
		
	}

}
