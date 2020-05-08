package StudentManagement;

public class Manage {
	private static int cont = 0;
	public static int insertStudent(Student arr[], Student instd) {
		arr[cont] = instd;
		System.out.println("학생정보가 추가되었습니다.");
		return cont+=1;
	}
	public static void insertSubject(Subject score[], Student instd) {
			System.out.print("입력할 과목이 몇개인지 입력 하십시오 : ");
			int cont = Main_Screen.get.nextInt();
			score = new Subject[cont];
			for(int i=0; i<cont ; i++) {
					System.out.println("과목명, 중간고사, 기말고사, 수행평가, 출석점수 순으로 입력하십시오. : ");
					score[i] = new Subject(Main_Screen.get.next(), Main_Screen.get.nextInt(), Main_Screen.get.nextInt(), Main_Screen.get.nextInt(), Main_Screen.get.nextInt());
					while(!compSbj(score, i)) {
						System.out.println("과목명, 중간고사, 기말고사, 수행평가, 출석점수 순으로 입력하십시오. : ");
						score[i] = new Subject(Main_Screen.get.next(), Main_Screen.get.nextInt(), Main_Screen.get.nextInt(), Main_Screen.get.nextInt(), Main_Screen.get.nextInt());				
				}
			}
			instd.setScore(score);
	}
	public static void modify(Student []arr, int num) {
		int mod = 0;
		while(mod!=5) {
			System.out.println("1.학년, 2.반, 3.번호, 4.이름, 5.성적, 6.메인메뉴");
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
			}else if(mod==5) {
				if(arr[num].getScore()!=null) {
					Subject tmp[] = arr[num].getScore();
					while(true) {
						for(int i=0; i<tmp.length; i++) {
							System.out.printf("%d. %s ", i+1, tmp[i].getTitle());
						}
						System.out.println();
						int sellectsub = 0;
						System.out.printf("수정할 과목의 번호를 입력하십시오. : ");
						sellectsub = Main_Screen.get.nextInt();
						if(0<sellectsub && sellectsub<=tmp.length) {
							while(true) {
								System.out.print("1.과목명, 2.중간고사, 3.기말고사, 4.수행평가, 5.출석점수, 6.종료");
								int modscore = Main_Screen.get.nextInt();
								if(modscore == 1) {
									System.out.print("과목명을 입력하여 주십시오. : ");
									tmp[sellectsub-1].setTitle(Main_Screen.get.next());
								}else if(modscore == 2) {
									System.out.print("중간고사를 입력하여 주십시오. : ");
									tmp[sellectsub-1].setMidterm(Main_Screen.get.nextInt());
								}else if(modscore == 3) {
									System.out.print("기말고사를 입력하여 주십시오. : ");
									tmp[sellectsub-1].setFinals(Main_Screen.get.nextInt());
								}else if(modscore == 4) {
									System.out.print("수행평가를 입력하여 주십시오. : ");
									tmp[sellectsub-1].setPerformance(Main_Screen.get.nextInt());
								}else if(modscore == 5) {
									System.out.print("출력점수를 입력하여 주십시오. : ");
									tmp[sellectsub-1].setAttendance(Main_Screen.get.nextInt());
								}else if(modscore == 6) {
									System.out.print("수정을 완료했습니다.\n");
									break;
								}else {
									System.out.println("입련된 번호에 해당하는 항목이 없습니다. 다시 입력하여 주십시오.");
								}
							}
							break;
						}
						System.out.println("해당 과목이 존재하지 않습니다 다시 선택하여 주십시오.");
					}
					arr[num].setScore(tmp);
				}
			}else if(mod==6){
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
		}
		return cont=0;
	}
	public static int getCont() {
		return cont;
	}
	public static boolean compStd(Student std, Student arr[]) {
		if(cont!=0) {
		for(int i=0; i<cont; i++) {
				if((arr[i].getGrade()==std.getGrade())&&(arr[i].getGroup()==std.getGroup())&&(arr[i].getNum()==std.getNum())) {
					return false;
				}
			}
		}
		return true;
	}
	public static boolean compSbj(Subject score[], int i) {
		for(int j=0; j<i; j++) {
			if(score[j].getTitle().equalsIgnoreCase(score[i].getTitle())){
				System.out.println("입력한 과목입니다. 다른 과목을 입력하여 주십시오.");
				return false;
			}
		}
		return true;
	}
}
