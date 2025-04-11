package com.alef.taskmanager;

import java.util.Scanner;

public class TaskApp {
	private Scanner sc;
	private TaskManager tasks;

	public TaskApp() {
		this.sc = new Scanner(System.in);
		this.tasks = new TaskManager();
	}

	public void main() {
		boolean run = true;
		while (run) {
			System.out.println("------------------------------");

			System.out.println("Welcome to your taskmanager!");
			System.out.println("Choose an option:");
			System.out.println("(1). Create new task.");
			System.out.println("(2). List all tasks.");
			System.out.println("(3). Complete a task.");
			System.out.println("(4). Delete a task.");
			System.out.println("(5). Close the program.");

			System.out.print("Enter your choise here: ");
			int choise = this.sc.nextInt();

			switch (choise) {
				case 1:
					this.createTaskInput();
					break;
				case 2:
					this.listTasksInput();
					break;
				case 3:
					this.completeTaskInput();
					break;
				case 4:
					this.deleteTaskInput();
					break;
				case 5:
					System.out.println("Bye!");
					run = false;
					break;
				default:
					System.out.println("Invalid option");
					break;
			}
		}
	}

	public void createTaskInput() {
		this.sc.nextLine(); // consume the leftover newline
		System.out.print("Enter your task title: ");
		String title = this.sc.nextLine();
		this.tasks.addTask(title);
		System.out.println("Complete!");
	}

	public void listTasksInput() {
		System.out.println("Task List: \n");
		this.tasks.listTasks();
		System.out.println("Complete!");
	}

	public void completeTaskInput() {
		System.out.print("Enter your task ID: ");
		int id = this.sc.nextInt();
		boolean result = this.tasks.completeTask(id);
		if (result) {
			System.out.println("Complete!");
			return;
		}
		System.out.println("Error!");
	}

	public void deleteTaskInput() {
		System.out.println("Enter your task ID: ");
		int id = this.sc.nextInt();
		boolean result = this.tasks.removeTask(id);
		if (result) {
			System.out.println("Complete!");
			return;
		}
		System.out.println("Error!");
	}
}
