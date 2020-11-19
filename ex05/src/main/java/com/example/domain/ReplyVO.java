package com.example.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReplyVO {
	private int rno;
	private int bno;
	private String reply;
	private String replyer;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/seoul")
	private Date replyDate;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/seoul")
	private Date replyUpdate;
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getReplyer() {
		return replyer;
	}
	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}
	public Date getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}
	public Date getReplyUpdate() {
		return replyUpdate;
	}
	public void setReplyUpdate(Date replyUpdate) {
		this.replyUpdate = replyUpdate;
	}
	@Override
	public String toString() {
		return "ReplyVO [rno=" + rno + ", bno=" + bno + ", reply=" + reply + ", replyer=" + replyer + ", replyDate="
				+ replyDate + ", replyUpdate=" + replyUpdate + "]";
	}
}
