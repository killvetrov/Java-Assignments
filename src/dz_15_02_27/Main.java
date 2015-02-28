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
		myStudent.setPhoneNumber("012 345-67-89");
		myStudent.setAge(21);
		myStudent.setPracticeStatus(true);
		myStudent.setPaymentStatus(true);
		myStudent.addNewSubject(new Subject("������", new Mark(9), new Mark(11), new Mark(10), new Mark(11), new Mark(10)));
		myStudent.addNewSubject(new Subject("�����", new Mark(8), new Mark(8), new Mark(7), new Mark(8), new Mark(9)));
		myStudent.addNewSubject(new Subject("����������"));
		myStudent.addMarkToSubject("����������", 9);
		myStudent.addMarkToSubject("����������", 10);
		myStudent.addNewSubject(new Subject("�����", new Mark(11), new Mark(12), new Mark(11), new Mark(12), new Mark(12), new Mark(12)));
		
		//myStudent.reportFull();
		
		grp01.fillWithRandomData();
		grp01.addStudent(myStudent);
		grp01.reportStudentList();
		
		System.out.println();
		grp01.reportStudentListByAverageMark();
		
		System.out.println("\n���������� � ������ ��������.");
		grp01.getBestStudent().reportPhysical();
		grp01.getBestStudent().reportMarksBySubject("�����");
	}
	
}
