package ac.kr.kopo.library;

public class UserRecentBook {
	
	private String userID;
	private String bookID;
	private String bookName;
	private String bookWriter;
	private String rentDate;
	private String returnDate;
	
	
	public UserRecentBook() {
		
	}
	
	@Override
	public String toString() {
		return "UserRentBook [userID=" + userID + ", bookID=" + bookID + ", bookName=" + bookName + ", bookWriter="
				+ bookWriter + ", 대여일자=" + rentDate + ", 반납일자=" + returnDate + "]";
	}

	public UserRecentBook(String userID, String bookID, String bookName, String bookWriter, String rentDate, String returnDate) {
		
		
		this.userID = userID;
		this.bookID = bookID;
		this.bookName = bookName;
		this.bookWriter = bookWriter;
		this.rentDate = rentDate;
		this.returnDate = returnDate;
	}
	
}
