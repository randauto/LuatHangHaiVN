package com.vinilearning.maritimelaw.model;

/**
 * Chapter Object.
 * 
 * @author TuanLQ.
 * 
 */
public class MChapter {
	protected int id;

	public void setId(int id) {
		this.id = id;
	}

	private String content;

	public MChapter() {
	}

	public MChapter(int id, String content) {
		this.content = content;
		this.id = id;
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
