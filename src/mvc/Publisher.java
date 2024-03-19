package mvc;

import java.util.*;

public class Publisher {

    private List<Subscriber> subscribers = new LinkedList<>();

    public void subscribe(Subscriber s) {
        subscribers.add(s);
    }

    public void unsubscribe(Subscriber s) {
        subscribers.remove(s);
    }

    public void notifySubscribers() {
        for (Subscriber subscriber : subscribers)
            subscriber.update();
    }

}
