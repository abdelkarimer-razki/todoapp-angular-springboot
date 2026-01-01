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
import java.util.Map;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class todolistappController {
	List<todo> listTodos = new ArrayList<todo>();
	Map<String, Integer> data = Map.of(
		"easy", 1,
		"medium", 2,
		"hard", 3
	);

	@GetMapping("/api/getTask")
	public List<todo> getTask(){
		return listTodos;
	}

	@GetMapping("/api/getTask/difficulty/{sort}")
	public List<todo> getTaskifficulty(@PathVariable Boolean sort)
	{
		if (sort)
			listTodos.sort((a,b)-> data.get(a.getDifficulty()) - data.get(b.getDifficulty()));
		else
			listTodos.sort((a,b)-> data.get(b.getDifficulty()) - data.get(a.getDifficulty()));
		return listTodos;
	}

	@GetMapping("/api/getTask/date/{sort}")
	public List<todo> getTaskdate(@PathVariable Boolean sort)
	{
		if (sort)
			listTodos.sort((a,b)-> data.get(a.getDateCreated()) - data.get(b.getDateCreated()));
		else
			listTodos.sort((a,b)-> data.get(b.getDateCreated()) - data.get(a.getDateCreated()));
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
