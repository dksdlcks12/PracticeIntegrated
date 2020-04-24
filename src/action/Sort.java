package action;

import java.util.Scanner;

public class Sort {
	private static void bubble(int num) {
		int cont=0;
		int sort[] = new int[num];
		boolean comp;
		
		while(cont<sort.length) {
			int in=0;
			sort[cont]=(int)(Math.random()*num+1);
			while(in<cont) {
				if(sort[cont]==sort[in]) {
					sort[cont]=(int)(Math.random()*num+1);
					break;
				}
				in++;
			}
			if(in==cont) {
				cont++;
			}
		}
		System.out.println("원본");
		for(int prt : sort) {
			System.out.printf("%4d", prt);
		}
		System.out.println();
		System.out.println("배열");
		
		for(int i=0; i<sort.length-1; i++) {
			comp=false;
			for(int j=0; j<sort.length-1-i; j++) {
				if(sort[j]>sort[j+1]) {
					int tmp = sort[j];
					sort[j] = sort[j+1];
					sort[j+1] = tmp;
				}
			}
			for(int j=0; j<sort.length; j++) {
				System.out.printf("%4d", sort[j]);
				if(0<j) {
					if(sort[j-1]>sort[j]) {
						comp = true;
					}
				}
			}
			System.out.println();
			if(!comp) {
				break;
			}
		}
	}
	private static void select(int num) {
		int sort[] = new int[num];
		int cont = 0;
		boolean comp;
		
		while(cont<sort.length) {
			int in = 0;
			sort[cont] = (int)(Math.random()*num+1);
			while(in<cont) {
				if(sort[in]==sort[cont]) {
					break;
				}
				in++;				
			}
			if(in==cont) {
				cont++;
			}
		}
		
		System.out.println("원본");
		for(int prt : sort) {
			System.out.printf("%4d", prt);
		}
		System.out.println();
		System.out.println("배열");
		
	
		for(int i=0; i<sort.length-1; i++) {
			comp = false;
			cont = i;
			for(int j=i; j<sort.length; j++) {
				if(sort[j]<sort[cont]) {
					cont = j;
				}
			}
			int tmp = sort[cont];
			sort[cont] = sort[i];
			sort[i] = tmp;
			for(int j=0; j<sort.length; j++) {
				System.out.printf("%4d", sort[j]);
				if(0<j) {
					if(sort[j-1]>sort[j]) {
						comp = true;
					}
				}
			}
			System.out.println();
			if(!comp) {
				break;
			}
		}
	}
	private static void insert(int num) {
		int cont=0;
		int sort[] = new int[num];
		boolean comp;
		while(cont<sort.length) {
			int in=0;
			sort[cont]=(int)(Math.random()*num+1);
			while(in<cont) {
				if(sort[cont]==sort[in]) {
					sort[cont]=(int)(Math.random()*num+1);
					break;
				}
				in++;
			}
			if(in==cont) {
				cont++;
			}
		}
		
		System.out.println("원본");
		for(int prt : sort) {
			System.out.printf("%4d", prt);
		}
		System.out.println();
		System.out.println("배열");
		
		for(int i=1; i<sort.length; i++) {
			comp = false;
			cont = 0;
			int key = sort[i];
			for(int j=i; 0<j; j--) {
				if(sort[j-1]>key) {
					sort[j]=sort[j-1];
					cont++;
				}else {
					break;
				}
			}
			sort[i-cont]=key;
			for(int j=0; j<sort.length; j++) {
				System.out.printf("%4d", sort[j]);
				if(0<j) {
					if(sort[j-1]>sort[j]) {
						comp = true;
					}
				}
			}
			System.out.println();
			if(!comp) {
				break;
			}
		}
	}
	public static void prtsort() {
		Scanner getnum = new Scanner(System.in);
		System.out.println("0.뒤로가기 1.버블정렬, 2.선택정렬, 3.삽입정렬");
		System.out.print("확인하고 싶은 정렬방법의 번호를 입력하십시오. : ");
		int menu = getnum.nextInt(), size = 0, change = 1;
		while(menu<0 || 3<menu) {
			System.out.println("입력하신 번호는 없는 번호 입니다. 다시 입력하여 주십시오.");
			System.out.println("0.뒤로가기 1.버블정렬, 2.선택정렬, 3.삽입정렬");
			System.out.print("확인하고 싶은 정렬방법의 번호를 입력하십시오. : ");
			menu = getnum.nextInt();
		}
		while(menu!=0) {
			if(change==1) {
				System.out.print("범위 설정을 위해 양수형 정수를 입력하여 주십시오. : ");
				size = getnum.nextInt();
				while(size<=0) {
					System.out.println("0이나 음수형 정수를 입력하셨습니다.");
					System.out.print("범위 설정을 위해 양수형 정수를 입력하여 주십시오. : ");
					size = getnum.nextInt();
					change = 2;
				}
			}
			if(menu==1) {
				bubble(size);
			}else if(menu==2) {
				select(size);
			}else {
				insert(size);
			}
			System.out.println("0.뒤로가기 1.버블정렬, 2.선택정렬, 3.삽입정렬");
			System.out.print("확인하고 싶은 정렬방법의 번호를 입력하십시오. : ");
			menu = getnum.nextInt();
			while(menu<0 || 3<menu) {
				System.out.println("입력하신 번호는 없는 번호 입니다. 다시 입력하여 주십시오.");
				System.out.println("0.뒤로가기 1.버블정렬, 2.선택정렬, 3.삽입정렬");
				System.out.print("확인하고 싶은 정렬방법의 번호를 입력하십시오. : ");
				menu = getnum.nextInt();
			}
			if(menu==0) {
				break;
			}
			System.out.print("범위를 수정하려면 1번, 수정하지 않으려면 2번을 입력하십시오. : ");
			change = getnum.nextInt();
			while(change<1 || 2<change) {
				System.out.println("입력하신 번호는 없는 번호 입니다. 다시 입력하여 주십시오.");
				System.out.print("범위를 수정하려면 1번, 수정하지 않으려면 2번을 입력하십시오. : ");
				change = getnum.nextInt();
			}
		}
	}

}
