package dz_15_02_16;

import java.util.Random;

public class SeriesMain {

	public static void main(String[] args) {
		
		Series mySeries = new Series();
		long countIterations = 0;
		long timeStart, timeWork;
		
		timeStart = System.currentTimeMillis();
		
		do {			
			if (mySeries.countOfGoodElements > 6) {
				System.out.printf("Итерация %,d - последовательность %d из %d%n", 
						countIterations, mySeries.countOfGoodElements, mySeries.data.length);
				//mySeries.print();
			}
			mySeries.fill();
			countIterations++;
//			if (countIterations > 10000000l) {
//				mySeries.fill_ideal();
//			}
		} while (!mySeries.isStrictConsequence());
		
		timeWork = System.currentTimeMillis() - timeStart;
		
		mySeries.print();
		System.out.printf("Итераций: %,d%n", countIterations);
		System.out.printf("Время: %04.1f с%n", (double) timeWork / 1000);

	}

}

class Series {

	int[] data = new int[8];
	Random rnd = new Random();
	int countOfGoodElements = 0;

	boolean isStrictConsequence() {
		boolean bStrict = true;
		countOfGoodElements = 0;
		if (data[0] == 0) {
			countOfGoodElements = 1;
			for (int i = 1; i < data.length; i++) {
				bStrict = bStrict && (data[i - 1] + 1 == data[i]);
				if (!bStrict)
					break;
				else
					countOfGoodElements++;
			}
		} else
			bStrict = false;
		return bStrict;
	}

	void fill() {
		for (int i = 0; i < data.length; i++) {
			data[i] = rnd.nextInt(10);
		}
	}
	
	void fill_ideal() {
		for (int i = 0; i < data.length; i++) {
			data[i] = i;
		}
	}
	
	void print() {
		System.out.print("Последовательность: ");
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}

}
