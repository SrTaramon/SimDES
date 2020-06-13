import java.util.Random;

public class WaitQueueValidarTicketEvent extends Event {
	private ServerValidarTicket server;

	public WaitQueueValidarTicketEvent(Fan fan, double time, ServerValidarTicket server) {
		super(fan, time);
		this.server = server;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Event getNextEvent(ServerTorniquet[] servers, Random gen, ServerTorniquetEspecial[] especial_servers, ServerValidarTicket[] serversValidar, ServerValidarTicketEspecial[] serversValidarEspecial) {
		
		if (this.server.isBeenServed(this.getFan())) {
			
			ServedValidarTicketEvent Event = new ServedValidarTicketEvent(this.getFan(), this.server.getDoneTime(),this.server);
			this.server.setServedEvent(Event);
			return Event;
		} else {
			
			WaitQueueValidarTicketEvent Event = new WaitQueueValidarTicketEvent(this.getFan(), this.server.getDoneTime(), server);
    		this.server.setWaitEvent(Event);
    		return Event;
		}
	}

	@Override
	public void updateStatistics(Statistics statistics) {
		// TODO Auto-generated method stub

	}
}
