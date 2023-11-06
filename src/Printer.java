import java.util.*;

public class Printer {
    private final int phase;
    private final int numberOfWeeks;
    private final Date firstDate;
    private final List<String> mainWeeks;

    public Printer(int phase, int numberOfWeeks, Date firstDate) {
        this.phase = phase;
        this.numberOfWeeks = numberOfWeeks;
        this.firstDate = firstDate;
        mainWeeks = Arrays.asList("Recovery", "Build1", "Build2", "Key");
    }

    public void print() {
        int week = 1;
        Calendar cal = Calendar.getInstance();
        cal.setTime(firstDate);
        printWeek(week++, "Test", cal);
        printWeek(week++, "Test", cal);
        int indx = 0;
        switch (phase) {
            case 2: {
                printWeek(week++, "Filler", cal);
                break;
            }
            case 3: {
                indx = 2;
                break;
            }
            case 4: {
                indx = 1;
                break;
            }
        }
        while (week <= numberOfWeeks - 2) {
            printWeek(week++, mainWeeks.get(indx++), cal);
            indx %= mainWeeks.size();
        }
        printWeek(week++, "Taper", cal);
        printWeek(week, "Race", cal);
    }

    void printWeek(int week, String weekName, Calendar cal) {
        System.out.print("Week #" + week + " - " + weekName + " - from " + (cal.get(Calendar.DAY_OF_MONTH)) + " " + CalenderHelper.convertMonth(cal.get(Calendar.MONTH)) + " to ");
        cal.add(Calendar.WEEK_OF_YEAR, 1);
        cal.add(Calendar.DAY_OF_YEAR, -1);
        System.out.println((cal.get(Calendar.DAY_OF_MONTH)) + " " + CalenderHelper.convertMonth(cal.get(Calendar.MONTH)));
        cal.add(Calendar.DAY_OF_YEAR, 1);
    }
}
