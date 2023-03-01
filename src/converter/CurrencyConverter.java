package converter;
import converter.ConfigReader.ConfigReader;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;

public class CurrencyConverter {
    static ConfigReader config;
    static {
        try {
            config = new ConfigReader();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static final String apiUrl = config.getApiUrl();
    private static final String appId = config.getAppId();

    private static HttpURLConnection getApiConnection() throws IOException{
        URL url = new URL(apiUrl + appId);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("GET");
        int status = conn.getResponseCode();
        if (status != 200){
            throw new IOException("Error connect api. Response code: " + status);
        }

        return conn;
    }

    private static JSONObject getRates() throws IOException{
        HttpURLConnection conn = null;
        try {
            conn = getApiConnection();

            try (BufferedReader readerResponse = new BufferedReader(
                    new InputStreamReader(conn.getInputStream())
            )) {
                StringBuilder response = new StringBuilder(4096);

                String readLine;
                while ((readLine = readerResponse.readLine()) != null) {
                    response.append(readLine);
                }

                JSONObject json = new JSONObject(response.toString());
                return json.getJSONObject("rates");

            }

        }catch (IOException e){
            e.printStackTrace();
            throw new IOException("Error retrieving rates from API " + e + " ");
        }finally {
            if (conn != null){
                conn.disconnect();
            }
        }
    }

    private static Object convertedAmount(double amount, String from, String to) throws IOException {
        JSONObject rates = getRates();

        from = from.toUpperCase();
        to = to.toUpperCase();

        assert rates != null;
        double fromRate = rates.getDouble(from);
        double toRate = rates.getDouble(to);

        return amount * (1 / fromRate) * toRate;

    }

    public String getStringConvertedAmount(double amount, String from, String to) throws IOException{

        double convertedAmount = (double) convertedAmount(amount, from, to);
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return decimalFormat.format(convertedAmount);

    }

}