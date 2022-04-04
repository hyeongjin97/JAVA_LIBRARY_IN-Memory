package ac.kr.kopo.library;

import java.util.Map;
import java.util.Scanner;

public class Login extends Register {

	Member admin = new Member("admin","admin","admin","admin");
	
	private Scanner sc = new Scanner(System.in);

	private String loginID;
	private String loginPwd;
	

	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}

	

	public String getLoginID() {
		return loginID;
	}



	public String loginStart(Map<String, Member> map) {
		
		map.put("admin", admin);
		System.out.println();
		System.out.println("========로그인 시작========");
		while (true) {
			System.out.print("아이디를 입력하세요 : ");
			loginID = sc.nextLine();
			if (!map.containsKey(loginID)) {
				System.out.println("등록된 아이디가 없습니다.");
			} else {
				break;
			}

		}
		while (true) {
			System.out.print("비밀번호를 입력하세요 : ");
			loginPwd = sc.nextLine();
			if (!map.get(loginID).userPWD.equals(loginPwd)) {
				System.out.println("비밀번호가 틀렸습니다.");
			} else {
				break;
			}
		}

		System.out.println("로그인 성공!! " + map.get(loginID).userName + "님 반갑습니다!!!");
		
		return map.get(loginID).userID;
	}
	
	

	

	public Login() {
		super();
	}

	public Login(String userName, String userID, String userPWD, String userPhoneNumber) {
		super(userName, userID, userPWD, userPhoneNumber);
	}

	

}
