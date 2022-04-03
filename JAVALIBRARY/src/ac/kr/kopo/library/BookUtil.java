package ac.kr.kopo.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BookUtil extends BookInfo {

	Map<String, BookInfo> bookMap = new HashMap<>();
	
	List<UserRentBook> userRentList = new ArrayList<>();
	
	Map<String, Object[]> userRentMap = new HashMap<>();

	private Scanner sc = new Scanner(System.in);

	BookInfo bi = null;

	UserRentBook urb = new UserRentBook();
	
	
	
	public Map<String,BookInfo> defaultBooks() {

		bookMap.put("1", new BookInfo("1", "자바의 정석", "남궁 성 ", "3"));
		bookMap.put("2", new BookInfo("2", "이것이 자바다", "신용권", "1"));
		bookMap.put("3", new BookInfo("3", "너의 췌장을 먹고 싶어", "스미노 요루", "4"));
		bookMap.put("4", new BookInfo("4", "총 균 쇠", "재레드 다이아몬드", "0"));

		return bookMap;
		
	}
	
	
	public Map<String, BookInfo> getBookMap() {
		return bookMap;
	}

	public void setBookMap(Map<String, BookInfo> bookMap) {
		this.bookMap = bookMap;
	}

	public void showBookList(Map<String,BookInfo> map) {
		
		Object[] arr = map.values().toArray();
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public void rentBook(Map<String,BookInfo> bookMap ,String str) {
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
 				urb =  new UserRentBook(str ,bi.bookID, bi.bookName, bi.writer,"a","b");
				userRentList.add(urb);
				Object[] arr = userRentList.toArray();
				for(int i = 0; i < arr.length; i++) {
					System.out.println(arr[i]);
				}
				userRentMap.put(str, arr);
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

	public BookUtil(String bookID, String bookName, String writer, String bookQuantity) {
		super(bookID, bookName, writer, bookQuantity);
		// TODO Auto-generated constructor stub
	}

	public BookUtil() {

	}

}
