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
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        printLine();
        echo("Hello! I am Duke");
        echo("What can i Do for you?");
        printLine();
        ArrayList<String> items = new ArrayList<String>();
        while(true){
            String s = scan.nextLine();
            if(s.equals("bye")){
                response("Bye. Hope to see you again Soon!");
                break;
            }
//            else if(s.equals("list")){
//                System.out.println(items);
//            }
            response(s);
        }

    }
}
