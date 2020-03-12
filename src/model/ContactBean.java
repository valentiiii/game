package model;

public class ContactBean {
	private String name;
	private String address;
	private String content;


	public ContactBean() {}
	public ContactBean(String name,String address,String content) {
		this.name = name;
		this.address = address;
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


}
