package network;

//shamelessly quoting from: http://zetcode.com/articles/javareadwebpage/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadWebPage {
    static BufferedReader br = null;
    ArrayList<String> website = new ArrayList<>();
    private String web;
    private String weather;
    private String line;

    //MODIFIES: THIS
    //EFFECT: access the api from web
    public String accessWeb(String city) throws IOException {
        //public static void main(String[] args) throws MalformedURLException, IOException {
        //String theURL = "https://www.ugrad.cs.ubc.ca/~cs210/2018w1/welcomemsg.html"; //this can point to any URL

        String apikey = "68b4b5dd9483039f88ad98be2d0b29d5"; //fill this in with the API key they email you
        //String londonweatherquery = "https://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=";
        String londonweatherquery = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&APPID=";
        String theURL = londonweatherquery + apikey;

        try {
            //String theURL = "https://edge.edx.org/courses/course-v1:UBC+CPSC210+all/beaf20f69f004eeb986101fd19512729/"; //this can point to any URL
            URL url = new URL(theURL);
            br = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
            }
            //System.out.println(sb);
            web = parseJson(sb.toString());
        } finally {
            if (br != null) {
                br.close();
            }
        }
        return web;
    }

    private static String parseJson(String s) {
        String predict = "";
        try {
            JSONObject obj = new JSONObject(s);
            JSONObject coordObj = obj.getJSONObject("coord");
            double lon = coordObj.getDouble("lon");
            double lat = coordObj.getDouble("lat");
            //System.out.println("lon = " + lon + " lat = " + lat);
            predict = "lon = " + lon + " lat = " + lat;

            JSONObject obj1 = new JSONObject(s);
            JSONObject mainObj = obj1.getJSONObject("main");
            int temp = mainObj.getInt("temp");
            //System.out.println("The temperature is " + temp);
            predict = predict + "\n" + "The temperature is " + temp;
//            String weather = mainObj.getString("main");
//            String description = mainObj.getString("description");
//            System.out.println("weather = " + weather + " description = " + description);

        } catch (JSONException je) {
            System.out.println("Exception been caught");
        }

        return predict;
    }
}


