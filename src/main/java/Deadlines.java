import java.util.Date;

public class Deadlines extends Task {

    private MyDate DeadLineDate;

    Deadlines(String TaskName , MyDate DeadLineDate ){
        super(TaskName , 2);
        this.DeadLineDate = DeadLineDate;
    }

    Deadlines(String TaskName , MyDate DeadLineDate , boolean done){
        super(TaskName , 2 , done);
        this.DeadLineDate = DeadLineDate;
    }

    public MyDate getDate(){
        return DeadLineDate;
    }



    public String toString(){
        return("[D][" + getStatusIcon() + "] " + this.getTaskName() + " (by: " + this.DeadLineDate + ")") ;
    }
}
