package com.pradeep.duke.Activities;

/**
 * Todos class
 */
public class ToDos extends Task{



    public ToDos(String TaskName){
        super(TaskName , 1);

    }

    public ToDos(String TaskName, boolean done){
        super(TaskName , 1 , done);

    }

    public String toString(){
        return("[T][" + getStatusIcon() + "] " + this.getTaskName());
    }
}
