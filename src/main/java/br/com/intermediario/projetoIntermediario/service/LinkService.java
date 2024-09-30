package br.com.intermediario.projetoIntermediario.service;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class LinkService {

    public String encurtarLink(String urlOriginal) throws Exception {
        try {
            String api = "https://tinyurl.com/api-create.php?url=" + urlOriginal;
            URL url = new URL(api);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder conteudo = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    conteudo.append(inputLine);
                }
                in.close();
                return conteudo.toString();
            } else {
                return "Erro ao acessar a API: Código de resposta " + responseCode;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao encurtar o link: " + e.getMessage();
        }
    }


    public boolean isUrlValid(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            connection.setConnectTimeout(3000);
            connection.setReadTimeout(3000);
            int responseCode = connection.getResponseCode();

            return (responseCode == HttpURLConnection.HTTP_OK);
        } catch (Exception e) {
            return false;
        }
    }
}
