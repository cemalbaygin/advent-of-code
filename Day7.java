import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;


public class Day7 {
    public static void main(String[] args) throws Exception {
        // Get inputs

        URL url = new URL("https://adventofcode.com/2022/day/7/input");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestProperty("Cookie","_ga=G7eb196528550.1670486222");
        conn.setRequestProperty("Content-Type","application/json");
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        String output;
        // cd /
        in.readLine();

        Dossier racine = new Dossier("/");
        LinkedList<Dossier> cursor = new LinkedList<>();
        cursor.push(racine);
        while ((output = in.readLine()) != null) {
            System.out.println("ici");

            if(output.charAt(0) == '$'){
                output = output.substring(2);

                switch (output.charAt(0)){
                    case 'c':
                        String name = output.substring(output.indexOf(' ')+1);

                        // manque le cas ou on rerentre dans un dossier
                        if(name.equals("..")){
                            cursor.pop();
                        }else{
                            Dossier n = new Dossier(name);
                            cursor.getFirst().sousDossier.add(n);
                            cursor.push(n);
                        }
                    break;
                    case 'l':

                        break;
                }
            }

            else if (output.charAt(0) != 'd'){
                String size = output.substring(0,output.indexOf(' '));
                cursor.getFirst().size += Integer.parseInt(size);

            }
        }


        System.out.println(resultat(racine));

        in.close();
    }

    // utilisé 47048086
    //

    static int max = 9048086;
                   //24390891
    static int resultat(Dossier racine){
        for (Dossier sousD: racine.sousDossier) {
            int taille = taille(sousD);
            if(taille < max && taille >= 7048086){
                max = taille;
            }
            resultat(sousD);
        }

        return max;
    }

    static int taille(Dossier d){

        int taille = d.size;
        for (Dossier sousD: d.sousDossier) {
            taille += taille(sousD);
        }

        return taille;
    }
}
