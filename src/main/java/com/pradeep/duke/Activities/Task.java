package com.pradeep.duke.Activities;


/**
 * Task Super class
 */
public class Task {
    private boolean Done = false;
    private String TaskName;

    private int Type;

    public Task(String TaskName , int Type , boolean Done){
        this.TaskName = TaskName;
        this.Type = Type;
        this.Done = Done;
    }

    public Task(String TaskName , int Type){
        this.TaskName = TaskName;
        this.Type = Type;
        this.Done = false;
    }
    public Task(){
        this.TaskName = "";
        this.Done = false;
    }

    /**
     * checks if the task name contains string s
     */
    public boolean contains(String s){
        return TaskName.toLowerCase().contains(s.toLowerCase());
    }

    public boolean getDoneStatus(){
        return Done;
    }

    public String getTaskName(){
        return TaskName;
    }

    public void setDone(boolean done){
        this.Done = done;
    }

    public String getStatusIcon() {
        return (Done ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    @Override
    public String toString() {
        return("[" + getStatusIcon() + "] " + TaskName);
    }

    public int getType() {

        return Type;
    }
}
