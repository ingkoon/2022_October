package com.ssafy.board.model;

import java.util.List;

// 컬럼 이름과 DTO이름과 매칭 시키는게 좋다고 한다.
public class GuestBookDto {
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

	/*
	 * public List<FileInfoDto> getFileInfos() { return fileInfos; }
	 * 
	 * public void setFileInfos(List<FileInfoDto> fileInfos) { this.fileInfos =
	 * fileInfos; }
	 */
}
