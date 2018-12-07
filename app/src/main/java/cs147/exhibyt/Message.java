package cs147.exhibyt;

import java.lang.reflect.Array;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static java.util.Arrays.asList;

public class Message {
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    private String textMessage;

    public boolean isNotUser() {
        return isNotUser;
    }

    public void setNotUser(boolean notUser) {
        isNotUser = notUser;
    }

    private boolean isNotUser;

    List<String> monthString = asList("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");

    private void createDate() {
        Calendar c = Calendar.getInstance();
        int month = c.get(Calendar.MONTH);
        int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
        int hour = c.get(Calendar.HOUR);
        int min = c.get(Calendar.MINUTE);
        boolean isAM = (c.get(Calendar.AM_PM) == Calendar.AM);

        //Creating the string
        String timeOfDay = "";
        if (isAM) {
            timeOfDay = "AM";
        } else {
            timeOfDay = "PM";
        }
        this.date = monthString.get(month);
        this.date += " " + Integer.toString(dayOfMonth);
        this.date += " " + Integer.toString(hour) + ":" + Integer.toString(min);
        this.date += " " + timeOfDay;
    }

    public Message(String msg, boolean isNotUser){
        createDate();
        this.textMessage = msg;
        this.isNotUser = isNotUser;
    }


}
