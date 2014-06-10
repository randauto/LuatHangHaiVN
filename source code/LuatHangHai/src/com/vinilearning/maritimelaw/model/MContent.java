package com.vinilearning.maritimelaw.model;

public class MContent extends MChapter {

	private int parent_id;
	private String content;
	private String title;

	public MContent() {
	}

	public MContent(int id, int parent_id, String title, String content) {
		this.id = id;
		this.parent_id = parent_id;
		this.title = title;
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getParent_id() {
		return parent_id;
	}

	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}

}
