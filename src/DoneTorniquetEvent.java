import java.util.Random;

public class DoneTorniquetEvent extends Event{

	private ServerTorniquet server;

	public DoneTorniquetEvent(Fan fan, double time, ServerTorniquet server) {
		super(fan, time);
		this.server = server;
		// TODO Auto-generated constructor stub
	}

	public Event getNextEvent(ServerTorniquet[] servers, Random gen, EspecialServerTorniquet[] especial_servers) {
		this.server.flushDoneEvent();
		return createArribadaVestibolEntrada();
	}

	private ArribadaVestibolEntrada createArribadaVestibolEntrada() {
		// TODO Auto-generated method stub
		return new ArribadaVestibolEntrada(this.getFan(), this.getTime());
	}

	public void updateStatistics(Statistics statistics) {
		// TODO Auto-generated method stub
		
	}

}
