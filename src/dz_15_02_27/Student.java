package dz_15_02_27;

import java.util.Arrays;

public class Student {
	// Класс Student описывает информацию о конкретном студенте и имеет ряд методов по организации этой информации. 
	// Студент имеет: имя, фамилия, телефон, почта, возраст, прошёл ли практику?, оплатил ли за обучение? и массив предметов (Subject). 
	// Основная задача класса - инкапсулировать данные студента, реализовать методы для комфортной работы со студентом.
	// Методы: геторы и сеторы всех инкапсулированных полей, вывод полной информации, вывод только физических данных о пользователе, 
	// вывод только оценок, вывод оценок по названию предмета, вывод списка доступных предметов у пользователя, средний балл, 
	// отработка практики, оплата за обучение, лучший предмет, худший предмет.
	
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	private byte age;
	private boolean practiceStatus;
	private boolean paymentStatus;
	private Subject[] subjData = new Subject[0];
	
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
	
	public byte getAge() {
		return age;
	}
	
	public void setAge(byte age) {
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
	
	public void report() {
		System.out.printf(
				"Имя: %s%n" +		
				"Фамилия: %s%n" +
				"Телефон: %s%n" +
				"email: %s%n" +
				"Возраст: %d%n" +
				"Статус практики: %s%n" +
				"Статус оплаты: %s%n",
				firstName, lastName, phoneNumber, email, age, 
				practiceStatus ? "пройдена" : "не пройдена",
				paymentStatus ? "оплачено" : "не оплачено");
		
		System.out.println("Предметы:");
		for (int i = 0; i < subjData.length; i++) {
			System.out.printf("\t%s\t", subjData[i].getTitle());
			for (int j = 0; j < subjData[i].getMarksCount(); j++) {
				System.out.printf("%3d|", subjData[i].getMarkByIndex(j));
			}
			System.out.printf("  -> средний балл %.1f%n", subjData[i].averageMark());			
		}
	}

}