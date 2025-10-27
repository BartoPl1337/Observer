package edu.io.logic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpDataSource implements DataSource {
    @Override
    public DataPack getData() {
        try {
            URL url = new URL("https://www.goldapi.io/api/XPT/PLN");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("x-access-token", "goldapi-2l8qahdsmh96pj3o-io");
            con.connect();

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
            in.close();

            String response = sb.toString();
            // Wartosc wymyslona wieksza od 0
            double price = 1000;
            long timestamp = System.currentTimeMillis() / 1000;

            String[] data = response.replaceAll("\"", "").split(",");
            for (String newData : data) {
                String[] dataArray = newData.split(":");
                if (dataArray[0].trim().equals("price")) price = Double.parseDouble(dataArray[1].trim());
                if (dataArray[0].trim().equals("timestamp")) timestamp = Long.parseLong(dataArray[1].trim());
            }

            return new DataPack(price, timestamp);

        } catch (Exception e) {
            System.out.println("Błąd: " + e.getMessage());
            return new DataPack(0, 0);
        }
    }
}
