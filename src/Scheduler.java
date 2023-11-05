import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Scheduler {
    private final String startDate;
    private final String raceDate;
    private int numberOfWeeks;
    private int phase;
    private int startDay;
    private int startMonth;
    private int endDay;
    private int endMonth;


    public Scheduler (String startDate,String raceDate) throws ParseException {
        this.startDate=startDate;
        this.raceDate=raceDate;
        CalculateWeeks();

    }

    public int getWeeks(Date start, Date end) {
        Calendar a = new GregorianCalendar();
        Calendar b = new GregorianCalendar();

        a.setTime(start);
        b.setTime(end);

        return b.get(Calendar.WEEK_OF_YEAR) - a.get(Calendar.WEEK_OF_YEAR);
    }

    private void CalculateWeeks() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        int year=getYear(startDate);
        int month=getMonth(startDate);
        int day=getDay(startDate);
        startDay=day;
        startMonth=month;

        Date start = dateFormat.parse(year+"-"+month+"-"+day);

        int year2=getYear(raceDate);
        month=getMonth(raceDate);
        day=getDay(raceDate);
        endDay=day;
        endMonth=month;

        Date end = dateFormat.parse(year2+"-"+month+"-"+day);
        numberOfWeeks = getWeeks(start,end);

        switch (numberOfWeeks%8){
            case 0:{
                phase=1;
                break;
            }
            case 1:
            case 5:{
                phase=2;
                break;
            }
            case 2:
            case 6:{
                phase = 3;
                break;
            }
            case 3:
            case 7:{
                phase = 4;
                break;
            }
        }
    }

    private int getDay(String raceDate) {
        int indx=0;
        int ans=0;
        while(!(raceDate.charAt(indx)>='0' && raceDate.charAt(indx)<='9'))
            indx++;
        ans+=raceDate.charAt(indx)-'0';
        if(raceDate.charAt(indx+1)>='0' && raceDate.charAt(indx+1)<='9')
        {
            ans*=10;
            ans+=raceDate.charAt(indx+1)-'0';
        }
        return ans;
    }

    private int getMonth(String startDate) {
        int indx=startDate.length()-6;
        StringBuilder temp= new StringBuilder();
        while(startDate.charAt(indx)!=' ')
            temp.insert(0, startDate.charAt(indx--));
        return switch (temp.toString().toUpperCase()) {
            case "JANUARY" -> 1;
            case "FEBRUARY" -> 2;
            case "MARCH" -> 3;
            case "APRIL" -> 4;
            case "MAY" -> 5;
            case "JUNE" -> 6;
            case "JULY" -> 7;
            case "AUGUST" -> 8;
            case "SEPTEMBER" -> 9;
            case "OCTOBER" -> 10;
            case "NOVEMBER" -> 11;
            case "DECEMBER" -> 12;
            default -> 0;
        };
    }

    private int getYear(String startDate) {
        int indx=startDate.length()-1;
        int ans=0;
        while(startDate.charAt(indx)!=' ')
        {
            ans*=10;
            ans+=startDate.charAt(indx--)-'0';
        }
        return ans;
    }

    public int getNumberOfWeeks() {
        return numberOfWeeks;
    }

    public void print() {
        Printer printer = new Printer(phase, numberOfWeeks, startDay, startMonth, endDay, endMonth);
        printer.print();
    }
}
