import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;


public class Day8Part2 {
    public static void main(String[] args) throws Exception {
        // Get inputs

        URL url = new URL("https://adventofcode.com/2022/day/8/input");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestProperty("Cookie","_ga=G7eb196528550.1670486222");
        conn.setRequestProperty("Content-Type","application/json");
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        String output;
        
        int size = 99;

        int[][] matrice = new int[size][];
        int[][] visiblesGauche = new int[size][];
        int[][] visiblesDroite = new int[size][];
        int[][] visibleHaut = new int[size][];
        int[][] visiblesBas = new int[size][];

        int i = 0;
        while ((output = in.readLine()) != null) {
            matrice[i] = new int[size];
            visiblesGauche[i] = new int[size];
            visiblesDroite[i] = new int[size];
            visibleHaut[i] = new int[size];
            visiblesBas[i] = new int[size];
            Arrays.fill(visiblesGauche[i], 0);
            Arrays.fill(visiblesDroite[i], 0);
            Arrays.fill(visibleHaut[i], 0);
            Arrays.fill(visiblesBas[i], 0);

            for(int j = 0; j < size; j++){
                matrice[i][j] = Character.getNumericValue(output.charAt(j));
            }

            i++;
        }
        //14size2
        for(i = 1; i < size-1; i++) {
            for (int j = 1; j < size-1; j++) {
                // a gauche
                for (int x = j-1; x != -1; x--) {
                    if(matrice[i][j] > matrice[i][x]){
                        visiblesGauche[i][j] += 1;
                    }else{
                            visiblesGauche[i][j] += 1;
                        break;
                    }
                }

                for (int x = j+1; x < size; x++) {
                    if(matrice[i][j] > matrice[i][x]){
                        visiblesDroite[i][j] += 1;
                    }else{
                            visiblesDroite[i][j] += 1;

                        break;
                    }
                }

                for (int y = i-1; y != -1; y--) {
                    if(matrice[i][j] > matrice[y][j]){
                        visibleHaut[i][j] += 1;
                    }else{
                            visibleHaut[i][j] += 1;
                        break;
                    }
                }

                for (int y = i+1; y < size; y++) {
                    if(matrice[i][j] > matrice[y][j]){
                        visiblesBas[i][j] += 1;
                    }else{
                            visiblesBas[i][j] += 1;
                        break;
                    }
                }
            }
        }

        int res = 0;
        for(i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrice[i][j]);
            }

            System.out.println("");
        }
        System.out.println("");

        int max = 0;
        for(i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int score = 1;
                if(visiblesGauche[i][j] > 0){

                    score *= visiblesGauche[i][j];
                }
                if(visiblesDroite[i][j] > 0){
                    score *= visiblesDroite[i][j];
                }
                if(visibleHaut[i][j] > 0){
                    score *= visibleHaut[i][j];
                }
                if(visiblesBas[i][j] > 0){
                    score *= visiblesBas[i][j];
                }

                System.out.println(score+ " "  + visibleHaut[i][j] + "," + visiblesGauche[i][j]+"," + visiblesDroite[i][j] + "," + visiblesBas[i][j]);

                if(max < score) max = score;
            }

            System.out.println("");
        }

        System.out.println(max);




        in.close();
    }

}
