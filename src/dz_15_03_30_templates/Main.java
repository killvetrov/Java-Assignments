package dz_15_03_30_templates;

import my.pakage.test.*;

public class Main {

	public static void main(String[] args) {
		Integer[] iArray = { 1, 2, 3, 5, 66 };
		MyCollection<Integer> myc1 = new MyCollection<Integer>(new Integer[] { 1, 2, 3, 4, 4, 4, 4, 5, 1, 2, 3, 3, 4, 7 });
		MyCollection<Integer> myc2 = new MyCollection<Integer>(new Integer[] { 0, 0, 7, 1, 1 ,9, 9, 1 ,1 });
		MyCollection<Double> myc3 = new MyCollection<Double>(new Double[] { 0.1, 0.2, 7.3, 1.5, 1.4 ,9.2, 9.2, 1.1 ,1.1 });
		
		MyCollection<Human> myc4 = new MyCollection<Human>();
		
		
		//myc4.addCollection(myc1);
		
		Human[] mobs = new Human[8];
		
		mobs[0] = new NormalPlayer("Malvina", 5, 1, 10, 100);
		mobs[1] = new NormalPlayer("Piero", 5, 1, 10, 100);
		mobs[2] = new DonatePlayer("Artemon", 15, 1, 10, 100);
		mobs[3] = new DonatePlayer("Buratino", 15, 1, 10, 100);
		mobs[4] = new MediumEnemy("Alisa", 12, 1, 10, 100);
		mobs[5] = new MediumEnemy("Basilio", 12, 1, 10, 100);
		mobs[6] = new HardEnemy("Karabas Barabas", 20, 1, 10, 100);
		mobs[7] = new HardEnemy("Duremar", 20, 1, 10, 100);
		
		MyCollection<String> mykey = new MyCollection<String>(new String[] { "g", "h", "b", "d", "a", "c", "f", "e" });
		
		myc4.addArray(mobs);
		myc4.sortByKey(mykey.getAsArray());
		myc4.remove(mobs[3]);
		//myc4.sort();
		
		System.out.println(myc1.remove((Integer) 6));
		myc1.remove((Integer) 7);
		myc1.addArray(iArray);
		myc1.addCollection(myc2);

		System.out.println(myc1.toString());
		myc3.remove(9.2);
		System.out.println(myc3.toString());
		myc3.sort();
		System.out.println(myc3.toString());
		
		try {
			myc1.get(4);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Был указан индекс за пределами массива");
		}
		
		System.out.println(myc4.toString());

	}

}
