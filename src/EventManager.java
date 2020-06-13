import java.util.PriorityQueue;
import acm.util.RandomGenerator;
import java.lang.Object;
import java.util.Random;

/**
 * EventManager class that handles the sequence of Event executions.
 */

public class EventManager {

    /**
     * Array of servers that determines the way ArrivalEvents are processed.
     */
	ServerTorniquet [] servers;
    
    ServerTorniquetEspecial[] special_servers;
    
    ServerValidarTicket[] serversValidar;
    
    ServerValidarTicketEspecial[] serversValidarEspecial;

    /**
     * PriorityQueue of events to be cleared by the end of the simulation.
     */
    PriorityQueue<Event> events;

    /**
     * Statistics object to keep track of average waiting time of served customers,
     * number of served customers,
     * and the number of customers that left without being served.
     */
    Statistics statistics = new Statistics();

    /**
     * RandomGenerator object to randomise arrival time as well as
     * service time, which is the time to convert ServedEvent to DoneEvent.
     */
    Random gen;


    /**
     * Constructs a EventManager that creates the ArrivalEvents of randomised time.
     * from the number of customers, load them into the PriorityQueue.
     * @param numServers the number of servers to be created.
     * @param numCustomer the number of customers to be served, which is
     * also equal to the number of ArrivalEvents preloaded onto PriorityQueue.
     * @param seed intialising value where the random values are generated from
     * @param arrivalRate arrival rate, mu in RandomGenerator constructor
     * @param svcRate service rate, lambda in RandomGenerator constructor
     * @param restRate rest rate, rho in RandomGenerator constructor
     */
    public EventManager(int numServers, int numEspecialServers, int numCustomer,
        long seed, int arrivalRate) {
        this.events = new PriorityQueue<>(new EventComparator());
        
        Random rnd = new Random();
        rnd.setSeed(seed);
        this.gen = rnd;
        
        double time = 0;
        Fan fan = new Fan(time);
        
        ArrivalVestibolSortida tempEvent = new ArrivalVestibolSortida(fan,time);
        events.add(tempEvent);
        
        for (int i = 0;i < numCustomer - 1;i++) {
            int x = this.gen.nextInt(arrivalRate); //modificarho 
            time += x;
            fan = new Fan(time);
            tempEvent = new ArrivalVestibolSortida(fan,time);
            events.add(tempEvent);
        }
        this.servers = new ServerTorniquet [numServers];
        for (int i = 0;i < numServers;i++) {
            this.servers[i] = new ServerTorniquet();
        }
        this.special_servers = new ServerTorniquetEspecial [numEspecialServers];
        for (int i = 0;i < numEspecialServers;i++) {
            this.special_servers[i] = new ServerTorniquetEspecial();
        }
    }


    /**
     * Processes the full sequence of ArrivalEvents to calculate statistics.
     * This process is split into a few stages,
     * (i)At the start of each loop, get the first event from the PriorityQueue
     * (ii)prints the profile of the event to signal that we start processing it
     * (iii)current event creates the next event, 
     * with some information on the available servers as well as RandomGenerator
     * in case a DoneEvent can be created from the current event.
     * (iv) If applicable, Statistics are also updated after 
     * the creation of the new event, which will also be added to the PriorityQueue. 
     * (v) prints the statistics after the PriorityQueue is cleared.
     */
    public void doService() {
        while (events.size() > 0) {
            Event firstEvent = getFirstEvent();
            System.out.println(firstEvent);
            Event newEvent = firstEvent.getNextEvent(servers,gen, special_servers, serversValidar, serversValidarEspecial);
            if (newEvent != null) {
                newEvent.updateStatistics(statistics);
                events.add(newEvent);	
            }

        }
        System.out.println(statistics);
    }

    /**
     * Accesses an event as well as remove it from the PriorityQueue.
     * @return the first event from the PriorityQueue, 
     * according to the Comparator object it was created with.
     */
    public Event getFirstEvent() {
        return events.poll();
    }
}