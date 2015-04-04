package dz_15_03_30_templates;

import java.util.Arrays;

/**
 * ����� {@code MyCollection} �������� �������� ��� ����������� ������� �
 * ������������� ������ ��� ������� ������ � ���.
 * 
 * @author Killvetrov
 */
public class MyCollection<T> {

	private T[] t;
	
	/**
	 * ������� ����� ��������� {@code MyCollection} ��� �������������.
	 * ���������� ������� ���� �� ��������� ������� ��� ������������� ���������:
	 * {@code add, addArray, addCollection}.   
	 */
	public MyCollection() {};

	/**
	 * ������� ����� ��������� {@code MyCollection}, ��������� �������� ������.
	 * 
	 * @param array - ��������� ���������� ������, �� �������� ����� ������� ����������
	 * @throws NullPointerException ���� �������� {@code array} ��������� �� {@code null}
	 */
	public MyCollection(T[] array) {
		if (array == null)
			throw new NullPointerException("Argument array is null");
		this.t = array;
	}
	
	/**
	 * ��������� ������� � ����� ����������� ������� ���������. ���� ����������
	 * ������ ��������� ����, ����� ������ ������ ���� {@code Object}, ����������
	 * ��������� �������.
	 * 
	 * @param t
	 *            - ��������� ����������� �������
	 * @throws IllegalArgumentException
	 *             ���� �������� {@code t} ����� {@code null}
	 */
	@SuppressWarnings("unchecked")
	public void add(T t) {
		if (t == null)
			throw new IllegalArgumentException("Argument t is null");
		if (this.t == null) {
			T[] newArray = (T[]) new Object[1];
			this.t = newArray;
			this.t[0] = (T) t;
			return;
		}

		T[] arrayPlusT = Arrays.copyOf(this.t, this.t.length + 1);
		arrayPlusT[arrayPlusT.length - 1] = t;
		this.t = arrayPlusT;
	}
	
	/**
	 * ���������� ������� ��������� �� ��������� �������.
	 * 
	 * @param position
	 *            - ��������� ������� ����������� ��������
	 * @return ��������� ������� ���������
	 * @throws NullPointerException
	 *             ���� ��������� ������ {@code t} ����� {@code null}
	 * @throws IndexOutOfBoundsException
	 *             ���� {@code position} ������� �� ������� �������
	 */
	public T get(int position) {
		if (this.t == null)
			throw new NullPointerException("Array t in MyCollection is null");
		if ( (position < 0) || (position > t.length - 1) )
			throw new IndexOutOfBoundsException(String.format("Positon %s is out of MyCollection bounds", position));
		return t[position];
	}
	
	/**
	 * ������� ��������� ������� �� ���������. ��� ���� ����� ������� ��� ����� ��������, 
	 * ���� �� ����������� ��������� ���.
	 * 
	 * @param t - ��������� �������, ������� ����� ������
	 * @return {@code true} - ���� ��������� ������� ��� ������ � ������, {@code false} - ���� ������� �� ��� ������
	 */
	public boolean remove (T t) {		
		if (t == null)
			throw new IllegalArgumentException("Argument t is null");
		if (this.t == null)
			throw new NullPointerException("Array t in MyCollection is null");
		
		T[] arrayMinusT;
		int removeCount = 0;
		
		arrayMinusT = this.t.clone();
		int newIndex = 0;
		
		for (int i = 0; i < this.t.length; i++) {
			if (this.t[i].equals(t)) {
				removeCount++;				
			} else {
				arrayMinusT[newIndex++] = this.t[i];
			}			
		}
		
		this.t = Arrays.copyOf(arrayMinusT, newIndex);
		
		return (removeCount > 0);
	}
	
	/**
	 * ������� ������� �� ��������� �� ��������� �������.
	 * 
	 * @param position
	 *            - ������� ��������, ������� ����� �������
	 */
	public void remove(int position) {
		if (this.t == null)
			throw new NullPointerException("Array t in MyCollection is null");
		if ( (position < 0) || (position > t.length - 1) )
			throw new IndexOutOfBoundsException("Argument position is out of bounds");
		
		for (int i = position; i < this.t.length - 1; i++)
			this.t[i] = this.t[i + 1];
		this.t = Arrays.copyOf(this.t, this.t.length - 1);		
	}
	
	/**
	 * ��������� ��������� ������ � ����� ������� ���������. ���� ����������
	 * ������ ��������� ��� �� ��� ������, ��������� ������ ����� �����������
	 * ��� ��� ��������.
	 * 
	 * @param t
	 *            - ������ ��� ���������� � ���������
	 */
	public void addArray(T[] t) {
		if (t == null)
			throw new IllegalArgumentException("Argument t is null");
		if (this.t == null) {
			this.t = Arrays.copyOf(t, t.length);
			return;
		}
		
		if ( !(this.getTypeName().equals(t.getClass().getComponentType().getSimpleName())) )
			throw new IllegalArgumentException(String.format("Type of array t (%s) is incompatible with type of this instance of MyCollection (%s)",
					t.getClass().getComponentType().getSimpleName(), this.getTypeName()));
		
		int oldLength = this.t.length;
		
		this.t = Arrays.copyOf(this.t, this.t.length + t.length);
		
		for (int i = 0; i < t.length; i++)
			this.t[oldLength + i] = t[i];		
	}
	
	/**
	 * ��������� ��������� ��������� � ����� �������. ���� ���������� ������
	 * ��������� ��� �� ��� ������, ��������� ��������� ����� ������������ 
	 * ��� ��� ��������.
	 * 
	 * @param myc
	 *            - ��������� ��� ����������
	 */
	@SuppressWarnings("unchecked")
	public void addCollection(MyCollection<?> myc) {
		if (myc == null)
			throw new IllegalArgumentException("Argument myc is null");
		else if (this.t == null) {
			this.t = (T[]) myc.getAsArray();
			return;
		}	
		
		if (this.getTypeName().equals(myc.getTypeName()))
			addArray((T[]) myc.getAsArray());
		else
			throw new IllegalArgumentException(String.format("Type of argument myc (%s) is incompatible with type of this instance of MyCollection (%s)",
					myc.getTypeName(), this.getTypeName()));
	}
	
	/**
	 * ���������� ���������� ��������� �� ���������� ������� ���������.
	 * 
	 * @return ����� ������� {@code t}
	 */
	public int size() {
		if (this.t == null)
			throw new NullPointerException("Array t in MyCollection is null");
		
		return this.t.length;
	}
	
	/**
	 * ���������� ������� ��������� � ���� �������.
	 * 
	 * @return ����� ����������� ������� ��������� 
	 */
	public T[] getAsArray() {
		if (this.t == null)
			throw new NullPointerException("Array t in MyCollection is null");
		
		return this.t.clone();
	}
	
	/**
	 * ���������� ��� ���� ����������� ������� ���������.
	 */
	public String getTypeName() {
		if (this.t == null)
			throw new NullPointerException("Array t in MyCollection is null");
		
		return this.t.getClass().getComponentType().getSimpleName();
	}
	
	
	/**
	 * ��������� ��������� �� �����������. �������� ��������� ������ �������������
	 * ��������� {@link Comparable}.
	 * 
	 * @throws RuntimeException ���� �������� ��������� �� ������������ ���������� 
	 */
	@SuppressWarnings("unchecked")
	public void sort() {
		if (this.t == null)
			throw new NullPointerException("Array t in MyCollection is null");
		if (this.t.length < 2)
			return;
		if ( !(this.t[0] instanceof Comparable<?>) )
			throw new RuntimeException(String.format("Cannot sort MyCollection: class %s does not implement Comparable interface", this.getTypeName()));
		
		T temp;
		
		for (int i = 0; i < this.t.length - 1; i++)
			for (int j = i + 1; j < this.t.length; j++) {
				if (((Comparable<T>) this.t[i]).compareTo(this.t[j]) > 0) {
					temp = this.t[i];
					this.t[i] = this.t[j];
					this.t[j] = temp;
				}
			}		
	}
	
	/**
	 * ��������� ��������� �� �����������, ������ �� ��������� ������� ��������.
	 * ��� ���� �������� ��������� ������� ������ ������������� ��������� 
	 * {@link Comparable}, � ���� �������� ��������� � ���� �� ���������.
	 * 
	 * @throws RuntimeException ���� ���������� ��������� ��������� ������� �� ���������
	 * 			� ����������� ��������� ���������, ���� ���� �������� ��������� ������� 
	 * 			�� ������������ ���������� 
	 */
	@SuppressWarnings("unchecked")
	public void sortByKey(Object[] key) {
		if (this.t == null)
			throw new NullPointerException("Array t in MyCollection is null");
		if (this.t.length < 2)
			return;
		if (key == null)
			throw new NullPointerException("Argument key is null");
		if (key.length != this.t.length) 
			throw new RuntimeException("Cannot sort MyCollection: number of elements in key array does not match number of elements in MyCollection");		
		if ( !(key[0] instanceof Comparable<?>) )
			throw new RuntimeException(String.format("Cannot sort MyCollection: type of key array %s does not implement Comparable interface", this.getTypeName()));
		
		T temp;
		Object tempKey;
		
		for (int i = 0; i < this.t.length - 1; i++)
			for (int j = i + 1; j < this.t.length; j++) {
				if (((Comparable<Object>) key[i]).compareTo(key[j]) > 0) {
					temp = this.t[i];
					this.t[i] = this.t[j];
					this.t[j] = temp;
					tempKey = key[i];
					key[i] = key[j];
					key[j] = tempKey;
				}
			}		
	}
		
	/**
	 * ���������� ������, ����������� ���������� ���������. � ��� ���������� ����������
	 * � ���� ���������, � ����� ������ ���� ���������.
	 */
	@Override
	public String toString() {
		if (this.t == null)
			throw new NullPointerException("Array t in MyCollection is null");
		
		String result = String.format("%s of type %s has %s elements:%n",
				this.getClass().getSimpleName(), this.t.getClass().getComponentType().getSimpleName(), this.t.length);
		
		result = result.concat("{ ");
		for (int i = 0; i < this.t.length; i++)			
			result = result.concat(String.format(i != 0 ? ", %s" : "%s", t[i]/*.toString()*/));		
		
		return result.concat(" }");
	}

}
