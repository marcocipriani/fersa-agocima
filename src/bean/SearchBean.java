package bean;

import controller.SearchController;


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

	public void setSearchkeyword(String keyword) {
		this.searchkeyword = keyword;
	}

	public boolean isChoice() {
		return choice;
	}

	public void setChoice(boolean coiche) {
		this.choice = coiche;
	}

}
