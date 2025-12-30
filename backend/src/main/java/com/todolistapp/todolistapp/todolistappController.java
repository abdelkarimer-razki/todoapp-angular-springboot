package com.todolistapp.todolistapp;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@CrossOrigin(origins = "https://localhost:4200")
public class todolistappController {
	List<todo> listTodos = new ArrayList<todo>();

	@GetMapping("/api/getTask")
	public List<todo> getTask(){
		return listTodos;
	}

	@PostMapping("/api/addTask")
	public void addTask(@RequestBody todo task)
	{
		listTodos.add(task);
	}

	@PutMapping("/api/updateTask/{id}")
	public void updateTask(@PathVariable String id, @RequestBody todo task)
	{
		for(todo t: listTodos)
		{
			if (id.equals(t.getId()))
			{
				t.setTask(task.getTask());
				t.setDescription(task.getDescription());
				t.setDifficulty(task.getDifficulty());
				break;
			}
		}
	}

	@DeleteMapping("/api/deleteTask/{id}")
	public void deleteTask(@PathVariable String id)
	{
		for(todo t: listTodos)
		{
			if (id.equals(t.getId()))
			{
				listTodos.remove(t);
				break ;
			}
		}
	}
}
