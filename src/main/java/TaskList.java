import java.text.ParseException;
import java.util.ArrayList;

public class TaskList {

    static final int TODOOFFSET = 5;
    static final int DEADLINEOFFSET = 9;
    static final int EVENTOFFSET = 6;

    static final int TODO = 1;
    static final int DEADLINE = 2;
    static final int EVENT = 3;

    public static String[] getNameAndDate(String s , int startOffset) throws IncompleteCommandException {
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
    static void addTasks( ArrayList<Task> list , String s , int type) throws IncompleteCommandException, ParseException {

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

        UI.addedTaskMsg(list);

//        UI.printLine();
//        UI.echo( "Got it. I've added this task: ");
//        UI.echo(tempTask.toString());
//        UI.echo("Now you have "+ list.size() + " items in the list" );
//        UI.printLine();

        Storage.saveToFile(list);

    }

    static void deleteTask(ArrayList<Task> list ,int toBeDeleted){


        Task temp = list.get(toBeDeleted);
        list.remove(toBeDeleted);
//        UI.printLine();
//        UI.echo("Noted. I have removed this task");
//        UI.echo("  " + temp.toString());
//        UI.echo("Now you have "+ list.size() + " items in the list" );
//        UI.printLine();

        UI.deletedTaskMsg(temp , list);

        Storage.saveToFile(list);
    }

    static void complete(ArrayList<Task> list ,int completedTaskIndex){
        list.get(completedTaskIndex).setDone(true);
//        UI.printLine();
        UI.printMsg("Nice! i have marked this task as done:" , list.get(completedTaskIndex).toString());
//        UI.printLine();

        Storage.saveToFile(list);
    }

    static ArrayList<Integer> find (ArrayList<Task> list , String s){
        ArrayList<Integer> foundIndexes = new ArrayList<Integer>();
        int i = 0;
        for(Task a : list){
            if(a.contains(s)){
                foundIndexes.add(i);
            }
            i++;
        }

        return foundIndexes;
    }
}
