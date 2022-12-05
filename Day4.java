import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class Day4 {
    public static void main(String[] args) throws Exception {
        // Get inputs
        URL url = new URL("https://adventofcode.com/2022/day/4/input");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestProperty("Cookie","_04");
        conn.setRequestProperty("Content-Type","application/json");
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        String output;

        StringBuffer response = new StringBuffer();


        int sum = 0;

        while ((output = in.readLine()) != null) {
            System.out.println(output);
            String[] values = output.split(",");
            String[] range1 = values[0].split("-");
            String[] range2 = values[1].split("-");

            int range11 = Integer.parseInt(range1[0]);
            int range12 = Integer.parseInt(range1[1]);

            int range21 = Integer.parseInt(range2[0]);
            int range22 = Integer.parseInt(range2[1]);

            if(range11 == range21 || range12 == range22 ||
                    (range11 > range21 && range12 < range22) ||
                    (range21 > range11 && range22 < range12) ){
                sum++;
                System.out.println("ok");
            }

        }

        System.out.println(sum);

        in.close();
    }
}
