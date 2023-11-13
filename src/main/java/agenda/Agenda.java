package agenda;

import java.time.LocalDate;
import java.util.*;

/**
 * Description : An agenda that stores events
 */
public class Agenda {
    ArrayList<Event> events = new ArrayList<>();

    /**
     * Adds an event to this agenda
     *
     * @param e the event to add
     */
    public void addEvent(Event e) {
        events.add(e);
    }

    /**
     * Computes the events that occur on a given day
     *
     * @param day the day toi test
     * @return a list of events that occur on that day
     */
    public List<Event> eventsInDay(LocalDate day) {
        ArrayList<Event> todayEvents = new ArrayList<Event>();
        for (Event e : events) {
            if (e.isInDay(day)) {
                todayEvents.add(e);
            }
        }
        return todayEvents;
    }

    public List<Event> findByTitle(String title) {
        List<Event> titleEvents = new ArrayList<Event>();
        for (Event e : events) {
            if (e.getTitle().equals(title)) {
                titleEvents.add(e);
            }
        }
        return (titleEvents);
    }

    public boolean isFreeFor(Event e) {
        boolean result = true;
        for (Event f : events) {
            if (f.getStart().equals(e.getStart())) {
                result = false;
                return (result);
            }
            else if(e.getStart().isBefore(f.getStart()) && e.getStart().plus(e.getDuration()).isBefore(f.getStart())) {
                result = false;
                return (result);

            }
            else if (e.getStart().isAfter(f.getStart()) && e.getStart().plus(e.getDuration()).isAfter(f.getStart())){
                result = false;
                return(result);
            }
        }
        return (result);
    }
}
