package bean;

public class ViewBean {
	private int id;

	public ViewBean() {
		this.id = 0; // default value
	}

	public int getId() { return id; }

	public void setId(int id) { this.id = id; }

	public boolean view() {
		if (this.id == 0) { return false; }
		return true;
	}
}
