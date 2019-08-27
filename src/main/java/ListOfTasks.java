import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

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
            respondMsg += (Integer.toString(i) + ". ");
            respondMsg += item.toString();
            i++;
            echo(respondMsg);
        }
        printLine();

    }
    String getFormattedList(){
        String output = "";
        for(Task t : list){
            output += t.getType();
            output += " ";
            output += t.getTaskName();
            output += " | ";
            output += t.getDoneStatus();
            if(t.getType() == DEADLINE){
                //ADD DEADLINE
                output += " ";
                output += ((Deadlines)t).getDate();
            }else if(t.getType() == EVENT){
                output += " ";
                output += ((Events)t).getDate();
            }else{
                output += " NA ";
            }
            output += " | ";
        }

        return output;

    }

    void saveToFile(){
        try{
            FileWriter fw=new FileWriter("./data/duke.txt");
            String formattedList = getFormattedList();

            fw.write(formattedList);
            fw.close();
        }catch(Exception e){System.out.println(e);}
        System.out.println("Success...");

    }

//    Date processDate(String dateBy){
//        String []dates = dateBy.split("/");
//        String []time = dateBy.split(" ");
//
//
//    }

    void loadTasks(){
        try{
            File file = new File("./data/duke.txt");
            Scanner input=new Scanner(file);
            input.useDelimiter(" +");

            while(input.hasNext()){
//                echo(input.next());
                String taskType = input.next();
//                echo(taskType + " HAHA");
                String temp = input.next();
//                echo(temp);
                String taskName = "";
                while(!temp.contains("|") && input.hasNext()){
                    taskName += temp;
                    taskName += " ";
                    temp = input.next();
                }
//                echo(taskName + " HAHAHA");
                String doneStatus = input.next();
//                echo(doneStatus);

                String tempDate = input.next();
//                echo(tempDate);
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

                if(taskType.contains("1")){
                    list.add(new ToDos(taskName , doneStat));
                }else if(taskType.contains("2")){
                    list.add(new Deadlines(taskName , DateBy,doneStat));
                }else if(taskType.contains("3")){
                    list.add(new Events(taskName , DateBy,doneStat));
                }
            }
            printList();

        }catch(FileNotFoundException e){
            System.out.println("No Saved Data found!");
        }

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
        System.out.println(taskName);
        System.out.println(dateBy);

        return new String[]{taskName , dateBy};

    }

    void addTasks(String s , int type) throws IncompleteCommandException {

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

        saveToFile();

    }

    void complete(int completedTaskIndex){
        list.get(completedTaskIndex).setDone(true);
        printLine();
        echo("Nice! i have marked this task as done:");
        echo("  " + list.get(completedTaskIndex).toString());
        printLine();

        saveToFile();
    }

}
