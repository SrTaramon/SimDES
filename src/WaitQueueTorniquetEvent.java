import java.util.Random;

public class WaitQueueTorniquetEvent extends Event {

	private ServerTorniquet server;

	public WaitQueueTorniquetEvent(Fan fan, double time, ServerTorniquet server) {
		super(fan, time);
		this.server = server;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Event getNextEvent(ServerTorniquet[] servers, Random gen, ServerTorniquetEspecial[] especial_servers, ServerValidarTicket[] serversValidar, ServerValidarTicketEspecial[] serversValidarEspecial) {
		
		if (this.server.isBeenServed(this.getFan())) {
			
			ServedTorniquetEvent Event = new ServedTorniquetEvent(this.getFan(), this.server.getDoneTime(),this.server);
			return Event;
		} else {
			
			WaitQueueTorniquetEvent Event = new WaitQueueTorniquetEvent(this.getFan(), this.server.getDoneTime(), server);
    		return Event;
		}
	}

	@Override
	public void updateStatistics(Statistics statistics) {
		// TODO Auto-generated method stub

	}
	
    public String toString() {
        return String.format("%.3f", this.getTime()) + ' ' + this.getFanID() + " Waits Queue to ServedTorniquet by: " + this.server.getServerID();
    }

}
