
/**
 * Statistics class to keep track of total waiting time of customers.
 * the number of customers who left without being served.
 * the number of customers who are served.
 */
public class Statistics {
    private double waitingTime = 0;
    private int numLeft = 0;
    private int numServed = 0;

    /**
     * Creates Statistics object using the empty constructor.
     */
    public Statistics(){}

    /**
     * Increases the number of customers who are served.
     */
    public void increaseServed() {
        numServed++;
    }

    /**
     * Increases waiting time of customers.
     */
    public void increaseWaitingTime(double time) {
        waitingTime += time;
    }

    /**
     * Increases the number of customers who left without being served.
     */
    public void increaseLeft() {
        numLeft++;
    }

    /**
     * Formats the Statistics to print all information gathered.
     */
    public String toString() {
        double x = waitingTime / numServed;
        return '[' + String.format("%.3f",x) + ' ' + 
            numServed + ' ' + numLeft + ']';
    }
}