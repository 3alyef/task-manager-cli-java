package com.alef.taskmanager.core;

import java.util.List;

import com.alef.taskmanager.model.Task;
import com.alef.taskmanager.storage.TaskStorage;

import java.util.ArrayList;

/**
 * The TaskManager class is responsible for managing a list of tasks.
 * It provides methods to:
 * 
 * - Add a new task
 * - List all tasks
 * - Mark a task as completed
 * - Remove a task
 */

public class TaskManager {
	private List<Task> tasks;
	private TaskStorage taskStorage;
	private int nextId = 1;

	public TaskManager() {
		this.taskStorage = new TaskStorage();
		List<Task> tsLoad = this.taskStorage.load();
		if (tsLoad != null) {
			this.tasks = tsLoad;
		} else {
			this.tasks = new ArrayList<Task>();
		}
		this.updateNextId();
	}

	public void addTask(String title) {
		/*
		 * boolean reload = true;
		 * while (reload) {
		 * boolean ok = this.verifyIDTask(this.nextId);
		 * if (ok) {
		 * reload = false;
		 * } else {
		 * this.nextId++;
		 * }
		 * }
		 */
		Task task = new Task(this.nextId);
		this.nextId++;
		task.setTitle(title);
		this.tasks.add(task);
		this.taskStorage.save(this.tasks);
	}

	public void listTasks() {
		for (Task task : this.tasks) {
			System.out.println("Task ID    : " + task.getId());
			System.out.println("Task title : " + task.getTitle());
			System.out.println("Task status: " + task.getStatus());
			System.out.println();
		}
	}

	public boolean completeTask(int id) {
		for (Task task : this.tasks) {
			if (task.getId() == id) {
				task.setStatus(true);
				this.taskStorage.save(this.tasks);
				return true;
			}
		}
		return false;
	}

	public boolean removeTask(int id) {
		// this.tasks.remove(id);
		boolean res = this.tasks.removeIf(task -> task.getId() == id);
		if (res) {
			this.taskStorage.save(this.tasks);
			this.updateNextId();
		}
		return res;
	}

	private void updateNextId() {
		int maxId = 0;
		for (Task task : this.tasks) {
			if (task.getId() > maxId) {
				maxId = task.getId();
			}
		}
		this.nextId = maxId + 1;
	}
}