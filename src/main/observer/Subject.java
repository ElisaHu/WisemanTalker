package observer;

import java.util.ArrayList;

public class Subject {
    ArrayList<Observer> observers = new ArrayList<>();

    //MODIFIES THIS
    //EFFECT ADD OBVERSE TO THE LIST
    public void addObserver(Observer observer) {
        if (observers.contains(observer)) return;
        observers.add(observer);
    }

    // EFFECT: CALL THE UPDATE IN EACH ELEMENT IN THE LIST
    public void notifyObserver() {
        for (Observer obs: observers) {
            obs.update();
        }
    }
}
