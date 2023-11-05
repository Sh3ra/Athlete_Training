import java.text.ParseException;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Athlete_Training {
    public static void main(String[] args) throws ParseException {
        //take input
        Scanner scanner = new Scanner(System.in);

        System.out.print("Plan Start Date : ");
        String startDate = scanner.nextLine();

        System.out.print("Race Date : ");
        String raceDate = scanner.nextLine();

        Scheduler scheduler =new Scheduler(startDate,raceDate);
        int numberOfWeeks = scheduler.getNumberOfWeeks();

        //validate input mora than or equal 8 weeks
        if(numberOfWeeks < 8)
        {
            System.out.println("Number of weeks less than expected(8)");
            return;
        }

        //check in which phase
        //  Phase1: 8 weeks (weeks%8 == 0) -> normal
        //  Phase2: 9 weeks (weeks%8 == 1||5) -> 1 filler week
        //  Phase3: 10 weeks (weeks%8 == 2||6) -> 1st test week in 1st recovery, 2nd test week in 1st build 1
        //  Phase4: 11 weeks (weeks%8 == 3||7) -> 2nd test week in 1st recovery

       scheduler.print();


        //print weeks
    }
}