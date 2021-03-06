package ac.kr.kopo.library;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LibraryMain {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Register re = new Register();
		Login lg = new Login();
		UserView uv = new UserView();
		BookUtil bu = new BookUtil();

		Map<String, BookInfo> bookMap = new HashMap<>();
		bookMap.put("1", new BookInfo("1", "자바의 정석", "남궁 성 ", "3"));
		bookMap.put("2", new BookInfo("2", "이것이 자바다", "신용권", "1"));
		bookMap.put("3", new BookInfo("3", "너의 췌장을 먹고 싶어", "스미노 요루", "4"));
		bookMap.put("4", new BookInfo("4", "총 균 쇠", "재레드 다이아몬드", "0"));     // 기본 도서 정보 입력
		
		while (true) {
			System.out.println("===============코포 도서관에 오신걸 환영합니다.===============\n");
			System.out.println("1.회원가입 2.로그인 3. 종료 (관리자 아이디 : admin, 비밀번호 : admin)");
			String num = sc.nextLine();
			while (true) {
				switch (num) {
				case "1":
					re.process(); // 회원가입 시작 
					break;
				case "2":
					lg.loginStart(re.getMap()); // 로그인 시작 
					uv.mainPage(re.getMap(),lg.getLoginID(),bookMap,bu.getUserRecentList()); // mainPage(회원정보 맵, 로그인한 아이디, 유저가 대여중인 책 리스트)
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
