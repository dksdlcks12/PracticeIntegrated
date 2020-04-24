package performance;

import java.util.Scanner;

import action.Sort;

public class Performance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner getnum = new Scanner(System.in);
		System.out.println("0.종료, 1.정렬, 2. , 3. ");
		System.out.print("확인하고 싶은 목차의 번호를 입력하십시오. : ");
		int menu = getnum.nextInt();
		while(menu<0 || 3<menu) {
			System.out.println("입력하신 번호는 없는 번호 입니다. 다시 입력하여 주십시오.");
			System.out.println("1.정렬, 2. , 3. ");
			System.out.print("확인하고 싶은 목차의 번호를 입력하십시오. : ");
			menu = getnum.nextInt();
		}
		while(menu!=0) {
			if(menu==1) {
				Sort.prtsort();
			}
			System.out.println("0.종료, 1.정렬, 2. , 3. ");
			System.out.print("확인하고 싶은 목차의 번호를 입력하십시오. : ");
			menu = getnum.nextInt();
			if(menu==0) {
				break;
			}
			while(menu<0 || 3<menu) {
				System.out.println("입력하신 번호는 없는 번호 입니다. 다시 입력하여 주십시오.");
				System.out.println("0.종료, 1.정렬, 2. , 3. ");
				System.out.print("확인하고 싶은 목차의 번호를 입력하십시오. : ");
				menu = getnum.nextInt();
			}
		}
		getnum.close();
		System.exit(0);
	}
	

}
