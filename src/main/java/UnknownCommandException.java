public class UnknownCommandException extends Exception {

    UnknownCommandException(String err){
        super(err);
    }



    String errMsg(){
        return "☹ OOPS!!! I'm sorry, but I don't know what that means :-(";
    }


    @Override
    public String toString() {
        return errMsg();
    }
}
