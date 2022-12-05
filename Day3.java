import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class Day3 {
    public static void main(String[] args) throws Exception {
        // Get inputs
        URL url = new URL("https://adventofcode.com/2022/day/3/input");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestProperty("Cookie","");
        conn.setRequestProperty("Content-Type","application/json");
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String output;


        StringBuffer response = new StringBuffer();


        int sum = 0;

        while ((output = in.readLine()) != null) {
            String part1 = output.substring(0, output.length()/2);
            String part2 = output.substring(output.length()/2);
            char common = Day3.getCommon(part1,part2);
            sum += Day3.score(common);

        }


        System.out.println(sum);

        in.close();
    }

    public static char getCommon(String a, String b) throws Exception {
        for (char c: a.toCharArray()) {
            if(b.indexOf(c) != -1){
                return c;
            }
        }

        throw new Exception("err");
    }

    public static int score(char c) {
        if(c >= 'a' && c <= 'z'){
            return c-96;
        }else{
            return c-64+26;
        }

    }
}
