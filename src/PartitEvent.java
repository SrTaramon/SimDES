import java.util.Random;

public class PartitEvent extends Event {

	public PartitEvent(Fan fan, double time) {
		super(fan, time);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Event getNextEvent(ServerTorniquet[] servers, Random gen, ServerTorniquetEspecial[] especial_servers) {
		// TODO Auto-generated method stub
		int x = gen.nextInt(30) + 120;
		this.getFan().setHaVistPartit(true);
		return new ArribadaVestibolEntrada(this.getFan(), this.getTime() + x);
	}

	@Override
	public void updateStatistics(Statistics statistics) {
		// TODO Auto-generated method stub

	}

}
