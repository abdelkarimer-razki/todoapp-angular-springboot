import { Routes } from '@angular/router';
import { Navbar } from './navbar/navbar';
import { Homepage } from './homepage/homepage';
import { Todoform } from './todoform/todoform';

export const routes: Routes = [
	{path:"", component:Homepage},
	{path:"todolist", component:Todoform}
];
