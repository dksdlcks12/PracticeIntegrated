package StudentManagement;

public class Main_Screen {
	private int[][] student_Id = new int[10][3];
	private String[] student_Name = new String[10];
	int cont=0;
	public static void main(String[] args) {
		Student st = new Student();
		st.setScore(new Subject("국어", 40, 40, 10, 10), new Subject("영어", 40, 40, 10, 10), new Subject("수학", 40, 40, 10, 10));
		st.prtScort();
	} 
	public class insert {
		public int[][] getStudent_Id() {
			return student_Id;
		}
		public void setStudent_Info(Student s) {
			student_Id[cont][0] = s.getGrade();
			student_Id[cont][1] = s.getGroup();
			student_Id[cont][2] = s.getNum();
			student_Name[cont] = s.getName();
			cont++;
		}
		public void getStudent_Info() {
			
		}
	}
}
