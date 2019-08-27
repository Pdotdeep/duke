public class Deadlines extends Task {

    String DeadLineDate;

    Deadlines(String TaskName , String DeadLineDate){
        super(TaskName);
        this.DeadLineDate = DeadLineDate;
    }

    public String toString(){
        return("[D][" + getStatusIcon() + "] " + this.getTaskName() + " (by: " + this.DeadLineDate + ")") ;
    }
}
