package com.alef.taskmanager.storage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import com.alef.taskmanager.model.Task;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class TaskStorage {
	private String fileJson = "tasks.json";
	private Gson gson = new Gson();

	public void save(List<Task> tasks) {
		try (FileWriter writer = new FileWriter(fileJson)) {
			String tasksJson = this.gson.toJson(tasks);
			writer.append(tasksJson);
		} catch (IOException error) {
			System.out.println("Failed to save tasks: " + error.getMessage());
		}
	}

	public List<Task> load() {
		try (FileReader reader = new FileReader(fileJson)) {
			BufferedReader bufferedReader = new BufferedReader(reader);

			StringBuilder sb = new StringBuilder();
			String line;

			while ((line = bufferedReader.readLine()) != null) {
				sb.append(line);
			}
			String tasksJson = sb.toString();

			Type taskListType = new TypeToken<List<Task>>() {
			}.getType();

			List<Task> tasks = gson.fromJson(tasksJson, taskListType);

			// Versão simplificada:
			// String json = Files.readString(Path.of("tasks.json"));

			return tasks;
		} catch (IOException error) {
			System.out.println("Failed to load tasks: " + error.getMessage());
		}
		return null;
	}
}
