import java.util.Random;

public class ServedTorniquetEspecialEvent extends Event{

	
	private ServerTorniquetEspecial server;

	public ServedTorniquetEspecialEvent(Fan fan, double time, ServerTorniquetEspecial server) {
		super(fan, time);
		this.server = server;
		// TODO Auto-generated constructor stub
	}


	public Event getNextEvent(ServerTorniquet[] servers, Random gen, ServerTorniquetEspecial[] especial_servers, ServerValidarTicket[] serversValidar, ServerValidarTicketEspecial[] serversValidarEspecial) {
		
		// En aquest cas al ser un esecial tardarà una mica mes de lo normal.
		double x = (double) (gen.nextInt(1));
		DoneTorniquetEspecialEvent Event = new DoneTorniquetEspecialEvent(this.getFan(), this.getTime() + x,this.server);
		this.server.setServedEventLastTime(this.getTime() + x);
		return Event;
	}

	public void updateStatistics(Statistics statistics) {
		// TODO Auto-generated method stub

	}
	
    public String toString() {
        return String.format("%.3f", this.getTime()) + ' ' + this.getFanID() + " ServedTorniquetEspecial by: " + this.server.getServerID(); 
    }
}
