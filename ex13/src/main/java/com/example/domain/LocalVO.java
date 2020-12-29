package com.example.domain;

public class LocalVO {
	private int id;
	private String placeName;
	private String addressName;
	private String phone;
	private double x;
	private double y;
	@Override
	public String toString() {
		return "LocalVO [id=" + id + ", placeName=" + placeName + ", addressName=" + addressName + ", phone=" + phone
				+ ", x=" + x + ", y=" + y + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public String getAddressName() {
		return addressName;
	}
	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
}
