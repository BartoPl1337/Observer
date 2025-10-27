package edu.io.logic;

import edu.io.pubsub.Publisher;

import java.util.Random;

public class PriceFeed {
    public final Publisher publisher;
    private final Random random = new Random();

    public PriceFeed() {
        this.publisher = new Publisher();
    }

    public void timer() {
        while (true) {
            double price = 1 + random.nextDouble() * 1000;
            System.out.println("Aktualna cena: " + price);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println(e);
                break;
            }
        }
    }
}
