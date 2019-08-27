public class ToDos extends Task{



    ToDos(String TaskName ){
        super(TaskName , 1);

    }

    ToDos(String TaskName , boolean done){
        super(TaskName , 1 , done);

    }

    public String toString(){
        return("[T][" + getStatusIcon() + "] " + this.getTaskName());
    }
}
