package edu.io.pubsub;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class Publisher {
    private final Map<String, Subscriber> subscriber = new ConcurrentHashMap<>();

    public void subscribe(Subscriber subscriber) {
        this.subscriber.put(subscriber.toString(), subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        this.subscriber.remove(subscriber.toString());
    }

    public void publish(Object newData) {
        for (Subscriber subscribers : subscriber.values()) {
            subscribers.update(newData);
        }
    }
}
