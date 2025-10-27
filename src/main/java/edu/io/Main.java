package edu.io;

import edu.io.logic.DataPack;
import edu.io.logic.HttpDataSource;

public class Main {
    public static void main(String[] args) {
        HttpDataSource source = new HttpDataSource();
        DataPack data = source.getData();
        System.out.println(data);
    }
}