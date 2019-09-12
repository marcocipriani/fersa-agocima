package bean;

import controller.LoginController;
import model.Usr;

public class SearchBean {
	private String searchKeyword;
	private boolean choice;

	public SearchBean() {
		this.searchKeyword = "";
		this.choice = false;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public boolean isChoice() {
		return choice;
	}

	public void setChoice(boolean coiche) {
		this.choice = coiche;
	}

}
