package com.pradeep.duke.Activities;
import java.awt.image.AreaAveragingScaleFilter;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.ArrayList;
import com.pradeep.duke.Processing.*;
import com.pradeep.duke.Exceptions.*;

public class ListOfTasks {
    private ArrayList<Task> list;

    void initiateDuke(){
        UI.printMsg("Hello! I am Duke" , "What can i do for you?" );
    }

    public ListOfTasks(ArrayList<Task> list){
        this.list = list;
        initiateDuke();

    }

    public void closeApp(){response("Bye. Hope to see you again Soon!");}

    void response(String s){
        UI.printMsg(s);
    }

    public void printList(){
        int i  =1;

        UI.printTasks(this.list);


    }

    public void printList(ArrayList<Integer> foundIndexes){
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

    public void addTasks(String s, int type) throws IncompleteCommandException, ParseException {

        TaskList.addTasks(list , s, type);
    }
//
public void deleteTask(int toBeDeleted){
        TaskList.deleteTask(list , toBeDeleted);
    }
//
public void complete(int completedTaskIndex){
        TaskList.complete(list, completedTaskIndex);
    }
//
public ArrayList<Integer> find(String s){
        return TaskList.find(list,s);
    }

    public void completeCommand(String s){



    }

}
