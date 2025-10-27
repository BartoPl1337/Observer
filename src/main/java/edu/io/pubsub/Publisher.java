package edu.io.pubsub;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class Publisher<T> {
    private final Map<String, Subscriber<T>> subscriber = new ConcurrentHashMap<>();

    public void subscribe(Subscriber<T> subscriber) {
        this.subscriber.put(subscriber.toString(), subscriber);
    }

    public void unsubscribe(Subscriber<T> subscriber) {
        this.subscriber.remove(subscriber.toString());
    }

    public void publish(T newData) {
        for (Subscriber<T> subscribers : subscriber.values()) {
            subscribers.update(newData);
        }
    }
}
