import java.util.Random;

public class DoneTorniquetEspecialEvent extends Event{

	private ServerTorniquetEspecial server;

	public DoneTorniquetEspecialEvent(Fan fan, double time, ServerTorniquetEspecial server) {
		super(fan, time);
		this.server = server;
		// TODO Auto-generated constructor stub
	}

	public Event getNextEvent(ServerTorniquet[] servers, Random gen, ServerTorniquetEspecial[] especial_servers, ServerValidarTicket[] serversValidar, ServerValidarTicketEspecial[] serversValidarEspecial) {
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
