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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateStatistics(Statistics statistics) {
		// TODO Auto-generated method stub

	}

}
