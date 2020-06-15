import java.util.Random;

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
    private boolean Billet = false;
    
    /**
     * CustomerID  that allows distinguishing between 2 customers.
     */
    private boolean HaVistPartit = false;
    
    /**
     * CustomerID  that allows distinguishing between 2 customers.
     */
    private boolean Especial = false;

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
        HaVistPartit = false;
        Random rn = new Random();
        Especial = rn.nextBoolean();
        Billet = rn.nextBoolean();
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
		//System.out.println(this.fanID + " " + HaVistPartit);
		return HaVistPartit;
	}

	public void setHaVistPartit(boolean haVistPartit) {
		HaVistPartit = haVistPartit;
	}
	
	public void setBillet(boolean billet) {
		Billet = billet;
	}

}