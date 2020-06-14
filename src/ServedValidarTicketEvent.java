import java.util.Random;

public class ServedValidarTicketEvent extends Event {

	private ServerValidarTicket server;

	public ServedValidarTicketEvent(Fan fan, double time, ServerValidarTicket server) {
		super(fan, time);
		this.server = server;
		// TODO Auto-generated constructor stub
	}


	public Event getNextEvent(ServerTorniquet[] servers, Random gen, ServerTorniquetEspecial[] especial_servers, ServerValidarTicket[] serversValidar, ServerValidarTicketEspecial[] serversValidarEspecial) {

		// En aquest cas al ser un normal tardarà una mica menys de lo normal.
		double x = (double) (5);
		DoneValidarTicketEvent Event = new DoneValidarTicketEvent(this.getFan(), this.getTime() + x,this.server);
		this.server.setServedEventLastTime(this.getTime() + x);
		return Event;
	}

	public void updateStatistics(Statistics statistics) {
		// TODO Auto-generated method stub

	}
	
    public String toString() {
        return String.format("%.3f", this.getTime()) + ' ' + this.getFanID() + " ServedValidarTicket by: " + this.server.getServerID(); 
    }

}
