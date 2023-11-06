import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Scheduler {
    private final String startDate;
    private final String raceDate;
    private int numberOfWeeks;
    private int phase;
    private Date firstDate;


    public Scheduler(String startDate, String raceDate) throws ParseException {
        this.startDate = startDate;
        this.raceDate = raceDate;
        CalculateWeeks();
    }

    private void CalculateWeeks() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        int year = CalenderHelper.getYear(startDate);
        int month = CalenderHelper.getMonth(startDate);
        int day = CalenderHelper.getDay(startDate);

        firstDate = dateFormat.parse(year + "-" + month + "-" + day);
        year = CalenderHelper.getYear(raceDate);
        month = CalenderHelper.getMonth(raceDate);
        day = CalenderHelper.getDay(raceDate);
        Date end = dateFormat.parse(year + "-" + month + "-" + day);
        numberOfWeeks = CalenderHelper.getWeeks(firstDate, end);
        calculatePhase();
    }

    private void calculatePhase() {
        switch (numberOfWeeks % 8) {
            case 0: {
                phase = 1;
                break;
            }
            case 1:
            case 5: {
                phase = 2;
                break;
            }
            case 2:
            case 6: {
                phase = 3;
                break;
            }
            case 3:
            case 7: {
                phase = 4;
                break;
            }
        }
    }

    public int getNumberOfWeeks() {
        return numberOfWeeks;
    }

    public void print() {
        Printer printer = new Printer(phase, numberOfWeeks, firstDate);
        printer.print();
    }
}
