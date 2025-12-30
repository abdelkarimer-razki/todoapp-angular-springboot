package com.todolistapp.todolistapp;
import java.rmi.server.UID;
import java.util.UUID;

public class todo {
    private String id;
    private String task;
    private String difficulty;
    private String description;

    public todo(String task, String difficulty, String description)
    {
        this.id = UUID.randomUUID().toString();
        this.task = task;
        this.difficulty = difficulty;
        this.description = description;
    }

    public String getId()
    {
        return this.id;
    }

    public todo(){
        this.id = UUID.randomUUID().toString();
    }

    public String getTask()
    {
        return this.task;
    }

    public String getDifficulty()
    {
        return this.difficulty;
    }

    public String getDescription()
    {
        return this.description;
    }

    public void setTask(String task)
    {
        this.task = task;
    }

    public void setDifficulty(String difficulty)
    {
        this.difficulty = difficulty;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
