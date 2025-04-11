package com.alef.taskmanager.model;

public class Task {
	private int id;
	private String title;
	private boolean status = false; // true => complete | false => incomplete

	public Task(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public int getId() {
		return this.id;
	}

	public String getStatus() {
		return this.status ? "Complete" : "Incomplete";
	}

	public void setStatus() {
		this.status = !this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}