import java.util.Scanner;

/** 
 * Main class for testing purposes.
 */

public class App {
    /**
     * Creates an EventManager to simulate the execution of events.
     * This is done by using Scanner object to take in inputs. 
     * required for a RandomGenerator, then pass those arguments to EventManager. 
     * @param args String[] 
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int seed = sc.nextInt();
        int numServers = sc.nextInt();
        int numCustomer = sc.nextInt();
        double arrivalRate = sc.nextDouble();
        double svcRate = sc.nextDouble();
        sc.close();
        double restRate = 1.0;

        EventManager eventManager = new EventManager(numServers, numCustomer,
            seed,arrivalRate,svcRate,restRate);
        eventManager.doService();
    }
}