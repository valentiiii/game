package model;

import java.util.Date;

public class ContactBean {


	private int num;
	private Date date;
	private String name;
	private String address;
	private String content;


	public ContactBean() {}
	public ContactBean(String name,String address,String content) {
		this.name = name;
		this.address = address;
		this.content = content;
	}

	public ContactBean(int num,Date date, String name,String address,String content) {
		this.num = num;
		this.date = date;
		this.name = name;
		this.address = address;
		this.content = content;
	}
	// 自動採番されたNo
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	// 送信日時
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	// 名前
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// アドレス
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	// 問い合わせ内容
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


}
