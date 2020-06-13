import java.util.Random;

public class DoneValidarTicketEspecialEvent extends Event {

	private ServerValidarTicketEspecial server;

	public DoneValidarTicketEspecialEvent(Fan fan, double time, ServerValidarTicketEspecial server) {
		super(fan, time);
		this.server = server;
		// TODO Auto-generated constructor stub
	}

	public Event getNextEvent(ServerTorniquet[] servers, Random gen, ServerTorniquetEspecial[] especial_servers, ServerValidarTicket[] serversValidar, ServerValidarTicketEspecial[] serversValidarEspecial) {
		this.server.flushDoneEvent();
		//return createArribadaVestibolEntrada();
		return createArrivalVestibolSortida();
	}

	private ArrivalVestibolSortida createArrivalVestibolSortida() {
		// TODO Auto-generated method stub
		return new ArrivalVestibolSortida(this.getFan(), this.getTime());
	}

	public void updateStatistics(Statistics statistics) {
		// TODO Auto-generated method stub
		
	}
}
