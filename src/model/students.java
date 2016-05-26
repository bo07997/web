package model;

import java.util.Date;

public class students {
	private String sid;
	private String sname;
	private String gender;
	private Date birthday;
	private String address;
	
	
	
	public students() {
		
	}
	
	
	

	public students(String sid, String sname, String gender,
			Date birthday, String address) {
		//super();
		this.sid = sid;
		this.sname = sname;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
	}




	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}






	@Override
	public String toString() {
		return "students [sid=" + sid  + ", sname="
				+ sname + ", gender=" + gender + ", birthday=" + birthday
				+ ", address=" + address + "]";
	}




	
	
	
	
}
