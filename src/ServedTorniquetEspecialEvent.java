import java.util.Random;

public class ServedTorniquetEspecialEvent extends Event{

	
	private EspecialServer server;

	public ServedTorniquetEspecialEvent(Fan fan, double time, EspecialServer server) {
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
