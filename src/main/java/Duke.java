

import java.util.ArrayList;
import java.util.Scanner;

public class Duke {

    static final int TODO = 1;
    static final int DEADLINE = 2;
    static final int EVENT = 3;



//    static void printLine(){
//        System.out.println("\t_______________________________________");
//    }
//    static void echo(String str){
//        System.out.println("\t"  + str);
//    }
//    static void response(String s){
//        printLine();
//        echo(s);
//        printLine();
//    }
//    static void printList(ArrayList<Task> items){
//        int i  =1;
//        printLine();
//        for(Task item : items){
//            String respondMsg = "";
//            respondMsg += (Integer.toString(i) + ". ");
//            respondMsg += item.toString();
//            i++;
//            echo(respondMsg);
//        }
//        printLine();
//
//    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ListOfTasks newDuke = new ListOfTasks();


//        ArrayList<Task> items = new ArrayList<Task>();
        while(true){
            String s = scan.nextLine();
            if(s.equals("bye")){
                newDuke.closeApp();
                break;
            }else if(s.equals("list")){
                newDuke.printList();
            }else{
                String[] tokens=s.split("\\s");
                if(tokens[0].equals("done")){
                    int completedTask = Integer.parseInt(tokens[1])-1;
                    newDuke.complete(completedTask);
                }else if(tokens[0].equals("todo")){
                    newDuke.addTasks(s , TODO);

                }else if(tokens[0].equals("deadline")){
                    newDuke.addTasks(s , DEADLINE);

                }else if(tokens[0].equals("event")){
                    newDuke.addTasks(s , EVENT);


                }else{
//                    Task newTask = new Task(s);
//                    items.add(newTask);
//                    response("added: " + s);
                }


            }

        }

    }
//
//    public static class Task {
//        private boolean Done = false;
//        private String TaskName;
//
//        Task(String TaskName){
//            this.TaskName = TaskName;
//            this.Done = false;
//        }
//
//        public void setDone(boolean done){
//            this.Done = done;
//        }
//
//        public String getStatusIcon() {
//            return (Done ? "\u2713" : "\u2718"); //return tick or X symbols
//        }
//
//        @Override
//        public String toString() {
//            return("[" + getStatusIcon() + "] " + TaskName);
//        }
//    }

}
