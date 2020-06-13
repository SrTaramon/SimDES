import java.util.Random;

public class DoneTorniquetEspecialEvent extends Event{

	private EspecialServer server;

	public DoneTorniquetEspecialEvent(Fan fan, double time, EspecialServer server) {
		super(fan, time);
		this.server = server;
		// TODO Auto-generated constructor stub
	}

	public Event getNextEvent(Server[] servers, Random gen, EspecialServer[] especial_servers) {
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
