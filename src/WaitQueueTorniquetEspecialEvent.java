import java.util.Random;

public class WaitQueueTorniquetEspecialEvent extends Event {
	
	private ServerTorniquetEspecial server;

	public WaitQueueTorniquetEspecialEvent(Fan fan, double time, ServerTorniquetEspecial server) {
		super(fan, time);
		this.server = server;
		// TODO Auto-generated constructor stub
	}


	public Event getNextEvent(ServerTorniquet[] servers, Random gen, ServerTorniquetEspecial[] especial_servers, ServerValidarTicket[] serversValidar, ServerValidarTicketEspecial[] serversValidarEspecial) {
		// TODO Auto-generated method stub
		if (this.server.isBeenServed(this.getFan())) {
			
			ServedTorniquetEspecialEvent Event = new ServedTorniquetEspecialEvent(this.getFan(), this.server.getDoneTime(),this.server);
			return Event;
		} else {
			
			WaitQueueTorniquetEspecialEvent Event = new WaitQueueTorniquetEspecialEvent(this.getFan(), this.server.getDoneTime(), server);
    		return Event;
		}
	}

	public void updateStatistics(Statistics statistics) {
		// TODO Auto-generated method stub

	}
	
    public String toString() {
        return String.format("%.3f", this.getTime()) + ' ' + this.getFanID() + " Waits Queue to ServedTorniquetEspecial by: " + this.server.getServerID();
    }

}
