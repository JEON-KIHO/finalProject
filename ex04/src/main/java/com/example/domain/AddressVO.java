package com.example.domain;

public class AddressVO {
	private int ano;
	private String name;
	private String tel;
	private String address;
	
	@Override
	public String toString() {
		return "AddressVO [ano=" + ano + ", name=" + name + ", tel=" + tel + ", address=" + address + "]";
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
