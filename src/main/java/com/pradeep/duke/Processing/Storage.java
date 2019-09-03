package com.pradeep.duke.Processing;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import com.pradeep.duke.Exceptions.*;

import com.pradeep.duke.Activities.*;
import com.pradeep.duke.Exceptions.*;
import com.pradeep.duke.Processing.*;
import com.pradeep.duke.MyDate;

public class Storage {

    static final int TODO = 1;
    static final int DEADLINE = 2;
    static final int EVENT = 3;

    public static String getFormattedList(ArrayList<Task> list){



        String output = "";
        for(Task t : list){
            output += " ";
            output += t.getType();
            output += " ";
            output += t.getTaskName();
            output += " | ";
            output += t.getDoneStatus();
            if(t.getType() == DEADLINE){
                output += " ";
                output += ((Deadlines)t).getDate();
            }else if(t.getType() == EVENT){
                output += " ";
                output += ((Events)t).getDate();
            }else{
                output += " NA ";
            }
            output += " |";
        }

        return output;

    }

    public static void saveToFile(ArrayList<Task> list){
        try{
            FileWriter fw=new FileWriter("./data/duke.txt");
            String formattedList = getFormattedList(list);

            fw.write(formattedList);
            fw.close();
        }catch(Exception e){System.out.println(e);}

    }

    public static ArrayList<Task> loadTasks(){

        ArrayList<Task> list = new ArrayList<Task>();

        try{
            File file = new File("./data/duke.txt");
            Scanner input=new Scanner(file);
            input.useDelimiter(" +");

            while(input.hasNext()){
                String taskType = input.next();

                String temp = input.next();
                String taskName = "";
                while(!temp.contains("|") && input.hasNext()){
                    taskName += temp;
                    taskName += " ";
                    temp = input.next();
                }
                String doneStatus = input.next();

                String tempDate = input.next();
                String DateBy = "";
                while(!tempDate.contains("|") && input.hasNext()){
                    DateBy += tempDate;
                    DateBy += " ";
                    tempDate = input.next();
//                    System.out.println("\nTest" + tempDate);
                }
                boolean doneStat;
                if(doneStatus.equals("true")){
                    doneStat = true;
                }else{
                    doneStat = false;
                }

                MyDate dateBy = null;

                if(!DateBy.contains("NA")){
                    try {
                        dateBy = new MyDate(DateBy);
                    }catch (ParseException e){

                    }
                }

                if(taskType.contains("1")){
                    list.add(new ToDos(taskName , doneStat));
                }else if(taskType.contains("2")){
                    list.add(new Deadlines(taskName , dateBy,doneStat));
                }else if(taskType.contains("3")){
                    list.add(new Events(taskName , dateBy,doneStat));
                }


            }

        }catch(FileNotFoundException e){
            UI.printMsg("No Saved Data found!");
        }

        return list;

    }

}
