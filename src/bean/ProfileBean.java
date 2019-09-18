package bean;

public class ProfileBean {
	private boolean firsTime;
	private String username;
	private String password;
	private Boolean loginRole;
	public ProfileBean() {
		this.firsTime = false;
		this.username = "";
		this.password = "";
		this.loginRole = false;
		System.out.println("creato nel costruttore");
	}
	public boolean isFirsTime() {
		return firsTime;
	}
	public void setFirsTime(boolean firsTime) {
		this.firsTime = firsTime;
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
