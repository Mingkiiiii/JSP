package model;

// VO(value object) 데이터 객체 형태로 표현하는 자바 클래스
// VO or DTO(data transfer object)라고함
public class userVO {
	private String userId; // carmel 표기법 _<부분을 대문자로(낙타표기법)
	private String userPw;
	private String userNm;
	private String useYn;
	// setter getter, toString
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public String getUseYn() {
		return useYn;
	}
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
	@Override
	public String toString() {
		return "userVO [userId=" + userId + ", userPw=" + userPw + ", userNm=" + userNm + ", useYn=" + useYn + "]";
	}
	
}
