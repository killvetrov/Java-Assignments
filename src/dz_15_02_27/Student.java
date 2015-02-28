package dz_15_02_27;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class Student {
	// ����� Student ��������� ���������� � ���������� �������� � ����� ��� ������� �� ����������� ���� ����������. 
	// ������� �����: ���, �������, �������, �����, �������, ������ �� ��������?, ������� �� �� ��������? � ������ ��������� (Subject). 
	// �������� ������ ������ - ��������������� ������ ��������, ����������� ������ ��� ���������� ������ �� ���������.
	// ������: ������ � ������ ���� ����������������� �����, ����� ������ ����������, ����� ������ ���������� ������ � ������������, 
	// ����� ������ ������, ����� ������ �� �������� ��������, ����� ������ ��������� ��������� � ������������, ������� ����, 
	// ��������� ��������, ������ �� ��������, ������ �������, ������ �������.
	
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	private int age;
	private boolean practiceStatus;
	private boolean paymentStatus;
	private Subject[] subjData = new Subject[0];
	private int id;
	
	private static int lastID = 0;
	
	public static Comparator<Student> lastNameComparator = new Comparator<Student>() {
		public int compare(Student stud1, Student stud2) {
			return stud1.getLastName().concat(stud1.getFirstName()).compareTo(stud2.getLastName().concat(stud2.getFirstName()));
		}
	};
	
	public static Comparator<Student> averageMarkComparator = new Comparator<Student>() {
		public int compare(Student stud1, Student stud2) {
			double result = stud1.getAverageMark() - stud2.getAverageMark();  
			return result == 0 ? 0 : result > 0 ? -1 : 1; 
		}
	};
	
	public Student() { 
		setID(++lastID);
	}
	
	public Student(String firstName, String lastName) {
		setFirstName(firstName);
		setLastName(lastName);
		setID(++lastID);
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public boolean hasPassedPractice() {
		return practiceStatus;
	}
	
	public void setPracticeStatus(boolean practiceStatus) {
		this.practiceStatus = practiceStatus;
	}
	
	public boolean hasPaid() {
		return paymentStatus;
	}
	
	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus; 
	}
	
	public void addNewSubject(Subject subj) {
		subjData = Arrays.copyOf(subjData, subjData.length + 1);
		subjData[subjData.length - 1] = subj;
	}
	
	public void addMarkToSubject(String subjectTitle, int markValue) {
		int indexOfSubject = -1;
		for (int i = 0; i < subjData.length; i++) {
			if (subjData[i].getTitle().equals(subjectTitle)) {
				indexOfSubject = i;
				break;
			}
		}
		
		if (indexOfSubject != -1)
			subjData[indexOfSubject].addNewMark(markValue);
	}
	
	public int getSubjectsCount() {
		return subjData.length;
	}
	
	public double getAverageMark() {
		double result = 0;
		for (int i = 0; i < subjData.length; i++)
			result += subjData[i].averageMark();
		result /= subjData.length;
		return result;
	}
	
	public String getBestSubjectTitle() {
		if (getSubjectsCount() == 0) return "";
		
		int maxAvgMarkIndex = 0;		
		for (int i = 1; i < subjData.length; i++) {
			if (subjData[i].averageMark() > subjData[maxAvgMarkIndex].averageMark()) {
				maxAvgMarkIndex = i;
			}
		}
		
		return subjData[maxAvgMarkIndex].getTitle();
	}
	
	public String getWorstSubjectTitle() {
		if (getSubjectsCount() == 0) return "";
		
		int minAvgMarkIndex = 0;		
		for (int i = 1; i < subjData.length; i++) {
			if (subjData[i].averageMark() < subjData[minAvgMarkIndex].averageMark()) {
				minAvgMarkIndex = i;
			}
		}
		
		return subjData[minAvgMarkIndex].getTitle();
	}
	
	public int getID() {
		return id;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public void reportFull() {
		System.out.printf(
				"���: %s%n" +		
				"�������: %s%n" +
				"�������: %s%n" +
				"email: %s%n" +
				"�������: %d%n" +
				"������ ��������: %s%n" +
				"������ ������: %s%n",
				firstName, lastName, phoneNumber, email, age, 
				practiceStatus ? "��������" : "�� ��������",
				paymentStatus ? "��������" : "�� ��������");
		
		System.out.println("��������:");
		for (int i = 0; i < subjData.length; i++) {
			System.out.printf("  %d. %s (������� ���� %.1f)%n     |", i + 1, subjData[i].getTitle(), subjData[i].averageMark());
			for (int j = 0; j < subjData[i].getMarksCount(); j++) {
				System.out.printf("%2d|", subjData[i].getMarkByIndex(j).getValue());
			}
			System.out.println();			
		}
		
		System.out.printf("����� ������� ����: %.1f%n", getAverageMark());
		System.out.printf("������ �������: %s%n", getBestSubjectTitle());
		System.out.printf("������ �������: %s%n", getWorstSubjectTitle());
		
	}
	
	public void reportPhysical() {
		System.out.printf(
				"���: %s%n" +		
				"�������: %s%n" +				
				"�������: %d%n",				
				firstName, lastName, age);
	}
	
	public void reportSubjects() {
		for (int i = 0; i < subjData.length; i++)
			System.out.println(subjData[i].getTitle());
	}
	
	public void reportMarks() {
		DateFormat df = new SimpleDateFormat("dd.MM.yyyy");		
		
		for (int i = 0; i < subjData.length; i++) {
			System.out.println(subjData[i].getTitle() + " - ������:");
			for (int j = 0; j < subjData[i].getMarksCount(); j++) {
				Date markDate = new Date(subjData[i].getMarkByIndex(j).getDate());
				System.out.print("\t" + df.format(markDate));
				System.out.println(" - " + subjData[i].getMarkByIndex(j).getValue());
			}
		}
	}
	
	public void reportMarksBySubject(String subjectTitle) {
		DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
		
		for (int i = 0; i < subjData.length; i++) {
			if (subjData[i].getTitle() == subjectTitle) {
				System.out.println(subjData[i].getTitle() + " - ������:");
				for (int j = 0; j < subjData[i].getMarksCount(); j++) {
					Date markDate = new Date(subjData[i].getMarkByIndex(j).getDate());
					System.out.print("\t" + df.format(markDate));
					System.out.println(" - " + subjData[i].getMarkByIndex(j).getValue());
				}
				break;
			}
		}
	}

}