import java.util.Random;

public class ArribadaVestibolEntrada extends Event{

	public ArribadaVestibolEntrada(Fan fan, double time) {
		super(fan, time);
		// TODO Auto-generated constructor stub
	}
	
	
	public Event getNextEvent(ServerTorniquet[] servers, Random gen, ServerTorniquetEspecial[] especial_servers, ServerValidarTicket[] serversValidar, ServerValidarTicketEspecial[] serversValidarEspecial) {
		//System.out.println(this.getFan().getFanID() + " " + this.getFan().isHaVistPartit());
		if (this.getFan().isHaVistPartit()) { //COndicio perque el fan sorti del sistema
        	//fer event Validar tiquet
			if (this.getFan().isBillet()) {
				return new ValidarTiquetEvent(this.getFan(), this.getTime());
			} else {
				return new ComprarTiquetEvent(this.getFan(), this.getTime());
			}
			
        } else {
        	return new PartitEvent(this.getFan(), this.getTime());
        }
	}

    public String toString() {
        return String.format("%.3f", this.getTime()) + ' ' + this.getFanID() + " Arrival Vestibol Entrada";
    }


	@Override
	public void updateStatistics(Statistics statistics) {
		// TODO Auto-generated method stub
		
	}



}
