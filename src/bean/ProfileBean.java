package bean;

public class ProfileBean {
	private boolean firstTime;
	private String username;
	private String password;
	private Boolean loginRole;
	
	public ProfileBean() {
		
		this.firstTime = true;
		this.username = "";
		this.password = "";
		this.loginRole = false;

	}
	public boolean isFirsTime() {
		return firstTime;
	}
	public void setFirsTime(boolean firsTime) {
		this.firstTime = firsTime;
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
	public Boolean getLoginRole() {
		return loginRole;
	}
	public void setLoginRole(Boolean loginRole) {
		this.loginRole = loginRole;
	}
	
	
}

