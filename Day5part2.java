import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class Day5part2 {
    public static void main(String[] args) throws Exception {
        // Get inputs
        URL url = new URL("https://adventofcode.com/2022/day/5/input");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestProperty("Cookie","");
        conn.setRequestProperty("Content-Type","application/json");
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        StringBuffer response = new StringBuffer();

        LinkedList<String> cargo = new LinkedList<>();
        for(int i=0; i<8; i++) {
            cargo.push(in.readLine());
        }

        List<LinkedList<Character>> colones = new ArrayList<>();
        for(int i=0; i<9; i++) {
            colones.add(new LinkedList<>());
        }

        for(int x=0; x<8; x++) {
            String lastline = cargo.pop();
            for(int i = 0; i < 9; i++){


                char lastChar = lastline.charAt((i*4)+1);

               if(lastChar >= 'A' && lastChar <= 'Z')
                    colones.get(i).push(lastChar);
            }
        }


        // ligne inutile
        in.readLine();
        in.readLine();

        String output;
        while ((output = in.readLine()) != null) {
            String deplacement = output.substring(5);

            int fin = deplacement.indexOf(' ');
            String nbADeplacer = deplacement.substring(0, fin);
            int nb = Integer.parseInt(nbADeplacer);

            char coloneAPop = deplacement.charAt(deplacement.length() - 6);
            int from = Integer.parseInt(String.valueOf(coloneAPop)) - 1;

            char coloneADeposer = deplacement.charAt(deplacement.length() - 1);
            int to = Integer.parseInt(String.valueOf(coloneADeposer)) - 1;

            List<Character> aDeposerEnBloc = new ArrayList<>();
            while(nb > 0){
                nb--;
                aDeposerEnBloc.add(colones.get(from).pop());
            }

            Collections.reverse(aDeposerEnBloc);

            aDeposerEnBloc.forEach(c -> colones.get(to).push(c));

        }


        for(int k=0; k<9; k++) {
            LinkedList<Character> colone = colones.get(k);
            System.out.println(colone.pop());
        }

        in.close();
    }
}
