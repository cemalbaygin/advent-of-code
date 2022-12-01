import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Day1part2 {
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

        List<Integer> score = new ArrayList<>();

        int sum = 0;
        while ((output = in.readLine()) != null) {
            if(output.equals("")){
                score.add(sum);
                sum=0;
            }else{
                sum += Integer.parseInt(output);
            }

            response.append(output+"\n");
        }

        Collections.sort(score, Collections.reverseOrder());

        int res = 0;
        for(int i=0; i<3;i++ )
        {
            System.out.println(score.get(i));
            res += score.get(i);
        }
        System.out.println(res);

        in.close();
    }
}
