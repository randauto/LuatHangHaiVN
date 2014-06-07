package com.vinilearning.maritimelaw.model;

/**
 * Chapter Object.
 * 
 * @author TuanLQ.
 * 
 */
public class MChapter {
	private int id;

	private String content;

	public MChapter() {
	}

	public MChapter(String content) {
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}