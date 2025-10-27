package edu.io.logic;

import edu.io.pubsub.Publisher;

import java.util.Random;

public class PriceFeed {
    public final Publisher<DataPack> publisher;
    private final DataSource dataSource;

    public PriceFeed(DataSource dataSource) {
        this.dataSource = dataSource;
        this.publisher = new Publisher<>();
    }

    public void refresh() {
        DataPack newData = dataSource.getData();
        publisher.publish(newData);
    }
}
