package com.alef.taskmanager;

import java.util.List;
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
	private List<Task> tasks = new ArrayList<Task>();
	private int nextId = 0;

	public void addTask(String title) {
		Task task = new Task(this.nextId);
		this.nextId++;
		task.setTitle(title);
		this.tasks.add(task);
	}

	public void listTasks() {
		for (Task task : this.tasks) {
			System.out.println("TaskId: " + task.getId());
			System.out.println("Task title: " + task.getTitle());
			System.out.println("Task status: " + task.getStatus());
			System.out.println();
		}
	}

	public void completeTask(int id) {
		for (Task task : this.tasks) {
			if (task.getId() == id) {
				task.setStatus(true);
				break;
			}
		}
	}

	public void removeTask(int id) {
		// this.tasks.remove(id);
		this.tasks.removeIf(task -> task.getId() == id);
	}
}