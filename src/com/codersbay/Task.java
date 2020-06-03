package com.codersbay;

public class Task {

    private String title;
    private String description;
    private int TODOID;
    private int TASKID;

    public Task() {
    }

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
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

    public int getTODOID() {
        return TODOID;
    }

    public void setTODOID(int TODOID) {
        this.TODOID = TODOID;
    }

    public int getTASKID() {

        return TASKID;
    }

    public void setTASKID(int TASKID) {
        this.TASKID = TASKID;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", TODOID=" + TODOID +
                ", TASKID=" + TASKID +
                '}';
    }
}
