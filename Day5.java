import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Day5 {
    public static void main(String[] args) throws Exception {
        // Get inputs
        URL url = new URL("https://adventofcode.com/2022/day/5/input");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestProperty("Cookie","_04");
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

            while(nb > 0){
                nb--;
                colones.get(to).push(colones.get(from).pop());
            }

        }


        for(int k=0; k<9; k++) {
            LinkedList<Character> colone = colones.get(k);
            System.out.println(colone.pop());
        }
        /*

move 6 from 1 to 7
move 2 from 2 to 4
move 2 from 7 to 4
move 6 from 4 to 3
move 1 from 5 to 1
move 3 from 8 to 3
move 15 from 3 to 4
move 6 from 5 to 9
move 14 from 4 to 2
move 3 from 2 to 7
move 1 from 2 to 7
move 9 from 9 to 1
move 3 from 2 to 1

         */
        /**
         * [S]                 [T] [Q]
         * [L]             [B] [M] [P]     [T]
         * [F]     [S]     [Z] [N] [S]     [R]
         * [Z] [R] [N]     [R] [D] [F]     [V]
         * [D] [Z] [H] [J] [W] [G] [W]     [G]
         * [B] [M] [C] [F] [H] [Z] [N] [R] [L]
         * [R] [B] [L] [C] [G] [J] [L] [Z] [C]
         * [H] [T] [Z] [S] [P] [V] [G] [M] [M]
         *  1   2   3   4   5   6   7   8   9
         */

        in.close();
    }
}
