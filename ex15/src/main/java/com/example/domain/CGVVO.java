package com.example.domain;

import java.util.Date;

public class CGVVO {
	private String day;
	private String title;
	private String image;
	private int rank;
	
	@Override
	public String toString() {
		return "CGVVO [day=" + day + ", title=" + title + ", image=" + image + ", rank=" + rank + "]";
	}
	
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
}
