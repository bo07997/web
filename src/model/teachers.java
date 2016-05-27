package model;

import java.util.Date;

public class teachers {

	private Integer tid;
	private String tname;
	private String fac;
	private Date ttime;
	private String address;
	public teachers(Integer tid, String tname, String fac, Date ttime,
			String address) {
		//super();
		this.tid = tid;
		this.tname = tname;
		this.fac = fac;
		this.ttime = ttime;
		this.address = address;
	}
	public teachers() {
		
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getFac() {
		return fac;
	}
	public void setFac(String fac) {
		this.fac = fac;
	}
	public Date getTtime() {
		return ttime;
	}
	public void setTtime(Date ttime) {
		this.ttime = ttime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "teachers [tid=" + tid + ", tname=" + tname + ", fac=" + fac
				+ ", ttime=" + ttime + ", address=" + address + "]";
	}
	
	
}
