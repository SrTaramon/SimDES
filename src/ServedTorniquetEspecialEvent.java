import java.util.Random;

public class ServedTorniquetEspecialEvent extends Event{

	
	private EspecialServerTorniquet server;

	public ServedTorniquetEspecialEvent(Fan fan, double time, EspecialServerTorniquet server) {
		super(fan, time);
		this.server = server;
		// TODO Auto-generated constructor stub
	}


	public Event getNextEvent(ServerTorniquet[] servers, Random gen, EspecialServerTorniquet[] especial_servers) {
		
		// En aquest cas al ser un esecial tardar� una mica mes de lo normal.
		double x = (double) (gen.nextInt(1));
		DoneTorniquetEspecialEvent Event = new DoneTorniquetEspecialEvent(this.getFan(), this.getTime() + x,this.server);
		this.server.setServedEvent(Event);
		return Event;
	}

	public void updateStatistics(Statistics statistics) {
		// TODO Auto-generated method stub

	}
}
