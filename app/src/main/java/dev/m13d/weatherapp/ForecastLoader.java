package dev.m13d.weatherapp;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public final class ForecastLoader {

    private static final String OPEN_WEATHER_MAP_API = "http://api.openweathermap.org/data/2.5/weather?q=%s&&apikey=%s&units=metric";
    private static final String API_KEY = "14f34cd242746f2d76bb04739d7485fe";
    private static final String RESPONSE = "cod";
    private static final String NEW_LINE = "\n";
    private static final int RESPONSE_SUCCESS = 200;

    public static JSONObject getJsonData(String city) {
        try {
            URL url = new URL(String.format(OPEN_WEATHER_MAP_API, city, API_KEY));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder rawData = new StringBuilder(1024);
            String tempVariable;
            while ((tempVariable = reader.readLine()) != null) {
                rawData.append(tempVariable).append(NEW_LINE);
            }
            reader.close();

            JSONObject jsonObject = new JSONObject(rawData.toString());
            if (jsonObject.getInt(RESPONSE) == RESPONSE_SUCCESS) {
                return jsonObject;
            } else {
                return null;//FIXME Обработка ошибки
            }
        } catch (Exception e) {
            return null; //FIXME Обработка ошибки
        }
    }

    private ForecastLoader() {
    }
}
