package electronic_life;

public class Vector {
	
	int x;
	int y;
	
	public Vector(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector add(Vector vectorToAdd) {
		return new Vector(this.x + vectorToAdd.x, this.y + vectorToAdd.y);
	}

}
