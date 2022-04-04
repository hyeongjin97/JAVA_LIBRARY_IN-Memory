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
		return "[bookID = " + bookID + ", bookName = " + bookName + ", bookWriter = "
				+ bookWriter + ", 대여일자 = " + rentDate + ", 반납일자 = " + returnDate + "]";
	}

	public UserRecentBook(String userID, String bookID, String bookName, String bookWriter, String rentDate, String returnDate) {
		
		
		this.userID = userID;
		this.bookID = bookID;
		this.bookName = bookName;
		this.bookWriter = bookWriter;
		this.rentDate = rentDate;
		this.returnDate = returnDate;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getBookID() {
		return bookID;
	}

	public void setBookID(String bookID) {
		this.bookID = bookID;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookWriter() {
		return bookWriter;
	}

	public void setBookWriter(String bookWriter) {
		this.bookWriter = bookWriter;
	}

	public String getRentDate() {
		return rentDate;
	}

	public void setRentDate(String rentDate) {
		this.rentDate = rentDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	
}
