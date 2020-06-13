import java.util.Random;

public class ServedTorniquetEspecialEvent extends Event{

	
	private EspecialServer server;

	public ServedTorniquetEspecialEvent(Fan fan, double time, EspecialServer server) {
		super(fan, time);
		this.server = server;
		// TODO Auto-generated constructor stub
	}


	public Event getNextEvent(Server[] servers, Random gen, EspecialServer[] especial_servers) {
		
		// En aquest cas al ser un esecial tardarà una mica mes de lo normal.
		double x = (double) (gen.nextInt(1));
		DoneTorniquetEspecialEvent Event = new DoneTorniquetEspecialEvent(this.getFan(), this.getTime() + x,this.server);
		this.server.setServedEvent(Event);
		return Event;
	}

	public void updateStatistics(Statistics statistics) {
		// TODO Auto-generated method stub

	}
}
