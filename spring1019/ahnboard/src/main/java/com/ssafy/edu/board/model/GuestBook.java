package com.ssafy.edu.board.model;

public class GuestBook {
	@Override
	public String toString() {
		return "GuestBookDto [articleNo=" + articleNo + ", userId=" + userId + ", userName=" + userName + ", subject="
				+ subject + ", content=" + content + ", regTime=" + regTime + "]";
	}

	private int articleNo;
	private String userId;
	private String userName;
	private String subject;
	private String content;
	private String regTime;	

	public int getArticleNo() {
		return articleNo;
	}

	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegTime() {
		return regTime;
	}

	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}
}
