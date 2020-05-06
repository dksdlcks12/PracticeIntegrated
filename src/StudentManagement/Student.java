package StudentManagement;

public class Student {
	private String name="";
	private int grade;
	private int group;
	private int num;
	private Subject score[];
	
	public boolean equal(int grade, int group, int num, String name) {
		if(this.grade!=grade) {
			return false;
		}
		if(this.group!=group) {
			return false;
		}
		if(this.num!=num) {
			return false;
		}
		if(!this.name.equals(name)) {
			return false;
		}
		return true;
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
	public void prtScort() {
		for(Subject tmp : score) {
			tmp.print();
		}
	}
	
}
