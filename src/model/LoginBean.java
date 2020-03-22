package model;

public class LoginBean {
	private String id;
	private String pass;

	public LoginBean() {}
	public LoginBean(String id,String pass) {
		this.id = id;
		this.pass = pass;
	}

	//ログインID
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	//ログインパスワード
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

}