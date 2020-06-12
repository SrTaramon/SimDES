public class Fan {

    /**
     * Counter integer that generates CustomerID in a non-repetitive way.
     */
    private static int counter = 1;

    /**
     * CustomerID  that allows distinguishing between 2 customers.
     */
    private final int fanID;

    /**
     * Time when the customer first arrives.
     */
    private final double time;

    /**
     * Creates Customer.
     * @param time randomised arrival time of customer
     */

    public Fan(double time) {
        this.fanID = counter;
        this.time = time;
        counter++;
    }

    public int getFanID() {
        return this.fanID;
    }

    public double getTime() {
        return this.time;
    }

}