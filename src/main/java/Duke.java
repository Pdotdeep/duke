import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    static void printLine(){
        System.out.println("\t_______________________________________");
    }
    static void echo(String str){
        System.out.println("\t"  + str);
    }
    static void response(String s){
        printLine();
        echo(s);
        printLine();
    }
    static void printList(ArrayList<Task> items){
        int i  =1;
        printLine();
        for(Task item : items){
            String respondMsg = "";
            respondMsg += (Integer.toString(i) + ". ");
            respondMsg += item.toString();
            i++;
            echo(respondMsg);
        }
        printLine();

    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        printLine();
        echo("Hello! I am Duke");
        echo("What can i Do for you?");
        printLine();
        ArrayList<Task> items = new ArrayList<Task>();
        while(true){
            String s = scan.nextLine();
            if(s.equals("bye")){
                response("Bye. Hope to see you again Soon!");
                break;
            }else if(s.equals("list")){
                printList(items);
            }else{
                String[] tokens=s.split("\\s");

                if(tokens[0].equals("done")){
                    items.get(Integer.parseInt(tokens[1])-1).setDone(true);
                    printLine();
                    echo("Nice! i have marked this task as done:");
                    echo("  " + items.get(Integer.parseInt(tokens[1])-1).toString());
                    printLine();
                }else{
                    Task newTask = new Task(s);
                    items.add(newTask);
                    response("added: " + s);
                }


            }

        }

    }

    public static class Task {
        private boolean Done = false;
        private String TaskName;

        Task(String TaskName){
            this.TaskName = TaskName;
            this.Done = false;
        }

        public void setDone(boolean done){
            this.Done = done;
        }

        public String getStatusIcon() {
            return (Done ? "\u2713" : "\u2718"); //return tick or X symbols
        }

        @Override
        public String toString() {
            return("[" + getStatusIcon() + "] " + TaskName);
        }
    }

}
