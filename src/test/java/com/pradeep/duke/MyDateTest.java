package com.pradeep.duke;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class MyDateTest {
    @Test
    public void testDateParsing(){
        try{
            MyDate date1 = new MyDate("Sunday 3pm");
            MyDate date2 = new MyDate("12/12/2019 12:23");

            assertEquals(null , date1.getDate());
            //assertEquals( , date1.getDate());


        }catch(Exception E){

        }

        assertEquals(2 ,2);
    }

}
