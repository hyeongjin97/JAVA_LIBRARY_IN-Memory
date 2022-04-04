package ac.kr.kopo.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BookUtil extends BookInfo {

	Map<String, BookInfo> bookMap = new HashMap<>();
	
	List<UserRecentBook> userRecentList = new ArrayList<>();
	
	Map<String, Object[]> userRecentMap = new HashMap<>();
	
	private Scanner sc = new Scanner(System.in);

	BookInfo bi = null;

	UserRecentBook urb = new UserRecentBook();
	
	
	


	

	public void showBookList(Map<String,BookInfo> map) {
		
		Object[] arr = map.values().toArray();
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public List<UserRecentBook> getUserRecentList() {
		return userRecentList;
	}

	public void setUserRecentList(List<UserRecentBook> userRecentList) {
		this.userRecentList = userRecentList;
	}

	public void rentBook(Map<String,BookInfo> bookMap ,String str, List<UserRecentBook> list) {
		System.out.println("---------- 책 목록 ----------");
		showBookList(bookMap);
		System.out.println("---------------------------");
		System.out.print("대여하고 싶은 책 id 입력하세요 : ");
		String rentID = sc.nextLine();
		if (bookMap.containsKey(rentID) && Integer.parseInt(bookMap.get(rentID).bookQuantity) > 0) {
			System.out.println(bookMap.get(rentID) + "\n해당 정보의 책을 빌리시겠습니까?(Y/N)");
			String confirm = sc.nextLine();
			switch (confirm) {
			case "Y":
				bi = bookMap.get(rentID);
 				urb =  new UserRecentBook(str ,bi.bookID, bi.bookName, bi.writer,"a","b");
				list.add(urb);
			    Object[] arr = list.toArray();
//				for(int i = 0; i < arr.length; i++) {
//					System.out.println(arr[i]);
//				}
				userRecentMap.put(str, arr);		
				
				Integer a = Integer.parseInt(bookMap.get(rentID).bookQuantity)-1;
				bookMap.get(rentID).bookQuantity = a.toString();
				break;
			case "N":
				System.out.println("취소되었습니다.");
				break;
			default:
				System.out.println("Y 또는 N을 입력해주세요.");
			}
		} else if (!bookMap.containsKey(rentID)) {
			System.out.println("입력하신 ID는 존재하지 않습니다.");
		} else {
			System.out.println("입력하신 ID의 책 수량이 없습니다.");
		}
		
		
	}
	
	public void returnBook(List<UserRecentBook> list,String str) {
		System.out.println("-------------------- 현재 대여중인 책 목록-------------------");
		Object[] arr = list.toArray();
	
		for(int i = 0; i < arr.length; i++) {
			if(list.get(i).getUserID().equals(str)) {
				System.out.println(arr[i]);
			}
		}
		System.out.println("--------------------------------------------------------");
		System.out.println("반납하실 책 ID를 입력해주세요:");
		String bookID = sc.nextLine();
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getUserID().equals(str)&&list.get(i).getBookID().equals(bookID)) {
				list.remove(i);
				System.out.println(arr[i]+"가 반납되었습니다.");
			}
		}
	}
	
	
	
	

	public Map<String, Object[]> getUserRecentMap() {
		return userRecentMap;
	}

	public void setUserRecentMap(Map<String, Object[]> userRecentMap) {
		this.userRecentMap = userRecentMap;
	}

	public BookUtil(String bookID, String bookName, String writer, String bookQuantity) {
		super(bookID, bookName, writer, bookQuantity);
		// TODO Auto-generated constructor stub
	}

	public BookUtil() {

	}

}
