import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDate {

    private Date date;
    private String dateStr;

    MyDate(String s) throws ParseException {

        this.dateStr = s;

        parseString(s);


    }

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
    public Date getDate(){
        return this.date;

    }

    @Override
    public String toString() {
        return dateStr;
    }
}
