package electronic_life;

public class Grid {
	
	int width;
	int height;
	String[] space;
	
	public Grid(int width, int height) {
		this.width = width;
		this.height = height;
		this.space = new String[width * height];
	}
	
	public String get(Vector vect) {
		return this.space[vect.x + width * vect.y];
	}
	
	public void set (Vector vect, String value) {
		this.space[vect.x + width * vect.y] = value;
	}

}
