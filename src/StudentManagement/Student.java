package StudentManagement;

public class Student {
	private int grade;
	private int group;
	private int num;
	private String name="";
	private Subject score[];
	
	public Student(Student student) {
		grade = student.grade;
		group = student.group;
		num = student.num;
		name = student.name;
		score = student.score;
	}
	public void prtStudent() {
		System.out.printf("%2d학년, %d반, %d번 이름 : %s\n", grade, group, num, name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getGroup() {
		return group;
	}
	public void setGroup(int group) {
		this.group = group;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Subject[] getScore() {
		return score;
	}
	public void setScore(Subject... score) {
		this.score = new Subject[score.length];
		for(int i=0; i<score.length; i++) {
			this.score[i] = new Subject(score[i]);
		}
	}
	public void prtScore() {
		for(Subject tmp : score) {
			tmp.print();
		}
	}
	public Student() {
		
	}
	public Student(int grade, int group, int num, String name) {
		this.grade = grade;
		this.group = group;
		this.num = num;
		this.name = name;
	}
	
}
