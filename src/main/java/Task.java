public class Task {
    private boolean Done = false;
    private String TaskName;

    private int Type;

    Task(String TaskName , int Type){
        this.TaskName = TaskName;
        this.Type = Type;
        this.Done = false;
    }
    Task(){
        this.TaskName = "";
        this.Done = false;
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
