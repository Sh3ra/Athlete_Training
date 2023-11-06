import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalenderHelper {
    static int getYear(String startDate) {
        int indx = startDate.length() - 4;
        int ans = 0;
        while (indx < startDate.length()) {
            ans *= 10;
            ans += startDate.charAt(indx++) - '0';
        }
        return ans;
    }

    static int getDay(String raceDate) {
        int indx = 0;
        int ans = 0;
        while (!(raceDate.charAt(indx) >= '0' && raceDate.charAt(indx) <= '9'))
            indx++;
        ans += raceDate.charAt(indx) - '0';
        if (raceDate.charAt(indx + 1) >= '0' && raceDate.charAt(indx + 1) <= '9') {
            ans *= 10;
            ans += raceDate.charAt(indx + 1) - '0';
        }
        return ans;
    }

    static int getMonth(String startDate) {
        int indx = startDate.length() - 6;
        StringBuilder temp = new StringBuilder();
        while (startDate.charAt(indx) != ' ')
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

    static int getWeeks(Date start, Date end) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(start);
        int weeks = 0;
        while (cal.getTime().before(end)) {
            cal.add(Calendar.WEEK_OF_YEAR, 1);
            weeks++;
        }
        return weeks;
    }

    static String convertMonth(int i) {
        return switch (i + 1) {
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
