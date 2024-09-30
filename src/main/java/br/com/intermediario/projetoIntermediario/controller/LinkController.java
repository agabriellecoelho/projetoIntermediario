package br.com.intermediario.projetoIntermediario.controller;

import br.com.intermediario.projetoIntermediario.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/links")
public class LinkController {

    @Autowired
    private LinkService linkService;

    @PostMapping("/encurtar")
    public Map<String, String> encurtarLink(@RequestBody Map<String, String> request) {
        String urlOriginal = request.get("url");
        if (urlOriginal == null || urlOriginal.isEmpty()) {
            return Collections.singletonMap("error", "A URL fornecida está vazia ou não foi informada.");
        }

        try {
            String urlEncurtada = linkService.encurtarLink(urlOriginal);

            Map<String, String> response = new HashMap<>();
            response.put("urlEncurtada", urlEncurtada);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.singletonMap("error", "Erro ao encurtar o link.");
        }
    }
}
