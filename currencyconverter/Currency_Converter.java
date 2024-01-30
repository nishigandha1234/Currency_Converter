package currencyconverter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Currency_Converter {

    public static void main(String[] args) {
        
        String apiKey = "YOUR_API_KEY";
        System.out.print("Enter the base currency code (e.g., USD): ");
        String baseCurrency = getUserInput();

        System.out.print("Enter the target currency code (e.g., EUR): ");
        String targetCurrency = getUserInput();

        
        System.out.print("Enter the amount to convert: ");
        double amountToConvert = Double.parseDouble(getUserInput());

        // Fetch exchange rates
        double exchangeRate = getExchangeRate(apiKey, baseCurrency, targetCurrency);

        // Perform currency conversion
        double convertedAmount = amountToConvert * exchangeRate;

        // Display the result
        System.out.println("Converted Amount: " + convertedAmount + " " + targetCurrency);
    }

    private static String getUserInput() 
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    private static double getExchangeRate(String apiKey, String baseCurrency, String targetCurrency) {
        try {
            String apiUrl = "https://open.er-api.com/v6/latest/" + baseCurrency + "?apikey=" + apiKey;
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String response = in.readLine();

                
                String rateKey = "\"" + targetCurrency + "\":";
                int index = response.indexOf(rateKey);
                int endIndex = response.indexOf(",", index);
                String rateSubstring = response.substring(index + rateKey.length(), endIndex).trim();
                return Double.parseDouble(rateSubstring);
            } else {
                System.out.println("Failed to fetch exchange rates. Response Code: " + responseCode);
                return 0.0;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return 0.0;
        }
    }
}
        
        System.out.print("Enter the amount to convert: ");
        double amountToConvert = Double.parseDouble(getUserInput());

        
        double exchangeRate = getExchangeRate(apiKey, baseCurrency, targetCurrency);

        
        double convertedAmount = amountToConvert * exchangeRate;

        
        System.out.println("Converted Amount: " + convertedAmount + " " + targetCurrency);
        }
        

    private static String getUserInput()
    {
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    private static double getExchangeRate(String apiKey, String baseCurrency, String targetCurrency) {
        try {
            String apiUrl = "https://open.er-api.com/v6/latest/" + baseCurrency + "?apikey=" + apiKey;
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String response = in.readLine();

                // Parse JSON response and extract exchange rate
                // Note: In a real-world scenario, consider using a JSON parsing library like Gson.
                // Here, we are using a simple substring extraction for demonstration purposes.
                String rateKey = "\"" + targetCurrency + "\":";
                int index = response.indexOf(rateKey);
                int endIndex = response.indexOf(",", index);
                String rateSubstring = response.substring(index + rateKey.length(), endIndex).trim();
                return Double.parseDouble(rateSubstring);
            } else {
                System.out.println("Failed to fetch exchange rates. Response Code: " + responseCode);
                return 0.0;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return 0.0;
        }
    }
    }
    }
