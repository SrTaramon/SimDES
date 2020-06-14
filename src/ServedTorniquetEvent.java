import java.util.Random;

public class ServedTorniquetEvent extends Event {

	private ServerTorniquet server;

	public ServedTorniquetEvent(Fan fan, double time, ServerTorniquet server) {
		super(fan, time);
		this.server = server;
		// TODO Auto-generated constructor stub
	}


	public Event getNextEvent(ServerTorniquet[] servers, Random gen, ServerTorniquetEspecial[] especial_servers, ServerValidarTicket[] serversValidar, ServerValidarTicketEspecial[] serversValidarEspecial) {

		// En aquest cas al ser un normal tardarà una mica menys de lo normal.
		double x = (double) (gen.nextInt(6) + 3);
		DoneTorniquetEvent Event = new DoneTorniquetEvent(this.getFan(), this.getTime() + x,this.server);
		this.server.setServedEventLastTime(this.getTime() + x);
		return Event;
	}

	public void updateStatistics(Statistics statistics) {
		// TODO Auto-generated method stub

	}
	
    public String toString() {
        return String.format("%.3f", this.getTime()) + ' ' + this.getFanID() + " ServedTorniquet by: " + this.server.getServerID();
    }

}
