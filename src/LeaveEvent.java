import java.util.Random;

public class LeaveEvent extends Event {

	public LeaveEvent(Fan fan, double time) {
		super(fan, time);
		// TODO Auto-generated constructor stub
	}


	public Event getNextEvent(Server[] servers, Random gen, EspecialServer[] especial_servers) {
		return null;
	}


	public void updateStatistics(Statistics statistics) {
		// TODO Auto-generated method stub

	}

}