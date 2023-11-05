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

    public void print() {
        System.out.println(numberOfWeeks);
        System.out.println(phase);
    }
}
