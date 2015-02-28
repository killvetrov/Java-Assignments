package dz_15_02_27;

import java.util.Arrays;
import java.util.Random;

public class Group {
	// Группа должна иметь инкапсулированные поля: название, комментарий, ФИО куратора, порядковый номер старосты, массив студентов.
	// Методы: получить\задать название, комментарий, ФИО куратора, установить старосту по номеру (в массиве), вывод старосты, 
	// вывод всех студентов, добавить студента, удалить студента, получить студента, лучший студент, худший студент, 
	// получить студента по фамилии, по телефону, по почте.
	
	private String title;
	private String comment;
	private String curatorName;
	private int leaderID;
	private Student[] students = new Student[0];
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;		
	}
	
	public String getCuratorName() {
		return curatorName;
	}
	
	public void setCuratorName(String curatorName) {
		this.curatorName = curatorName;
	}
	
	public void addStudent(Student stud) {		
		students = Arrays.copyOf(students, students.length + 1);
		students[students.length - 1] = stud;
	}
	
	public void removeStudent(Student stud) {
		Student[] studentsMinusOne = new Student[students.length - 1];
		int j = 0;
		for (int i = 0; i < students.length; i++) {
			if (!students[i].equals(stud))
				studentsMinusOne[j++] = students[i];
			else
				continue;
		}	
		students = studentsMinusOne;
	}
	
	public Student getStudentByID(int id) {
		Student result = null;
		for (int i = 0; i < students.length; i++) {
			if (students[i].getID() == id) {
				result = students[i];
				break;
			}	
		}
		return result;
	}
	
	public Student getStudentByLastName(String lastName) {
		Student result = null;
		for (int i = 0; i < students.length; i++) {
			if (students[i].getLastName().equals(lastName)) {
				result = students[i];
				break;
			}	
		}
		return result;
	}
	
	public Student getStudentByEmail(String email) {
		Student result = null;
		for (int i = 0; i < students.length; i++) {
			if (students[i].getEmail().equals(email)) {
				result = students[i];
				break;
			}	
		}
		return result;
	}
	
	public Student getStudentByPhone(String phone) {
		Student result = null;
		for (int i = 0; i < students.length; i++) {
			if (students[i].getPhoneNumber().equals(phone)) {
				result = students[i];
				break;
			}	
		}
		return result;
	}
	
	public int getStudentCount() {
		return students.length;
	}
	
	public int getLeaderID() {
		return leaderID;
	}
	
	public void setLeaderID(int id) {
		leaderID = id;
	}
	
	public void reportLeader() {
		Student leader = getStudentByID(leaderID);
		System.out.println(leader != null ? 
				"Староста группы \"" + title + "\": " + leader.getLastName() + " " + leader.getFirstName() :
					"Староста группы не выбран.");
	}
	
	public void reportStudentList() {
		System.out.printf("В группе \"%s\" учится %d студентов.%n"
				+ "Комментарий: %s%nКуратор: %s%n", 
				getTitle(), getStudentCount(), getComment(), getCuratorName());
		
		Student[] studentsSortedByLastname = Arrays.copyOf(students, students.length);		
		Arrays.sort(studentsSortedByLastname, Student.lastNameComparator);
		for (int i = 0; i < getStudentCount(); i++) {
			System.out.printf("%2d. %s %s%s%n", 
					i + 1, 
					studentsSortedByLastname[i].getLastName(), 
					studentsSortedByLastname[i].getFirstName(),
					studentsSortedByLastname[i].getID() == leaderID ? " [староста]" : "",
					studentsSortedByLastname[i].getID()
					);
		}
	}
	
	public void reportStudentListByAverageMark() {
		System.out.printf("Рейтинг группы \"%s\" по успеваемости.%n", getTitle());
		
		Student[] studentsSortedByAvgMark = Arrays.copyOf(students, students.length);		
		Arrays.sort(studentsSortedByAvgMark, Student.averageMarkComparator);
		for (int i = 0; i < getStudentCount(); i++) {
			System.out.printf("%2d. %s %s%s - %.1f%n", 
					i + 1, 
					studentsSortedByAvgMark[i].getLastName(), 
					studentsSortedByAvgMark[i].getFirstName(),
					studentsSortedByAvgMark[i].getID() == leaderID ? " [староста]" : "",
					studentsSortedByAvgMark[i].getAverageMark()
					);
		}
	}
	
	public Student getBestStudent() {
		if (students.length == 0) return null;
		Student[] studentsSortedByAvgMark = Arrays.copyOf(students, students.length);		
		Arrays.sort(studentsSortedByAvgMark, Student.averageMarkComparator);
		return studentsSortedByAvgMark[0];
	}
	
	public Student getWorstStudent() {
		if (students.length == 0) return null;
		Student[] studentsSortedByAvgMark = Arrays.copyOf(students, students.length);		
		Arrays.sort(studentsSortedByAvgMark, Student.averageMarkComparator);
		return studentsSortedByAvgMark[studentsSortedByAvgMark.length - 1];
	}
	
	public void fillWithRandomData() {
		
		final String[] FIRST_NAMES_M = {
				"Иван",
				"Сергей",
				"Владимир",
				"Константин",
				"Александр",
				"Павел",
				"Роман",
				"Денис",
				"Андрей",
				"Игорь"				
		};
		
		final String[] FIRST_NAMES_F = {
				"Евгения",
				"Елена",
				"Дарья",
				"Александра",
				"Мария",
				"Юлия",
				"Анна",
				"Виктория",
				"Вера",
				"Ольга"				
		};
		
		final String[] LAST_NAMES = {
				"Иванов",
				"Петров",
				"Сидоров",
				"Медведев",
				"Знайкин",
				"Рыбин",
				"Добров",
				"Новоселов",
				"Степанов",
				"Давыдов",
				"Начинкин",
				"Самоделкин",
				"Незнамов",
				"Уточкин",
				"Ленивцев",
				"Зубрилкин",
				"Зубастиков"
		};
		
		final String[] SUBJECT_TITLES = {
				"Физика",
				"История",
				"Математика",
				"Химия",
				"Джава",
				"English"
		};
		
		final int MIN_STUDENTS = 10;
		final int MAX_STUDENTS = LAST_NAMES.length;
		
		boolean usedLastname[] = new boolean[LAST_NAMES.length];
		
		Random rnd = new Random();
		
		setTitle("" + (char) ('К' + rnd.nextInt(8)) + "-" + (char) ('1' + rnd.nextInt(9)) + " " + String.valueOf(2012 + rnd.nextInt(4)));
		
		setComment("набор случайных людей");
		setCuratorName("Владислав Вениаминович Важнецкий");
		
		students = new Student[0];
		int countOfStudents = MIN_STUDENTS + rnd.nextInt(MAX_STUDENTS - MIN_STUDENTS + 1);		
		
		for (int i = 0; i < countOfStudents; i++) {
			int indexLastName = rnd.nextInt(LAST_NAMES.length);
			while (usedLastname[indexLastName]) {
				indexLastName = rnd.nextInt(LAST_NAMES.length);
			}
			usedLastname[indexLastName] = true;
			switch (rnd.nextInt(2)) {
			case 0:
				addStudent(new Student(FIRST_NAMES_M[rnd.nextInt(FIRST_NAMES_M.length)], LAST_NAMES[indexLastName]));
				break;
			case 1:
				addStudent(new Student(FIRST_NAMES_F[rnd.nextInt(FIRST_NAMES_M.length)], LAST_NAMES[indexLastName] + "а"));
				break;
			}
		}
		
		leaderID = 1 + rnd.nextInt(students[students.length - 1].getID());
		
		for (int i = 0; i < countOfStudents; i++) {
			students[i].setAge(rnd.nextBoolean() ? 20 : 21);
			students[i].setEmail("" + (char) ('a' + rnd.nextInt(26)) + (char) ('a' + rnd.nextInt(26)) + (char) ('a' + rnd.nextInt(26)) + "@univer.edu");
			students[i].setPhoneNumber("0" + (char) ('0' + rnd.nextInt(10)) + (char) ('0' + rnd.nextInt(10)) + (char) ('0' + rnd.nextInt(10)));
			students[i].setPracticeStatus(rnd.nextBoolean());
			students[i].setPaymentStatus(rnd.nextBoolean());
			
			int countOfSubjects = 3 + rnd.nextInt(SUBJECT_TITLES.length - 3 + 1); 			
			boolean usedSubjectTitle[] = new boolean[SUBJECT_TITLES.length];
			
			for (int j = 0; j < countOfSubjects; j++) {
				int indexSubjectTitle = rnd.nextInt(SUBJECT_TITLES.length);
				while (usedSubjectTitle[indexSubjectTitle]) {
					indexSubjectTitle = rnd.nextInt(SUBJECT_TITLES.length);
				}
				usedSubjectTitle[indexSubjectTitle] = true;
				students[i].addNewSubject(new Subject(SUBJECT_TITLES[indexSubjectTitle], 
						new Mark(5 + rnd.nextInt(8)), new Mark(5 + rnd.nextInt(8)), new Mark(5 + rnd.nextInt(8)),
						new Mark(5 + rnd.nextInt(8)), new Mark(5 + rnd.nextInt(8)), new Mark(5 + rnd.nextInt(8))));
			}
		}
		
	}

}
