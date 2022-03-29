package ac.kr.kopo.library;

import java.util.Map;
import java.util.Scanner;

public class Login extends Register {
	
	private Scanner sc = new Scanner(System.in);
	
	private String loginID;
	private String loginPwd;
	
	
	public void loginStart(Map<String,Member> map) {
		
		
		System.out.println();
		System.out.println("========로그인 시작========");
		System.out.println("아이디를 입력하세요 : ");
		loginID = sc.nextLine();
		if(!map.containsKey(loginID)) {
			System.out.println("등록된 아이디가 없습니다.");
			return;
		}
		System.out.println("비밀번호를 입력하세요 : ");
		loginPwd = sc.nextLine();
		if(!map.get(loginID).userPWD.equals(loginPwd)) {
			System.out.println("비밀번호가 틀렸습니다.");
			return;
		}
		System.out.println("로그인 성공");
		
	}


	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Login(String userName, String userID, String userPWD, String userPhoneNumber) {
		super(userName, userID, userPWD, userPhoneNumber);
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Login [loginID=" + loginID + ", loginPwd=" + loginPwd + "]";
	}
	
	


	
	
	
}
