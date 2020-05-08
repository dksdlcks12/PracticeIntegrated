package StudentManagement;

import java.util.Scanner;

public class Main_Screen {
	static Scanner get = new Scanner(System.in);
	static Student arr[] = new Student [10]; 
	static Subject score[];
	public static void main(String[] args) {
		int menu = 0;
		while(menu != 5) {
			prtMenu();
			menu = get.nextInt();
			switch(menu) {
			case 1:
				insertMenu();
				break;
			case 2:
				System.out.print("수정할 칸의 번호를 입력하시오.(1~10) : ");
				int mod = get.nextInt()-1;
				if(arr[mod]!=null) {
					arr[mod].prtStudent();
					System.out.println("위 내용이 수정하실 내용이 맞으면 1번, 아니면 1번을 제외한 아무번호나 입력하십시오. : ");
					int check = get.nextInt();
					if(check==1) {
						Manage.modify(arr, mod);
					}else {
						System.out.println("메인메뉴로 돌아갑니다.");
					}
				}else {
					System.out.println("입력된 값이 없습니다.");
				}
				break;
			case 3:
				System.out.print("삭제할 칸의 번호를 입력하시오.(1~10) : ");
				int sell = get.nextInt()-1;
				if(arr[sell]!=null) {
					arr[sell].prtStudent();
					System.out.println("위 내용이 삭제하실 내용이 맞으면 1번, 아니면 아무번호나 입력하십시오. : ");
					int check = get.nextInt();
					if(check==1) {
						Manage.deleteStudent(arr, sell);
					}else {
						System.out.println("메인메뉴로 돌아갑니다.");
					}
				}else {
					System.out.println("입력된 값이 없습니다.");
				}
				break;
			case 4:
				for(Student tmp : arr) {
					if(tmp!=null) {
						tmp.prtStudent();
						if(tmp.getScore()!=null) {
							tmp.prtScore();
						}
						
					}
				}
				break;
			case 5:
				get.close();
				break;
			default:
				
			}
		}
	}
	public static void prtMenu() {
		System.out.println("학생정보추가 : 1");
		System.out.println("학생정보수정 : 2");
		System.out.println("학생정보삭제 : 3");
		System.out.println("학생정보출력 : 4");
		System.out.println("종료 : 5");
		System.out.print("메뉴를 입력하시오 : ");
	}
	public static void insertPrt(Student instd) {
		System.out.print("학년 입력 : ");
		instd.setGrade(get.nextInt());
		System.out.print(" 반  입력 : ");
		instd.setGroup(get.nextInt());
		System.out.print("번호 입력 : ");
		instd.setNum(get.nextInt());
		System.out.print("이름 입력 : ");
		instd.setName(get.next());
	}
	public static void insertMenu() {
		Student instd = new Student();
		insertPrt(instd);
		while(!Manage.compStd(instd, arr)) {
			System.out.println("중복된 학생정보가 있습니다. 다시 입력하여 주십시오.");
			insertPrt(instd);
		}
		int comp = 1;
		System.out.print("학생의 성적을 입력하시려면 1번을, 아니면 1번을 제외한 아무 번호나 입력하십시오. : ");
		comp = get.nextInt();
		
		if(comp==1) {
			Manage.insertSubject(score, instd);
		}
		Manage.insertStudent(arr, instd);
	}
}
interface Management{
	public int insertStudent(Student []arr, Student instd);
	public void modifyStudent(Student []arr, int modsell);
	public int deleteStudent(Student []arr, int delsell);
	public void printStudent(Student []arr,int count);
}
