import java.util.Random;

public class DoneTorniquetEvent extends Event{

	private ServerTorniquet server;

	public DoneTorniquetEvent(Fan fan, double time, ServerTorniquet server) {
		super(fan, time);
		this.server = server;
		// TODO Auto-generated constructor stub
	}

	public Event getNextEvent(ServerTorniquet[] servers, Random gen, ServerTorniquetEspecial[] especial_servers, ServerValidarTicket[] serversValidar, ServerValidarTicketEspecial[] serversValidarEspecial) {
		this.server.flushDoneEvent();
		return new ArribadaVestibolEntrada(this.getFan(), this.getTime());
	}

	public void updateStatistics(Statistics statistics) {
		// TODO Auto-generated method stub
		
	}
	
    public String toString() {
        return String.format("%.3f", this.getTime()) + ' ' + this.getFanID() + " Done ServedTorniquet by: " + this.server.getServerID();
    }

}
