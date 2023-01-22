package model;

import java.util.Date;

public class ActivityEntry {

	
	private Integer id;
	private String ip;
	private Date lastLogin;
	private Integer userId;
	
	public ActivityEntry() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "ActivityEntry [id=" + id + ", ip=" + ip + ", lastLogin=" + lastLogin + ", userId=" + userId + "]";
	}
	
	

	
	
}
