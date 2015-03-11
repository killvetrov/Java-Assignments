package dz_15_02_11_draw;

import java.util.Random;

public class Draw {

	public static void main(String[] args) {
		
		Random rnd = new Random();
		
		String shape = "circle-";
		
		int size = (10 + rnd.nextInt(16)) * 2 + 1;
		//size = 25;
		
		char arr_ch[][] = new char[size][size];
		
		for (int i = 0; i < arr_ch.length; i++) {
			for (int j = 0; j < arr_ch[i].length; j++) {
				switch (shape) {
				
				case "diamond":
					arr_ch[i][j] = (j >= Math.abs(size / 2 - i)) && (j <= size - 1 - Math.abs(size / 2 - i)) ? '*' : ' ';
					break;
					
				case "diamond-":
					arr_ch[i][j] = (j == Math.abs(size / 2 - i)) || (j == size - 1 - Math.abs(size / 2 - i)) ? '*' : ' ';
					break;
					
				case "circle":
					arr_ch[i][j] = (size*size / 4 >= (i - size / 2)*(i - size / 2) + (j - size / 2)*(j - size / 2)) ? '*' : ' ';
					break;
					
				case "circle-":					
					arr_ch[i][j] = (size*size / 4 >= (i - size / 2)*(i - size / 2) + (j - size / 2)*(j - size / 2))
					               && ((size-3)*(size-3) / 4 <= (i - size / 2)*(i - size / 2) + (j - size / 2)*(j - size / 2)) ? '*' : ' ';
					
					break;
				
				}
				 
			}
		}
		
		for (int i = 0; i < arr_ch.length; i++) {
			for (int j = 0; j < arr_ch[i].length; j++) {
				System.out.print(arr_ch[i][j] + " ");				
			}
			System.out.println();
		}	
	}

}
