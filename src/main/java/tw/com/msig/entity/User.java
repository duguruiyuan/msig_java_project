package tw.com.msig.entity;

import java.time.LocalDateTime;

public class User {

	private String username; // 使用者帳號
	private String password; // 使用者密碼
	private LocalDateTime loginTime; // 登入時間

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

	public LocalDateTime getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(LocalDateTime loginTime) {
		this.loginTime = loginTime;
	}
}
