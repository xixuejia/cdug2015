package com.ibm.cdug2015.panel.domain;

import java.util.Date;

public class Comment {
	private String userName;
	private String content;
	private Date date;
	private boolean isQuestion;

	public Comment() {
		this.date = new Date();
	}

	public Comment(String userName, String content) {
		this.userName = userName;
		this.content = content;
		this.date = new Date();
		this.isQuestion = false;
	}

	public String getuserName() {
		return userName;
	}

	public void setuserName(String userName) {
		this.userName = userName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isQuestion() {
		return isQuestion;
	}

	public void setQuestion(boolean isQuestion) {
		this.isQuestion = isQuestion;
	}

	@Override
	public String toString() {
		return "Comment [userName=" + userName + ",content=" + content
				+ ",date=" + date + ",isQuestion=" + isQuestion + "]";
	}
}
