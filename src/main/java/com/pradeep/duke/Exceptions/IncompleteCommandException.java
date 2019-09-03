package com.pradeep.duke.Exceptions;


public class IncompleteCommandException  extends Exception{
    private String ErrType;
    public IncompleteCommandException(String err){
        super(err);
        ErrType = err;
    }

    String errMsg(){
        return "☹ OOPS!!! The description of a " + ErrType + " cannot be empty.";
    }


    @Override
    public String toString() {
        return errMsg();
    }
}
