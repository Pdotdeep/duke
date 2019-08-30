import java.io.File;
import java.text.ParseException;
import java.util.Scanner;

public class Duke {

    static final int TODO = 1;
    static final int DEADLINE = 2;
    static final int EVENT = 3;



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ListOfTasks newDuke = new ListOfTasks(FileParser.loadTasks());

        while(true){
            String s = scan.nextLine();

            try{

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
                    }else if(tokens[0].equals("delete")){
                        int deletedTask = Integer.parseInt(tokens[1])-1;
                        newDuke.deleteTask(deletedTask);

                    }else {
                        throw new UnknownCommandException("Unknown Command");

                    }
                }

            }catch(IndexOutOfBoundsException e){
                System.out.println("There is no such item in the list !!");
            }catch(UnknownCommandException e){
                System.out.println(e);

            }catch (IncompleteCommandException e){
                System.out.println(e);
            }catch (ParseException e){
                System.out.println(e);
            }

        }


    }

}
