package cw_15_03_30;

public class Box<T> {

	private T t;
	
	public Box() {
		
	}
	
	public Box(T t) {
		this.t = t;
	}
	
	public void box(T t) {
		this.t = t;
	}
	
	public T unbox() {
		return this.t;
	}
	
	@Override
	public String toString() {
		return "T class " + t.getClass() + " t value = " + t.toString();
	}
	

}
