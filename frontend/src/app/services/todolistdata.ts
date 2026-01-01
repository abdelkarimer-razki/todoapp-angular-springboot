import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { task } from '../classes/task'

@Injectable({
	providedIn: 'root',
})
export class Todolistdata {
	private apiUrl = "http://localhost:8080/api/"
	constructor(private http:HttpClient){}
	
	getTask(){
		return this.http.get(this.apiUrl + "getTask")
	}
	
	addTask(task:task)
	{
		return this.http.post(this.apiUrl + 'addTask', task)
	}

	deleteTask(id:String)
	{
		return this.http.delete(this.apiUrl + 'deleteTask/' + id)
	}

	updateTask(id:String, task:task)
	{
		return this.http.put(this.apiUrl + "updateTask/" + id, task)
	}
}
