package edu.io.logic;

public class DataPack {
    public final long timestamp;
    public final double price;

    public DataPack(double price, long timestamp) {
        this.timestamp = timestamp;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Price = " + price + "Time = " + timestamp;
    }
}
