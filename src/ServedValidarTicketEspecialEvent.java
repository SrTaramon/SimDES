import java.util.Random;

public class ServedValidarTicketEspecialEvent extends Event {

	private ServerTorniquetEspecial server;

	public ServedValidarTicketEspecialEvent(Fan fan, double time, ServerTorniquetEspecial server) {
		super(fan, time);
		this.server = server;
		// TODO Auto-generated constructor stub
	}


	public Event getNextEvent(ServerTorniquet[] servers, Random gen, ServerTorniquetEspecial[] especial_servers, ServerValidarTicket[] serversValidar, ServerValidarTicketEspecial[] serversValidarEspecial) {
		
		// En aquest cas al ser un esecial tardarà una mica mes de lo normal.
		double x = (double) (gen.nextInt(1));
		//Aqui es suma un temps fixe.
		
		//DoneTorniquetEspecialEvent Event = new DoneTorniquetEspecialEvent(this.getFan(), this.getTime() + x,this.server);
		this.server.setServedEvent(Event);
		return Event;
	}

	@Override
	public void updateStatistics(Statistics statistics) {
		// TODO Auto-generated method stub
		
	}

}
