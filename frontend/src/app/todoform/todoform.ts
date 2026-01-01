import { Component, signal } from '@angular/core';
import { Todolistdata } from '../services/todolistdata';

import { task } from '../classes/task'
import { FormsModule } from '@angular/forms';


@Component({
	selector: 'app-todoform',
	imports: [FormsModule],
	templateUrl: './todoform.html',
	styleUrl: './todoform.css',
})
export class Todoform {

	task:task = {
		"task":"",
		"description":"",
		"difficulty":"",
		"id":crypto.randomUUID(),
		"dateCreated":new Date()
	};

	allTasks = signal<task[]>([]);
	isLoading = signal<Boolean>(true);

	constructor(private tdata:Todolistdata){}


	ngOnInit()
	{
		this.getData()
	}

	cleanTask()
	{
		this.task.task = ""
		this.task.description = ""
		this.task.difficulty = ""
		this.task.id = crypto.randomUUID()
		this.task.dateCreated = new Date()
	}

	getData()
	{
		this.tdata.getTask().subscribe(
			(data) =>{
				this.isLoading.set(false)
				this.allTasks.set(data as task[])
				this.cleanTask()
				console.log(this.allTasks, this.isLoading)
			}
		)
	}

	addTask()
	{
		this.isLoading.set(true)
		this.tdata.addTask(this.task).subscribe(
			(data)=> {
				this.cleanTask()
				console.log("data sent successfully")
				this.getData()
			}
		)
	}
}
