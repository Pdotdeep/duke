package com.pradeep.duke.Processing;

import java.util.ArrayList;
import com.pradeep.duke.Activities.*;


/**
 * Class to handle all the print messages
 */
public class UI {

    static void printLine(){
        System.out.println("\t________________________________________________");
    }
    static void echo(String str){
        System.out.println("\t"  + str);
    }

    public static void printError(String errMsg){
        printLine();
        echo(errMsg);
        printLine();
    }

    public static void printMsg(String... Msg){
        printLine();
        for(String s :Msg){
            echo(s);
        }
        printLine();
    }

    public static void printTasks(ArrayList<Task> tasks){
        printLine();
        int i = 1;
        for(Task s :tasks){
            echo(Integer.toString(i) + ". " + s.toString());
            i++;
        }
        printLine();
    }
    public static void printMsges(ArrayList<String> Msg){
        printLine();
        for(String s :Msg){
            echo(s);
        }
        printLine();
    }

    static void addedTaskMsg(ArrayList<Task> list){
        printLine();
        echo( "Got it. I've added this task: ");
        echo(list.get(list.size()-1).toString());
        echo("Now you have "+ list.size() + " items in the list" );
        printLine();
    }
    static void deletedTaskMsg(Task temp , ArrayList<Task> list){
        UI.printLine();
        UI.echo("Noted. I have removed this task");
        UI.echo("  " + temp.toString());
        UI.echo("Now you have "+ list.size() + " items in the list" );
        UI.printLine();
    }

}
