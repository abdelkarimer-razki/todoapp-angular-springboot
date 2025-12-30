package com.todolistapp.todolistapp;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
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

	

}
