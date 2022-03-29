package ac.kr.kopo.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Register extends Member {
	private Scanner sc = new Scanner(System.in);

	Member m = null;

	List<Member> list = new ArrayList<>();
	Map<String, Member> map = new HashMap<>();

	public void startRegister() {

		System.out.println("------회원가입을 시작합니다--------");
		System.out.println("이름을 입력하세요 : ");
		userName = sc.nextLine();
		System.out.println("아이디를 입력하세요 : ");
		userID = sc.nextLine();
		System.out.println("비밀번호를 입력하세요 : ");
		userPWD = sc.nextLine();
		System.out.println("전화번호를 입력하세요 : ");
		userPhoneNumber = sc.nextLine();
		m = new Member(userName, userID, userPWD, userPhoneNumber);
		list.add(m);
		map.put(userID, m);

	}

	public Map<String, Member> getMap() {
		return map;

	}

	public void printList() {
		Object[] arr = list.toArray();
		for (Object ar : arr) {
			System.out.println(ar);
		}
	}

	public void process() {
		startRegister();
	}

	public Register() {
		super();
	}

	public Register(String userName, String userID, String userPWD, String userPhoneNumber) {
		super(userName, userID, userPWD, userPhoneNumber);
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
