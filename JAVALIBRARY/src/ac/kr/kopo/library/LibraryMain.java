package ac.kr.kopo.library;

import java.util.Scanner;

public class LibraryMain {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Register re = new Register();
		Login lg = new Login();
		UserView uv = new UserView();
		BookUtil bu = new BookUtil();
		
		while (true) {
			System.out.println("=====회원가입 및 로그인 구현=====");
			System.out.println("1.회원가입 2.로그인 3. 종료");
			String num = sc.nextLine();
			while (true) {
				switch (num) {
				case "1":
					re.process();
					break;
				case "2":
					lg.loginStart(re.getMap());
					uv.mainPage(re.getMap(),lg.getLoginID(),bu.defaultBooks());
					break;
				case "3":
					System.exit(0);

				default:
					System.out.println("메뉴에 있는 번호를 입력하세요!!!");

				}
				break;
			}
		}
	}
}
