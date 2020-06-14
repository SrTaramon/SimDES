import java.util.Random;

public class PartitEvent extends Event {

	public PartitEvent(Fan fan, double time) {
		super(fan, time);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Event getNextEvent(ServerTorniquet[] servers, Random gen, ServerTorniquetEspecial[] especial_servers, ServerValidarTicket[] serversValidar, ServerValidarTicketEspecial[] serversValidarEspecial) {
		// TODO Auto-generated method stub
		int x = gen.nextInt(1800) + 7200;
		//System.out.println(this.getFan().getFanID() + " SetHasVistPartit");
		this.setFanHaVistPartit();
		return new ArribadaVestibolEntrada(this.getFan(), this.getTime() + x);
	}

	@Override
	public void updateStatistics(Statistics statistics) {
		// TODO Auto-generated method stub

	}
	
    public String toString() {
        return String.format("%.3f", this.getTime()) + ' ' + this.getFanID() + " Arrival Partit";
    }

}
