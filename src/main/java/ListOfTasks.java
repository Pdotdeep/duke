import java.awt.image.AreaAveragingScaleFilter;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.ArrayList;

public class ListOfTasks {
    private ArrayList<Task> list;

//    final int TODOOFFSET = 5;
//    final int DEADLINEOFFSET = 9;
//    final int EVENTOFFSET = 6;
//
//    static final int TODO = 1;
//    static final int DEADLINE = 2;
//    static final int EVENT = 3;

    void initiateDuke(){
        UI.printMsg("Hello! I am Duke" , "What can i do for you?" );
    }

    ListOfTasks(ArrayList<Task> list){
        this.list = list;
        initiateDuke();

    }

    void closeApp(){response("Bye. Hope to see you again Soon!");}

    void response(String s){
        UI.printMsg(s);
    }

    void printList(){
        int i  =1;

        UI.printTasks(this.list);


//        UI.printLine();
//        for(Task item : this.list){
//            String respondMsg = "";
//            respondMsg += (i + ". ");
//            respondMsg += item.toString();
//            i++;
//            UI.echo(respondMsg);
//        }
//        UI.printLine();

    }

    void printList(ArrayList<Integer> foundIndexes){
        int i  =1;

        ArrayList<String> messages = new ArrayList<String>();
//        UI.printLine();
        for(int a : foundIndexes){
            String respondMsg = "";
            respondMsg += (i + ". ");
            respondMsg += list.get(a).toString();
            i++;
            messages.add(respondMsg);
        }
//        UI.printLine();
        UI.printMsges(messages);
    }

//    public String[] getNameAndDate(String s , int startOffset) throws IncompleteCommandException {
//        int endIndex = s.indexOf('/');
//
//        if(s.length() <= startOffset){
//            if(startOffset == TODOOFFSET){
//                throw new IncompleteCommandException("todo");
//            }else if(startOffset == DEADLINEOFFSET){
//                throw new IncompleteCommandException("deadline");
//            }else if(startOffset == EVENTOFFSET){
//                throw new IncompleteCommandException("event");
//            }
//
//        }
//        if(endIndex == -1 && startOffset == DEADLINEOFFSET){ throw new IncompleteCommandException("deadline"); }
//        if(endIndex == -1 && startOffset == EVENTOFFSET){ throw new IncompleteCommandException("event"); }
//        if(endIndex == -1){
//            String taskName = s.substring(startOffset);
//            return new String[]{taskName};
//        }
//        String taskName = s.substring(startOffset , endIndex);
//        String dateBy = s.substring(endIndex + 4);
//
//        return new String[]{taskName , dateBy};
//
//    }

    void addTasks(String s , int type) throws IncompleteCommandException, ParseException {

        TaskList.addTasks(list , s, type);
//
//        Task tempTask;
//
//        if (type == TODO){
//            String[] breakdown = getNameAndDate(s , TODOOFFSET);
//            tempTask = new ToDos(breakdown[0]);
//
//        }else if (type == DEADLINE){
//            String[] breakdown = getNameAndDate(s , DEADLINEOFFSET);
//            MyDate dateBy = new MyDate(breakdown[1]);
//            tempTask = new Deadlines(breakdown[0] , dateBy);
//
//
//        }else{
//            String[] breakdown = getNameAndDate(s , EVENTOFFSET);
//            MyDate dateBy = new MyDate(breakdown[1]);
//            tempTask = new Events(breakdown[0] , dateBy);
//
//        }
//        list.add(tempTask);
//
//        printLine();
//        echo( "Got it. I've added this task: ");
//        echo(tempTask.toString());
//        echo("Now you have "+ list.size() + " items in the list" );
//        printLine();
//
//        Storage.saveToFile(list);
//
    }
//
    void deleteTask(int toBeDeleted){
        TaskList.deleteTask(list , toBeDeleted);
//
//
//        Task temp = list.get(toBeDeleted);
//        list.remove(toBeDeleted);
//        printLine();
//        echo("Noted. I have removed this task");
//        echo("  " + temp.toString());
//        echo("Now you have "+ list.size() + " items in the list" );
//        printLine();
//
//        Storage.saveToFile(list);
    }
//
    void complete(int completedTaskIndex){
        TaskList.complete(list, completedTaskIndex);
//        list.get(completedTaskIndex).setDone(true);
//        printLine();
//        echo("Nice! i have marked this task as done:");
//        echo("  " + list.get(completedTaskIndex).toString());
//        printLine();
//
//        Storage.saveToFile(list);
    }
//
    ArrayList<Integer> find (String s){
        return TaskList.find(list,s);
//        ArrayList<Integer> foundIndexes = new ArrayList<Integer>();
//        int i = 0;
//        for(Task a : list){
//            if(a.contains(s)){
//                foundIndexes.add(i);
//            }
//            i++;
//        }
//
//        return foundIndexes;
    }

    void completeCommand(String s){



    }

}
