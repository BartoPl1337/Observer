package edu.io;

import edu.io.logic.DataPack;
import edu.io.pubsub.Subscriber;

import java.io.FileWriter;
import java.io.IOException;

public class PriceLog implements Subscriber {
    @Override
    public void update(Object data) {
        try (FileWriter fw = new FileWriter("price.log", true)) {
            if (data instanceof DataPack pack) {
                fw.write(pack.price + "," + pack.timestamp);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
