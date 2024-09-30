package br.com.intermediario.projetoIntermediario;
import br.com.intermediario.projetoIntermediario.controller.desabilitarCtrl;
import br.com.intermediario.projetoIntermediario.service.LinkService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.net.ssl.*;
import java.util.Scanner;
import java.net.URL;


@SpringBootApplication
public class EncurtaLink {
	public static void main(String[] args) {

		try {
			desabilitarCtrl.desabilitarVerificacaoSSL();
		} catch (Exception e) {
			e.printStackTrace();
		}
		LinkService linkService = new LinkService();
		Scanner scanner = new Scanner(System.in);
		String urlOriginal;

		while(true) {
			System.out.println("Informe o link que deseja encurtar:");
			urlOriginal = scanner.nextLine();

			if (linkService.isUrlValid(urlOriginal)) {
				System.out.println("URL válida. Tentando encurtar...");
				break;
			} else {
				System.out.println("URL inválida. Por favor, insira um link válido.");
			}
		}
		try {
			String linkEncurtado = linkService.encurtarLink(urlOriginal);
			System.out.println("Link encurtado: " + linkEncurtado);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao encurtar o link.");
		}

	}
}
