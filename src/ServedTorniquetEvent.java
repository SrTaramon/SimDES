import java.util.Random;

public class ServedTorniquetEvent extends Event {

	private Server server;

	public ServedTorniquetEvent(Fan fan, double time, Server server) {
		super(fan, time);
		this.server = server;
		// TODO Auto-generated constructor stub
	}


	public Event getNextEvent(Server[] servers, Random gen, EspecialServer[] especial_servers) {

		// En aquest cas al ser un normal tardarà una mica menys de lo normal.
		double x = (double) (gen.nextInt(1) / 5);
		DoneTorniquetEvent Event = new DoneTorniquetEvent(this.getFan(), this.getTime() + x,this.server);
		this.server.setServedEvent(Event);
		return Event;
	}

	public void updateStatistics(Statistics statistics) {
		// TODO Auto-generated method stub

	}

}
