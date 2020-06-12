import java.util.Random;

import acm.util.RandomGenerator;

public class ArrivalVestibolSortida extends Event {
	
	
	/**
     * Creates an ArrivalEvent.
     * 
     * @param customer customer that the event is involving.
     * @param time     time at which event is created.
     */
    public ArrivalVestibolSortida(Fan fan, double time) {
        super(fan, time);
    }

    /**
     * Creates the next event based on the availability of servers. The available
     * server will be updated to hold a field of the event and be involved in the
     * creation of new event.
     * 
     * @param servers Array of servers to be checked
     * @param gen     RandomGenerator, not used in this case.
     * @return parent class Event, which could be in the form of LeaveEvent, if
     *         there are no available servers. ServedEvent, if there exists an
     *         available server that is completely free. WaitEvent, if there exists
     *         available server and there are no empty servers. null, which won't be
     *         reached as it's a Debugging statement.
     */
    public Event getNextEvent(Server[] servers, Random gen) {
        Server freeServer = getFreeServer(servers);
    	
        // IMPORTANT Fer que el server tingui una fucniao on mira si la cua del vips pot passar or not. 
        
        if (this.getFan().isVIP() == true) { // Fan que s VIP, Llavors passa per la cua vip
        	WaitEventVipQueue WaitVipQueue = createWaitVipQueue(freeServer);
            return WaitVipQueue;
          
        } else {
        	WaitEventQueue WaitVipQueue = createWaitQueue(freeServer);
            return WaitVipQueue;
        }

        
//        else if (freeServer.canTakeServedEvent()) {
//        	TorniquetSortida newEvent = createServedEvent(freeServer);
//            freeServer.setServedEvent(newEvent);
//            return newEvent;
//        } else if (freeServer.canTakeWaitEvent()) {
//            WaitEvent newEvent = createWaitEvent(freeServer);
//            freeServer.setWaitEvent(newEvent);
//            return newEvent;
//        } else {
//            System.out.println("Bug in ArrivalEvents");
//            return null;
//        }
    }

    public WaitEventVipQueue createWaitVipQueue(Server freeServer) {
		// TODO Auto-generated method stub
		return new WaitEventVipQueue(this.getFan(), this.getTime());
	}
    
    public WaitEventQueue createWaitQueue(Server freeServer) {
		// TODO Auto-generated method stub
		return new WaitEventQueue(this.getFan(), this.getTime());
	}

//	/**
//     * Creates a LeaveEvent not bounded to any server.
//     * 
//     * @return LeaveEvent
//     */
//    public LeaveEvent createLeaveEvent() {
//        return new LeaveEvent(this.getCustomer(), this.getTime());
//    }
//
//    /**
//     * Creates a ServedEvent bounded to an empty server.
//     * 
//     * @param freeServer the server that is empty.
//     * @return ServedEvent.
//     */
//    public ServedEvent createServedEvent(Server freeServer) {
//        return new ServedEvent(this.getCustomer(), this.getTime(), freeServer);
//    }
//
//    /**
//     * Creates a WaitEvent bounded to a partially occupied server.
//     * 
//     * @param freeServer the server that is partially occupied.
//     * @return WaitEvent.
//     */
//    public WaitEvent createWaitEvent(Server freeServer) {
//        return new WaitEvent(this.getCustomer(), this.getTime(), freeServer);
//    }

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