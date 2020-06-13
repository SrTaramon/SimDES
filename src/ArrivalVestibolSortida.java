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
    public Event getNextEvent(ServerTorniquet[] servers, Random gen, ServerTorniquetEspecial[] especial_servers) {
    	
        
        if (this.getFan().isHaVistPartit()) { //COndicio perque el fan sorti del sistema
        	return createLeaveEvent();
        	
        } else if (this.getFan().isEspecial()) { // MIra si el clinet Es especial o no
        	
        	// Cas on el client es especial i necessita passar per la cua especial
        	ServerTorniquetEspecial freeEspecialServer = getFreeEspecialServer(especial_servers);
        	if (freeEspecialServer.isAvailable()) {
        		
        		//No Hi ha ningu a la cua 
        		ServedTorniquetEspecialEvent Event = createServedTorniquetEspecialEvent(freeEspecialServer);
        		freeEspecialServer.setServedEvent(Event);
        		return Event;
        		
        	} else {
        		
        		//Si Hi ha algu a la cua i es te que esperar a que s'acabi.
        		WaitQueueTorniquetEspecialEvent Event = createWaitQueueTorniquetEspecialEvent(freeEspecialServer);
        		freeEspecialServer.setWaitEvent(Event);
        		return Event;
        		
        	}
        } else {
        	
        	// Cas on el client NO es especial i necessita passar per la cua 
        	ServerTorniquet freeServer = getFreeServer(servers);
        	if (freeServer.isAvailable()) {
        		
        		//No Hi ha ningu a la cua 
        		ServedTorniquetEvent Event = createServedTorniquetEvent(freeServer);
        		freeServer.setServedEvent(Event);
        		return Event;
        		
        		
        	} else {
        		
        		//Si Hi ha algu a la cua i es te que esperar a que s'acabi.
        		WaitQueueTorniquetEvent Event = createWaitQueueTorniquetEvent(freeServer);
        		freeServer.setWaitEvent(Event);
        		return Event;
        		
        	}
        }
    }

    private LeaveEvent createLeaveEvent() {
		// TODO Auto-generated method stub
		return new LeaveEvent(this.getFan(), this.getTime());
	}
    
    private ServedTorniquetEspecialEvent createServedTorniquetEspecialEvent(ServerTorniquetEspecial server) {
		// TODO Auto-generated method stub
		return new ServedTorniquetEspecialEvent(this.getFan(), this.getTime(), server);
	}
    
    private WaitQueueTorniquetEspecialEvent createWaitQueueTorniquetEspecialEvent(ServerTorniquetEspecial server) {
		// TODO Auto-generated method stub
		return new WaitQueueTorniquetEspecialEvent(this.getFan(), this.getTime(), server);
	}

    private ServedTorniquetEvent createServedTorniquetEvent(ServerTorniquet server) {
		// TODO Auto-generated method stub
		return new ServedTorniquetEvent(this.getFan(), this.getTime(), server);
	}
    
    private WaitQueueTorniquetEvent createWaitQueueTorniquetEvent(ServerTorniquet server) {
		// TODO Auto-generated method stub
		return new WaitQueueTorniquetEvent(this.getFan(), this.getTime(), server);
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
    
    public ServerTorniquetEspecial getFreeEspecialServer(ServerTorniquetEspecial[] servers) {
    	// Encara s'ha de fer
		return null;
    	
    }
    
    
    public ServerTorniquet getFreeServer(ServerTorniquet[] servers) {
    	// MOdificar funcio per mirar uina de les cues pot anar. El server mirara si es vip o no.
        boolean hasFoundSlots = false;
        ServerTorniquet choiceServer = null;
        for (int i = 0; i < servers.length; i++) {
        	ServerTorniquet newServer = servers[i];
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