import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

class FoodTrucks {

    public List<FoodTruck> getOpenFoodTrucks(Date date) throws Exception {
        String data = sendGet("https://data.sfgov.org/resource/bbb8-hzi6.json");
        Gson gson = new Gson();
        List<FoodTruck> foodTrucks = gson.fromJson(data, new TypeToken<List<FoodTruck>>(){}.getType());
        foodTrucks.removeIf(p -> !p.isOpen(date));
        return foodTrucks;
    }

    private String sendGet(String url) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder sb = new StringBuilder();
        
        while ((inputLine = in.readLine()) != null) {
            sb.append(inputLine);
        }
        in.close();
        return sb.toString();
    }

}