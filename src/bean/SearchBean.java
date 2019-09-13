package bean;

import controller.LoginController;
import model.Usr;

public class SearchBean {
	private String searchkeyword;
	private boolean choice;

	public SearchBean() {
		this.searchkeyword = "";
		this.choice = false;
	}

	public String getSearchkeyword() {
		return searchkeyword;
	}

	public void setSearchkeyword(String searchkeyword) {
		this.searchkeyword = searchkeyword;
	}

	public boolean isChoice() {
		return choice;
	}

	public void setChoice(boolean coiche) {
		this.choice = coiche;
	}

}
