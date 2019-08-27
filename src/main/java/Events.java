import java.util.Date;

public class Events extends Task{
    private MyDate EventDate;
    Events(String TaskName , MyDate EventDate ){
        super(TaskName , 3);
        this.EventDate = EventDate;
    }
    Events(String TaskName , MyDate EventDate , boolean done){
        super(TaskName , 3 , done);
        this.EventDate = EventDate;
    }

    public MyDate getDate(){
        return EventDate;
    }

    @Override
    public String toString() {
        return("[E][" + getStatusIcon() + "] " + this.getTaskName()) + " (at: " + this.EventDate + ")";
    }
}
