package bean;

import model.ActualUsr;
import controller.LoginController;
import dao.UsrDAO;

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

	public boolean checkRole() {
		ActualUsr au = UsrDAO.findByUsernameAndPassword(this.username, this.password, this.loginRole);
    	
    	if(loginRole && (au.getRoles() == 1 || au.getRoles() == 2)){
            au.setActualRole(true);
            return true;
        } else if (!loginRole && (au.getRoles() == 0 || au.getRoles() == 2) ){
            return true;
        } else if (!loginRole && (au.getRoles() == 1)) {
            return false;
        } else if (loginRole && (au.getRoles() == 0)) {
            return false;
        }
        return false;
	}

}
