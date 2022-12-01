import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class Day1 {
    public static void main(String[] args) throws IOException {

        // Get inputs
        URL url = new URL("https://adventofcode.com/2022/day/1/input");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestProperty("Cookie","xxx");
        conn.setRequestProperty("Content-Type","application/json");
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String output;

        StringBuffer response = new StringBuffer();

        int max=-1;
        int sum = 0;
        while ((output = in.readLine()) != null) {
            if(output.equals("")){
                if(sum > max){
                    max = sum;
                }
                sum=0;
            }else{
                sum += Integer.parseInt(output);
            }
        }

        System.out.print(max);
        in.close();
    }
}
