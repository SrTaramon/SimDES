import java.util.Random;

public class ValidarTiquetEvent extends Event {

	public ValidarTiquetEvent(Fan fan, double time) {
		super(fan, time);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Event getNextEvent(ServerTorniquet[] servers, Random gen, ServerTorniquetEspecial[] especial_servers, ServerValidarTicket[] serversValidar, ServerValidarTicketEspecial[] serversValidarEspecial) {
		
		if (this.getFan().isEspecial()) { // MIra si el clinet Es especial o no
        	
        	// Cas on el client es especial i necessita passar per la cua especial
			ServerValidarTicketEspecial freeEspecialServer = getFreeEspecialServerValidar(serversValidarEspecial);
        	if (freeEspecialServer.isAvailable()) {
        		
        		//No Hi ha ningu a la cua 
        		ServedValidarTicketEspecialEvent Event = createServedValidarTicketEspecialEvent(freeEspecialServer);
        		freeEspecialServer.addWaitEvent(Event);
        		return Event;
        		
        	} else {
        		
        		//Si Hi ha algu a la cua i es te que esperar a que s'acabi.
        		WaitQueueValidarTicketEspecialEvent Event = createWaitQueueValidarTicketEspecialEvent(freeEspecialServer);
        		freeEspecialServer.addWaitEvent(Event);
        		return Event;
        		
        	}
        } else {
        	
        	// Cas on el client NO es especial i necessita passar per la cua 
        	ServerValidarTicket freeServer = getFreeServerValidar(serversValidar);
        	if (freeServer.isAvailable()) {
        		
        		//No Hi ha ningu a la cua 
        		ServedValidarTicketEvent Event = createServedValidarTicketEvent(freeServer);
        		freeServer.addWaitEvent(Event);
        		return Event;
        		
        		
        	} else {
        		
        		//Si Hi ha algu a la cua i es te que esperar a que s'acabi.
        		WaitQueueValidarTicketEvent Event = createWaitQueueValidarTicketEvent(freeServer);
        		freeServer.addWaitEvent(Event);
        		return Event;
        		
        	}
        }
	}
	
	



	private ServedValidarTicketEspecialEvent createServedValidarTicketEspecialEvent(ServerValidarTicketEspecial server) {
		// TODO Auto-generated method stub
		return new ServedValidarTicketEspecialEvent(this.getFan(), this.getTime(), server);
	}
    
    private WaitQueueValidarTicketEspecialEvent createWaitQueueValidarTicketEspecialEvent(ServerValidarTicketEspecial server) {
		// TODO Auto-generated method stub
		return new WaitQueueValidarTicketEspecialEvent(this.getFan(), this.getTime(), server);
	}

    private ServedValidarTicketEvent createServedValidarTicketEvent(ServerValidarTicket server) {
		// TODO Auto-generated method stub
		return new ServedValidarTicketEvent(this.getFan(), this.getTime(), server);
	}
    
    private WaitQueueValidarTicketEvent createWaitQueueValidarTicketEvent(ServerValidarTicket server) {
		// TODO Auto-generated method stub
		return new WaitQueueValidarTicketEvent(this.getFan(), this.getTime(), server);
	}

	@Override
	public void updateStatistics(Statistics statistics) {
		// TODO Auto-generated method stub

	}

	private ServerValidarTicket getFreeServerValidar(ServerValidarTicket[] serversValidar) {
    	int minimSizeCua = 9999;
    	ServerValidarTicket choiceServer = null;
        for (int i = 0; i < serversValidar.length; i++) {
        	ServerValidarTicket newServer = serversValidar[i];
            if (newServer.isAvailable()) {
                return newServer;
            } else if (newServer.getCuaSize() < minimSizeCua) {
            	minimSizeCua = newServer.getCuaSize();
                choiceServer = newServer;
            }
        }
	    return choiceServer;
	}
    
    private ServerValidarTicketEspecial getFreeEspecialServerValidar(ServerValidarTicketEspecial[] serversValidarEspecial) {
        int minimSizeCua = 9999;
        ServerValidarTicketEspecial choiceServer = null;
        for (int i = 0; i < serversValidarEspecial.length; i++) {
        	ServerValidarTicketEspecial newServer = serversValidarEspecial[i];
            if (newServer.isAvailable()) {
                return newServer;
            } else if (newServer.getCuaSize() < minimSizeCua) {
            	minimSizeCua = newServer.getCuaSize();
                choiceServer = newServer;
            }
        }
	    return choiceServer;
	}
    
    public String toString() {
        return String.format("%.3f", this.getTime()) + ' ' + this.getFanID() + " Valida Tiquet";
    }

}
