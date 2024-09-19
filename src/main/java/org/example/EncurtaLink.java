package org.example;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class EncurtaLink {
    public static void main(String[] args) {
        try {
            String grandeLink = "https://www1.satc.edu.br/portais/alunos/index.php/conteudos/lista_aulas_virtuais";
            String api = "https://tinyurl.com/api-create.php?url=" + grandeLink;
            URL url = new URL(api);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer conteudo = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                conteudo.append(inputLine);
            }
            in.close();

            System.out.println("Link encurtado: " + conteudo.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
