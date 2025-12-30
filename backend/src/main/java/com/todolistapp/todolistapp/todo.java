package com.todolistapp.todolistapp;
import java.util.UUID;
import java.time.LocalDate;

public class todo {
    private String id;
    private String task;
    private String difficulty;
    private String description;
    private LocalDate date_created;

    public todo(String task, String difficulty, String description)
    {
        this.id = UUID.randomUUID().toString();
        this.task = task;
        this.difficulty = difficulty;
        this.description = description;
        this.date_created = LocalDate.now();
    }

    public String getId()
    {
        return this.id;
    }

    public String getDateCreated()
    {
        return this.date_created.toString();
    }

    public todo(){
        this.id = UUID.randomUUID().toString();
        this.date_created = LocalDate.now();
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
