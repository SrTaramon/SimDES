import java.util.Random;

public class WaitQueueValidarTicketEspecialEvent extends Event {
	
	private ServerValidarTicketEspecial server;

	public WaitQueueValidarTicketEspecialEvent(Fan fan, double time, ServerValidarTicketEspecial server) {
		super(fan, time);
		this.server = server;
		// TODO Auto-generated constructor stub
	}


	public Event getNextEvent(ServerTorniquet[] servers, Random gen, ServerTorniquetEspecial[] especial_servers, ServerValidarTicket[] serversValidar, ServerValidarTicketEspecial[] serversValidarEspecial) {
		
		// En aquest cas al ser un esecial tardarà una mica mes de lo normal.
		if (this.server.isBeenServed(this.getFan())) {
			
			ServedValidarTicketEspecialEvent Event = new ServedValidarTicketEspecialEvent(this.getFan(), this.server.getDoneTime(),this.server);
			return Event;
		} else {
			
			WaitQueueValidarTicketEspecialEvent Event = new WaitQueueValidarTicketEspecialEvent(this.getFan(), this.server.getDoneTime(), server);
    		return Event;
		}
	}

	@Override
	public void updateStatistics(Statistics statistics) {
		// TODO Auto-generated method stub
		
	}
	
    public String toString() {
        return String.format("%.3f", this.getTime()) + ' ' + this.getFanID() + " Waits Queue to ServedValidarTicketEspecial by: " + this.server.getServerID(); 
    }

}
