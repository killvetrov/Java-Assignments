package cw_15_04_01_collections;

import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		ArrayList myarrlist = new ArrayList<String>();
		
		myarrlist.add("A");
		myarrlist.add("B");
		myarrlist.add("C");
		
		for (int i = 0; i < myarrlist.size(); i++) {
			System.out.println(myarrlist.get(i));
		}
		
//		myarrlist.add(1, "b");
//		myarrlist.clear();
//		myarrlist.get(1);
//		myarrlist.remove(1);
//		myarrlist.remove("A");
//		myarrlist.size();
//		// myarrlist.addAll(c);
		
	}

}
