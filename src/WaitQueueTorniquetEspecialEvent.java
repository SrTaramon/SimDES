import java.util.Random;

public class WaitQueueTorniquetEspecialEvent extends Event {
	
	private EspecialServer server;

	public WaitQueueTorniquetEspecialEvent(Fan fan, double time, EspecialServer server) {
		super(fan, time);
		this.server = server;
		// TODO Auto-generated constructor stub
	}


	public Event getNextEvent(Server[] servers, Random gen, EspecialServer[] especial_servers) {
		// TODO Auto-generated method stub
		if (this.server.isBeenServed(this.getFan())) {
			
			ServedTorniquetEspecialEvent Event = new ServedTorniquetEspecialEvent(this.getFan(), this.server.getDoneTime(),this.server);
			this.server.setServedEvent(Event);
			return Event;
		} else {
			
			WaitQueueTorniquetEspecialEvent Event = new WaitQueueTorniquetEspecialEvent(this.getFan(), this.server.getDoneTime(), server);
    		this.server.setWaitEvent(Event);
    		return Event;
		}
	}

	public void updateStatistics(Statistics statistics) {
		// TODO Auto-generated method stub

	}

}
