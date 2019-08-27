import java.text.ParseException;
import java.util.ArrayList;

public class ListOfTasks {
    private ArrayList<Task> list;

    final int TODOOFFSET = 5;
    final int DEADLINEOFFSET = 9;
    final int EVENTOFFSET = 6;

    static final int TODO = 1;
    static final int DEADLINE = 2;
    static final int EVENT = 3;

    void initiateDuke(){
        printLine();
        echo("Hello! I am Duke");
        echo("What can i Do for you?");
        printLine();
    }

    ListOfTasks(ArrayList<Task> list){
        this.list = list;
        initiateDuke();

    }

    void printLine(){
        System.out.println("\t________________________________________________");
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
            respondMsg += (i + ". ");
            respondMsg += item.toString();
            i++;
            echo(respondMsg);
        }
        printLine();

    }

    public String[] getNameAndDate(String s , int startOffset) throws IncompleteCommandException {
        int endIndex = s.indexOf('/');

        if(s.length() <= startOffset){
            if(startOffset == TODOOFFSET){
                throw new IncompleteCommandException("todo");
            }else if(startOffset == DEADLINEOFFSET){
                throw new IncompleteCommandException("deadline");
            }else if(startOffset == EVENTOFFSET){
                throw new IncompleteCommandException("event");
            }

        }
        if(endIndex == -1 && startOffset == DEADLINEOFFSET){ throw new IncompleteCommandException("deadline"); }
        if(endIndex == -1 && startOffset == EVENTOFFSET){ throw new IncompleteCommandException("event"); }
        if(endIndex == -1){
            String taskName = s.substring(startOffset);
            return new String[]{taskName};
        }
        String taskName = s.substring(startOffset , endIndex);
        String dateBy = s.substring(endIndex + 4);

        return new String[]{taskName , dateBy};

    }

    void addTasks(String s , int type) throws IncompleteCommandException, ParseException {

        Task tempTask;

        if (type == TODO){
            String[] breakdown = getNameAndDate(s , TODOOFFSET);
            tempTask = new ToDos(breakdown[0]);

        }else if (type == DEADLINE){
            String[] breakdown = getNameAndDate(s , DEADLINEOFFSET);
            MyDate dateBy = new MyDate(breakdown[1]);
            tempTask = new Deadlines(breakdown[0] , dateBy);


        }else{
            String[] breakdown = getNameAndDate(s , EVENTOFFSET);
            MyDate dateBy = new MyDate(breakdown[1]);
            tempTask = new Events(breakdown[0] , dateBy);

        }
        list.add(tempTask);

        printLine();
        echo( "Got it. I've added this task: ");
        echo(tempTask.toString());
        echo("Now you have "+ list.size() + " items in the list" );
        printLine();

        FileParser.saveToFile(list);

    }

    void complete(int completedTaskIndex){
        list.get(completedTaskIndex).setDone(true);
        printLine();
        echo("Nice! i have marked this task as done:");
        echo("  " + list.get(completedTaskIndex).toString());
        printLine();

        FileParser.saveToFile(list);
    }

}
