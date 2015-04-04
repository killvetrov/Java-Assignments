package dz_15_03_30_templates;

import java.util.Arrays;

/**
 * Класс {@code MyCollection} является оберткой для одномерного массива и
 * предоставляет методы для удобной работы с ним.
 * 
 * @author Killvetrov
 */
public class MyCollection<T> {

	private T[] t;
	
	/**
	 * Создает новый экземпляр {@code MyCollection} без инициализации.
	 * Необходимо вызвать один из следующих методов для инициализации коллекции:
	 * {@code add, addArray, addCollection}.   
	 */
	public MyCollection() {};

	/**
	 * Создает новый экземпляр {@code MyCollection}, используя заданный массив.
	 * 
	 * @param array - указывает одномерный массив, из которого будет создана колллекция
	 * @throws NullPointerException если параметр {@code array} указывает на {@code null}
	 */
	public MyCollection(T[] array) {
		if (array == null)
			throw new NullPointerException("Argument array is null");
		this.t = array;
	}
	
	/**
	 * Добавляет элемент в конец внутреннего массива коллекции. Если внутренний
	 * массив коллекции пуст, будет создан массив типа {@code Object}, содержащий
	 * указанный элемент.
	 * 
	 * @param t
	 *            - указывает добавляемый элемент
	 * @throws IllegalArgumentException
	 *             если параметр {@code t} равен {@code null}
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
	 * Возвращает элемент коллекции по указанной позиции.
	 * 
	 * @param position
	 *            - указывает позицию получаемого элемента
	 * @return указанный элемент коллекции
	 * @throws NullPointerException
	 *             если локальный массив {@code t} равен {@code null}
	 * @throws IndexOutOfBoundsException
	 *             если {@code position} выходит за границы массива
	 */
	public T get(int position) {
		if (this.t == null)
			throw new NullPointerException("Array t in MyCollection is null");
		if ( (position < 0) || (position > t.length - 1) )
			throw new IndexOutOfBoundsException(String.format("Positon %s is out of MyCollection bounds", position));
		return t[position];
	}
	
	/**
	 * Удаляет указанный элемент из коллекции. При этом будут удалены все копии элемента, 
	 * если он встречается несколько раз.
	 * 
	 * @param t - указывает элемент, который будет удален
	 * @return {@code true} - если указанный элемент был найден и удален, {@code false} - если элемент не был найден
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
	 * Удаляет элемент из коллекции по указанной позиции.
	 * 
	 * @param position
	 *            - позиция элемента, которая будет удалена
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
	 * Добавляет указанный массив в конец текущей коллекции. Если внутренний
	 * массив коллекции еще не был создан, указанный массив будет использован
	 * для его создания.
	 * 
	 * @param t
	 *            - массив для добавления в коллекцию
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
	 * Добавляет указанную коллекцию в конец текущей. Если внутренний массив
	 * коллекции еще не был создан, указанная коллекция будет использована 
	 * для его создания.
	 * 
	 * @param myc
	 *            - коллекция для добавления
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
	 * Возвращает количество элементов во внутреннем массиве коллекции.
	 * 
	 * @return длину массива {@code t}
	 */
	public int size() {
		if (this.t == null)
			throw new NullPointerException("Array t in MyCollection is null");
		
		return this.t.length;
	}
	
	/**
	 * Возвращает текущую коллекцию в виде массива.
	 * 
	 * @return копию внутреннего массива коллекции 
	 */
	public T[] getAsArray() {
		if (this.t == null)
			throw new NullPointerException("Array t in MyCollection is null");
		
		return this.t.clone();
	}
	
	/**
	 * Возвращает имя типа внутреннего массива коллекции.
	 */
	public String getTypeName() {
		if (this.t == null)
			throw new NullPointerException("Array t in MyCollection is null");
		
		return this.t.getClass().getComponentType().getSimpleName();
	}
	
	
	/**
	 * Сортирует коллекцию по возрастанию. Элементы коллекции должны реализовывать
	 * интерфейс {@link Comparable}.
	 * 
	 * @throws RuntimeException если элементы коллекции не поддерживают сортировку 
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
	 * Сортирует коллекцию по возрастанию, исходя из ключевого массива значений.
	 * При этом элементы ключевого массива должны реализовывать интерфейс 
	 * {@link Comparable}, а сами элементы коллекции в этом не нуждаются.
	 * 
	 * @throws RuntimeException если количество элементов ключевого массива не совпадает
	 * 			с количеством элементов коллекции, либо если элементы ключевого массива 
	 * 			не поддерживают сортировку 
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
	 * Возвращает строку, описывающую содержимое коллекции. В ней содержится информация
	 * о типе коллекции, а также список всех элементов.
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
