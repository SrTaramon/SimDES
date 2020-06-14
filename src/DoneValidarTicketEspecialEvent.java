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
		return new ArrivalVestibolSortida(this.getFan(), this.getTime());
	}

	public void updateStatistics(Statistics statistics) {
		// TODO Auto-generated method stub
		
	}
	
    public String toString() {
        return String.format("%.3f", this.getTime()) + ' ' + this.getFanID() + " Done ValidarTicketEspecial by: " + this.server.getServerID(); 
    }
}
