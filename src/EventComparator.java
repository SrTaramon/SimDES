import java.util.Comparator;

/**
 * EventComparator class to create a comparison criteria for events.
 */
public class EventComparator implements Comparator<Event> {

    /**
     * Compares 2 Events and decides which is smaller, equal or greater.
     * The first key is to check for the earliest time.
     * If there is a tie breaker, customerID is checked instead, 
     * which also hints on the priority of different type of events.
     * @param e1 left event
     * @param e2 right event
     * @return -1 if left event is prioritised over right event. 
     * 0 if there isn't a priority, which will not happen in this case.
     * 1 if right event is prioritised over left event.
     */
    public int compare(Event e1, Event e2)  {
        if (e1.getTime() < e2.getTime()) {
            return -1;
        } else if (e1.getTime() > e2.getTime()) {
            return 1;
        } else if (e1.getFanID() < e2.getFanID()) {
            return -1;
        } else if (e1.getFanID() > e2.getFanID()) {
            return 1;
        } else {
            System.out.println("Bug with code, please check");
            return 0;
        }

    }
}