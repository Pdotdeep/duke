public class ToDos extends Task{



    ToDos(String TaskName ){
        super(TaskName , 1);

    }

    public String toString(){
        return("[T][" + getStatusIcon() + "] " + this.getTaskName());
    }
}
