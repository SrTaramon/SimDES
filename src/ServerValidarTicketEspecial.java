import java.util.Queue;

class ServerValidarTicketEspecial {
    /**
     * Counter integer that generates ServerID in a non-repetitive way.
     */
    private static int counter = 1;
    /**
     * CustomerID  that allows distinguishing between 2 servers.
     */
    private int serverID;

    private double lastServerTime = 0;

    private Queue<Event> Cua = null;

    /**
     * Creates a server.
     */
    public ServerValidarTicketEspecial() {
        this.serverID = counter;
        counter++;
    }

    public int getServerID() {
        return this.serverID;
    }

    /**
     * Causes the first slot inside the Server to be occupied.
     * Or updates the service status of the customer in the first slot.
     * @param newEvent the status of the customer being served
     * in the form of an event.
     */
    public void setServedEventLastTime(double lastserverime) {
        this.lastServerTime = lastserverime;
    }

    /**
     * Checks whether the first slot inside the Server has been taken.
     * @return true if first slot has not been taken, false otherwise.
     */
    public int getCuaSize() {
        return Cua.size();
    }

    /**
     * Clears up the 2nd slot of the server. 
     * This is done by removing up the 2nd customer to the 1st slot.
     * and replace the 2nd slot with null status.
     */
    public void flushDoneEvent() {
    	Cua.poll();
    }

    /**
     * Gets the timestamp at which a customer waiting can expect to be served.
     * @return earliest possible time at which waiting customer can be served
     */
    public double getDoneTime() {
        return this.lastServerTime;
    }

	public void addWaitEvent(Event event) {
		// TODO Auto-generated method stub
		Cua.add(event);
		
	}

	public boolean isAvailable() {
		// TODO Auto-generated method stub
		return (Cua.size() == 0);
	}

	public boolean isBeenServed(Fan fan) {
		// TODO Auto-generated method stub
		if (Cua.peek().getFanID() == fan.getFanID()) {
			return true;
		}
		return false;
	}
}