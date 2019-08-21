public class Task {
    private boolean Done = false;
    private String TaskName;

    Task(String TaskName){
        this.TaskName = TaskName;
        this.Done = false;
    }

    public String getStatusIcon() {
        return (Done ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    @Override
    public String toString() {
        return("[" + getStatusIcon() + "] " + TaskName);
    }
}
