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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserPWD() {
		return userPWD;
	}

	public void setUserPWD(String userPWD) {
		this.userPWD = userPWD;
	}

	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	
	@Override
	public String toString() {
		return "userName=" + userName + ", userID=" + userID + ", userPWD=" + userPWD + ", userPhoneNumber="
				+ userPhoneNumber + "";
	}

	
	
	
	
}