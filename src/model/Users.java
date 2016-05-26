package model;
/*
 * ”√ªß¿‡
 */
public class Users {

	private String uid;
	private String username;
	private String password;
	private String sid;
	private String tag;
	
	public Users(String uid, String username, String password, String sid,
			String tag) {
		//super();
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.sid = sid;
		this.tag = tag;
	}
	public Users() {
		// TODO Auto-generated constructor stub
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	@Override
	public String toString() {
		return "Users [uid=" + uid + ", username=" + username + ", password="
				+ password + ", sid=" + sid + ", tag=" + tag + "]";
	}
	
	
}
