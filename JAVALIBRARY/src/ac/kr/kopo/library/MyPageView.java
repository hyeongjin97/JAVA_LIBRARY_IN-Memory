package ac.kr.kopo.library;

import java.util.Scanner;

public class MyPageView extends Member {
	
	private Scanner sc = new Scanner(System.in);
	
	public void mainMyPage() {
		System.out.println("원하시는 메뉴를 선택하세요");
		System.out.println("1.정보 수정 2.현재 대여중인 책");
		String num = sc.nextLine();
		switch(num) {
		case "1":
			break;
		case "2":
			break;
		default :
			System.out.println("메뉴에 있는 번호를 선택하세요!!!");
		
		}
	}
	
	
	
	
	
	
}
