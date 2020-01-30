package com.muuseum.personCounter;

import com.muuseum.fileHandling.FileHandler;
import com.muuseum.model.Direction;

import java.time.LocalTime;
import java.util.List;

public class PersonCounter {
    private FileHandler fileHandler;
    private List<LocalTime> arrivals;
    private List<LocalTime> departures;
    private LocalTime maxArrivalTime;
    private LocalTime maxDepartureTime;
    private int maxPeople = 0;
    private int currentPeople = 0;

    public PersonCounter(String filePath) {
        this.fileHandler = new FileHandler(filePath);
        this.arrivals = this.fileHandler.getSortedTime(Direction.ARRIVE);
        this.departures = this.fileHandler.getSortedTime(Direction.LEAVE);
    }

    public void mostVisitorsInMuseum() {

        int i = 0;
        int j = 0;
        while (i < arrivals.size() && j < departures.size()) {
            int compareValue = arrivals.get(i).compareTo(departures.get(j));

            if (compareValue < 1) {
                currentPeople++;

                if (currentPeople > maxPeople) {
                    maxPeople = currentPeople;
                    maxArrivalTime = arrivals.get(i);
                    maxDepartureTime = departures.get(j);
                }
                i++;
            } else {
                currentPeople--;
                j++;
            }
        }
        System.out.println(maxArrivalTime + "-" + maxDepartureTime + ";" + maxPeople);
    }


}
