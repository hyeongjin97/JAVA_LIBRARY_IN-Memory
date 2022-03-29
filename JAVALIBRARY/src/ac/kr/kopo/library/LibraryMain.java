package ac.kr.kopo.library;

import java.util.Scanner;

public class LibraryMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Register re = new Register();
		Login lg = new Login();
		System.out.println("=====회원가입 및 로그인 구현=====");
		int cnt = 0;
		while(true) {
			System.out.println("1.회원가입 2.로그인 3. 종료");
			int num = sc.nextInt();
			if(num == 3) {
				System.out.println("========회원 명단========");
				re.printList();
				return;
			}else if(num == 1) {				
				re.process();
				cnt++;
			}else if(num == 2) {
				lg.loginStart(re.getMap());
			}
		}
	
	
	}
}
