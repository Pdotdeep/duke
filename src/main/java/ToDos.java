public class ToDos extends Task{

    ToDos(String TaskName){
        super(TaskName);
    }

    public String toString(){
        return("[T][" + getStatusIcon() + "] " + this.getTaskName());
    }
}
