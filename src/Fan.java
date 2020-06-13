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
     * CustomerID  that allows distinguishing between 2 customers.
     */
    private static boolean Billet;
    
    /**
     * CustomerID  that allows distinguishing between 2 customers.
     */
    private static boolean HaVistPartit;
    
    /**
     * CustomerID  that allows distinguishing between 2 customers.
     */
    private static boolean Especial;

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

	public boolean isBillet() {
		return Billet;
	}

	public boolean isEspecial() {
		return Especial;
	}

	public boolean isHaVistPartit() {
		return HaVistPartit;
	}

	public static void setHaVistPartit(boolean haVistPartit) {
		HaVistPartit = haVistPartit;
	}

}