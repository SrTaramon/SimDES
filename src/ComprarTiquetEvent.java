import java.util.Random;

public class ComprarTiquetEvent extends Event {

	public ComprarTiquetEvent(Fan fan, double time) {
		super(fan, time);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Event getNextEvent(ServerTorniquet[] servers, Random gen, ServerTorniquetEspecial[] especial_servers) {
		// TODO Auto-generated method stub
		int x = gen.nextInt(10) + 5;
		this.getFan().setBillet(true);
		return new ValidarTiquetEvent(this.getFan(), this.getTime() + x);
	}

	@Override
	public void updateStatistics(Statistics statistics) {
		// TODO Auto-generated method stub

	}

}
