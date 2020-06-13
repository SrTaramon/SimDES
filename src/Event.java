import java.util.Random;

import acm.util.RandomGenerator;

public abstract class Event {
    /**
     * Customer that the event is involving.
     */
    private final Fan fan;
    /**
     * Time at which the event is created, 
     * which may differ from customer arrival time if 
     * it is only created when it is caused to wait by another preceeding event.
     */
    private final double time;

    /** 
     * Creates an Event.
     * @param customer customer that the event is involving
     * @param time time at which event is created
     */
    public Event(Fan fan, double time) {
        this.fan = fan;
        this.time = time;
    }


    /** 
     * Creates the next event of parent type based on its original type.
     */
    public abstract Event getNextEvent(ServerTorniquet [] servers, Random gen, ServerTorniquetEspecial[] especial_servers);

    /** Modifies information in statistics if required.
     */
    public abstract void updateStatistics(Statistics statistics);

    public Fan getFan() {
        return this.fan;
    }

    public int getFanID() {
        return this.fan.getFanID();
    }

    public double getTime() {
        return this.time;
    }
}