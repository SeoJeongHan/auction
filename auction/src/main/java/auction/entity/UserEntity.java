package auction.entity;

import org.springframework.stereotype.Component;

@Component
public class UserEntity {
	private String id;				// 아이디
	private String password;	// 비밀번호
	private String passwordChk;	// 비밀번호2
	private String name;		// 이름
	private String address;		// 주소
	private String phone;		// 전화번호
	private String email;		// 메일
	private String gender;
	private int point;			// 포인트
	
	public UserEntity(){	}
	public UserEntity(String id, String password, String name, String address, String phone, String email, String gender, int point) {
		this.id = id;
		this.password = password;
		this.address = address;
		this.phone = phone;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.point = point;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordChk() {
		return passwordChk;
	}
	public void setPasswordChk(String passwordChk) {
		this.passwordChk = passwordChk;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
