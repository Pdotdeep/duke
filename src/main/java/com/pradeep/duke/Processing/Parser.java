package com.pradeep.duke.Processing;

/**
 * Parser class to process string command into the respective command enum
 */
public class Parser {

    /**
     * Enum commands accepted by Duke
     */
    public enum Commands{
        delete, list , todo, event , deadline , find ,bye, done ,unknown
    }


    /**
     * Process the string command into enum variable.
     * @param s String Command
     * @return returns the command
     */
    public static Commands getCommand(String s){

        if(s.equals("bye")){
            return Commands.bye;
        }else if(s.equals("list")){
            return Commands.list;
        }else{
            String[] tokens=s.split("\\s");
            if(tokens[0].equals("done")){
                return Commands.done;
            }else if(tokens[0].contains("todo")){
                return Commands.todo;

            }else if(tokens[0].contains("deadline")){
                return Commands.deadline;

            }else if(tokens[0].contains("event")){
                return Commands.event;
            }else if(tokens[0].contains("delete")){
                return Commands.delete;

            }else if(tokens[0].contains("find")){
                return Commands.find;
            }else {
                return Commands.unknown;
            }
        }

    }

    /**
     * Parses the string Commmand received to return the payload of the command
     * @param c The type of command
     * @param s the string command
     */
    public static String getPayload(Commands c, String s){

        String[] tokens=s.split("\\s");
        if(c == Commands.done){
            int completedTask = Integer.parseInt(tokens[1])-1;
            return String.valueOf(completedTask);

        }else if(c == Commands.delete){
            int deletedTask = Integer.parseInt(tokens[1])-1;
            return String.valueOf(deletedTask);

        }else if(c == Commands.find){
            return String.valueOf(tokens[1]);

        }else {
            return null;

        }

    }
}
