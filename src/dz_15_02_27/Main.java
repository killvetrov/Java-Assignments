// 2. ����. ������ - ��� ����������� �������� �� ���������� � ����������� ��������� � �����.
// ���� ���������� ������ ������������ ����� ����� �� ������� �������: Group, Student, Subject, Mark.
// ����� Mark ������������ ��� �������� ���������� � ���������� ������. 
// ���� ������: long date (���� � utc), int value (�������� ������ �� 0 �� 12).
// ����� Subject ������������ ����� �������, ������� ������� �� �������� (String) � ������� ������ (Mark). 
// ��� �� ������� ����������� ������ �� ���������\������ �������� � ������ � �������� (������: ������� ���., ������ ���� � �.�. �� �������).
// ����� Student ��������� ���������� � ���������� �������� � ����� ��� ������� �� ����������� ���� ����������. 
// ������� �����: ���, �������, �������, �����, �������, ������ �� ��������?, ������� �� �� ��������? � ������ ��������� (Subject). 
// �������� ������ ������ - ��������������� ������ ��������, ����������� ������ ��� ���������� ������ �� ���������.
// ������: ������ � ������ ���� ����������������� �����, ����� ������ ����������, ����� ������ ���������� ������ � ������������, 
// ����� ������ ������, ����� ������ �� �������� ��������, ����� ������ ��������� ��������� � ������������, ������� ����, 
// ��������� ��������, ������ �� ��������, ������ �������, ������ �������.
// ����� Group ������������ ����� ������ ��������� � ������ �� ������ � ����. 
// ������ ������ ����� ����������������� ����: ��������, �����������, ��� ��������, ���������� ����� ��������, ������ ���������.
// ������: ��������\������ ��������, �����������, ��� ��������, ���������� �������� �� ������ (� �������), ����� ��������, 
// ����� ���� ���������, �������� ��������, ������� ��������, �������� ��������, ������ �������, ������ �������, 
// �������� �������� �� �������, �� ��������, �� �����.

package dz_15_02_27;

public class Main {

	public static void main(String[] args) {

		Group grp01 = new Group();

		Student myStudent = new Student();
		myStudent.setFirstName("�������");
		myStudent.setLastName("�������������");
		myStudent.setEmail("wunder@univer.edu");
		myStudent.setPhoneNumber("012 345-67-892");
		myStudent.setAge(21);
		myStudent.setPracticeStatus(true);
		myStudent.setPaymentStatus(true);
		myStudent.addNewSubject(new Subject("������", new Mark(9),
				new Mark(11), new Mark(10), new Mark(11), new Mark(10)));
		myStudent.addNewSubject(new Subject("�����", new Mark(8), new Mark(8),
				new Mark(7), new Mark(8), new Mark(9)));
		myStudent.addNewSubject(new Subject("����������"));
		myStudent.addMarkToSubject("����������", 9);
		myStudent.addMarkToSubject("����������", 10);
		myStudent.addNewSubject(new Subject("�����", new Mark(11),
				new Mark(12), new Mark(11), new Mark(12), new Mark(12),
				new Mark(12)));

		Student myStudent2 = new Student();
		myStudent2.setFirstName("�������");
		myStudent2.setLastName("�������������2");
		myStudent2.setEmail("wunder@univer.edu");
		myStudent2.setPhoneNumber("012 345-67-89");
		myStudent2.setAge(21);
		myStudent2.setPracticeStatus(true);
		myStudent2.setPaymentStatus(true);
		myStudent2.addNewSubject(new Subject("������", new Mark(9),
				new Mark(11), new Mark(10), new Mark(11), new Mark(10)));
		myStudent2.addNewSubject(new Subject("�����", new Mark(8), new Mark(8),
				new Mark(7), new Mark(8), new Mark(9)));
		myStudent2.addNewSubject(new Subject("����������"));
		myStudent2.addMarkToSubject("����������", 9);
		myStudent2.addMarkToSubject("����������", 10);
		myStudent2.addNewSubject(new Subject("�����", new Mark(11),
				new Mark(12), new Mark(11), new Mark(12), new Mark(12),
				new Mark(12)));

		// myStudent.reportFull();

		grp01.fillWithRandomData();
		grp01.addStudent(myStudent);
		grp01.addStudent(myStudent2);
		
		grp01.setLeaderID(grp01.getStudentByLastName("�������������2").getID());
		grp01.setLeaderID(grp01.getStudentByLastName("�������������").getID());
		
		grp01.reportStudentList();

		

		System.out.println();
		grp01.reportStudentListByAverageMark();

		System.out.println("\n���������� � ������ ��������.");
		grp01.getBestStudent().reportPhysical();
		grp01.getBestStudent().reportMarksBySubject("�����");
		
		System.out.println(myStudent.toString());
	}

}
