package com.codersbay;

import java.util.ArrayList;

public class Todo {
    private String title;
    private String description;
    private ArrayList<Task> taskList;
    private int TODOID;

    public Todo() {
    }

    public Todo(String title, String description, ArrayList<Task> taskList) {
        this.title = title;
        this.description = description;
        this.taskList = taskList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    public int getTODOID() {
        return TODOID;
    }

    public void setTODOID(int TODOID) {
        this.TODOID = TODOID;
    }

    public void addTask(Task task) {
        this.taskList.add(task);
    }

    public void removeTask(Task task) {
        this.taskList.remove(task);
    }


    @Override
    public String toString() {
        return "Todo{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", taskList=" + taskList +
                ", TODOID=" + TODOID +
                '}';
    }
}
