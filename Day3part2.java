import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class Day3part2 {
    public static void main(String[] args) throws Exception {
        // Get inputs
        URL url = new URL("https://adventofcode.com/2022/day/3/input");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestProperty("Cookie","");
        conn.setRequestProperty("Content-Type","application/json");
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String output1,output2, output3;


        StringBuffer response = new StringBuffer();


        int sum = 0;

        while ((output1 = in.readLine()) != null && (output2 = in.readLine()) != null && (output3 = in.readLine()) != null) {
            char common = Day3part2.getCommon(output1,output2,output3);
            sum += Day3part2.score(common);
        }


        System.out.println(sum);

        in.close();
    }

    public static char getCommon(String a, String b, String c) throws Exception {
        for (char car: a.toCharArray()) {
            if(b.indexOf(car) != -1 && c.indexOf(car) != -1){
                return car;
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
