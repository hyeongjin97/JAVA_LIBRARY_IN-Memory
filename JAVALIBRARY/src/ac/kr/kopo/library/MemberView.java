package ac.kr.kopo.library;

import java.util.Scanner;

public class MemberView {
	
	private Scanner sc = new Scanner(System.in);
	
	
	public void mainPage() {
		
		while(true) {
			
			System.out.println("원하는 메뉴를 선택하세요 : ");
			System.out.println("1.책 목록보기 2. 책 대여하기 3. 책 반납하기 4.마이페이지 5. 로그아웃");
			String num = sc.nextLine();
			switch(num) {
			case "1":
				break;
			case "2":
				break;
			case "3":
				break;
			case "4":
				break;
			case "5":
				break;
			default:
				System.out.println("메뉴에 있는 번호를 선택하세요!!!");
			
			}
			
			
		}
	}
}