package ac.kr.kopo.library;

public class Member {
	String userName;
	String userID;
	String userPWD;
	String userPhoneNumber;
	
	public Member() {
		super();
	}

	public Member(String userName, String userID, String userPWD, String userPhoneNumber) {
		super();
		this.userName = userName;
		this.userID = userID;
		this.userPWD = userPWD;
		this.userPhoneNumber = userPhoneNumber;
	}

	
	
	@Override
	public String toString() {
		return "userName=" + userName + ", userID=" + userID + ", userPWD=" + userPWD + ", userPhoneNumber="
				+ userPhoneNumber + "";
	}

	
	
	
	
}