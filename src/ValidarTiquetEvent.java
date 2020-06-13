import java.util.Random;

public class ValidarTiquetEvent extends Event {

	public ValidarTiquetEvent(Fan fan, double time) {
		super(fan, time);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Event getNextEvent(ServerTorniquet[] servers, Random gen, ServerTorniquetEspecial[] especial_servers) {
		
		if (this.getFan().isEspecial()) { // MIra si el clinet Es especial o no
        	
        	// Cas on el client es especial i necessita passar per la cua especial
        	ServerTorniquetEspecial freeEspecialServer = getFreeEspecialServer(especial_servers);
        	if (freeEspecialServer.isAvailable()) {
        		
        		//No Hi ha ningu a la cua 
        		ServedValidarTicketEspecialEvent Event = createServedValidarTicketEspecialEvent(freeEspecialServer);
        		freeEspecialServer.setServedEvent(Event);
        		return Event;
        		
        	} else {
        		
        		//Si Hi ha algu a la cua i es te que esperar a que s'acabi.
        		WaitQueueValidarTicketEspecialEvent Event = createWaitQueueValidarTicketEspecialEvent(freeEspecialServer);
        		freeEspecialServer.setWaitEvent(Event);
        		return Event;
        		
        	}
        } else {
        	
        	// Cas on el client NO es especial i necessita passar per la cua 
        	ServerTorniquet freeServer = getFreeServer(servers);
        	if (freeServer.isAvailable()) {
        		
        		//No Hi ha ningu a la cua 
        		ServedValidarTicketEvent Event = createServedValidarTicketEvent(freeServer);
        		freeServer.setServedEvent(Event);
        		return Event;
        		
        		
        	} else {
        		
        		//Si Hi ha algu a la cua i es te que esperar a que s'acabi.
        		WaitQueueValidarTicketEvent Event = createWaitQueueValidarTicketEvent(freeServer);
        		freeServer.setWaitEvent(Event);
        		return Event;
        		
        	}
        }
	}
	
	
    private ServedValidarTicketEspecialEvent createServedValidarTicketEspecialEvent(ServerTorniquetEspecial server) {
		// TODO Auto-generated method stub
		return new ServedValidarTicketEspecialEvent(this.getFan(), this.getTime(), server);
	}
    
    private WaitQueueValidarTicketEspecialEvent createWaitQueueValidarTicketEspecialEvent(ServerTorniquetEspecial server) {
		// TODO Auto-generated method stub
		return new WaitQueueValidarTicketEspecialEvent(this.getFan(), this.getTime(), server);
	}

    private ServedValidarTicketEvent createServedValidarTicketEvent(ServerTorniquet server) {
		// TODO Auto-generated method stub
		return new ServedValidarTicketEvent(this.getFan(), this.getTime(), server);
	}
    
    private WaitQueueValidarTicketEvent createWaitQueueValidarTicketEvent(ServerTorniquet server) {
		// TODO Auto-generated method stub
		return new WaitQueueValidarTicketEvent(this.getFan(), this.getTime(), server);
	}

	@Override
	public void updateStatistics(Statistics statistics) {
		// TODO Auto-generated method stub

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
	 
    public ServerTorniquetEspecial getFreeEspecialServer(ServerTorniquetEspecial[] servers) {
	   	// Encara s'ha de fer
		return null;
	    	
    }

}
