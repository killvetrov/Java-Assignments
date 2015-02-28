package dz_15_02_27;

import java.util.Arrays;

public class Subject {
	// Класс Subject представляет собой предмет, который состоит из названия (String) и массива оценок (Mark). 
	// Так же следует реализовать методы по изменению\чтению названия и работа с оценками (методы: среднее арф., высший балл и т.п. по желанию).
	
	private String title;
	private Mark[] marks;
	
	public Subject(String title, Mark... marks) {
		this.title = title;
		this.marks = new Mark[marks.length];
		for (int i = 0; i < marks.length; i++) {
			this.marks[i] = marks[i];
		}
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getMarkByIndex(int index) {
		return marks[index].getValue();
	}
	
	public void setMarkByIndex(int index, int newValue) {
		marks[index].setValue(newValue);
	}
	
	public int getMarksCount() {
		return marks.length;
	}
	
	public void addNewMark(int value) {
		marks = Arrays.copyOf(marks, marks.length + 1);
		marks[marks.length - 1] = new Mark(value);		
	}
	
	public double averageMark() {
		double result = 0;
		for (int i = 0; i < marks.length; i++)
			result += marks[i].getValue();
		result /= marks.length;
		return result;
	}
	
	public int minMark() {
		int min = 0;
		for (int i = 0; i < marks.length; i++) {
			if (marks[i].getValue() < min) min = marks[i].getValue();
		}
		return min;
	}
	
	public int maxMark() {
		int max = 0;
		for (int i = 0; i < marks.length; i++) {
			if (marks[i].getValue() > max) max = marks[i].getValue();
		}
		return max;
	}	
	
}
