package com.company.security.model;

public class AppUser {

	private Long userId;
	private String userName;
	private String encryptedPassword;

	public AppUser(Long userId, String userName, String encryptedPassword) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.encryptedPassword = encryptedPassword;
	}

	public AppUser() {
		super();
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	@Override
	public String toString() {
		return "AppUser [userId=" + userId + ", encryptedPassword=" + encryptedPassword + "]";
	}

}
