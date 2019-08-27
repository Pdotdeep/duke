public class IncompleteCommandException  extends Exception{
    private String ErrType;
    IncompleteCommandException(String err){
        super(err);
        ErrType = err;
    }

    String printLine(){
        return "\t_______________________________________\n";
    }
    String errMsg(){
        return "\t ☹ OOPS!!! The description of a " + ErrType + " cannot be empty.\n";
    }


    @Override
    public String toString() {
        return printLine()+errMsg()+printLine();
    }
}
