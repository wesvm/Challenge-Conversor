package models;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;

public class CurrencyConverter {

    private static final String apiUrl = "https://openexchangerates.org/api/latest.json?app_id=";
    private static final String appId = "271ba31646d44a1f81835ea0d3fd4076";

    private static JSONObject getRates(){

        try {
            URL url = new URL(apiUrl + appId);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");

            BufferedReader readerResponse = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();

            String readLine;
            while ((readLine = readerResponse.readLine()) != null) {
                response.append(readLine);
            }
            readerResponse.close();

            JSONObject json = new JSONObject(response.toString());
            return json.getJSONObject("rates");

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private static Object ConvertedAmount(double amount, String from, String to) {
        JSONObject rates = getRates();

        from = from.toUpperCase();
        to = to.toUpperCase();

        assert rates != null;
        double fromRate = rates.getDouble(from);
        double toRate = rates.getDouble(to);

        return amount * (1 / fromRate) * toRate;

    }

    public String getStringConvertedAmount(double amount, String from, String to){
        try {
            double convertedAmount = (double) ConvertedAmount(amount, from, to);

            DecimalFormat decimalFormat = new DecimalFormat("#.##");

            return decimalFormat.format(convertedAmount);
        }catch (Exception e){
            return null;
        }
    }

    public double getDoubleConvertedAmount(double amount, String from, String to){
        try {
            double convertedAmount = (double) ConvertedAmount(amount, from, to);

            DecimalFormat decimalFormat = new DecimalFormat("#.##");

            return Double.parseDouble(decimalFormat.format(convertedAmount));

        }catch (Exception e){
            return 0;
        }
    }

}
