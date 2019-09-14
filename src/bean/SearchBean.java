package bean;

public class SearchBean {
	private String searchKeyword;
	private boolean choice;

	public SearchBean() {
		this.searchKeyword = "";
		this.choice = false; // default searching for apt
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

	public void setChoice(boolean choice) {
		this.choice = choice;
	}

}
