package ac.kr.kopo.library;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MyPageView extends Login {

	private Scanner sc = new Scanner(System.in);
	private String num;
	private String modifyStr;
	private String modifyStr1;
	private String confirm;

	Member m = null;

	public MyPageView() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void MyPage(Map<String, Member> map, String str, List<UserRecentBook> list) { // 마이페이지 보여주는 메소드
		System.out.println("원하시는 메뉴를 선택하세요");
		System.out.println("1.정보 수정 2.현재 대여중인 책 3.메인 페이지로 가기");
		num = sc.nextLine();
		switch (num) {
		case "1":
			modifyInfoPage(map, str, list);
			break;
		case "2":
			showUserRent(list, str);
			break;
		case "3":
			return;
		default:
			System.out.println("메뉴에 있는 번호를 선택하세요!!!");
			MyPage(map, str, list);

		}
	}

	public void modifyInfoPage(Map<String, Member> map, String str, List<UserRecentBook> list) { // 회원정보 수정 메소드
		System.out.println("회원정보 수정 페이지 입니다.");
		System.out.println("수정하고 싶은 정보를 선택하세요.");
		System.out.println("1. 이름 수정 2. 비밀번호 수정 3. 전화번호 수정 4. 내 정보 보기 5. 메인페이지 이동");
		num = sc.nextLine();
		switch (num) {
		case "1":
			modifyNameUtil(map, str, list);
			break;
		case "2":
			modifyPasswordUtil(map, str, list);
			break;
		case "3":
			modifyPhoneNumberUtil(map, str, list);
			break;
		case "4":
			showUserInfo(map, str, list);
			return;
		case "5":
			return;
		default:
			System.out.println("메뉴에 있는 번호를 선택하세요!!!");
			modifyInfoPage(map, str, list);

		}
	}

	public void modifyNameUtil(Map<String, Member> map, String str, List<UserRecentBook> list) { // 회원 이름 수정 메소드

		System.out.println("현재 이름 :" + map.get(str).userName);
		System.out.print("수정하고 싶은 이름을 입력하세요 : ");
		modifyStr = sc.nextLine();
		while (true) {
			System.out.println("이름을 " + modifyStr + "로 바꾸시겠습니까?(Y/N)");
			confirm = sc.nextLine();
			if (confirm.equals("Y")) {
				m = new Member(modifyStr, map.get(str).userID, map.get(str).userPWD, map.get(str).userPhoneNumber);
				map.put(str, m);
				System.out.println("이름이 " + modifyStr + "로 변경되었습니다.");
				modifyInfoPage(map, str, list);
			} else if (confirm.equals("N")) {
				System.out.println("취소되었습니다.");
				modifyInfoPage(map, str, list);
			} else {
				System.out.println("Y 또는 N을 입력해주세요.");
				modifyNameUtil(map, str, list);

			}
			break;
		}

	}

	public void modifyPasswordUtil(Map<String, Member> map, String str, List<UserRecentBook> list) { // 회원 패스워드 수정 메소드

		System.out.print("수정하고 싶은 비밀번호를 입력하세요 : ");
		modifyStr = sc.nextLine();

		System.out.print("다시한번 비밀번호를 입력하세요 : ");
		modifyStr1 = sc.nextLine();
		while (true) {
			if (modifyStr.equals(modifyStr1)) { // 2번 입력받은 비밀번호가 일치한지 확인
				System.out.println("비밀번호를 바꾸시겠습니까?(Y/N)");
				confirm = sc.nextLine();

				if (confirm.equals("Y")) {
					m = new Member(map.get(str).userName, map.get(str).userID, modifyStr, map.get(str).userPhoneNumber);
					map.put(str, m);
					System.out.println("비밀번호가 변경되었습니다.");
					MyPage(map, str, list);
				} else if (confirm.equals("N")) {
					System.out.println("취소되었습니다.");
					MyPage(map, str, list);
				} else {
					System.out.println("Y 또는 N을 입력해주세요.");
					modifyPasswordUtil(map, str, list);
				}
			} else {
				System.out.println("비밀번호가 일치하지 않습니다.");
				modifyPasswordUtil(map, str, list);
			}
			break;
		}
	}

	public void modifyPhoneNumberUtil(Map<String, Member> map, String str, List<UserRecentBook> list) { // 전화번호 수정 메소드
		System.out.println("현재 전화번호 : " + map.get(str).userPhoneNumber);
		System.out.print("수정하고 싶은 전화번호를 입력하세요 : ");
		modifyStr = sc.nextLine();
		while (true) {
			System.out.println("전화번호를 " + modifyStr + "로 바꾸시겠습니까?(Y/N)");
			confirm = sc.nextLine();
			if (confirm.equals("Y")) {
				m = new Member(map.get(str).userName, map.get(str).userID, map.get(str).userPWD, modifyStr);
				map.put(str, m);
				System.out.println("전화번호가 " + modifyStr + "로 변경되었습니다.");
				modifyInfoPage(map, str, list);
			} else if (confirm.equals("N")) {
				System.out.println("취소되었습니다.");
				modifyInfoPage(map, str, list);
			} else {
				System.out.println("Y 또는 N을 입력해주세요.");
				modifyNameUtil(map, str, list);

			}
			break;
		}
	}

	public void showUserInfo(Map<String, Member> map, String str, List<UserRecentBook> list) { // 유저 리스트를 보여주는 메소드
		System.out.println(
				"-------------------" + map.get(str).userName + "님의 정보 ---------------------------------------");
		System.out.println(map.get(str).toString());
		System.out.println("---------------------------------------------------------------------");
	}

	public void showUserRent(List<UserRecentBook> list, String str) { // 유저가 대여중인 책 목록를 보여주는 메소드

		Object[] arr = list.toArray();
		System.out.println(
				"----------------------------------------------현재 대여중인 책 목록----------------------------------------------------------------");
		for (int i = 0; i < arr.length; i++) {
			if (list.get(i).getUserID().equals(str)) {
				System.out.println(arr[i]);
			}
		}
		System.out.println(
				"------------------------------------------------------------------------------------------------------------------------------");

	}

}
