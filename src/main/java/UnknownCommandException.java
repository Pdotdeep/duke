public class UnknownCommandException extends Exception {

    UnknownCommandException(String err){
        super(err);
    }


    String printLine(){
        return "\t____________________________________________________\n";
    }
    String errMsg(){
        return "\t☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n";
    }


    @Override
    public String toString() {
        return printLine()+errMsg()+printLine();
    }
}
