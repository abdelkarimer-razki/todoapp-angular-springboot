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
	edit = signal<Boolean>(false);

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
			}
		)
	}


	addTask()
	{
		if (this.task.task == "" || this.task.description == "" || this.task.difficulty == "")
			alert("You should fill all the inputs")
		else
		{
			this.isLoading.set(true)
			this.tdata.addTask(this.task).subscribe(
				(data)=> {
					this.cleanTask()
					this.getData()
				}
			)
		}
	}

	deleteTask(id:String)
	{
		this.tdata.deleteTask(id).subscribe(
			(data)=>{
				this.cleanTask()
				this.getData()
			}
		)
	}

	updateTask(id:String, task:task)
	{
		this.tdata.updateTask(id, task).subscribe(
			(data)=>{
				this.edit.set(false)
				this.getData()
			}
		)
	}
}
