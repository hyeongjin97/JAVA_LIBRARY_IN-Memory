package ac.kr.kopo.library;

import java.util.Scanner;

public class LibraryMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Register re = new Register();
		Login lg = new Login();
		while (true) {
			System.out.println("=====회원가입 및 로그인 구현=====");
			System.out.println("1.회원가입 2.로그인 3. 종료");
			String num = sc.nextLine();
			int cnt = 0;
			while (true) {
				switch (num) {
				case "1":
					re.process();
					cnt++;
					break;
				case "2":
					lg.loginStart(re.getMap());
					break;
				case "3":
					System.out.println("========회원 명단========");
					re.printList();
					System.exit(0);

				default:
					System.out.println("메뉴에 있는 번호를 입력하세요!!!");

				}
				break;
			}
		}
	}
}
