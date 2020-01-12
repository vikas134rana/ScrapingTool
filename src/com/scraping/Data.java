package com.scraping;

public class Data {

	private String info;
	private String address;
	private String phone;
	private String website;
	private String email;

	public Data() {
	}

	public Data(String info, String address, String phone, String website, String email) {
		super();
		this.info = info;
		this.address = address;
		this.phone = phone;
		this.website = website;
		this.setEmail(email);
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Data [info=" + info + ", address=" + address + ", phone=" + phone + ", website=" + website + ", email=" + email + "]";
	}

}
