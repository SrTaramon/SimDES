import java.util.Random;

public class WaitQueueTorniquetEvent extends Event {

	private Server server;

	public WaitQueueTorniquetEvent(Fan fan, double time, Server server) {
		super(fan, time);
		this.server = server;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Event getNextEvent(Server[] servers, Random gen, EspecialServer[] especial_servers) {
		
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
