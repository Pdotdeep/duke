public class Events extends Task{
    private String EventDate;
    Events(String TaskName , String EventDate ){
        super(TaskName , 3);
        this.EventDate = EventDate;
    }

    @Override
    public String toString() {
        return("[E][" + getStatusIcon() + "] " + this.getTaskName()) + " (at: " + this.EventDate + ")";
    }
}
