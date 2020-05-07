package StudentManagement;

public class Manage {
	private static int cont = 0;
	public static int insertStudent(Student arr[], Student std) {
		arr[cont] = std;
		System.out.println("학생정보가 추가되었습니다.");
		return cont+=1;
	}
	public static void modifyStuent(Student []arr, int num) {
		int mod = 0;
		while(mod!=5) {
			System.out.println("1.학년, 2.반, 3.번호, 4.이름, 5.메인메뉴");
			System.out.print("메뉴를 선택하여 주십시오. : ");
			mod = Main_Screen.get.nextInt();
			if(mod==1) {
				System.out.print("학년 입력 : ");
				arr[num].setGrade(Main_Screen.get.nextInt());
			}else if(mod==2) {
				System.out.print("반 입력 : ");
				arr[num].setGroup(Main_Screen.get.nextInt());
			}else if(mod==3) {
				System.out.print("번호 입력 : ");
				arr[num].setNum(Main_Screen.get.nextInt());
			}else if(mod==4) {
				System.out.print("이름 입력 : ");
				arr[num].setName(Main_Screen.get.next());
			}else if(mod==5){
				System.out.println("메인메뉴로 돌아갑니다.");
			}else {
				System.out.println("메뉴에 없는 번호 입니다. 다시 입력하여 주십시오.");
			}
		}


	}
	public static int deleteStudent(Student []arr, int sell) {
		if(cont!=0) {
			for(;sell<cont;sell++) {
				if(arr[sell+1]!=null) {
					arr[sell]=arr[sell+1];
				}else {
					arr[sell]=null;
				}
			}
			System.out.println("삭제가 완료되었습니다.");
			return cont-=1; 
		}else {
			return cont=0;
		}
	}
	public static int getCont() {
		return cont;
	}
	public static boolean check(Student std, Student arr[]) {
		if(cont!=0) {
		for(int i=0; i<cont; i++) {
				if((arr[i].getGrade()==std.getGrade())&&(arr[i].getGroup()==std.getGroup())&&(arr[i].getNum()==std.getNum())) {
					return false;
				}
			}
		}
		return true;
	}
}
