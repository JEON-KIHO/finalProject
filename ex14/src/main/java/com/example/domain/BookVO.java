package com.example.domain;

public class BookVO {
	private String isbn;
	private String title;
	private int price;
	private String image;
	@Override
	public String toString() {
		return "BookVO [isbn=" + isbn + ", title=" + title + ", price=" + price + ", image=" + image + "]";
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}
