import java.util.ArrayList;

public class ListOfTasks {
    private ArrayList<Task> list;

    final int TODOOFFSET = 5;
    final int DEADLINEOFFSET = 9;
    final int EVENTOFFSET = 6;

    static final int TODO = 1;
    static final int DEADLINE = 2;
    static final int EVENT = 3;

    ListOfTasks(){
        list = new ArrayList<Task>();
        printLine();
        echo("Hello! I am Duke");
        echo("What can i Do for you?");
        printLine();
    }

    void printLine(){
        System.out.println("\t_______________________________________");
    }
    void echo(String str){
        System.out.println("\t"  + str);
    }

    void closeApp(){response("Bye. Hope to see you again Soon!");}

    void response(String s){
        printLine();
        echo(s);
        printLine();
    }

    void printList(){
        int i  =1;
        printLine();
        for(Task item : this.list){
            String respondMsg = "";
            respondMsg += (Integer.toString(i) + ". ");
            respondMsg += item.toString();
            i++;
            echo(respondMsg);
        }
        printLine();

    }

    public String[] getNameAndDate(String s , int startOffset){
        int endIndex = s.indexOf('/');
        if(endIndex == -1){
            String taskName = s.substring(startOffset);
            return new String[]{taskName};
        }
        String taskName = s.substring(startOffset , endIndex);
        String dateBy = s.substring(endIndex + 4);
        System.out.println(taskName);
        System.out.println(dateBy);

        return new String[]{taskName , dateBy};

    }

    void addTasks(String s , int type){

        Task tempTask;

        if (type == TODO){
            String[] breakdown = getNameAndDate(s , TODOOFFSET);
            tempTask = new ToDos(breakdown[0]);

        }else if (type == DEADLINE){
            String[] breakdown = getNameAndDate(s , DEADLINEOFFSET);
            tempTask = new Deadlines(breakdown[0] , breakdown[1]);


        }else{
            String[] breakdown = getNameAndDate(s , EVENTOFFSET);
            tempTask = new Events(breakdown[0] , breakdown[1]);

        }
        list.add(tempTask);

        printLine();
        echo( "Got it. I've added this task: ");
        echo(tempTask.toString());
        echo("Now you have "+ list.size() + " items in the list" );
        printLine();

    }

    void complete(int completedTaskIndex){
        list.get(completedTaskIndex).setDone(true);
        printLine();
        echo("Nice! i have marked this task as done:");
        echo("  " + list.get(completedTaskIndex).toString());
        printLine();
    }

}
