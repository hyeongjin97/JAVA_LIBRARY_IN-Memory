package ac.kr.kopo.library;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
	
	Calendar cal = Calendar.getInstance();
	Calendar cal2 = Calendar.getInstance();
	Date rentDate = new Date();
	Date returnDate = new Date();
	
	SimpleDateFormat sdf;

	public void showBookList(Map<String, BookInfo> map) {

		Object[] arr = map.values().toArray();
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			System.out.println();
		}
	}

	public List<UserRecentBook> getUserRecentList() {
		return userRecentList;
	}

	public void setUserRecentList(List<UserRecentBook> userRecentList) {
		this.userRecentList = userRecentList;
	}

	public void rentBook(Map<String, BookInfo> bookMap, String str, List<UserRecentBook> list) {
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE));
		cal2.set(cal2.get(Calendar.YEAR), cal2.get(Calendar.MONTH), cal2.get(Calendar.DATE));
		cal2.add(Calendar.DATE, 7);
		rentDate = new Date(cal.getTimeInMillis());
		returnDate = new Date(cal2.getTimeInMillis());
		System.out.println("--------------------------- 책 목록 -----------------------------------------");
		showBookList(bookMap);
		System.out.println("----------------------------------------------------------------------------");
		System.out.print("대여하고 싶은 책 id 입력하세요 : ");
		String rentID = sc.nextLine();
		if (bookMap.containsKey(rentID) && Integer.parseInt(bookMap.get(rentID).bookQuantity) > 0) {
			System.out.println(bookMap.get(rentID) + "\n해당 정보의 책을 빌리시겠습니까?(Y/N)");
			String confirm = sc.nextLine();
			switch (confirm) {
			case "Y":
				bi = bookMap.get(rentID);
				urb = new UserRecentBook(str, bi.bookID, bi.bookName, bi.writer, sdf.format(rentDate), sdf.format(returnDate));
				list.add(urb);
				Object[] arr = list.toArray();
//				for(int i = 0; i < arr.length; i++) {
//					System.out.println(arr[i]);
//				}
				userRecentMap.put(str, arr);

				Integer a = Integer.parseInt(bookMap.get(rentID).bookQuantity) - 1;
				bookMap.get(rentID).bookQuantity = a.toString();
				System.out.println("대여가 완료되었습니다.");
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

	public void returnBook(List<UserRecentBook> list, String str, Map<String, BookInfo> bookMap) {
		System.out.println("----------------------------------------------현재 대여중인 책 목록----------------------------------------------------------------");
		Object[] arr = list.toArray();

		for (int i = 0; i < arr.length; i++) {
			if (list.get(i).getUserID().equals(str)) {
				System.out.println(arr[i]);
			}
		}
		
		if(list.size() == 0) {
			System.out.println("현재 대여중인 책이 없습니다.");
			return;
			
		}
		
		System.out.println("------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("반납하실 책 ID를 입력해주세요:");
		String bookID = sc.nextLine();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getUserID().equals(str) && list.get(i).getBookID().equals(bookID)) {
				System.out.println(arr[i] + "\n해당 정보의 책을 반납하시겠습니까?(Y/N)");
				String confirm = sc.nextLine();
				switch (confirm) {
				case "Y":
					list.remove(i);
					System.out.println(arr[i] + "\n해당 정보의 책이 반납되었습니다.");
					Integer a = Integer.parseInt(bookMap.get(bookID).bookQuantity) + 1;
					bookMap.get(bookID).bookQuantity = a.toString();
					break;
				case "N":
					System.out.println("취소되었습니다.");
					break;
				default:
					System.out.println("Y 또는 N 키를 입력해주세요.");
					break;
				}
			}else {
				System.out.println("대여 목록에 해당 ID 정보를 가진 책이 없습니다.");
			}
		}
	}
	
	public void adminAddBook(Map<String, BookInfo> bookMap, String str, List<UserRecentBook> list) {
		System.out.print("1. 기존에 있는 책 추가하기 2. 새로운 정보의 책 추가하기");
		String num = sc.nextLine();
		switch(num) {
		case "1":
			System.out.println("--------------------------- 책 목록 -----------------------------------------");
			showBookList(bookMap);
			System.out.println("----------------------------------------------------------------------------");
			System.out.print("추가할 책 ID를 입력하세요 : ");
			String addBookID = sc.nextLine();
			if(bookMap.containsKey(addBookID)) {
				System.out.print("추가할 수랑을 입력해주세요 : ");
				String addCount = sc.nextLine();
				System.out.println(bookMap.get(addBookID).toString());
				System.out.println("해당 정보의 책을 "+addCount+"개 추가하시겠습니까 ?(Y/N)");
				String confirm = sc.nextLine();
				switch(confirm) {
				case "Y":
					Integer a = Integer.parseInt(bookMap.get(addBookID).bookQuantity) + Integer.parseInt(addCount);
					bookMap.get(addBookID).bookQuantity = a.toString();
					System.out.println("추가되었습니다.");
					break;
				case "N":
					System.out.println("취소되었습니다.");
					break;
				default:
					System.out.println("Y 또는 N을 입력하세요.");
				
				}
			}else {
				System.out.println("입력하신 ID를 가진 책이 존재하지 않습니다.");
			}
			break;
		case "2":
			System.out.println("--------------------------- 책 목록 -----------------------------------------");
			showBookList(bookMap);
			System.out.println("----------------------------------------------------------------------------");
			System.out.print("추가할 책 ID를 입력하세요 : ");
			addBookID = sc.nextLine();
			if(!bookMap.containsKey(addBookID)) {
				System.out.print("책 이름을 입력해주세요:");
				String bookName = sc.nextLine();
				System.out.print("책 작가를 입력해주세요:");
				String bookWriter = sc.nextLine();
				System.out.print("추가하실 수량을 입력해주세요:");
				String bookCount = sc.nextLine();
				bi = new BookInfo(addBookID,bookName,bookWriter,bookCount);
				bookMap.put(addBookID, bi);
				System.out.println(bookMap.get(addBookID).toString());
				System.out.println("해당 정보의 책이 추가되었습니다.");
			
			}else {
				System.out.println("입력하신 ID를 가진 책이 이미 존재합니다.");
			}
			break;
		default:
			System.out.println("메뉴에 있는 번호를 입력해주세요.");
		}
	}
	
	public void adminUpdateBook(Map<String, BookInfo> bookMap, String str, List<UserRecentBook> list) {
		System.out.println("--------------------------- 책 목록 -----------------------------------------");
		showBookList(bookMap);
		System.out.println("----------------------------------------------------------------------------");
		System.out.print("수정 책 ID를 입력하세요 : ");
		String updateBookID = sc.nextLine();
		if(bookMap.containsKey(updateBookID)) {
			System.out.print("수정할 책 이름을 입력해주세요:");
			String bookName = sc.nextLine();
			System.out.print("수정할 책 작가를 입력해주세요:");
			String bookWriter = sc.nextLine();
			System.out.print("수정할 수량을 입력해주세요:");
			String bookCount = sc.nextLine();
			bi = new BookInfo(updateBookID,bookName,bookWriter,bookCount);
			bookMap.put(updateBookID, bi);
			System.out.println(bookMap.get(updateBookID).toString());
			System.out.println("해당 정보의 책이 수정되었습니다.");
		
		}else {
			System.out.println("입력하신 ID를 가진 책이 존재하지 않습니다.");
		}
	}
	
	public void adminDeleteBook(Map<String, BookInfo> bookMap, String str, List<UserRecentBook> list) {
		System.out.println("--------------------------- 책 목록 -----------------------------------------");
		showBookList(bookMap);
		System.out.println("----------------------------------------------------------------------------");
		System.out.print("삭제할 책 정보의 ID를 입력하세요 : ");
		String deleteBookID = sc.nextLine();
		if(bookMap.containsKey(deleteBookID)) {
			System.out.println(bookMap.get(deleteBookID).toString());
			System.out.println("해당 정보의 책이 삭제되었습니다.");
			bookMap.remove(deleteBookID);
		
		}else {
			System.out.println("입력하신 ID를 가진 책 정보가 존재하지 않습니다.");
		}
	}
	
	public void adminUserInfo(Map<String, Member> userMap,String str) {
		System.out.println("--------------------------- 유저 목록 ------------------------------------");
		Object [] arr = userMap.values().toArray();
		for(Object arr1 : arr) {
			System.out.println(arr1.toString());
		}
		System.out.println("------------------------------------------------------------------------");
		System.out.println("삭제할 사용자 ID를 입력해주세요 : ");
		String deleteUser = sc.nextLine();
		if(userMap.containsKey(deleteUser)) {
			
			System.out.println(userMap.get(deleteUser).toString());
			System.out.println("해당 정보의 사용자를 삭제하겠습니까?(Y/N)");
			String confirm = sc.nextLine();
			switch(confirm) {
			case "Y":
				System.out.println(userMap.get(deleteUser).toString());
				System.out.println("해당 정보의 사용자를 삭제하였습니다.");
				userMap.remove(deleteUser);
				break;
			case "N":
				System.out.println("취소되었습니다.");
				break;
			default:
				System.out.println("메뉴에 있는 번호를 입력해주세요.");
			}
		
		}else {
			System.out.println("입력하신 ID를 가진 사용자가 없습니다.");
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
