import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Object;
import java.util.Random;
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
    	
    	File text = new File("entrada.txt");

        //Creating Scanner instnace to read File in Java
        Scanner sc = null;
		try {
			sc = new Scanner(text);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //Scanner sc = new Scanner(System.in);
        int seed = sc.nextInt();
        int numServers = sc.nextInt();
        int numCustomer = sc.nextInt();
        int arrivalRate = sc.nextInt();
        double svcRate = sc.nextDouble();
        sc.close();
        double restRate = 1.0;
        
        System.out.println("Yesaaaaa " + seed + " " + numServers + " " + numCustomer + " " + arrivalRate + " " + svcRate);
        
        Random rnd = new Random();
        rnd.setSeed(seed);
        double x = rnd.nextFloat();
        System.out.println(x);
        System.out.println(rnd.nextFloat() + " " + rnd.nextFloat() + " " + rnd.nextFloat() + " " + rnd.nextFloat() + " " + rnd.nextFloat() + " " + rnd.nextFloat() + " " + rnd.nextFloat());
        Random rnd2 = new Random(1);
        
        System.out.println(rnd2.nextInt(arrivalRate) + " " + rnd2.nextInt(arrivalRate) + " " + rnd2.nextInt(arrivalRate) + " " + rnd2.nextInt(arrivalRate));
    }
}