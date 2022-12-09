import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.LinkedList;


public class Day8 {
    public static void main(String[] args) throws Exception {
        // Get inputs

        URL url = new URL("https://adventofcode.com/2022/day/8/input");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestProperty("Cookie","_ga=G7eb196528550.1670486222");
        conn.setRequestProperty("Content-Type","application/json");
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        String output;

        int[][] matrice = new int[99][];
        boolean[][] visiblesGauche = new boolean[99][];
        boolean[][] visiblesDroite = new boolean[99][];
        boolean[][] visibleHaut = new boolean[99][];
        boolean[][] visiblesBas = new boolean[99][];

        int i = 0;
        while ((output = in.readLine()) != null) {
            matrice[i] = new int[99];
            visiblesGauche[i] = new boolean[99];
            visiblesDroite[i] = new boolean[99];
            visibleHaut[i] = new boolean[99];
            visiblesBas[i] = new boolean[99];
            Arrays.fill(visiblesGauche[i], true);
            Arrays.fill(visiblesDroite[i], true);
            Arrays.fill(visibleHaut[i], true);
            Arrays.fill(visiblesBas[i], true);

            for(int j = 0; j < 99; j++){
                matrice[i][j] = Character.getNumericValue(output.charAt(j));
            }

            i++;
        }
        //14992
        for(i = 1; i < 99-1; i++) {
            for (int j = 1; j < 99-1; j++) {
                // a gauche
                for (int x = j-1; x != -1; x--) {
                    if(matrice[i][j] <= matrice[i][x]){
                        visiblesGauche[i][j] = false;
                    }
                }

                for (int x = j+1; x < 99; x++) {
                    if(matrice[i][j] <= matrice[i][x]){
                        visiblesDroite[i][j] = false;
                    }
                }

                for (int y = i-1; y != -1; y--) {
                    if(matrice[i][j] <= matrice[y][j]){
                        visibleHaut[i][j] = false;
                    }
                }

                for (int y = i+1; y < 99; y++) {
                    if(matrice[i][j] <= matrice[y][j]){
                        visiblesBas[i][j] = false;
                    }
                }
            }
        }

        int res = 0;
        for(i = 0; i < 99; i++) {
            for (int j = 0; j < 99; j++) {
                System.out.print(matrice[i][j]);
            }

            System.out.println("");
        }
        System.out.println("");

        for(i = 0; i < 99; i++) {
            for (int j = 0; j < 99; j++) {
                if(visiblesGauche[i][j] || visiblesDroite[i][j] || visibleHaut[i][j] || visiblesBas[i][j]){
                    System.out.print("1");
                    res++;
                }else{
                    System.out.print("0");
                }
            }

            System.out.println("");
        }

        System.out.println(res);


        in.close();
    }

}
