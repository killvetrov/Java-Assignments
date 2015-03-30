package dz_15_03_30_templates;

import java.util.Arrays;

public class MyCollection<T> {

	private T[] t;

	public MyCollection() {};

	public MyCollection(T[] array) {
		if (array == null)
			throw new IllegalArgumentException();
		this.t = array;
	}

	public void add(T t) {
		T[] arrayPlusT = Arrays.copyOf(this.t, this.t.length + 1);
		arrayPlusT[arrayPlusT.length - 1] = t;
		this.t = arrayPlusT;
	}
	
	public T get(int position) {
		if ( (position < 0) || (position > t.length - 1) )
			throw new IndexOutOfBoundsException();
		return t[position];
	}
	
	public boolean remove (T t) {
		
		
		return false;
	}
	
	@Override
	public String toString() {
		String result = String.format("%s of type %s has %s elements:%n", 
				this.getClass().getSimpleName(), this.t.getClass().getSimpleName(), this.t.length);
		
		for (int i = 0; i < this.t.length; i++)			
			result = result.concat(String.format("%s%n", t[i].toString()));		
		
		return result;
	}

}
