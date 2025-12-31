import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable({
	providedIn: 'root',
})
export class Todolistdata {

	private apiUrl = "http://localhost:8080/api/"
	constructor(private http:HttpClient){}


	getTask(){
		return this.http.get(this.apiUrl + "getTask")
	}


}
