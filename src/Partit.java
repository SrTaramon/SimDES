import java.util.Random;

public class Partit extends Event{

	public Partit(Fan fan, double time) {
		super(fan, time);
		// TODO Auto-generated constructor stub
	}
	
	
	public Event getNextEvent(Server[] servers, Random gen) {
        Server freeServer = getFreeServer(servers);
        if (freeServer == null) {
            return createLeaveEvent();
        } else if (freeServer.canTakeServedEvent()) {
        	TorniquetSortida newEvent = createServedEvent(freeServer);
            freeServer.setServedEvent(newEvent);
            return newEvent;
        } else if (freeServer.canTakeWaitEvent()) {
            WaitEvent newEvent = createWaitEvent(freeServer);
            freeServer.setWaitEvent(newEvent);
            return newEvent;
        } else {
            System.out.println("Bug in ArrivalEvents");
            return null;
        }
        return null;
    }

    /**
     * Creates a LeaveEvent not bounded to any server.
     * 
     * @return LeaveEvent
     */
    public LeaveEvent createLeaveEvent() {
        return new LeaveEvent(this.getCustomer(), this.getTime());
    }

    /**
     * Creates a ServedEvent bounded to an empty server.
     * 
     * @param freeServer the server that is empty.
     * @return ServedEvent.
     */
    public ServedEvent createServedEvent(Server freeServer) {
        return new ServedEvent(this.getCustomer(), this.getTime(), freeServer);
    }

    /**
     * Creates a WaitEvent bounded to a partially occupied server.
     * 
     * @param freeServer the server that is partially occupied.
     * @return WaitEvent.
     */
    public WaitEvent createWaitEvent(Server freeServer) {
        return new WaitEvent(this.getCustomer(), this.getTime(), freeServer);
    }

    /**
     * Modifies information in statistics if required.
     * 
     * @param statistics Not used in this case.
     */
    public void updateStatistics(Statistics statistics) {
        return;
    }

    /**
     * Finds the earliest available server based on search results.
     * 
     * @param servers Array of servers to be checked.
     * @return Server if an empty server or partially empty server is found null
     *         otherwise.
     */
    public Server getFreeServer(Server[] servers) {
        boolean hasFoundSlots = false;
        Server choiceServer = null;
        for (int i = 0; i < servers.length; i++) {
            Server newServer = servers[i];
            if (newServer.canTakeServedEvent()) {
                return newServer;
            } else if (newServer.canTakeWaitEvent() && !hasFoundSlots) {
                choiceServer = newServer;
                hasFoundSlots = true;
            }
        }
        if (hasFoundSlots == false) {
            return null;
        } else {
            return choiceServer;
        }
    }

    /**
     * Formats the ArrivalEvent to print out its profile.
     */
    public String toString() {
        return String.format("%.3f", this.getTime()) + ' ' + this.getFanID() + " arrives";
    }

}
