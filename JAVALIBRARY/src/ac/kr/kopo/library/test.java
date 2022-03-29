package ac.kr.kopo.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Member m = null;
		List<Member> list = new ArrayList<>();
		Map<String,Member> map = new HashMap<>();
		
		for(int i = 0; i < 2; i++) {
			
			System.out.println("이름 : ");
			String name = sc.nextLine();
			System.out.println("아이디 : ");
			String id = sc.nextLine();
			System.out.println("비밀번호 : ");
			String pwd = sc.nextLine();
			System.out.println("전화번호 : ");
			String num = sc.nextLine();
			
			m = new Member(name,id,pwd,num);
			
			list.add(m);
		}
		
		Object[] arr = list.toArray();
		
		map.put(list.get(0).userID, list.get(0));
		map.put(list.get(1).userID, list.get(1));
		
		System.out.println(map);
		
		
		System.out.println("------------------로그인---------------");
		
		System.out.println("아이디를 입력하세요 : ");
		String loginId = sc.nextLine();
		if(!map.containsKey(loginId)) {
			System.out.println("존재하지 않는 아이디 입니다.");
			System.exit(0);
		}
		System.out.println("비밀번호를 입력하세요 : ");
		String loginPwd = sc.nextLine();
		if(!map.get(loginId).userPWD.equals(loginPwd)) {
			System.out.println("비밀번호가 다릅니다.");
			System.exit(0);
		}
		System.out.println("로그인 성공");
		
		
	}
}
