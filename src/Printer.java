import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Printer {
    private int phase;
    private int numberOfWeeks;
    private int startDay;
    private int startMonth;
    private int endDay;
    private int endMonth;

    public Printer(int phase, int numberOfWeeks, int startDay, int startMonth, int endDay, int endMonth) {
        this.phase=phase;
        this.numberOfWeeks=numberOfWeeks;
        this.startDay=startDay;
        this.startMonth=startMonth;
        this.endDay=endDay;
        this.endMonth=endMonth;
    }

    public void print() throws ParseException {
        int week=1;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM");
        Date start = dateFormat.parse(startDay+"-"+startMonth);

        Calendar cal = Calendar.getInstance();
        cal.setTime(start);
        System.out.print("Week #"+week+" - "+"Test"+" - from "+(cal.get(Calendar.DAY_OF_MONTH))+" "+convertMonth(cal.get(Calendar.MONTH))+" to ");
        cal.add(Calendar.WEEK_OF_YEAR, 1);
        cal.get(Calendar.DAY_OF_MONTH);

        System.out.println((cal.get(Calendar.DAY_OF_MONTH)-1)+" "+convertMonth(cal.get(Calendar.MONTH)));
        week++;
        System.out.print("Week #"+week+" - "+"Test"+" - from "+(cal.get(Calendar.DAY_OF_MONTH))+" "+convertMonth(cal.get(Calendar.MONTH))+" to ");
        cal.add(Calendar.WEEK_OF_YEAR, 1);
        cal.get(Calendar.DAY_OF_MONTH);
        System.out.println((cal.get(Calendar.DAY_OF_MONTH)-1)+" "+convertMonth(cal.get(Calendar.MONTH)));

    }

    private String convertMonth(int i) {
        return switch (i+1) {
            case 1 -> "January";
            case 2 -> "February";
            case 3 -> "March";
            case 4 -> "April";
            case 5 -> "May";
            case 6 -> "June";
            case 7 -> "July";
            case 8 -> "August";
            case 9 -> "September";
            case 10 -> "October";
            case 11 -> "November";
            case 12 -> "December";
            default -> "Invalid month";
        };
    }


}
