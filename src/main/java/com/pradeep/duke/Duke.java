package com.pradeep.duke;


import com.pradeep.duke.Activities.*;
import com.pradeep.duke.Exceptions.*;
import com.pradeep.duke.Processing.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main Class for duke
 */
public class Duke {

    static final int TODO = 1;
    static final int DEADLINE = 2;
    static final int EVENT = 3;



    /**
     * Entry function into the program. Receives string command from command line and processes it into the type of the command before processing
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ListOfTasks newDuke = new ListOfTasks(Storage.loadTasks());

        while(true && scan.hasNext()){

            String s = scan.nextLine();

            try{
                Parser.Commands command = Parser.getCommand(s);
//                int payload = Parser.getPayload(command , s);

                if(command == Parser.Commands.bye){
                    newDuke.closeApp();
                    break;
                }else if(command == Parser.Commands.list){
                    newDuke.printList();
                }else{
//                    String[] tokens=s.split("\\s");

                    if(command == Parser.Commands.done){
                        String completedTask = Parser.getPayload(Parser.Commands.done , s);
                        newDuke.complete(Integer.parseInt(completedTask));
                    }else if(command == Parser.Commands.todo){
                        newDuke.addTasks(s , TODO);
                    }else if(command == Parser.Commands.deadline){
                        newDuke.addTasks(s , DEADLINE);

                    }else if(command == Parser.Commands.event){
                        newDuke.addTasks(s , EVENT);
                    }else if(command == Parser.Commands.find){
                        String keyword = Parser.getPayload(Parser.Commands.find , s);
                        ArrayList<Integer>foundItems = newDuke.find(keyword);
                        newDuke.printList(foundItems);
                    }else if(command == Parser.Commands.delete){
                        String deletedTask = Parser.getPayload(Parser.Commands.delete , s);
                        newDuke.deleteTask(Integer.parseInt(deletedTask));

                    }else {
                        throw new UnknownCommandException("Unknown Command");

                    }
                }

            }catch(IndexOutOfBoundsException e){
                UI.printError("There is no such item in the list !!");
            }catch(UnknownCommandException e){
                UI.printError(e.toString());
            }catch (IncompleteCommandException e){
                UI.printError(e.toString());
            }catch (ParseException e){
                UI.printError(e.toString());
            }

        }


    }

}
