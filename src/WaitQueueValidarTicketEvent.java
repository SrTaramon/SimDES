import java.util.Random;

public class WaitQueueValidarTicketEvent extends Event {
	private ServerTorniquet server;

	public WaitQueueValidarTicketEvent(Fan fan, double time, ServerTorniquet server) {
		super(fan, time);
		this.server = server;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Event getNextEvent(ServerTorniquet[] servers, Random gen, ServerTorniquetEspecial[] especial_servers, ServerValidarTicket[] serversValidar, ServerValidarTicketEspecial[] serversValidarEspecial) {
		
		if (this.server.isBeenServed(this.getFan())) {
			
			ServedTorniquetEvent Event = new ServedTorniquetEvent(this.getFan(), this.server.getDoneTime(),this.server);
			this.server.setServedEvent(Event);
			return Event;
		} else {
			
			WaitQueueTorniquetEvent Event = new WaitQueueTorniquetEvent(this.getFan(), this.server.getDoneTime(), server);
    		this.server.setWaitEvent(Event);
    		return Event;
		}
	}

	@Override
	public void updateStatistics(Statistics statistics) {
		// TODO Auto-generated method stub

	}
}
