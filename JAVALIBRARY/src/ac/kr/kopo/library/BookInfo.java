package ac.kr.kopo.library;

public class BookInfo {  // 책 정보를 담고 있는 클래스 
	
	String bookID; 
	String bookName;	
	String writer;
	String bookQuantity;
	
	
	
	public BookInfo() {
		
	}



	public BookInfo(String bookID, String bookName, String writer, String bookQuantity) {

		this.bookID = bookID;
		this.bookName = bookName;
		this.writer = writer;
		this.bookQuantity = bookQuantity;
	}


	
	@Override
	public String toString() {
		return "[책 아이디 = " + bookID + ", 책 이름 = " + bookName + ", 작가 = " + writer + ", 책 잔여 수량 = "
				+ bookQuantity + "]";
	}
	
	
	


}
