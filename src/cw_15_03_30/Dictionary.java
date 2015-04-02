package cw_15_03_30;

public class Dictionary<T, V> {

	private T t;
	private V v;
	
	public Dictionary(T t, V v) {
		this.t = t;
		this.v = v;
	}
	
	public static <P1, P2> String concat (P1 p1, P2 p2) {
		return p1.toString() + p2.toString();
	}
	
}
