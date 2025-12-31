import { Component } from '@angular/core';
import { Todolistdata } from '../services/todolistdata';


@Component({
	selector: 'app-todoform',
	imports: [],
	templateUrl: './todoform.html',
	styleUrl: './todoform.css',
})
export class Todoform {

	constructor(private tdata:Todolistdata){}


	ngOnInit()
	{
		this.getData()
	}
	getData()
	{
		this.tdata.getTask().subscribe(
		(data) => console.log(data)
		)
	}
}
