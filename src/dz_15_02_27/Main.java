// 2. Студ. учётка - это программный комплекс по управлению и организации студентов и групп.
// Ваша библиотека должна представлять собой набор из четырех классов: Group, Student, Subject, Mark.
// Класс Mark предназначен для хранение информации о конкретной оценке. 
// Поля класса: long date (дата в utc), int value (значение оценки от 0 до 12).
// Класс Subject представляет собой предмет, который состоит из названия (String) и массива оценок (Mark). 
// Так же следует реализовать методы по изменению\чтению названия и работа с оценками (методы: среднее арф., высший балл и т.п. по желанию).
// Класс Student описывает информацию о конкретном студенте и имеет ряд методов по организации этой информации. 
// Студент имеет: имя, фамилия, телефон, почта, возраст, прошёл ли практику?, оплатил ли за обучение? и массив предметов (Subject). 
// Основная задача класса - инкапсулировать данные студента, реализовать методы для комфортной работы со студентом.
// Методы: геторы и сеторы всех инкапсулированных полей, вывод полной информации, вывод только физических данных о пользователе, 
// вывод только оценок, вывод оценок по названию предмета, вывод списка доступных предметов у пользователя, средний балл, 
// отработка практики, оплата за обучение, лучший предмет, худший предмет.
// Класс Group представляет собой группу студентов и методы по работе с ними. 
// Группа должна иметь инкапсулированные поля: название, комментарий, ФИО куратора, порядковый номер старосты, массив студентов.
// Методы: получить\задать название, комментарий, ФИО куратора, установить старосту по номеру (в массиве), вывод старосты, 
// вывод всех студентов, добавить студента, удалить студента, получить студента, лучший студент, худший студент, 
// получить студента по фамилии, по телефону, по почте.

package dz_15_02_27;

public class Main {

	public static void main(String[] args) {

		Group grp01 = new Group();

		Student myStudent = new Student();
		myStudent.setFirstName("Вовочка");
		myStudent.setLastName("Вундеркинидзе");
		myStudent.setEmail("wunder@univer.edu");
		myStudent.setPhoneNumber("012 345-67-892");
		myStudent.setAge(21);
		myStudent.setPracticeStatus(true);
		myStudent.setPaymentStatus(true);
		myStudent.addNewSubject(new Subject("Физика", new Mark(9),
				new Mark(11), new Mark(10), new Mark(11), new Mark(10)));
		myStudent.addNewSubject(new Subject("Химия", new Mark(8), new Mark(8),
				new Mark(7), new Mark(8), new Mark(9)));
		myStudent.addNewSubject(new Subject("Математика"));
		myStudent.addMarkToSubject("Математика", 9);
		myStudent.addMarkToSubject("Математика", 10);
		myStudent.addNewSubject(new Subject("Джава", new Mark(11),
				new Mark(12), new Mark(11), new Mark(12), new Mark(12),
				new Mark(12)));

		Student myStudent2 = new Student();
		myStudent2.setFirstName("Вовочка");
		myStudent2.setLastName("Вундеркинидзе2");
		myStudent2.setEmail("wunder@univer.edu");
		myStudent2.setPhoneNumber("012 345-67-89");
		myStudent2.setAge(21);
		myStudent2.setPracticeStatus(true);
		myStudent2.setPaymentStatus(true);
		myStudent2.addNewSubject(new Subject("Физика", new Mark(9),
				new Mark(11), new Mark(10), new Mark(11), new Mark(10)));
		myStudent2.addNewSubject(new Subject("Химия", new Mark(8), new Mark(8),
				new Mark(7), new Mark(8), new Mark(9)));
		myStudent2.addNewSubject(new Subject("Математика"));
		myStudent2.addMarkToSubject("Математика", 9);
		myStudent2.addMarkToSubject("Математика", 10);
		myStudent2.addNewSubject(new Subject("Джава", new Mark(11),
				new Mark(12), new Mark(11), new Mark(12), new Mark(12),
				new Mark(12)));

		// myStudent.reportFull();

		grp01.fillWithRandomData();
		grp01.addStudent(myStudent);
		grp01.addStudent(myStudent2);
		
		grp01.setLeaderID(grp01.getStudentByLastName("Вундеркинидзе2").getID());
		grp01.setLeaderID(grp01.getStudentByLastName("Вундеркинидзе").getID());
		
		grp01.reportStudentList();

		

		System.out.println();
		grp01.reportStudentListByAverageMark();

		System.out.println("\nИнформация о лучшем студенте.");
		grp01.getBestStudent().reportPhysical();
		grp01.getBestStudent().reportMarksBySubject("Джава");
		
		System.out.println(myStudent.toString());
	}

}
