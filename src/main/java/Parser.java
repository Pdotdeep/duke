public class Parser {
    public enum Commands{
        delete, list , todo, event , deadline , find ,bye, done ,unknown
    }

    static Commands getCommand(String s){

        if(s.equals("bye")){
            return Commands.bye;
        }else if(s.equals("list")){
            return Commands.list;
        }else{
            String[] tokens=s.split("\\s");
            if(tokens[0].equals("done")){
                return Commands.done;
            }else if(tokens[0].equals("todo")){
                return Commands.todo;

            }else if(tokens[0].equals("deadline")){
                return Commands.deadline;

            }else if(tokens[0].equals("event")){
                return Commands.event;
            }else if(tokens[0].equals("delete")){
                return Commands.delete;

            }else {
                return Commands.unknown;
            }
        }

    }

    static int getPayload(Commands c , String s){

        String[] tokens=s.split("\\s");
        if(c == Commands.done){
            int completedTask = Integer.parseInt(tokens[1])-1;
            return completedTask;

        }else if(c == Commands.done){
            int deletedTask = Integer.parseInt(tokens[1])-1;
            return deletedTask;

        }else {
            return -1;

        }

    }
}
