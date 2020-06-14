import java.util.Random;

public class ServedValidarTicketEspecialEvent extends Event {

	private ServerValidarTicketEspecial server;

	public ServedValidarTicketEspecialEvent(Fan fan, double time, ServerValidarTicketEspecial server) {
		super(fan, time);
		this.server = server;
		// TODO Auto-generated constructor stub
	}


	public Event getNextEvent(ServerTorniquet[] servers, Random gen, ServerTorniquetEspecial[] especial_servers, ServerValidarTicket[] serversValidar, ServerValidarTicketEspecial[] serversValidarEspecial) {
		
		// En aquest cas al ser un esecial tardarà una mica mes de lo normal.
		double x = (double) (10);
		//Aqui es suma un temps fixe.
		
		DoneValidarTicketEspecialEvent Event = new DoneValidarTicketEspecialEvent(this.getFan(), this.getTime() + x,this.server);
		this.server.setServedEventLastTime(this.getTime() + x);
		return Event;
	}

	@Override
	public void updateStatistics(Statistics statistics) {
		// TODO Auto-generated method stub
		
	}
	
    public String toString() {
        return String.format("%.3f", this.getTime()) + ' ' + this.getFanID() + " ServedValidarTicketEspecial by: " + this.server.getServerID(); 
    }

}
