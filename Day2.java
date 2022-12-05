import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class Day2 {
    public static void main(String[] args) throws IOException {

        // Get inputs
        URL url = new URL("https://adventofcode.com/2022/day/2/input");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestProperty("Cookie","");
        conn.setRequestProperty("Content-Type","application/json");
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String output;

        StringBuffer response = new StringBuffer();

        int sum = 0;
        while ((output = in.readLine()) != null) {
            char adversaire = output.charAt(0);
            char joueur = output.charAt(2);

            int shapeScore = switch (joueur){
                case 'X' -> 1;
                case 'Y' -> 2;
                case 'Z' -> 3;
                default -> throw new IllegalStateException("Unexpected value: " + joueur + " " + output);
            };

            int outcomeScore = switch (""+adversaire+joueur){
                case "AX", "BY", "CZ" -> 3;
                case "AZ", "BX", "CY" -> 0;
                case "AY", "BZ", "CX" -> 6;
                case default -> throw new IllegalStateException("Unexpected value: " + adversaire+joueur + " " + output);
            };
            
            sum += shapeScore;
            sum += outcomeScore;

            System.out.println(adversaire + " " + joueur + " " + shapeScore + " " + outcomeScore);


        }

        System.out.print(sum);
        in.close();
    }
}
