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

	//TODO fondere con validate()
	public boolean checkRole() {
		ActualUsr au = UsrDAO.findByUsername(this.username, this.password, this.loginRole);
    	
    	if(loginRole && (au.getRoles() == 1 || au.getRoles() == 2)){
            au.setActualRole(true);
            System.out.println("@UsrDAO.java - Sei un proprietario tenant");
            return true;
        } else if (!loginRole && (au.getRoles() == 0 || au.getRoles() == 2) ){
            System.out.println("@UsrDAO.java - Sei un inquilino renter");
            return true;
        } else if (!loginRole && (au.getRoles() == 1)) {
            System.out.println("@UsrDAO.java - Hai provato come renter, Non hai i privilegi necessari");
            return false;
        } else if (loginRole && (au.getRoles() == 0)) {
            System.out.println("@UsrDAO.java - Hai provato come tenant, Non hai i privilegi necessari");
            return false;
        }
    	
    	System.out.println("@UsrDAO.java - Altro caso");
        return false;
	}

}
