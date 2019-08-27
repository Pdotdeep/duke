public class Deadlines extends Task {

    private String DeadLineDate;

    Deadlines(String TaskName , String DeadLineDate ){
        super(TaskName , 2);
        this.DeadLineDate = DeadLineDate;
    }



    public String toString(){
        return("[D][" + getStatusIcon() + "] " + this.getTaskName() + " (by: " + this.DeadLineDate + ")") ;
    }
}
