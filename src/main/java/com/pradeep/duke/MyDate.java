package com.pradeep.duke;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Date wrapper class for having a date object and string date
 */
public class MyDate {

    private Date date = null;
    private String dateStr;

    /**
     * Constructor for class
     * @throws ParseException
     */
    public MyDate(String s) throws ParseException {

        this.dateStr = s;

        parseString(s);


    }

    /**
     * Parses the string date received into a Date object if possible. Otherwise string format is used
     * @param dateBy String variable which represents the date.
     * @throws NumberFormatException , ArrayIndexOutOfBoundsException
     */
    public void parseString(String dateBy) throws ParseException , NumberFormatException , ArrayIndexOutOfBoundsException{

        try {

            String []dates = dateBy.split(" ");
            int time = Integer.parseInt(dates[1]);
            int hour = time/100;
            int min = time%100;

            String dateInStringForm = dates[0] + " " + String.valueOf(hour) + ":" + String.valueOf(min);

            this.date =  new SimpleDateFormat("dd/MM/yyyy hh:mm").parse(dateInStringForm);



        } catch (Exception e) {

        }


    }

    /**
     * Returns the date object
     * @return Date object of the Task
     */
    public Date getDate(){
        return this.date;

    }

    @Override
    public String toString() {
        return dateStr;
    }
}
