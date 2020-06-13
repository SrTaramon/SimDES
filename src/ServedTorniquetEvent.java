import java.util.Random;

public class ServedTorniquetEvent extends Event {

	private Server server;

	public ServedTorniquetEvent(Fan fan, double time, Server server) {
		super(fan, time);
		this.server = server;
		// TODO Auto-generated constructor stub
	}


	public Event getNextEvent(Server[] servers, Random gen, EspecialServer[] especial_servers) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateStatistics(Statistics statistics) {
		// TODO Auto-generated method stub

	}

}
