package bean;

import model.ActualUsr;
import controller.LoginController;

public class LoginBean {
	private String username;
	private String password;
	private Boolean loginRole;

	public LoginBean() {
		this.username = "";
		this.password = "";
		this.loginRole = false;
	}

	public void setUsername(String user) {
		this.username = user;
	}

	public String getUsername() {
		return this.username;
	}

	public void setPassword(String pwd) {
		this.password = pwd;
	}

	public String getPassword() {
		return this.password;
	}

	public Boolean getLoginRole() { return loginRole; }

	public void setLoginRole(Boolean loginRole) { this.loginRole = loginRole; }

	public boolean validate() {
		if (this.username.equals("") || this.password.equals("")) {
			return false;
		}
		LoginController controller = LoginController.getInstance();
		ActualUsr found = controller.login(this.username, this.password, this.loginRole);
		return  (found != null);
	}

}
