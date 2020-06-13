class EspecialServer {
    /**
     * Counter integer that generates ServerID in a non-repetitive way.
     */
    private static int counter = 1;
    /**
     * CustomerID  that allows distinguishing between 2 servers.
     */
    private int serverID;

    /**
     * the first event being resolved by the server.
     */
    private Event served = null;

    /**
     * the second event being resolved by the server.
     */
    private Event wait = null;

    /**
     * Creates a server.
     */
    public EspecialServer() {
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
    public void setServedEvent(Event newEvent) {
        this.served = newEvent;
    }

    /**
     * Causes the second slot inside the Server to be occupied.
     * Or updates the service status of the customer in the second slot.
     * @param newEvent the status of the customer being served
     * in the form of an event.
     */
    public void setWaitEvent(Event newEvent) {
        this.wait = newEvent;
    }

    /**
     * Checks whether the first slot inside the Server has been taken.
     * @return true if first slot has not been taken, false otherwise.
     */
    public boolean canTakeServedEvent() {
        return (served == null && wait == null);
    }

    /**
     * Checks whether the second slot inside the Server has been taken.
     * @return true if the second slot has not been and the first slot is taken,
     * false otherwise.
     */
    public boolean canTakeWaitEvent() {
        return (served != null && wait == null);
    }

    /**
     * Clears up the 2nd slot of the server. 
     * This is done by removing up the 2nd customer to the 1st slot.
     * and replace the 2nd slot with null status.
     */
    public void flushDoneEvent() {
        if (served != null) {
            served = null;
        }
        if (wait != null) {
            served = wait;
            wait = null;
        }
    }

    /**
     * Gets the timestamp at which a customer waiting can expect to be served.
     * @return earliest possible time at which waiting customer can be served
     */
    public double getDoneTime() {
        return this.served.getTime();
    }
}