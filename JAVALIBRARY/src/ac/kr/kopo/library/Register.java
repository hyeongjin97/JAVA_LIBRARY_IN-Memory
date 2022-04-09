package ac.kr.kopo.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Register extends Member {
	private Scanner sc = new Scanner(System.in);

	Member m = new Member();
	List<Member> list = new ArrayList<>();
	Map<String, Member> map = new HashMap<>();

	public void startRegister() {
		
		System.out.println("====================회원가입을 시작합니다.===================");
		while (true) {
			System.out.print("이름을 입력하세요 : ");
			userName = sc.nextLine();
			if (userName == "") {
				System.out.println("공백은 입력불가입니다.");
			} else {
				break;
			}
		}
		while (true) {

			System.out.print("아이디를 입력하세요 : ");
			userID = sc.nextLine();
			
			if (map.containsKey(userID) || userID.equals("admin")) {
				System.out.println("해당 아이디가 존재합니다");
			} else if (userID == "") {
				System.out.println("공백은 입력불가입니다.");
			} else {
				break;
			}
		}
		while (true) {
			System.out.print("비밀번호를 입력하세요 : ");
			userPWD = sc.nextLine();
			if (userPWD == "") {
				System.out.println("공백은 입력 불가합니다.");
			} else {
				while (true) {
					System.out.print("비밀번호를 다시 한번 입력하세요 : ");
					String userPWD2 = sc.nextLine();
					if (!userPWD.equals(userPWD2)) {
						System.out.println("비밀번호가 일치하지 않습니다.");
					} else {
						break;
					}
				}
				break;
		}
			
		}
		while (true) {
			System.out.print("전화번호를 입력하세요 : ");
			userPhoneNumber = sc.nextLine();
			if (userPhoneNumber == "") {
				System.out.println("공백입력은 불가합니다.");
			} else {
				break;
			}
		}
		
		m = new Member(userName, userID, userPWD, userPhoneNumber);
		list.add(m);
		map.put(userID, m);
		System.out.println("\n회원가입 성공!!");
		System.out.println("가입정보 : " + toString()+"\n");
	}

	public Map<String, Member> getMap() {
		
		return map;

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