package ac.kr.kopo.library;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserView {

	Scanner sc = new Scanner(System.in);
	MyPageView mp = new MyPageView();
	BookUtil bu = new BookUtil();

	public void mainPage(Map<String, Member> map, String str, Map<String, BookInfo> map1, List<UserRecentBook> list) {
		if (map.get(str).userID.equals("admin")) {
			while (true) {
				System.out.println("\n===============================메인 페이지===============================");
				System.out.println("원하는 메뉴를 선택하세요.");
				System.out.println("1.책 목록보기 2. 책 추가하기 3. 책 삭제하기 4. 책 정보 수정하기 5. 사용자 관리 6. 로그아웃");
				String num = sc.nextLine();
				switch (num) {
				case "1":
					bu.showBookList(map1);
					break;
				case "2":
					bu.adminAddBook(map1, str, list);
					break;
				case "3":
					bu.adminDeleteBook(map1, str, list);
					break;
				case "4":
					bu.adminUpdateBook(map1, str, list);
					break;
				case "5":
					bu.adminUserInfo(map, str);
					break;
				case "6":
					return;
				default:
					System.out.println("메뉴에 있는 번호를 선택하세요!!!");
				}

			}
		} else {
			while (true) {
				System.out.println("\n===============================메인 페이지===============================");
				System.out.println("원하는 메뉴를 선택하세요");
				System.out.println("1.책 목록보기 2. 책 대여하기 3. 책 반납하기 4.마이페이지 5. 로그아웃");
				String num = sc.nextLine();
				switch (num) {
				case "1":
					bu.showBookList(map1);
					break;
				case "2":
					bu.rentBook(map1, str, list);
					break;
				case "3":
					bu.returnBook(list, str, map1);
					break;
				case "4":
					mp.MyPage(map, str, list);
					break;
				case "5":
					return;
				default:
					System.out.println("\n메뉴에 있는 번호를 선택하세요!!!");

				}

			}

		}
	}
}
