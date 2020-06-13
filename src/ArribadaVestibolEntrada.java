import java.util.Random;

public class ArribadaVestibolEntrada extends Event{

	public ArribadaVestibolEntrada(Fan fan, double time) {
		super(fan, time);
		// TODO Auto-generated constructor stub
	}
	
	
	public Event getNextEvent(ServerTorniquet[] servers, Random gen, ServerTorniquetEspecial[] especial_servers, ServerValidarTicket[] serversValidar, ServerValidarTicketEspecial[] serversValidarEspecial) {
		if (this.getFan().isHaVistPartit()) { //COndicio perque el fan sorti del sistema
        	//fer event Validar tiquet
			if (this.getFan().isBillet()) {
				return new ValidarTiquetEvent(this.getFan(), this.getTime());
			} else {
				return new ComprarTiquetEvent(this.getFan(), this.getTime());
			}
			
        } else {
        	return new PartitEvent(this.getFan(), this.getTime());
        }
	}

//    /**
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
