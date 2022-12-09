import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class Day6 {
    public static void main(String[] args) throws Exception {
        // Get inputs
        URL url = new URL("https://adventofcode.com/2022/day/6/input");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestProperty("Cookie","_xxxx0187904");
        conn.setRequestProperty("Content-Type","application/json");
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        String output;
        int debut = 0;
        int fin = 14;
        while ((output = in.readLine()) != null) {
            while(fin < output.length()){
                String tmp = output.substring(debut,fin);

                if(Day6.check(tmp)){
                    System.out.println(debut + " " + fin);
                    System.out.println(tmp);
                    System.exit(1);
                }

                debut++;
                fin++;
            }
        }


        in.close();
    }

    public static boolean check(CharSequence checkString)
    {
        return checkString.length() == checkString.chars().distinct().count();
    }
}
