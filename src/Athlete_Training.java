import java.text.ParseException;
import java.util.Scanner;


public class Athlete_Training {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Plan Start Date : ");
        String startDate = scanner.nextLine();
        System.out.print("Race Date : ");
        String raceDate = scanner.nextLine();
        Scheduler scheduler = new Scheduler(startDate, raceDate);
        int numberOfWeeks = scheduler.getNumberOfWeeks();
        if (numberOfWeeks < 8) {
            System.out.println("Number of weeks less than expected(8)");
            return;
        }
        scheduler.print();
    }
}